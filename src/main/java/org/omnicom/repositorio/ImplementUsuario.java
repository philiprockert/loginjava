package org.omnicom.repositorio;

import org.omnicom.conexion.conexion;
import org.omnicom.modelo.modulousuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                modulousuario u = new modulousuario();
                u.setIdusuario(rs.getLong("idusuario"));
                u.setName(rs.getString("name"));
                u.setCorreo(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                usuario.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public modulousuario porId(Long idusuario) {
        return null;
    }

    @Override
    public void guardar(modulousuario modulousuario) {

    }

    @Override
    public void eliminar(Long idusuario) {

    }
}
