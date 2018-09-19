package br.com.mvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	  private static String C_FORNAME = "org.mariadb.jdbc.Driver";
	  private static String URL = "jdbc:mysql://localhost:3306/test";
	  private static String USER = "usr_bd";
	  private static String PASSW = "enterdb";
	  
	  public Connection getConnection(){
		  try{
	        Class.forName( C_FORNAME );
	        return DriverManager.getConnection(URL, USER, PASSW);
		  }catch(SQLException erroSQL){
		    throw new  RuntimeException(erroSQL);
		  }catch(ClassNotFoundException erroClasse){
		    throw new  RuntimeException(erroClasse);
		  }
	  }
}
