package com.techouts.Servlets2;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mail = req.getParameter("eid");

		ServletContext context = getServletContext();
		context.setAttribute("ref", mail);

		String url = "jdbc:mysql://localhost:3306?user=root&password=techouts";
		String query = "select mailid from ravindradb.userinfo where mailid=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mail);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("mail.jsp");
				dispatcher.include(req, resp);

			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("mail.html");
				dispatcher.include(req, resp);
			}
			connection.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
