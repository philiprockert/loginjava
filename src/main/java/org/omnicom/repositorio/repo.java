package org.omnicom.repositorio;

import org.omnicom.modelo.modulousuario;

import java.util.List;

public interface repo<T> {
    List<T> listar();
    T porId(Long idusuario);
    void  guardar(Long op);
    void eliminar();

}
