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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import fr.tbr.iam.services.servlets.GenericSpringServlet;
import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.datamodel.User;
import fr.tbr.iamcore.services.dao.UserDAOInterface;
import fr.tbr.iamcore.services.dao.impl.UserJDBCDAO;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Login")
public class Login extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;
	//UserDAOInterface dao = new UserJDBCDAO();
	
	@Autowired
	UserDAOInterface dao;
    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("got GET request");
		doPost(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("got POST request");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
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
		
		Boolean results = dao.authenticate(user);
		if(results == true)
		{
			HttpSession session = request.getSession();
            session.setAttribute("id", String.valueOf(user.getId()));
            System.out.println(user.getId());
		}
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(results.toString());
	}
}
