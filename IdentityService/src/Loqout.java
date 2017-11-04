import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loqout
 */
@WebServlet("/Loqout")
public class Loqout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loqout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			pstmt = conn.prepareStatement("DELETE FROM account_token WHERE token=?");
			pstmt.setString(1, "avHUwsLLtyhlVFiXcGwO"/*request.getParameter("token")*/);
			pstmt.executeUpdate();
			
	        
	    } catch(SQLException se) {
	        se.printStackTrace();
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        //finally block used to close resources
	        try {
	        	if(pstmt!=null)
	        		pstmt.close();
	        } catch(SQLException se2) {
	        	se2.printStackTrace();
	        }
	        try {
	            if(conn!=null)
	            	conn.close();
	        } catch(SQLException se) {
	            se.printStackTrace();
	        }
	    }
	}

}
