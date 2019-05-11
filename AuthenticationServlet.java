package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.StudentDAO;
import com.ts.dto.Student;

@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email=request.getParameter("email");
		StudentDAO studentDao = new StudentDAO();
		Student student = studentDao.getStudentByEmail(email);
		HttpSession session = request.getSession(true);
		session.setAttribute("status", "clockin");
		if(student!=null){
			session.setAttribute("userId",student.getStuId());
			RequestDispatcher rd = request.getRequestDispatcher("StudentDashboard.jsp");
			rd.forward(request, response);
		}
		else{
			out.println("<html>");
			out.print("<body>");
			out.println("<h1>Record not found..</h1>");
			out.print("</body>");
			out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
