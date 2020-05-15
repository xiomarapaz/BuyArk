package main.java;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        super();
        // TODO Auto-generated constructor stub
    }

    // ACABAR DE COMPARAR LOS DATOS DE REGISTRO
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        // Patrón para validar el email
        Pattern mail = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,})$");
		
        //Patron para validar contraseña
        Pattern pwd = Pattern
        		.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        
        //Patron para validar usuario
        Pattern user = Pattern
        		.compile("^[A-Za-z0-9]{10}$");
        
      //Recoger parametros
    	String usuari = req.getParameter("user");
		String pass = req.getParameter("password");
        String email = req.getParameter("email");
        
        //comprobaciones con las expresiones
        Matcher matmail = mail.matcher(email);
        Matcher matpwd = pwd.matcher(pass);
        Matcher matuser = user.matcher(usuari);
        
  
        if (matmail.find() == true && matpwd.find() == true && matuser.find() == true) {
           	//ComprobarDatos();
        	InsertarDatos(usuari, pass, email);
            response(resp, "Felicidades "+usuari+" Registro realizado!");
            response(resp, "Tus datos son: "+pass+" "+email);
           
//            try {
//    			Class.forName("org.sqlite.JDBC");
//    			String dbURL = "jdbc:sqlite:C:\\Users\\xioma\\eclipse-workspace\\Servlet\\test.db";
//    			
//    			Connection c = DriverManager.getConnection(dbURL+"sqlite:test.db");
//    	        System.out.println("Base de datos conectada");
//
//    	        System.out.println("Felicidades "+usuari+" Registro realizado!");
//    	        System.out.println("Tus datos son: "+pass+" "+email);
//    	        
//    	        Statement query = c.createStatement(); 
//    	        /*
//    	        String sql = ("insert into USER(NICK, PASS, EMAIL) values('"+usuari+"','"+pass+"','"+email+"')"
//    	        			);
//    	        query.executeUpdate(sql);
//    	        */
//    	        String sql =("INSERT INTO USER (nick, pass, email ) VALUES('"+usuari+"','"+pass+"','"+email+"')");
//
////    	        int i=query.executeUpdate ("insert into USER(NICK, PASS, EMAIL) values('"+usuari+"','"+pass+"','"+email+"');");
//    	        int i=query.executeUpdate (sql);
//    	        query.close();
//    	        
//    	        c.close();
//    	        System.out.println("Insert hecho");
//    			} catch ( Exception e ) {
//    	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//    	         System.exit(0);
//    			}
        	}else {
        	response(resp, "Registro incorrecto.");
        }
        /*
        int r = ComprobarDatos();
		if (r==1) {
			System.out.println("Usuario ya creado");	
		}*/
        
    }//Final de void 
    
    //AÑADIR DATOS A LA BBDD
    public static void InsertarDatos(String usuari, String pass, String email) {
    	try {
    		Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:test.db");
			
	        System.out.println("Base de datos conectada!!!!!!!!!!!!");
	         
	        Statement query = c.createStatement(); 
	        
	        String sql =("INSERT INTO USER (NICK, PASS, EMAIL ) VALUES('"+usuari+"','"+pass+"','"+email+"')");
	        			
	        query.executeUpdate(sql);
	        
	        query.close();
	        c.close();
	        System.out.println("Insert hecho");
			} catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
			}
    }
    
    
	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}

	//Comprobar datos en la bbdd
    public static int ComprobarDatos() {
    	try {			
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        System.out.println("Base de datos conectada");
	         
	        Statement query = c.createStatement(); 
	        String sql = ("SELECT * FROM USER");
	        int r = query.executeUpdate(sql);
	        query.close();
	        c.close();
	        //si encuentra el mismo usuario dentro de la bbdd devolvera 1
	        return r;
	        
    		} catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
			}
		return 0;
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
