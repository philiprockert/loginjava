package org.omnicom.repositorio;

import org.omnicom.conexion.conexion;
import org.omnicom.modelo.modulousuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImplementUsuario implements repo<modulousuario>{

    private Connection getConnection() throws SQLException {
        return conexion.getInstance();
    }
    @Override
    public List<modulousuario> listar() {
        List<modulousuario> usuario = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs  = stmt.executeQuery("SELECT * FROM usuario")){
            while (rs.next()){
                modulousuario u = Crearusuario(rs);
                usuario.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }


    public modulousuario porId(Long idusuario) {
         modulousuario usuario = null;
         try(PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM usuario WHERE idusuario = ?")) {
             stmt.setLong(1, idusuario);
             ResultSet rs = stmt.executeQuery();
             if (rs.next()){
                 usuario = Crearusuario(rs);
             }
             rs.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }


        return usuario;
    }


    public void guardar( Long op) {
        String sql = null;
        if (op == 3)
        {
           sql = "INSERT INTO usuario (nombre, telefono, email) VALUES (?, ?, ?)";
        }
        else if
        ( op == 4) {
            sql ="UPDATE usuario SET nombre = ?, telefono = ?, email= ? WHERE idusuario =?";
        }


        try(PreparedStatement stmt =getConnection().prepareStatement(sql) ) {
            modulousuario usuario = new modulousuario();
            Scanner scanner = new Scanner(System.in);
            System.out.println("ingresa el nombre");
            String n = scanner.next();
            stmt.setString(1, usuario.getName(n));
            System.out.println("ingresa el telefono");
            String t = scanner.next();
            stmt.setString(2, usuario.getTelefono(t));
            System.out.println("ingresa el correo");
            String c = scanner.next();
            stmt.setString(3, usuario.getEmail(c));
            if (op == 4){
                System.out.println("ingresa el id");
                Long i = scanner.nextLong();
                stmt.setLong(4, usuario.getIdusuario(i));
                stmt.executeUpdate();
            }
                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void eliminar() {
        Scanner scanner = new Scanner(System.in);
        Long id = scanner.nextLong();
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM usuario WHERE idusuario = id")){
           stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static modulousuario Crearusuario(ResultSet rs) throws SQLException {
        modulousuario u = new modulousuario();
        u.setIdusuario(rs.getLong("idusuario"));
        u.setName(rs.getString("nombre"));
        u.setEmail(rs.getString("email"));
        u.setTelefono(rs.getString("telefono"));
        return u;
    }
}
