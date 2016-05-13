package fr.tbr.iam.services.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/CreateIdentity")
public class CreateIdentity extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;
	//IdentityDAOInterface dao = new IdentityJDBCDAO();
	
	@Autowired
	IdentityDAOInterface dao;
    /**
     * Default constructor. 
     */
    public CreateIdentity() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("got GET request");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("got POST request");
		Identity identity = new Identity();
		
		if(!request.getParameter("id").equals(""))
		{	
			int id = Integer.parseInt(request.getParameter("id"));
			identity.setId(id);
		}
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String rawDate = request.getParameter("date");
		
		
		identity.setFirstName(fname);
		identity.setLastName(lname);
		identity.setEmail(email);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try 
		{
			date = formatter.parse(rawDate);
		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("got POST request");
			e.printStackTrace();
		}
		identity.setBirthDate(date);
		boolean res = dao.write(identity);
		response.setCharacterEncoding("UTF-8");
		if(res == true)
		{
			response.sendRedirect("/iamweb/create.jsp");
		}
		else
		{
			response.sendRedirect("/iamweb/create.jsp?msg=error");
		}
	    
	}
}
