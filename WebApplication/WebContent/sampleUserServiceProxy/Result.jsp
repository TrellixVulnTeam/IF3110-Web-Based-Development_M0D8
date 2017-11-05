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
        String arg0_1id=  request.getParameter("arg032");
        int arg0_1idTemp  = Integer.parseInt(arg0_1id);
        com.services.User getUser13mtemp = sampleUserServiceProxyid.getUser(arg0_1idTemp);
if(getUser13mtemp == null){
%>
<%=getUser13mtemp %>
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
if(getUser13mtemp != null){
java.lang.String typename16 = getUser13mtemp.getName();
        String tempResultname16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename16));
        %>
        <%= tempResultname16 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getUser13mtemp != null){
%>
<%=getUser13mtemp.getId()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">username:</TD>
<TD>
<%
if(getUser13mtemp != null){
java.lang.String typeusername20 = getUser13mtemp.getUsername();
        String tempResultusername20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeusername20));
        %>
        <%= tempResultusername20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">star:</TD>
<TD>
<%
if(getUser13mtemp != null){
%>
<%=getUser13mtemp.getStar()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">vote:</TD>
<TD>
<%
if(getUser13mtemp != null){
%>
<%=getUser13mtemp.getVote()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagePath:</TD>
<TD>
<%
if(getUser13mtemp != null){
java.lang.String typeimagePath26 = getUser13mtemp.getImagePath();
        String tempResultimagePath26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagePath26));
        %>
        <%= tempResultimagePath26 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(getUser13mtemp != null){
java.lang.String typeemail28 = getUser13mtemp.getEmail();
        String tempResultemail28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail28));
        %>
        <%= tempResultemail28 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">phoneNumber:</TD>
<TD>
<%
if(getUser13mtemp != null){
java.lang.String typephoneNumber30 = getUser13mtemp.getPhoneNumber();
        String tempResultphoneNumber30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typephoneNumber30));
        %>
        <%= tempResultphoneNumber30 %>
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