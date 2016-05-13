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
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String filename = request.getParameter("filename");
        HttpSession session = request.getSession();
        ServletContext sc = session.getServletContext();
        URL url = sc.getResource("/"+filename+".xml");
//        String path = getServletContext().getRealPath("/");
        System.out.println("in serv: "+url.toString());
        XMLParser parser = new XMLParser ();
        PrintWriter out = response.getWriter();
        try
        {
            String doc = parser.parse(url);
            out.println(doc);
        }
        catch (DocumentException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}