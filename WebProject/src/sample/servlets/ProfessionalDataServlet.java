package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.beans.ProfessionalData;

/**
 * Servlet implementation class ProfessionalData
 */
public class ProfessionalDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String role=request.getParameter("role");
		int experience=Integer.parseInt(request.getParameter("experience"));
		
		String skills[]=request.getParameterValues("skills");
		List<String> skillSet= Arrays.asList(skills);
		
		ProfessionalData professionalData= new ProfessionalData(role,experience,skillSet);
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("professionalData", professionalData);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.html");
		out.println("<h2> Captured Professional Details</h2>");
		requestDispatcher.include(request, response);
	}

}
