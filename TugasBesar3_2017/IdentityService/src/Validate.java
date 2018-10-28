

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
		int idUser = 0;
		String token = "";
		try {
			body = new JSONObject(text);
			idUser = body.getInt("id");
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
			pstmt = conn.prepareStatement("SELECT * FROM account_token WHERE id=?");
			pstmt.setInt(1, idUser);
			
			rs = pstmt.executeQuery();
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			String toReturn = "";
			
			if (!rs.isBeforeFirst()) { // ID is not valid    
				toReturn = "{\"token_status\":\"invalidId\"}";
				out.print(toReturn);
			} else { // Check token, browser, and IP
				StringBuffer stoken = new StringBuffer("");
				StringBuffer browser = new StringBuffer("");
				StringBuffer ip = new StringBuffer("");
				int i = 0;
				while (token.charAt(i) != '#') {
					stoken.append(token.charAt(i));
					i++;
				}
				i++;
				while (token.charAt(i) != '#') {
					browser.append(token.charAt(i));
					i++;
				}
				i++;
				while (i<token.length()) {
					ip.append(token.charAt(i));
					i++;
				}
				
				rs.next();
				String tokendb = rs.getString("token");
				StringBuffer stokendb = new StringBuffer("");
				StringBuffer browserdb = new StringBuffer("");
				StringBuffer ipdb = new StringBuffer("");
				i = 0;
				while (tokendb.charAt(i) != '#') {
					stokendb.append(tokendb.charAt(i));
					i++;
				}
				i++;
				while (tokendb.charAt(i) != '#') {
					browserdb.append(tokendb.charAt(i));
					i++;
				}
				i++;
				while (i<tokendb.length()) {
					ipdb.append(tokendb.charAt(i));
					i++;
				}
				
				// Check expiry time
				Date expiry = rs.getTimestamp("expiry_time");
				Date now = new Date();
				
				// Return validation
				if (!stoken.toString().equals(stokendb.toString())) {
					toReturn = "{\"token_status\":\"invalidToken\"}";
					out.print(toReturn);
				}
				else if (!browser.toString().equals(browserdb.toString())) {
					toReturn = "{\"token_status\":\"invalidUseragent\"}";
					out.print(toReturn);
				}
				else if (!ip.toString().equals(ipdb.toString())) {
					toReturn = "{\"token_status\":\"invalidIpaddress\"}";
					out.print(toReturn);
				}
				else if (now.compareTo(expiry) >= 0) {
					toReturn = "{\"token_status\":\"expired\"}";
					out.print(toReturn);
				}
				else {
					toReturn = "{\"token_status\":\"valid\"}";
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
