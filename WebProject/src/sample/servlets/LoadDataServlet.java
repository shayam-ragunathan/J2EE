package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
public class LoadDataServlet extends HttpServlet {
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
		Object dataStoreObject= ctx.getAttribute("languageDataStore");
		DataStore dataStore = (DataStore) dataStoreObject;
		List<String>  languageList= dataStore.getContents();
		languageList.stream().forEach((languageLists) -> out.println("<h3>" + languageLists + "</h3>"));
		
		
		out.println("<h2> Retrived Programming languages From Data store </h2>");
	}
}
