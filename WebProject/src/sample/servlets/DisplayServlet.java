package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.beans.PersonalData;
import sample.beans.ProfessionalData;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();
		PersonalData persoanlData=(PersonalData) httpSession.getAttribute("personalData");
		ProfessionalData professionalData=(ProfessionalData) httpSession.getAttribute("professionalData");
		
		out.println("<h2>Personal Details</h2>");
		out.println("<h3>Name: "+persoanlData.getName() +"</h3>");
		out.println("<h3>Email: "+persoanlData.getEmail() +"</h3>");
		
		out.println("<h2>Professional Details</h2>");
		out.println("<h3>Role: "+professionalData.getRole() +"</h3>");
		out.println("<h3>Experience: "+professionalData.getExperience() +"</h3>");
		List<String>  skillSet= professionalData.getSkills();
		String allSkills = "";
		for(String skill:skillSet)
		{
			allSkills = allSkills +skill+",";
		}
		out.print("<h3>Skills: "+allSkills.substring(0, allSkills.length()-1)+"</h3>");
	}

}
