package org.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RemoveBook")
public class RemoveBook extends HttpServlet
{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
	
	String id=req.getParameter("id");
	
	String url="jdbc:mysql://localhost:3306";
	String user="root";
	String password="techouts";
	
	String qwery="delete from ravindradb.bookstore where id=?";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection(url, user, password);
		
		
		PreparedStatement preparedStatement=connection.prepareStatement(qwery);
		preparedStatement.setString(1, id);
		preparedStatement.executeUpdate();
		
		PrintWriter printWriter=resp.getWriter();
		printWriter.println("Book is Deleted");
		
		connection.close();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
