package com.olganails.Inventarioapp.Services;

import java.util.List;
import java.util.Optional;


import com.olganails.Inventarioapp.Models.UsuarioModel;

public interface UsuarioService {
    List<UsuarioModel> obtenerTodosUsuarios();
    Optional<UsuarioModel> obtenerUsuarioPorId(String id);
    void crearUsuario(UsuarioModel usuario);
    void actualizarUsuario(UsuarioModel usuario);
    void borrarUsuario(String id);
    boolean tienePermisoAccesoTotal(String username);
    UsuarioModel findByUsername(String username);
}
