package org.getfit.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.getfit.entities.Entrenador;
import org.getfit.entities.Plan;
import org.getfit.entities.Rol;
import org.getfit.entities.Rutina;
import org.getfit.entities.Usuario;
import org.getfit.repositories.RolRepository;
import org.getfit.repositories.RutinaRepository;
import org.getfit.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	/*========== CONEXIONES ===========*/

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RutinaRepository rutinaRepository;
	
	@Autowired
	private RolRepository rolRepository;
	

	/*========== METODOS ===========*/
	
	//OBTIENE TODOS LOS USUARIOS
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	// CREAR USUARIO ADMINISTRADOR
	public Usuario saveAdmin(String loginname, String nombre, String password, String correo) throws Exception {

		// Crea el usuario con todos sus atributos
		Usuario usuario = Usuario.builder()
				.loginname(loginname)
				.nombre(nombre)
				.password(new BCryptPasswordEncoder().encode(password))
				.correo(correo)
				.build();

		// GESTION DE ROLES
		Rol rol = rolRepository.findByNombre("admin");
		usuario.setRol(rol);

		try {
			// Guarda en usuarioRepository el usuario
			usuarioRepository.saveAndFlush(usuario);

			return usuario;
		} catch (Exception e) {
			throw new Exception("El/la usuario " + nombre + " ya existe");
		}
	}
	
	// CREAR USUARIO ESTANDAR
	public void saveUsuario(
			String loginname,
			String nombre,
			String password,
			String correo,
			
			String genero,
			int altura,
			int peso
			) throws Exception {
		
		// Crea el usuario con todos sus atributos
		Usuario usuario = Usuario.builder()
				.loginname(loginname)
				.nombre(nombre)
				.password(new BCryptPasswordEncoder().encode(password))
				.correo(correo)
				
				.genero(genero)
				.altura(altura)
				.peso(peso)
				.build();

		
		// GESTION DE ROLES
		Rol rol = rolRepository.findByNombre("user");
		usuario.setRol(rol);

		
		try {
			// Guarda en usuarioRepository el usuario
			usuarioRepository.saveAndFlush(usuario);
		} catch (Exception e) {
			throw new Exception("El/la usuario " + nombre + " ya existe");
		}
	}

	
	//OBTIENE UN USUARIO MEDIANTE UN ID
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).get();
	}

	
	//ACTUALIZA UN USUARIO
	public void updateUsuario(
			Long id,
			int altura,
			int peso,
			Plan plan,
			Entrenador entrenador,
			Long[] idRutinas

			) throws Exception {
		
		//Obtiene el usuario del repositorio
		Usuario usuario = usuarioRepository.findById(id).get();
		
		//Asigna sus atributos nuevos
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
			throw new Exception("El/la usuario " + usuario.getNombre() + " ya existe");
		}
	}

	//ELIMINA UN USUARIO
	public void deleteUsuario(Long id) {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	
	
	//METODO PARA AUTENTICAR UN JUGADOR
	public Usuario autenticarUsuario(String loginname, String password) throws Exception {
		Usuario usuario = null;
		
		// Verificar que el usuario existe
		try {
			usuario = usuarioRepository.findByLoginname(loginname);
			if (usuario == null ) {throw new Exception();}
		}
		catch (Exception e) {
			throw new Exception("El usuario "+loginname+" no existe");
		}
		
		// Verificar que la password coincide
		if (!  (new BCryptPasswordEncoder()).matches(password,usuario.getPassword()) ) {
			throw new Exception("La password es incorrecta");
		}
		
		return usuario;
	}
	
	
	//COMPROBAR SI EXISTE UN USUARIO
	public boolean existeUsuario(String loginname) {
		return usuarioRepository.findByLoginname(loginname) != null;
	}
}
