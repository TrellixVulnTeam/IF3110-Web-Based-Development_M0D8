<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
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

<jsp:useBean id="uploadProxy" scope="request" class="com.services.UserServiceProxy" />
<%
	uploadProxy.setEndpoint("http://localhost:8000/WebService/User");
	String idStr = request.getParameter("id_active");
	int id = Integer.parseInt(idStr);
	
	com.services.User user = null;	
	try{
		user = uploadProxy.getUser(mytoken, id);
	} catch (com.services.TokenException tex) {
		response.sendRedirect("LogoutServlet");
	}
%>

<%
   File file ;
   int maxFileSize = 5000 * 1024;
   int maxMemSize = 5000 * 1024;
   String filePath = "C:\\Users\\W8.1\\Desktop\\TugasBesar2_2017\\WebApplication\\WebContent\\profiles\\";

   // Verify the content type
   String contentType = request.getContentType();
   
   if ((contentType.indexOf("multipart/form-data") >= 0)) {
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("C:\\temp\\"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );
      
      try { 
         // Parse the request to get file items.
         List fileItems = upload.parseRequest(request);

         // Process the uploaded file items
         Iterator i = fileItems.iterator();
         out.println(String.valueOf(i.hasNext()));
        
         while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();
            if ( true ) {
               // Get the uploaded file parameters
               String fieldName = fi.getFieldName();
               String fileName = fi.getName();
               boolean isInMemory = fi.isInMemory();
               long sizeInBytes = fi.getSize();
            
               // Write the file
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( filePath + 
                  fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( filePath + 
                  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               }
               fi.write( file ) ;
               String filep = "profiles/" + fileName;
               
               com.services.UserServiceProxy proxy = new com.services.UserServiceProxy();
               user.setImagePath(filep);
               uploadProxy.saveUser(mytoken, user);
            }
         }
      } catch(Exception ex) {
         System.out.println(ex);
      }
   } else {
   }
%>