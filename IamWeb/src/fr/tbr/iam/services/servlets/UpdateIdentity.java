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
 * Servlet implementation class Update
 */
@WebServlet("/UpdateIdentity")
public class UpdateIdentity extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	IdentityDAOInterface dao;
	/**
	 * Default constructor. 
	 */
	public UpdateIdentity() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * This is not used anymore (OLD)
	 * This is used to update the identity in the DB
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param id, fname, lname, email, date
	 * @return nothing
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("got POST request");
		Integer id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String rawDate = request.getParameter("date");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(rawDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Identity identity = new Identity(fname, lname, email,date);
		identity.setId(id);
		dao.update(identity);
		System.out.println(fname +" "+lname +" "+  rawDate);
	}
}
