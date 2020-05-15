package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLite {
	public static void main(String args[]) {
	      try {
	         Class.forName("org.sqlite.JDBC");
	         Connection c = DriverManager.getConnection("jdbc:sqlite:C:\\\\Users\\\\xioma\\\\eclipse-workspace\\\\Servlet\\\\test.db");
	         System.out.println("Base de datos abierta correctamente");

	         Statement consulta = c.createStatement();
	         String sql = "CREATE TABLE USUARIO " +
	                        "(ID	INTEGER	PRIMARY KEY	AUTOINCREMENT,"+
	                        "NICK	VARCHAR(20) NOT NULL," +
	                        "PASS	VARCHAR(20)    NOT NULL, " + 
	                        "EMAIL	VARCHAR (60) NOT NULL)";
	                         
	         consulta.executeUpdate(sql);
	         consulta.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Tabla creada OK");
 }
	
	
}