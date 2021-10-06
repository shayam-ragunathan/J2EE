<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightBlue">
<h2>Creating a Person</h2>
<jsp:useBean id="person" class="sample.beans.Person" scope="application" />
<jsp:setProperty property="*" name="person"/>
<h2>Person Created successfully</h2>
<h2><a href="showPerson.jsp">Click hear</a> to display the created person</h2>
</body>
</html>