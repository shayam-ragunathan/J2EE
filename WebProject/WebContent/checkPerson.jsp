<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String age = request.getParameter("age");
if (Integer.parseInt(age) < 18){
 %>
 <h2>Not allowed!! </h2>
 <jsp:include page="personEntry2.jsp"></jsp:include>
 <%
 }
 else
 {
 %>
 <jsp:forward page="createPerson.jsp"></jsp:forward>
 <%
 }
  %>

</body>
</html>