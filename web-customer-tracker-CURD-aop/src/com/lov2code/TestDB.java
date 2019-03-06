package com.lov2code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import java.sql.*;
/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/nmc?useSSL=false";
		String user="postgres";
		String pw="";
		Connection con = null;
		PreparedStatement stm = null;
		try{
			System.out.println("Strart");
			PrintWriter printWriter = response.getWriter();
			printWriter.println("Start "+jdbcUrl);
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(jdbcUrl,user,pw);
//			stm = con.prepareStatement("insert into nmc.student(first_name,last_name,email) values('kwwwk','lol','dd@dd.com');");
//			boolean t = stm.execute();
//			System.out.println(t);
			printWriter.println("Sucess");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}	}

}
