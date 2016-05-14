package fr.tbr.iam.services.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.tbr.iam.services.servlets.GenericSpringServlet;
import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.services.dao.IdentityDAOInterface;
import fr.tbr.iamcore.services.dao.impl.IdentityJDBCDAO;

/**
 * Servlet implementation class Create
 */
@WebServlet("/DeleteIdentity")
public class DeleteIdentity extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	IdentityDAOInterface dao;
	/**
	 * Default constructor. 
	 */
	public DeleteIdentity() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * This is used to delete an identity from the DB
	 * It creates a new identity and delete it.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param id
	 * @return boolean succes, fail
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("got POST request");
		Integer id = Integer.parseInt(request.getParameter("id"));

		Identity identity = new Identity();
		identity.setId(id);

		Boolean results = dao.delete(identity);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(results.toString());
	}
}
