package org.omnicom.modelo;

public class modulousuario {
    private Long idusuario;
    private String name;
    private String telefono;
    private String correo;

    public modulousuario(Long idusuario, String name, String telefono, String correo) {
        this.idusuario = idusuario;
        this.name = name;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }
}
