package org.getfit.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.getfit.entities.Ejercicio;
import org.getfit.entities.Entrenador;
import org.getfit.entities.Plan;
import org.getfit.entities.Rutina;
import org.getfit.entities.Usuario;
import org.getfit.repositories.RutinaRepository;
import org.getfit.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RutinaRepository rutinaRepository;
	

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
			int peso,
			Plan plan,
			Long[] idRutinas
			
			) throws Exception {
		
		Usuario usuario = Usuario.builder().loginname(loginname).nombre(nombre).contraseña(contraseña).correo(correo).fechaNac(fechaNac).genero(genero).altura(altura).peso(peso).plan(plan).build();

		// GESTION DE RUTINAS
		Collection<Rutina> rutinas = new ArrayList<Rutina>();
		for (Long idRutina : idRutinas) {
			Rutina rutina = rutinaRepository.getById(idRutina);
			rutinas.add(rutina);
			rutina.getUsuarios().add(usuario);
		}
		usuario.setRutinas(rutinas);

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
			int peso,
			Plan plan,
			Entrenador entrenador,
			Long[] idRutinas

			) throws Exception {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuario.setNombre(nombre);
		usuario.setFechaNac(fechaNac);
		usuario.setGenero(genero);
		usuario.setAltura(altura);
		usuario.setPeso(peso);
		usuario.setPlan(plan);
		usuario.setEntrenador(entrenador);
		
		// GESTION DE RUTINAS
		List<Rutina> rutinas = new ArrayList<Rutina>();
		for (Long idRutina : idRutinas) {
			Rutina rutina = rutinaRepository.getById(idRutina);
			rutinas.add(rutina);
			rutina.getUsuarios().add(usuario);
		}
		usuario.getRutinas().addAll(rutinas);

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
