package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.beans.PersonalData;

/**
 * Servlet implementation class PesonalDataServlet
 */
public class PesonalDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String emailID=request.getParameter("emailId");
		PersonalData personalData= new PersonalData(name,emailID);
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("personalData", personalData);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("professional.html");
		out.println("<h2> Captured personal Details</h2>");
		requestDispatcher.include(request, response);
		
	
	}

}
