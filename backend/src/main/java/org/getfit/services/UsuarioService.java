package org.getfit.services;

import java.time.LocalDate;



import java.util.List;
import org.getfit.entities.Entrenador;
import org.getfit.entities.Plan;
import org.getfit.entities.Rol;
import org.getfit.entities.Usuario;
import org.getfit.entities.Rutina;
import org.getfit.repositories.EntrenadorRepository;
import org.getfit.repositories.PlanRepository;
import org.getfit.repositories.RolRepository;
import org.getfit.repositories.RutinaRepository;
import org.getfit.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private RolRepository rolRepository;

	/*==================================================================================*/
	
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}
	
	
	public Usuario saveAdmin(
			String loginname,
			String nombre,
			String contraseña,
			String correo,
			LocalDate fechaNac,
			String extension,
			String genero,
			int altura,
			int peso,
			Long idEntrenador,
			Long idPlan,
			Long idRutina) throws Exception {
		
		// Gestión de atributos "regulares"
		Usuario usuario = Usuario.builder().loginname(loginname).nombre(nombre).contraseña(new BCryptPasswordEncoder().encode(contraseña)).correo(correo).fechaNac(fechaNac).extension(extension).genero(genero).altura(altura).peso(peso).build();

		// Gestión de roles
		Rol rol = rolRepository.findByNombre("admin");
		usuario.setRol(rol);
		
		try {
			usuarioRepository.saveAndFlush(usuario);
			return usuario;
		} catch (Exception e) {
			throw new Exception("El/la usuario " + nombre + " ya existe");
		}
	}
	

	public Usuario saveUsuario(
			String loginname,
			String nombre,
			String contraseña,
			String correo,
			LocalDate fechaNac,
			String extension,
			String genero,
			int altura,
			int peso,
			Long idEntrenador,
			Long idPlan,
			Long idRutina) throws Exception {
		
		// Gestión de atributos "regulares"
		Usuario usuario = Usuario.builder().loginname(loginname).nombre(nombre).contraseña(new BCryptPasswordEncoder().encode(contraseña)).correo(correo).fechaNac(fechaNac).extension(extension).genero(genero).altura(altura).peso(peso).build();
		
		
		// GESTION DE ROLES
		Rol rol = rolRepository.findByNombre("user");
		usuario.setRol(rol);
		
		
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
			return usuario;
		} catch (Exception e) {
			throw new Exception("El/la usuario " + loginname + " ya existe");
		}
	}

	//OBETENER UN USUARIO MEDIANTE UN ID
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).get();
	}

	// UPDATE USUARIO
	public void updateUsuario(Long idUsuario, String nombre, Long idEntrenador, Long idPlan, Long idRutina) throws Exception {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		usuario.setNombre(nombre);
		
		//ENTRENADOR
		if (usuario.getEntrenador()==null || idEntrenador != usuario.getEntrenador().getId()) {
			Entrenador nuevoEntrenador = entrenadorRepository.getById(idEntrenador);
			usuario.setEntrenador(nuevoEntrenador);
		}
		
		//PLAN
		if (usuario.getPlan()==null || idPlan != usuario.getPlan().getId()) {
			Plan nuevoPlan = planRepository.getById(idPlan);
			usuario.setPlan(nuevoPlan);
		}
				
		//RUTINA
		if (usuario.getRutina()==null || idRutina != usuario.getRutina().getId()) {
			Rutina nuevoRutina = rutinaRepository.getById(idRutina);
			usuario.setRutina(nuevoRutina);
		}
		
		try {
			usuarioRepository.saveAndFlush(usuario);
		} catch (Exception e) {
			throw new Exception("El/la usuario " + nombre + " ya existe");
		}
	}

	//DELETE USUARIO
	public void deleteUsuario(Long id) {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	
	//METODO PARA AUTENTICAR EN EL LOGIN UN USUARIO
		public Usuario autenticarUsuario(String loginname, String contraseña) throws Exception {
			Usuario usuario = null;
			
			// Verificar que el usuario existe
			try {
				usuario = usuarioRepository.findByLoginname(loginname);
				if (usuario == null ) {throw new Exception();}
			}
			catch (Exception e) {
				throw new Exception("El usuario "+loginname+" no existe");
			}
			
			// Verificar que la contraseña coincide
			if (!  (new BCryptPasswordEncoder()).matches(contraseña,usuario.getContraseña()) ) {
				throw new Exception("La contraseña es incorrecta");
			}
			
			return usuario;
		}
	
	//COMPROBAR SI EL USUARIO EXISTE
	public boolean existeUsuario(String loginname) {
		return usuarioRepository.findByLoginname(loginname) != null;
	}
}

