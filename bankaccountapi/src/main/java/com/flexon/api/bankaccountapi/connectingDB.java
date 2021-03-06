package com.flexon.api.bankaccountapi;
import java.sql.*;

public class connectingDB {
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String URL = "jdbc:mysql://bankaccount.creljvovz8f3.us-east-2.rds.amazonaws.com/bankaccount";
    static String USER = "xin1306028";
    static String PASS = "1306028Bb";
    String CREATETABLE = "CREATE TABLE usertable " + "(AccountNumber INTEGER NOT NULL, " + " Name VARCHAR(255),"
    		+ " email VARCHAR(255)" + " phone VARCHAR(255), " + "ssn VARCHAR(225)" + " PRIMARY KEY ( AccountNumber ))";
    
    static Connection conn = null;
      
    public static Connection getConnection() {
      try {
    	  if(conn ==null) {
    		  Class.forName("com.mysql.jdbc.Driver"); 
    		  conn = DriverManager.getConnection(URL,USER,PASS); 
    	  }

      } catch (ClassNotFoundException | SQLException e) {
    	  e.printStackTrace();
      }
      
      return conn;
    }
    
   
    
}
