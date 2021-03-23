<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<%
	ServletContext context = getServletContext();
	String st = (String) application.getAttribute("temp");
	%>
<h1>Welcome Mrs: <%=st%></h1>

</body>


</html>