<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDate" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<h1>Showing Contents</h1>
<jsp:include page="dummy.html"></jsp:include>

<%!
int x=100;
public String welcome(String name)
{
  return "Welcome " + name;
}
public class Math
{
int x,y;

public int mul(int x,int y)
{
return x*y;
}
public int div(int x,int y)
{
return x/y;
}
}
%>
 
 <%
 for (int a=1; a<=5;a++){
 %>
  <H2>Hello</H2>
  <%
  }
  %>
  <%!
int y=200;
 %>
  <h2>Value of X is <%=x %></h2>
  <h2>Squire of X is <%= (x*y) %> </h2>
  <% Math m1 =new Math(); %>
  <h2>Mul of 79 and 67 is <%= m1.mul(79, 67) %> </h2>
  <%-- <h2>dev of 79 and 0 is <%= m1.div(79, 0) %> </h2>--%>
  <h2>Siri Says <%= welcome("shyam") %> </h2>
  <%
  LocalDate sysDate = LocalDate.now();
   %>
  <h2>Todays date is <%= sysDate %> </h2> 
  
   
   
   
  
</body>
</html>