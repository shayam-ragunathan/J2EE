<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<h2 style="color:red;background-color:white">Enter Person Details</h2>
<form action="checkPerson.jsp" method="post">
<pre>
            Name        : <input type="text" name ="name" />
            Age         : <input type="text" name ="age" />
            Weight      : <input type="text" name ="weight" />
            <input type="submit" value="Create Person"/>
</pre>

</form>

</body>
</html>