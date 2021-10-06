package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.beans.UserValidation;
import sample.beans.Users;

/**
 * Servlet implementation class UserValidationServler
 */
public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2> From doGet, No code!!!</h2>");
		response.sendRedirect("login.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				//reading data from request
				String userId = request.getParameter("uid");
				String userPassword = request.getParameter("pwd");
				//adding to bean
				Users user =new Users(userId,userPassword);
				
				//Send bean to another bean for validation
				Boolean isValid = UserValidation.isValid(user);
				RequestDispatcher requestdispatcher = null;
				if(isValid)
				{
					requestdispatcher = request.getRequestDispatcher("userData");
					request.setAttribute("userData", user);
					requestdispatcher.forward(request, response);
				}
				else
				{
					out.println("<h2> Go away!!!</h2>");
					requestdispatcher = request.getRequestDispatcher("login.html");
					requestdispatcher.include(request, response);
				}
	}

}
