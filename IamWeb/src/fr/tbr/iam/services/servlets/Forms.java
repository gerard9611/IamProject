package fr.tbr.iam.services.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.springframework.web.util.UrlPathHelper;

import fr.tbr.iam.parser.XMLParser;

/**
 * Servlet implementation class Forms
 */
@WebServlet("/Forms")
public class Forms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Forms() {
		super();
	}

	/**
	 * This function is used to call the Forms XML Parser and return the parsed data
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param filename
	 * @return String as the document content
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("filename");
		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		URL url = sc.getResource("/"+filename+".xml");
		XMLParser parser = new XMLParser ();
		PrintWriter out = response.getWriter();
		try
		{
			String doc = parser.parse(url);
			out.println(doc);
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}