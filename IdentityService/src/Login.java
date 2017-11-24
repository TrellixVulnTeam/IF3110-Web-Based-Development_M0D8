import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("<h2>Hello World</h2>");
		out.print("</body></html>");*/
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		JSONObject body;
		String username = "";
		String password = "";
		String uagent = "";
		String ip = "";
		try {
			body = new JSONObject(text);
			username = body.get("username").toString();
			password = body.getString("pass").toString();
			uagent = body.getString("uagent").toString();
			ip = body.getString("ip").toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DB.JDBC_DRIVER);
			
			// Open connection
			conn = DriverManager.getConnection(DB.DB_URL, DB.USER, DB.PASS);
			
			// Execute SQL query
			pstmt = conn.prepareStatement("SELECT * FROM account WHERE username=? AND password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			
			rs = pstmt.executeQuery();
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			String toReturn = "";
			
			if (!rs.isBeforeFirst()) {    
				toReturn = "{\"status\":\"fail\"}";
				out.print(toReturn);
			} else {
				rs.next();
				int id = rs.getInt(1);
				
				// Generate Token
				Token token = new Token();
				String secToken;
				do {
					token.generate();
					secToken = token.get() + "#" + uagent + "#" + ip;
					pstmt = conn.prepareStatement("SELECT * FROM account_token WHERE token=?");
					pstmt.setString(1, secToken);
					rs = pstmt.executeQuery();
				} while (rs.isBeforeFirst());
				
				// Generate current datetime for expiry time
				java.util.Date date = new Date();
				Long expiryTime = new Long(date.getTime() + 60000 * 30);
				Object datetime = new java.sql.Timestamp(expiryTime);
				
				// Update DB
				pstmt = conn.prepareStatement("INSERT INTO account_token(id,token,expiry_time) VALUES(?,?,?)");
				pstmt.setInt(1, id);
				pstmt.setString(2, secToken);
				pstmt.setObject(3, datetime);
				pstmt.executeUpdate();
				
				String expiryTimeString = expiryTime.toString(); 
				
				toReturn = "{\"status\":\"ok\",\"token\":\"" + secToken + "\",\"expiry\":\"" + expiryTimeString + "\",\"id\":" + id + "}";
				out.print(toReturn);
			}
	        
	    } catch(SQLException se) {
	        se.printStackTrace();
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        //finally block used to close resources
	    	try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        try {
	        	if(pstmt!=null)
	        		pstmt.close();
	        } catch(SQLException se2) {
	        	se2.printStackTrace();
	        }
	        try {
	            if(conn!=null)
	            	conn.close();
	        } catch(SQLException se) {
	            se.printStackTrace();
	        }
	    }
	}
}
