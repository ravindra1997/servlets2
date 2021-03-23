package com.techouts.Servlets3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String umail = req.getParameter("mail");

		String url = "jdbc:mysql://localhost:3306?user=root&password=techouts";
		String query = "select mailid from ravindradb.userinfo where mailid=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, umail);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				HttpSession session = req.getSession();

				session.setAttribute("rn", umail);

				session.setMaxInactiveInterval(200);

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Logout");
				requestDispatcher.include(req, resp);
			} else {

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
				requestDispatcher.include(req, resp);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
