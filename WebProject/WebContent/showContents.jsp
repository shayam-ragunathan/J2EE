<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="sample.beans.DataStore" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- Getting data from session,application context, request level --%>
<% 

String name =request.getParameter("name");
String emailId =request.getParameter("emailId");

String sessionId =session.getId();

Date sessionStartTime =new Date(session.getCreationTime());

DataStore dataStore =(DataStore) application.getAttribute("electronics");

List<String> contents = dataStore.getContents();
 
%>

<h2> Hi <%=name %> , your email is <%= emailId %> </h2>
<h2> Your Session id is <%= sessionId %>  </h2>
<h2>Session start time is <%= sessionStartTime %> </h2>
<h2>List of product from Application level:

<%
for (String lcontent : contents)
{
out.println(lcontent);
}

 %>
 
</h2>



</body>
</html>