package org.omnicom;

import org.omnicom.conexion.conexion;
import org.omnicom.modelo.modulousuario;
import org.omnicom.repositorio.ImplementUsuario;
import org.omnicom.repositorio.repo;

import java.sql.*;

public class Main {
   public static void main(String[] args){


       try (Connection conn = conexion.getInstance() ;

           ){

           repo<modulousuario> repositorio = new ImplementUsuario();
            repositorio.listar().forEach(u -> System.out.println(u.getName()));
       }
       catch (SQLException throwables){
           throwables.printStackTrace();
       }
   }
}