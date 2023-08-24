package org.omnicom.modelo;

public class modulousuario {
    private Long idusuario;
    private String nombre;
    private String telefono;
    private String email;



    public String toString() {
        return
                        idusuario +
                        " | " +
                                nombre +
                        " | "  +
                        telefono +
                        " | " +
                                email;
    }

    public modulousuario() {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getEmail(String email) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono(String telefono) {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getName(String nombre) {
        return nombre;
    }
    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdusuario(Long idusuario) {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }


}
