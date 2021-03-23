package org.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddBook")
public class AddBook extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String bookId=req.getParameter("id");
		String bookName=req.getParameter("bname");
		String bookAuthor=req.getParameter("bauthor");
		String bookPrice=req.getParameter("price");
		//int price =Integer.parseInt(bookPrice);
		
		
		String url="jdbc:mysql://localhost:3306";
		String user="root";
		String password="techouts";
		
		String qwery="insert into ravindradb.bookstore values (?,?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection(url, user, password);
			
			
			PreparedStatement preparedStatement=connection.prepareStatement(qwery);
			
			preparedStatement.setString(1, bookId);
			preparedStatement.setString(2, bookName);
			preparedStatement.setString(3, bookAuthor);
			preparedStatement.setString(4, bookPrice);
			preparedStatement.executeUpdate();
			
			Cookie cookie=new Cookie("user", bookName);
			resp.addCookie(cookie);
			

			PrintWriter printWriter=resp.getWriter();
			printWriter.println("Successfully Added");
			
						
			connection.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

}
