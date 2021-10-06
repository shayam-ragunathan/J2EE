package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.beans.DataStore;

/**
 * Servlet implementation class StoreDataServlet
 */
public class StoreDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext ctx =this.getServletContext();
		List<String> contents =Arrays.asList("Core Java","Spring","J2EE Advanced","PL/SQL","SQL");
		DataStore datastore = new DataStore();
		datastore.setContents(contents);
		ctx.setAttribute("languageDataStore", datastore);
		out.println("<h2> Added the Programming languages into Data store </h2>");
	}

}