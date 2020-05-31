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
	
	public static void main( String args[] ) throws SQLException {
		SQLite db = new SQLite();
    	db.createTableUser();
	   }
	
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
        } finally {
        	stmt.close();
            con.close();
        }
        LOGGER.log(Level.INFO, "Table created successfully");
    }
	
}