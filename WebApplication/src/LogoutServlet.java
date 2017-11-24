

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String token = request.getParameter("token");
		if (token != null) {
			String body = "{\"token\": \"" + token + "\"}";
			
			URL url = new URL ("http://localhost:7000/IdentityService/Logout");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "appplication/json; charset=utf-8");
			connection.setRequestProperty("Content-Length", "" +  Integer.toString(body.getBytes().length));
		    
			DataOutputStream out = new DataOutputStream(connection.getOutputStream ());
		    out.writeBytes(body);
		    out.flush();
		    out.close();
			
		    connection.connect();
		    
		    Cookie[] cookie = request.getCookies();
		    for (int i = 0; i < cookie.length; ++i) {
		    	if (cookie[i].getName().equals("token")) {
		    		cookie[i].setMaxAge(0);
		    		response.addCookie(cookie[i]);
		    		break;
		    	}
		    }
		}
		response.sendRedirect("http://localhost:9000/WebApplication/Login.jsp?e=" + request.getParameter("e"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
