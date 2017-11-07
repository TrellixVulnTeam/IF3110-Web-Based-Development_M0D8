

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertLocation
 */
@WebServlet("/InsertLocation")
public class InsertLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_active");
		String locStr = request.getParameter("newloc");
		com.services.Location loc = new com.services.Location(locStr);
		com.services.LocationServiceProxy proxy = new com.services.LocationServiceProxy();
		proxy.setEndpoint("http://localhost:8000/WebService/Location");
		proxy.insertLocation(Integer.parseInt(id), loc);
		response.sendRedirect("http://localhost:9000/WebApplication/Editlocation.jsp?id_active=" + id);
	}

}
