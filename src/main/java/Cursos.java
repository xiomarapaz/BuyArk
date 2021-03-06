package main.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cursos
 * @author xioma
 */
@WebServlet("/Cursos")
public class Cursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("main.java.Login");

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cursos() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param nickname and commment
	 * 
	 * method that takes the values from the section of opinions and do a insert into the database
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String n = req.getParameter("nickname");
		String coment= req.getParameter("comentario");

		 try {
			 	SQLite db = new SQLite();
			 	db.crearComentario();
			 	this.insertarComentario(n, coment);
				resp.sendRedirect("html/comentario_ok.jsp");
			} catch (NullPointerException | SQLException e) {
				LOGGER.log(Level.SEVERE, e.getMessage());
				resp.sendRedirect("html/comentario_NOTok.jsp");
			}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param curses, payment, user
	 * 
	 * method that takes the values from the buy of the curses, and do a insert into the database
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] cursos = req.getParameterValues("image[]");
		
		String aux = "";
		
		for (int i=0; i<cursos.length; i++) {
			aux += cursos[i] + ",";
		}
		
		String pago = req.getParameter("payment");
		String user = req.getParameter("nickname");
		
		try {
				SQLite db = new SQLite();
				db.crearCompra();
				this.insertarCompra(user, aux, pago);
				resp.sendRedirect("html/compraOK.jsp");
		} catch (NullPointerException | SQLException | IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			resp.sendRedirect("html/compra_NOTokjsp");
		} 
	}
	
	/**
	 * 
	 * function that does insert inside the database
	 * 
	 * @param nickname
	 * @param comment
	 */
	public void insertarComentario(String n, String comment) throws SQLException {
		Connection c = null;
		Statement stmt = null;
    
		try {
			SQLite db = new SQLite();
    		c = db.conectar();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			String query = "INSERT INTO COMENTARIOS (NICK,COMMENTS) VALUES ('"+n+"','"+comment+"');";
			stmt.executeUpdate(query);
			c.commit();
		} catch (Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage());
        }	finally {
        	c.close();
        	stmt.close();
        }
		LOGGER.log(Level.INFO, "Comentario a�adido correctamente");
	}
	
	
	/**
	 * function that does insert inside the database
	 * @param nickname
	 * @param curses
	 * @param pago
	 */
	public void insertarCompra(String n, String aux, String pago) throws SQLException {
		Connection c = null;
    	Statement stmt = null;
    	
    	try {
    		SQLite db = new SQLite();
    		c = db.conectar();
    		c.setAutoCommit(false);
    		stmt = c.createStatement();
    		
    		String sql = "INSERT INTO COMPRA (NICK, PRODUCTOS, PAGO) " +
                    "VALUES ('" + n+ "', '" + aux+ "', '" + pago+ "');"; 
    		
    		stmt.executeUpdate(sql);
    		c.commit();
    		
    	} catch (Exception e) {
    		LOGGER.log(Level.SEVERE, e.getMessage());
    	} finally {
    		stmt.close();
    		c.close();
    	}
    	LOGGER.log(Level.INFO, "Compra a�adida correctamente");
		
	}
	
	
}
