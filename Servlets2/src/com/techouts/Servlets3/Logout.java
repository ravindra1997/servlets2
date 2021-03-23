package com.techouts.Servlets3;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		String num = (String) session.getAttribute("rn");
		System.out.println(num);
		System.out.println();
		session.invalidate();

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Logout.html");
		requestDispatcher.include(req, resp);
	}
}
