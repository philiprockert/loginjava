package org.omnicom;

import java.sql.*;

public class Main {
   public static void main(String[] args){
       String url = "jdbc:mysql://localhost:3306/omnicom";
       String user = "root";
       String password = "dimebag1971";
       try {
           Connection conn = DriverManager.getConnection(url,user,password);
           Statement stmt = conn.createStatement();
           ResultSet resultado = stmt.executeQuery("SELECT * from );
       }
        catch (SQLException throwables){
           throwables.printStackTrace();
        }
   }
}