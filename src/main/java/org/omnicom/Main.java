package org.omnicom;

import com.sun.source.tree.SwitchTree;
import org.omnicom.conexion.conexion;
import org.omnicom.modelo.modulousuario;
import org.omnicom.repositorio.ImplementUsuario;
import org.omnicom.repositorio.repo;

import java.lang.invoke.SwitchPoint;
import java.sql.*;
import java.util.Scanner;

public class Main {
   public static void main(String[] args){


       try (Connection conn = conexion.getInstance() ;

           ){

           repo<modulousuario> repositorio = new ImplementUsuario();
           Scanner scanner = new Scanner(System.in);
           System.out.println("elige una opcion: " + "1 imprimir datos" + "2 buscar por id"
                   + "3 insertar un nuevo usuario" +"4 actualizar un dato" + " 5 eliminar un usuario");
           Long opcion = scanner.nextLong();
           if (opcion == 1) {
               repositorio.listar().forEach(System.out::println);
           } else if (opcion == 2) {
               Long id = scanner.nextLong();
               System.out.println(repositorio.porId(id));
           } else if (opcion == 3) {
               repositorio.guardar(opcion);
           } else if (opcion == 4) {
               repositorio.guardar(opcion);
           } else if (opcion == 5) {
               repositorio.eliminar();
           }


       }
       catch (SQLException throwables){
           throwables.printStackTrace();
       }
   }
}