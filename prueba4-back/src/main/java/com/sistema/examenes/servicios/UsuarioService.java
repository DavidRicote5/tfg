package com.sistema.examenes.servicios;

import com.sistema.examenes.modelo.Categoria;
import com.sistema.examenes.modelo.Usuario;
import com.sistema.examenes.modelo.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);
    
    public Usuario actualizarUsuario(Usuario usuario);
    
    Set<Usuario> obtenerUsuarios();

    public void eliminarUsuario(Long usuarioId);
}
