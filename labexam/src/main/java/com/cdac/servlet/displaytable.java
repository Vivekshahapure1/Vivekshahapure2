package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/accept")
public class displaytable extends HttpServlet{
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
    {  
         
       response.setContentType("text/html");  
       PrintWriter out = response.getWriter();
       out.println("<!DOCTYPE html>");
	   out.println("<html>");
	   out.println("<head>");
       try 
       {  
           Class.forName("com.mysql.cj.jdbc.Driver");  
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking?useSSL=false", "root", "Velar@8805");    
           Statement stmt = con.createStatement();  
           ResultSet rs = stmt.executeQuery("select * from employee");  
           out.println("<table border=1");  
           out.println("<tr>"
           		+ "<th>empid</th>"
           		+ "<th>empname</th>"
           		+ "<th>age</th>"
           		+ "<th>salery</th>"
           		+ "</tr>");  
           while (rs.next()) 
           {  
               String id = rs.getString("empid");  
               String ename = rs.getString("empname");  
               int ag=rs.getInt("age");
               int sal = rs.getInt("salary");   
               out.println("<tr>"
               		+ "<td>" + id + "</td>"
               				+ "<td>" + ename + "</td>"
               				+"<td>" + ag + "</td>"
               						+ "<td>" + sal + "</td>"
               								+ "</tr>");   
           }  
           out.println("</table>");  
           out.println("</html></body>");  
           con.close();  
          }  
           catch (Exception e) 
          {  
           e.printStackTrace();
       }    
   }
}
