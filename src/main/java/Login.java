package main.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 * @author xioma
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("main.java.Login");
       
    /**
     * @see HttpServlet#HttpServlet()
     * constructor from the class
     */
    public Login() {
        super();
    }
    
    /**
     * @param user, pass
     * @throws Servlet
     * 
     * contrast the values from the requests (user, pass) with the values in the database 
     */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, FileNotFoundException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		Connection c = null;
    	Statement stmt = null;
    	
		try {				
		    	SQLite db = new SQLite();
	    		c = db.conectar();
	    		stmt = c.createStatement();
	    		String q ="SELECT count(nick) FROM USER WHERE nick='"+user+"' AND pass='"+pass+"'";
				ResultSet r = stmt.executeQuery(q);
				while(r.next()){
					String countRow=r.getString(1);
					if(countRow.equals("1")){
						//se inicia sesion del usuario
						HttpSession sesion = req.getSession(true);
						sesion.setAttribute("user", user);
						sesion.setMaxInactiveInterval(200);
						resp.sendRedirect("html/index.jsp");
		    		} else {
		    			resp.sendRedirect("html/login_NOTok.jsp");
		    		}
				}	
		}
			 catch (NullPointerException | SQLException | IOException e) {
				 resp.sendRedirect("html/login_NOTok.jsp");		}
				}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}	


}
