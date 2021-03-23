<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String ma = (String) application.getAttribute("ref");
	%>
	<h1>
		EmailId:
		<%=ma%></h1>
	<form action="Password" method="post">
		Password:<input name="pass" />
	    <input type="submit" value="next">
	</form>

</body>
</html>