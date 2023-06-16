package com.getfit.servicios;


import java.util.Set;

import com.getfit.modelo.Usuario;
import com.getfit.modelo.UsuarioRol;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);
    
    public Usuario actualizarUsuario(Usuario usuario);
    
    Set<Usuario> obtenerUsuarios();

    public void eliminarUsuario(Long usuarioId);
}