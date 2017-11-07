

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditLocation
 */
@WebServlet("/EditLocation")
public class EditLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_active");
		String oldLoc = request.getParameter("loc");
		String newLoc = request.getParameter("newloc");
		com.services.Location oldloc = new com.services.Location(oldLoc);
		com.services.Location newloc = new com.services.Location(newLoc);
		com.services.LocationServiceProxy proxy = new com.services.LocationServiceProxy();
		proxy.setEndpoint("http://localhost:8000/WebService/Location");
		proxy.updateLocation(Integer.parseInt(id), oldloc, newloc);
		response.sendRedirect("http://localhost:9000/WebApplication/Editlocation.jsp?id_active=" + id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
