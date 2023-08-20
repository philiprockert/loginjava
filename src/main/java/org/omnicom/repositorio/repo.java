package org.omnicom.repositorio;

import java.util.List;

public interface repo<T> {
    List<T> listar();
    T porId(Long idusuario);
    void guardar(T t);
    void eliminar(Long idusuario);

}
