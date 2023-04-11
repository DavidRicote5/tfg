package org.getfit.services;

import java.time.LocalDate;
import java.util.List;
import org.getfit.entities.Usuario;
import org.getfit.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public void saveUsuario(
			String loginname,
			String nombre,
			String contraseña,
			String correo,
			LocalDate fechaNac,
			String genero,
			int altura,
			int peso
			) throws Exception {
		
		Usuario usuario = Usuario.builder().loginname(loginname).nombre(nombre).contraseña(contraseña).correo(correo).fechaNac(fechaNac).genero(genero).altura(altura).peso(peso).build();
		
		try {
			usuarioRepository.saveAndFlush(usuario);
		} catch (Exception e) {
			throw new Exception("El/la usuario " + nombre + " ya existe");
		}
	}

	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public void updateUsuario(
			Long id,
			String nombre,
			LocalDate fechaNac,
			String genero,
			int altura,
			int peso
			) throws Exception {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuario.setNombre(nombre);
		usuario.setFechaNac(fechaNac);
		usuario.setGenero(genero);
		usuario.setAltura(altura);
		usuario.setPeso(peso);
		try {
			usuarioRepository.saveAndFlush(usuario);
		} catch (Exception e) {
			throw new Exception("El/la usuario " + nombre + " ya existe");
		}
	}

	public void deleteUsuario(Long id) {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
}
