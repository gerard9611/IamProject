package fr.tbr.iam.services.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.tbr.iam.services.servlets.GenericSpringServlet;
import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.services.dao.IdentityDAOInterface;
import fr.tbr.iamcore.services.dao.impl.IdentityJDBCDAO;

/**
 * Servlet implementation class Read
 */
@WebServlet("/ReadIdentity")
public class ReadIdentity extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;
	//IdentityDAOInterface dao = new IdentityJDBCDAO();
	
	@Autowired
	IdentityDAOInterface dao;
    /**
     * Default constructor. 
     */
    public ReadIdentity() {
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
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Identity> identities = new ArrayList<Identity>();
		
		String searchText = request.getParameter("searchText");
		System.out.println("got POST request with text ");
		if(searchText.isEmpty())
		{
			identities=(ArrayList<Identity>) dao.readAll();
		}
		else
		{
			identities=(ArrayList<Identity>) dao.search(searchText);
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	    String json = gson.toJson(identities);
	    System.out.println(json);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}
}
