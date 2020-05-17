package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;


public class InsertIntoDatabase {
	
	public static void main( String args[] ) {
		try {
			Class.forName("org.sqlite.JDBC");
			
			InsertIntoDatabase db = new InsertIntoDatabase();
			Connection c = db.conectar();
			
			System.out.println("Base de datos abierta correctamente desde InsertIntoDatabase");
	         
	        Statement query = c.createStatement(); 
	        String sql =("INSERT INTO USER (nick, pass, email ) VALUES('patri', '2jshwyq', 'marc@bhnj.com')");
	        
	        int update = query.executeUpdate(sql);
	        
	        query.close();
	        c.close();
	        System.out.println(update+" row insert");
			} catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
			}
	     
	   }
	
	public Connection conectar() {

		
		Connection c = null;
		
		File archivo = new File("C:\\Users\\xioma\\eclipse-nuevo\\BuyArk\\src\\main\\resources\\config.properties");
		
		try (InputStream inputStream = new FileInputStream(archivo)){
			Properties prop = new Properties();
			prop.load(inputStream);
			
			String url = prop.getProperty("URL");
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection(url);
		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
		}
		return c;
		
		
	}
}


