package org.omnicom;

import java.sql.*;
import java.util.Scanner;

public class Main {
   public static void main(String[] args){
       String url = "jdbc:mysql://localhost:3306/omnicom";
       String user = "root";
       String password = "dimebag1971";
       Scanner scanner = new Scanner(System.in);

       System.out.print("Ingresa tu nombre: ");
       String nombre = scanner.nextLine();

       System.out.print("Ingresa tu telefono: ");
       String tel = scanner.nextLine();
       try (Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM usuario")){
           String sql = "INSERT INTO usuario (name, telefono) VALUES (?, ?)";

           // Crear un PreparedStatement para la sentencia SQL
           PreparedStatement preparedStatement = conn.prepareStatement(sql);
           preparedStatement.setString(1, nombre);
           preparedStatement.setString(2, tel);

           // Ejecutar la inserción
           preparedStatement.executeUpdate();
           while (resultado.next()){
               System.out.println(resultado.getString("name"));
               System.out.println(resultado.getString("telefono"));
               System.out.println(resultado.getInt("idusuario"));
           }
       }
       catch (SQLException throwables){
           throwables.printStackTrace();
       }
   }
}