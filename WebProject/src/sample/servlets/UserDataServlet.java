package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.beans.UserDetails;
import sample.beans.Users;
import sample.repository.UserRepository;

/**
 * Servlet implementation class UserDataServlet
 */
public class UserDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Users currentUser = (Users) request.getAttribute("userData");
		UserDetails userDetails = UserRepository.getUserById(currentUser);
		out.println("<h2> Printing User details</h2>");
		out.println("<h3>Name: "+userDetails.getFirstName()+ " "+userDetails.getMiddleName()+" " +userDetails.getLastName()+" </h3>");
		out.println("<h3>Email ID: "+userDetails.getEmailId());
		
		
	}

}
