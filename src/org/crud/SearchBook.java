package org.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "techouts";

		String qwery = "select * from ravindradb.bookstore where id=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, user, password);

			PreparedStatement preparedStatement = connection.prepareStatement(qwery);

			preparedStatement.setString(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String bid = resultSet.getString("id");
				String bname = resultSet.getString("bookname");
				String bauthor = resultSet.getString("bookauthor");
				String price = resultSet.getString("bookprice");

				ServletContext context = getServletContext();
				context.setAttribute("id", bid);
				context.setAttribute("bn", bname);
				context.setAttribute("ba", bauthor);
				context.setAttribute("price", price);

				RequestDispatcher dispatcher = req.getRequestDispatcher("ViewBook.jsp");
				dispatcher.include(req, resp);

			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("SearchBook.jsp");
				dispatcher.include(req, resp);

			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
