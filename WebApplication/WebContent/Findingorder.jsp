<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.io.output.*" %>

<%
    String mytoken = "";
    Cookie[] mycookies = request.getCookies();
    if (mycookies != null) {
        for (int i = 0; i < mycookies.length; ++i) {
        	if (mycookies[i].getName().equals("token")) {
        		mytoken = mycookies[i].getValue();
        			break;
        	}
        }
    }
%>

<jsp:useBean id="findorderProxy" scope="request" class="com.services.UserServiceProxy" />
<%
	findorderProxy.setEndpoint("http://localhost:8000/WebService/User");
	String idStr = request.getParameter("id_active");
	int id = Integer.parseInt(idStr);
	String redirect = "";
	String redirect2 = "";
	com.services.User user = null;	
	try{
		user = findorderProxy.getUser(mytoken, id);
	} catch (com.services.TokenException tex) {
		redirect = "LogoutServlet";
		user = new com.services.User();
	}
%>

<%
	// Update driver available attr
	boolean finding = "1".equals(request.getParameter("finding"));
	user.setFinding(finding);
%>

<%
	// Save user to database
	try {
		findorderProxy.saveUser(mytoken, user);
	} catch (com.services.TokenException tex) {
		redirect2 = "LogoutServlet";
	}
%>

<% response.sendRedirect("Findorder.jsp?id_active=" + idStr); %>

<%
	if (redirect != "") {
		response.sendRedirect(redirect);
	} else if (redirect2 != "") {
		response.sendRedirect(redirect2);
	}
%>