

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.io.*;

public class Wave extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("name");
		String b = request.getParameter("email");
		String c = request.getParameter("message");
		PrintWriter pw = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wavecafe","root","Meg$1320");
			Statement st=con.createStatement();
			st.executeUpdate("insert into feedback(name,email,message) values('"+a+"','"+b+"','"+c+"')");
			response.sendRedirect("wave.jsp");
		}
		catch (Exception e){
			pw.println(e);
	    }
    }
}
