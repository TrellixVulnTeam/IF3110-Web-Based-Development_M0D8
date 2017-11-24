

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import java.sql.*;
import java.util.Date;
import java.util.stream.Collectors; 

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		JSONObject body;
		String username = "";
		String password = "";
		String email = "";
		String uagent = "";
		String ip = "";
		try {
			body = new JSONObject(text);
			username = body.get("username").toString();
			password = body.getString("pass").toString();
			email = body.getString("email").toString();
			uagent = body.getString("uagent").toString();
			ip = body.getString("ip").toString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		String toReturn = "";
		try {
			Class.forName(DB.JDBC_DRIVER);  
			Connection con=DriverManager.getConnection(  
					DB.DB_URL, DB.USER, DB.PASS);
			
			PreparedStatement ps = con.prepareStatement(
					"select * from account where username=? or email=?");
			ps.setString(1, username);
			ps.setString(2, email);
			
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				//hasil kosong
				//Masukkan data ke database
				ps=con.prepareStatement(  
						"insert into account(username, password, email) values(?,?,?)");
				
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, email);
				
				int i = ps.executeUpdate();
				
				//Cari data pengguna untuk mendapatkan id
				ps = con.prepareStatement(
						"select * from account where username=?");
				ps.setString(1,  username);
				
				rs = ps.executeQuery();
				rs.next();
				int id = rs.getInt(1);
				
				Token token = new Token();
				String secToken;
				do {
					token.generate();
					secToken = token.get() + "#" + uagent + "#" + ip;
					ps = con.prepareStatement("SELECT * FROM account_token WHERE token=?");
					ps.setString(1, secToken);
					rs = ps.executeQuery();
				} while (rs.isBeforeFirst());
				
				// Generate current datetime for expiry time
				java.util.Date date = new Date();
				Long expiryTime = new Long(date.getTime() + 60000 * 2);
				Object datetime = new java.sql.Timestamp(expiryTime);
				
				// Update DB
				ps = con.prepareStatement("INSERT INTO account_token(id,token,expiry_time) VALUES(?,?,?)");
				ps.setInt(1, id);
				ps.setString(2, secToken);
				ps.setObject(3, datetime);
				ps.executeUpdate();

				String expiryTimeString = expiryTime.toString(); 
				
				toReturn = "{\"status\":\"ok\",\"token\":\"" + secToken + "\",\"expiry\":\"" + expiryTimeString + "\"}";
				out.print(toReturn);
			}
			else {
				toReturn = "{\"status\":\"fail\"}";
				out.print(toReturn);
			} 
		}
		catch(Exception e) {
			System.out.println(e);
			toReturn = "{\"status\":\"exception\"}";
		}
		
		
	}

}
