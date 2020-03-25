package com.spring.mvc.testdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = "root";
		String pass = "!QAZ1qaz";

		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";

		String driver = "com.mysql.cj.jdbc.Driver";

		try {

			System.out.println("Connecting to database" + jdbcUrl);

			Class.forName(driver);

			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("success!!");
			con.close();

		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}

	}

}
