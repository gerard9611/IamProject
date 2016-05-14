package fr.tbr.iam.services.servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import fr.tbr.iamcore.datamodel.User;
import fr.tbr.iamcore.services.dao.UserDAOInterface;
import fr.tbr.iamcore.services.dao.impl.UserJDBCDAO;

/**
 * Servlet implementation class Create
 */
@WebServlet("/CreateUser")
public class CreateUser extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;
	//UserDAOInterface dao = new UserJDBCDAO();

	@Autowired
	UserDAOInterface dao;
	/**
	 * Default constructor. 
	 */
	public CreateUser() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * This is used to create a User, it creates a User and an Identity
	 * and write both on the DB
	 * Knowing that a USER is an Identity
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param fname, lname, username, password, email, date
	 * @return redirects with or without error message
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("got POST request");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String rawDate = request.getParameter("date");
		Identity identity = new Identity(fname,lname,null);

		MessageDigest digest = null;
		try 
		{
			digest = MessageDigest.getInstance("SHA-256");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

		User user = User.getInstance();

		user.setUsername(username);
		user.setPassword(String.format("%064x", new java.math.BigInteger(1, hash)));

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(rawDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		identity.setBirthDate(date);
		identity.setEmail(email);
		user.setUserIdentity(identity);
		boolean res = dao.write(user);
		response.setCharacterEncoding("UTF-8");
		if(res == true)
			response.sendRedirect("/iamweb/");
		else
			response.sendRedirect("/iamweb/index.jsp?msg=error");
	}
}
