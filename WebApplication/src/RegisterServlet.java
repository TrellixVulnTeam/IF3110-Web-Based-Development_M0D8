

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullName = request.getParameter("fullname");
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String cpass = request.getParameter("cpass");
		String phone = request.getParameter("phone");
		String isDriver = request.getParameter("is-driver");
		
		String bodyIdentity = "{\"username\": \"" + userName + "\",\"pass\": \"" + pass + "\",\"email\":\"" + email + "\"}";
		
		URL url = new URL ("http://localhost:7000/IdentityService/Register");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "appplication/json; charset=utf-8");
		connection.setRequestProperty("Content-Length", "" +  Integer.toString(bodyIdentity.getBytes().length));
	    
		DataOutputStream out = new DataOutputStream(connection.getOutputStream ());
	    out.writeBytes(bodyIdentity);
	    out.flush();
	    out.close();
		
	    connection.connect();
		
	    String result;
	    BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
	    ByteArrayOutputStream buf = new ByteArrayOutputStream();
	    int result2 = bis.read();
	    while(result2 != -1) {
	        buf.write((byte) result2);
	        result2 = bis.read();
	    }
	    result = buf.toString();
	    JSONObject resultJSON = null;
	    String status = "";
	    try {
			resultJSON = new JSONObject(result);
			status = resultJSON.getString("status");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    if(status.equals("ok")) {
	    	try {
				String token = resultJSON.getString("token");
				
				String expiryTime = resultJSON.getString("expiry");
				
				Cookie cookieToken = new Cookie("token", token);
				Cookie cookieExpiry = new Cookie("expiry", expiryTime);
				response.addCookie(cookieToken);
				response.addCookie(cookieExpiry);
				boolean temp;
				if(isDriver==null) {
					temp = false;
				}
				else {
					temp = true;
				}
				
				com.services.UserServiceProxy proxy = new com.services.UserServiceProxy();
				
				com.services.User user = new com.services.User(
				           temp,
				           email,
				           0,
				           null,
				           fullName,
				           phone,
				           null,
				           0f,
				           userName,
				           0);
				proxy.createUser(user);
				if(temp) {
					response.sendRedirect("http://localhost:9000/WebApplication/Profile.jsp");
				}
				else {
					response.sendRedirect("http://localhost:9000/WebApplication/Order.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    else {
	    	response.sendRedirect("http://localhost:9000/WebbApplication/Register.jsp");
	    }
	    
	}

}
