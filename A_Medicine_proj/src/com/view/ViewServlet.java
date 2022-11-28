package com.view;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Med;
import com.model.MedDao;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add New Medicines</a>");
		out.println("<h1>Medicines List</h1>");
		
		List<Med> list=MedDao.getAllMedicines();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>company</th><th>Mfddate</th><th>ExpDate</th><th>Edit</th><th>Delete</th></tr>");
		for(Med e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getCompany()+"</td><td>"+e.getMfddate()+"</td><td>"+e.getExpDate()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
