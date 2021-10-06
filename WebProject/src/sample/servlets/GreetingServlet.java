package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetingServlet
 */
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		System.out.println("Shyam Initializing the GreetingServlet");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = this.getInitParameter("firstName") + " "+this.getInitParameter("middleName");
		String message = this.getInitParameter("greetingMessage") + " " +name ;
		out.println("<h2>"+message +"</h2>");
		this.getServletContext().setInitParameter("Greeting", "Hello");
		out.println("<h2>"+this.getServletContext().getInitParameter("Greeting") +" From ServletContext</h2>");
		out.println("<h2>"+this.getServletContext().getInitParameter("contextFirstName") + " "+this.getServletContext().getInitParameter("contextLastName") +" From ServletContext</h2>");
			}

}
