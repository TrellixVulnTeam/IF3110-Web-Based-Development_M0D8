

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPMessage;

import org.json.JSONObject;

/**
 * Servlet implementation class Validate
 */
@WebServlet({ "/Validate", "/validate" })
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		JSONObject body;
		String token = "";
		try {
			body = new JSONObject(text);
			token = body.get("token").toString();
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
			pstmt = conn.prepareStatement("SELECT * FROM account_token WHERE token=?");
			pstmt.setString(1, token);
			
			rs = pstmt.executeQuery();
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			String toReturn = "";
			
			if (!rs.isBeforeFirst()) { // Token is not valid    
				toReturn = "{\"token_status\":\"invalid\"}";
				out.print(toReturn);
			} else { // Check expiry time
				rs.next();
				
				Date expiry = rs.getTimestamp("expiry_time");
				Date now = new Date();
				if (now.compareTo(expiry) < 0) { // Token is valid
					toReturn = "{\"token_status\":\"valid\"}";
					out.print(toReturn);
				} else { // Token is expired 
					toReturn = "{\"token_status\":\"expired\"}";
					out.print(toReturn);
				}
			}
	        
	    } catch(SQLException se) {
	        se.printStackTrace();
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        //finally block used to close resources
	        try {
	        	if(pstmt!=null)
	        		pstmt.close();
	        } catch(SQLException se2) {}
	        try {
	            if(conn!=null)
	            	conn.close();
	        } catch(SQLException se) {
	            se.printStackTrace();
	        }
	        try {
	            if(rs!=null)
	            	rs.close();
	        } catch(SQLException se) {
	            se.printStackTrace();
	        }
	    }
	}
	
	private String parseSOAP(HttpServletRequest request) {
		String str = null;
		try {
			MessageFactory message = MessageFactory.newInstance();
			InputStream in = request.getInputStream();
			SOAPMessage soap = message.createMessage(new MimeHeaders(), in);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			soap.writeTo(out);
			str = new String(out.toByteArray()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

}
