package org.getfit.services;

import java.time.LocalDate;

import java.util.List;
import org.getfit.entities.Entrenador;
import org.getfit.entities.Plan;
import org.getfit.entities.Usuario;
import org.getfit.entities.Rutina;
import org.getfit.repositories.EntrenadorRepository;
import org.getfit.repositories.PlanRepository;
import org.getfit.repositories.RutinaRepository;
import org.getfit.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	
	//CABLEAR CONEXIONES
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EntrenadorRepository entrenadorRepository;
	
	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private RutinaRepository rutinaRepository;

	/*==================================================================================*/
	
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public void saveUsuario(String username, String nombre, String contraseña, String correo, LocalDate fechaNac, String genero, int altura, int peso, Long idEntrenador, Long idPlan, Long idRutina) throws Exception {
		Usuario usuario = Usuario.builder().username(username).nombre(nombre).contraseña(contraseña).fechaNac(fechaNac).genero(genero).altura(altura).peso(peso).build();
		
		//GESTION DE ENTRENADOR
		Entrenador entrenador = entrenadorRepository.getById(idEntrenador);
		usuario.setEntrenador(entrenador);
		
		//GESTION DE PLAN
		Plan plan = planRepository.getById(idPlan);
		usuario.setPlan(plan);
		
		//GESTION DE RUTINA
		Rutina rutina = rutinaRepository.getById(idRutina);
		usuario.setRutina(rutina);
		
		try {
			usuarioRepository.saveAndFlush(usuario);
		} catch (Exception e) {
			throw new Exception("El/la usuario " + username + " ya existe");
		}
	}

	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public void updateUsuario(Long id, String nombre) throws Exception {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuario.setNombre(nombre);
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

