

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hidedriver
 */
@WebServlet("/Hidedriver")
public class Hidedriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hidedriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id_active");
		String idoStr = request.getParameter("id_order");
		int ido = Integer.parseInt(idoStr);
		com.services.HistoryServiceProxy proxy = new com.services.HistoryServiceProxy();
		proxy.setEndpoint("http://localhost:8000/WebService/History");
		proxy.hideHistoryAsDriver(ido);
		response.sendRedirect("http://localhost:9000/WebApplication/Historydriver.jsp?id_active=" + idStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
