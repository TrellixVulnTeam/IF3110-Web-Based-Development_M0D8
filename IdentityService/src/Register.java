

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*; 

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullname");
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String cpass = request.getParameter("cpass");
		String phone = request.getParameter("phone");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print(fullName);
		out.print(userName);
		out.print(email);
		out.print(pass);
		out.print(cpass);
		out.print(phone);
		
		try {
			Class.forName(DB.JDBC_DRIVER);  
			Connection con=DriverManager.getConnection(  
					DB.DB_URL, DB.USER, DB.PASS);
			
			PreparedStatement checkIfExist = con.prepareStatement(
					"select * from account where username=? or email=?");
			checkIfExist.setString(1, userName);
			checkIfExist.setString(2, email);
			
			ResultSet rs = checkIfExist.executeQuery();
			if (!rs.isBeforeFirst()) {
				//hasil kosong
				PreparedStatement ps=con.prepareStatement(  
						"insert into account(username, password, email) values(?,?,?)");
				
				ps.setString(1, userName);
				ps.setString(2, pass);
				ps.setString(3, email);
				
				int i = ps.executeUpdate();
				
				out.print("<html><body>");
				out.print("<h2>Register is success</h2>");
				out.print("</body></html>");
			}
			else {
				out.print("<html><body>");
				out.print("<h2>Register is failed</h2>");
				out.print("</body></html>");
			} 
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
