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
	ServletContext context = getServletContext();
	String bookid = (String) application.getAttribute("id");
	String name = (String) application.getAttribute("bn");
	String author = (String) application.getAttribute("ba");
	String price = (String) application.getAttribute("price");
	%>
	<h2>Welcome To Book-World</h2>
	<table>
		<tr>
			<th>BookId</th>
			<th>BookName</th>
			<th>BookAuthor</th>
			<th>Price</th>
		</tr>
		<tr>
			<td><%=bookid%></td>
			<td><%=name%></td>
			<td><%=author%></td>
			<td><%=price%></td>
		</tr>
	</table>
</body>
</html>