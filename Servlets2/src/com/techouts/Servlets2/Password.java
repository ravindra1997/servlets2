package com.techouts.Servlets2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Password")
public class Password extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext context = getServletContext();

		String mi = (String) context.getAttribute("ref");
		String pas = req.getParameter("pass");
		String url = "jdbc:mysql://localhost:3306?user=root&password=techouts";
		String query = "select name from ravindradb.userinfo where mailid=? and password=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mi);
			preparedStatement.setString(2, pas);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				/*
				 * String st= resultSet.getString("name"); context.setAttribute("temp", st);
				 */
				System.out.println("User details are valid...");
                RequestDispatcher dispatcher=req.getRequestDispatcher("name.jsp");
                dispatcher.forward(req, resp);

			} else {
				System.out.println("User details is not valied...");
				RequestDispatcher rs = req.getRequestDispatcher("mail.jsp");
				rs.include(req, resp);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
