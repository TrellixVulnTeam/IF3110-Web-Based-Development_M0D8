

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DB.JDBC_DRIVER);
			
			// Open connection
			conn = DriverManager.getConnection(DB.DB_URL, DB.USER, DB.PASS);
			
			// Execute SQL query
			pstmt = conn.prepareStatement("SELECT * FROM account WHERE username=? AND password=?");
			pstmt.setString(1, "erick"/*request.getParameter("username")*/);
			pstmt.setString(2, "bertus"/*request.getParameter("password")*/);
			
			ResultSet rs = pstmt.executeQuery();
			if (!rs.isBeforeFirst()) {    
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				out.print("<html><body>");
				out.print("<h2>Username Password is not valid</h2>");
				out.print("</body></html>");
			} else {
				rs.next();
				// Generate Token
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				out.print("<html><body>");
				out.print("<h2>Valid</h2>");
				out.print("</body></html>");
			}

	        // Clean-up environment
	        rs.close();
	        pstmt.close();
	        conn.close();
	        
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
	    }
	}
}
