package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends GenericServlet {
	@Override

	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {

		String name = req.getParameter("name");

		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("Welcome Mr:" + name);

		/*
		 * Cookie cookie = new Cookie("user", name); // cookie object
		 * resp.addCookie(cookie);
		 */
		printWriter.print("<form action='SecondServlet'>");
		printWriter.print("<input type='submit' value='go'>");
		printWriter.print("/form");

		printWriter.close();
	}

}
