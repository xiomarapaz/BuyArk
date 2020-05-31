package main.java;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.logging.Logger;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("main.java.Registro");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        super();
    }

    public void createTableUser() throws SQLException, NullPointerException {
    	Connection con = null;
        Statement stmt = null;
        try {
        	SQLite db = new SQLite();
        	con = db.conectar();
        	stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS USER (" +
            			 "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "NICK  VARCHAR(20) NOT NULL," +
                         "PASS VARCHAR(20), " + 
                         "EMAIL VARCHAR(20)" + 
                         ")";
            
            stmt.executeUpdate(sql);
        } catch (Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage());
        } 
        LOGGER.log(Level.INFO, "Table created successfully");
    }
    
    public void insertaUser(String nickname, String password, String email) throws SQLException, NullPointerException {
    	Connection con = null;
    	Statement stmt = null;
    	
    	try {
    		SQLite db = new SQLite();
    		con = db.conectar();
    		con.setAutoCommit(false);
    		stmt = con.createStatement();
    		
    		String sql = "INSERT INTO USER (NICK, PASS, EMAIL) " +
                    "VALUES ('" + nickname+ "', '" + password+ "', '" + email+ "');"; 
    		
    		stmt.executeUpdate(sql);
    		con.commit();
    		
    	} catch (Exception e) {
    		LOGGER.log(Level.SEVERE, e.getMessage());
    	} finally {
    		stmt.close();
    		con.close();
    	}
    	LOGGER.log(Level.INFO, "User inserted successfully");
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    	
    	try {
			this.createTableUser();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
    	
        // Patrón para validar el email
        Pattern mail = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,})$");
		
        //Patron para validar contraseña
        Pattern pwd = Pattern
        		.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        
        //Patron para validar usuario
        Pattern user = Pattern
        		.compile("^[A-Za-z0-9]{3,}$");
        
      //Recoger parametros
    	String usuari = req.getParameter("user");
		String pass = req.getParameter("pass");
        String email = req.getParameter("email");
        
        //comprobaciones con las expresiones
        Matcher matmail = mail.matcher(email);
        Matcher matpwd = pwd.matcher(pass);
        Matcher matuser = user.matcher(usuari);
        
  
        if (matmail.find() == true && matpwd.find() == true && matuser.find() == true) {
        	try {
        		insertaUser(usuari, pass, email);
        	} catch (Exception e) {
        		LOGGER.log(Level.SEVERE, e.getMessage());
        	} 
        	LOGGER.log(Level.INFO, "Usuario creado correctamente");
        		resp.sendRedirect("html/registro_ok.jsp");
        	}else {
				resp.sendRedirect("html/registro_NOTok.jsp");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}