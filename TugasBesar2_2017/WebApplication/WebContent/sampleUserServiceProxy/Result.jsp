<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleUserServiceProxyid" scope="session" class="com.services.UserServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleUserServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleUserServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleUserServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.services.UserService getUserService10mtemp = sampleUserServiceProxyid.getUserService();
if(getUserService10mtemp == null){
%>
<%=getUserService10mtemp %>
<%
}else{
        if(getUserService10mtemp!= null){
        String tempreturnp11 = getUserService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String name_2id=  request.getParameter("name18");
            java.lang.String name_2idTemp = null;
        if(!name_2id.equals("")){
         name_2idTemp  = name_2id;
        }
        String id_3id=  request.getParameter("id20");
        int id_3idTemp  = Integer.parseInt(id_3id);
        String username_4id=  request.getParameter("username22");
            java.lang.String username_4idTemp = null;
        if(!username_4id.equals("")){
         username_4idTemp  = username_4id;
        }
        String star_5id=  request.getParameter("star24");
        float star_5idTemp  = Float.parseFloat(star_5id);
        String vote_6id=  request.getParameter("vote26");
        int vote_6idTemp  = Integer.parseInt(vote_6id);
        String imagePath_7id=  request.getParameter("imagePath28");
            java.lang.String imagePath_7idTemp = null;
        if(!imagePath_7id.equals("")){
         imagePath_7idTemp  = imagePath_7id;
        }
        String email_8id=  request.getParameter("email30");
            java.lang.String email_8idTemp = null;
        if(!email_8id.equals("")){
         email_8idTemp  = email_8id;
        }
        String phoneNumber_9id=  request.getParameter("phoneNumber32");
            java.lang.String phoneNumber_9idTemp = null;
        if(!phoneNumber_9id.equals("")){
         phoneNumber_9idTemp  = phoneNumber_9id;
        }
        %>
        <jsp:useBean id="com1services1User_1id" scope="session" class="com.services.User" />
        <%
        com1services1User_1id.setName(name_2idTemp);
        com1services1User_1id.setId(id_3idTemp);
        com1services1User_1id.setUsername(username_4idTemp);
        com1services1User_1id.setStar(star_5idTemp);
        com1services1User_1id.setVote(vote_6idTemp);
        com1services1User_1id.setImagePath(imagePath_7idTemp);
        com1services1User_1id.setEmail(email_8idTemp);
        com1services1User_1id.setPhoneNumber(phoneNumber_9idTemp);
        sampleUserServiceProxyid.loadPreferredLocations(com1services1User_1id);
break;
case 34:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg053");
        int arg0_10idTemp  = Integer.parseInt(arg0_10id);
        com.services.User getUser34mtemp = sampleUserServiceProxyid.getUser(arg0_10idTemp);
if(getUser34mtemp == null){
%>
<%=getUser34mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(getUser34mtemp != null){
java.lang.String typename37 = getUser34mtemp.getName();
        String tempResultname37 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename37));
        %>
        <%= tempResultname37 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getUser34mtemp != null){
%>
<%=getUser34mtemp.getId()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">username:</TD>
<TD>
<%
if(getUser34mtemp != null){
java.lang.String typeusername41 = getUser34mtemp.getUsername();
        String tempResultusername41 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeusername41));
        %>
        <%= tempResultusername41 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">star:</TD>
<TD>
<%
if(getUser34mtemp != null){
%>
<%=getUser34mtemp.getStar()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">vote:</TD>
<TD>
<%
if(getUser34mtemp != null){
%>
<%=getUser34mtemp.getVote()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagePath:</TD>
<TD>
<%
if(getUser34mtemp != null){
java.lang.String typeimagePath47 = getUser34mtemp.getImagePath();
        String tempResultimagePath47 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagePath47));
        %>
        <%= tempResultimagePath47 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(getUser34mtemp != null){
java.lang.String typeemail49 = getUser34mtemp.getEmail();
        String tempResultemail49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail49));
        %>
        <%= tempResultemail49 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">phoneNumber:</TD>
<TD>
<%
if(getUser34mtemp != null){
java.lang.String typephoneNumber51 = getUser34mtemp.getPhoneNumber();
        String tempResultphoneNumber51 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typephoneNumber51));
        %>
        <%= tempResultphoneNumber51 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>