package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLite {
	private static final Logger LOGGER = Logger.getLogger("main.java.SQLite");
	
	
	public Connection conectar() throws FileNotFoundException, IOException {
		Connection c = null;
		File archivo = new File("C:\\Users\\xioma\\eclipse-nuevo\\BuyArk\\src\\main\\resources\\config.properties");
		
		try (InputStream inputStream = new FileInputStream(archivo)) {
			Properties prop = new Properties();
            prop.load(inputStream);
            
            String uri = prop.getProperty("URI");
            
            Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection(uri);         
	      } catch ( Exception e ) {
	    	  LOGGER.log(Level.SEVERE, e.getMessage());
	      }
	      return c;
		
	}
	

	public void crearCompra() throws SQLException {
		Connection c = null;
		Statement stmt = null;
    
		try {
			SQLite db = new SQLite();
    		c = db.conectar();
			stmt = c.createStatement();
			
			String sql = "CREATE TABLE IF NOT EXISTS COMPRA (" +
       			 	"ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
       			    "NICK  VARCHAR(20) NOT NULL, " +
	                "PRODUCTOS VARCHAR(500), " + 
	                "PAGO VARCHAR(25), " + 
	                "FOREIGN KEY (NICK) REFERENCES USER (NICK)" +
	                ")";
       
       
       stmt.executeUpdate(sql);
		} catch (Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        LOGGER.log(Level.INFO, "Table COMPRAS created successfully");
    }

	
	public void crearComentario() throws SQLException {
		Connection c = null;
		Statement stmt = null;
    
		try {
			SQLite db = new SQLite();
    		c = db.conectar();
			stmt = c.createStatement();
			
			String sql = "CREATE TABLE IF NOT EXISTS COMENTARIOS (" +
       			 	"ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
       			    "NICK  VARCHAR(10) NOT NULL, " +
	                "COMMENTS VARCHAR(500), " + 
	                "FOREIGN KEY (NICK) REFERENCES USER (NICK)" +
	                ")";
       
       stmt.executeUpdate(sql);
		} catch (Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        LOGGER.log(Level.INFO, "Table COMENTARIOS created successfully");
    }

	
	
}