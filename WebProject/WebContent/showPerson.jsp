<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightBlue">
<jsp:useBean id="person" class="sample.beans.Person" scope="application" />
<h2>Printing the Person details</h2>
<pre>
<h2>Name   : <jsp:getProperty property="name" name="person"/> </h2>
<h2>Age    : <jsp:getProperty property="age" name="person"/> </h2>
<h2>Weight : <jsp:getProperty property="weight" name="person"/> </h2>
</pre>


</body>
</html>