

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Finishorder
 */
@WebServlet("/Finishorder")
public class Finishorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Finishorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idc = request.getParameter("id_active");
		String idd = request.getParameter("id_driver");
		String star = request.getParameter("star");
		String feedback = request.getParameter("comment");
		String pickup = request.getParameter("pickup");
		String dest = request.getParameter("dest");
		
		com.services.History history = new com.services.History();
		history.setIdCustomer(Integer.parseInt(idc));
		history.setIdDriver(Integer.parseInt(idd));
		history.setRating(Integer.parseInt(star));
		history.setFeedback(feedback);
		history.setPickUp(pickup);
		history.setDestination(dest);
		
		com.services.HistoryServiceProxy proxy = new com.services.HistoryServiceProxy();
		
		Cookie cookie = null;
		Cookie[] cookies = null;
		String token = null;
		cookies = request.getCookies();
		
		if(cookies!=null) {
			for (int i = 0; i < cookies.length; i++) {
	            cookie = cookies[i];
	            if(cookie.getName().equals("token")) {
	            	token = cookie.getValue();
	            }
	         }
		}
		
		try {
			proxy.createHistory(token, history, Integer.parseInt(idc));
			proxy.updateCustomer(token, Integer.parseInt(idd), history);
		}
		catch(com.services.TokenException t) {
			response.sendRedirect("http://localhost:9000/WebApplication/LogoutServlet?id="+idc+"&e="+proxy.getValidation(token, Integer.parseInt(idc)));
		}
		
		
		
		response.sendRedirect("http://localhost:9000/WebApplication/Profile.jsp?id_active=" + idc);
	}
}
