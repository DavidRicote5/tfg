package com.getfit.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getfit.excepciones.UsuarioFoundException;
import com.getfit.modelo.Entrenador;
import com.getfit.modelo.Usuario;
import com.getfit.modelo.UsuarioRol;
import com.getfit.repositorios.RolRepository;
import com.getfit.repositorios.UsuarioRepository;
import com.getfit.servicios.UsuarioService;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
	public void eliminarUsuario(Long usuarioId) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioId);
		usuarioRepository.delete(usuario);
		
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Set<Usuario> obtenerUsuarios() {
	    return new LinkedHashSet<>(usuarioRepository.findAll());  
	}

}