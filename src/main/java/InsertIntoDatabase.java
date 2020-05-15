package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertIntoDatabase {
	
	public static void main( String args[] ) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:test.db");
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
	
}


