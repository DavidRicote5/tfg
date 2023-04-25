package org.getfit.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.getfit.entities.Entrenador;
import org.getfit.entities.Plan;
import org.getfit.entities.Usuario;
import org.getfit.exception.DangerException;
import org.getfit.helpers.PRG;
import org.getfit.repositories.UsuarioRepository;
import org.getfit.services.EntrenadorService;
import org.getfit.services.PlanService;
import org.getfit.services.RutinaService;
import org.getfit.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("c")
	public String cGet(ModelMap m) {
		m.put("view", "usuario/c");
		return "_t/frame";
	}

	@PostMapping("/c")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	/*@PostMapping("c")
	public String cPost(@RequestParam("loginname") String loginname, @RequestParam("nombre") String nombre,
			@RequestParam("password") String password, @RequestParam("correo") String correo,
			@RequestParam("fechaNac") LocalDate fechaNac, @RequestParam("genero") String genero,
			@RequestParam("altura") int altura, @RequestParam("peso") int peso

	) throws DangerException {
		try {
			usuarioService.saveUsuario(loginname, nombre, password, correo, fechaNac, genero, altura, peso);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/usuario/r");
		}
		return "redirect:/usuario/r";
	}*/

	@GetMapping("/r")
	public List<Usuario> usuarios(){
		return usuarioRepository.findAll();
	}
	
	/*
	@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Usuario> usuarios = usuarioService.getUsuarios();
		m.put("usuarios", usuarios);
		m.put("view", "usuario/r");
		return "_t/frame";
	}
	*/

	@GetMapping("/u/{id}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id){
		Usuario usuario = usuarioRepository.findById(id).get();
		return ResponseEntity.ok(usuario);
	}
	
	/*
	@GetMapping("u")
	public String uGet(@RequestParam("id") Long idUsuario, ModelMap m) {
		Usuario usuario = usuarioService.getUsuarioById(idUsuario);
		List<Plan> planes = planService.getPlanes();
		List<Entrenador> entrenadors = entrenadorService.getEntrenadors();

		m.put("rutinas", rutinaService.getRutinas());
		m.put("entrenadors", entrenadors);
		m.put("planes", planes);
		m.put("usuario", usuario);
		m.put("view", "usuario/u");

		return "_t/frame";
	}*/

	@PutMapping("/u/{id}")
	public ResponseEntity<Usuario> actulizarUsuario(@PathVariable Long id, @RequestBody Usuario detallesUsuario){
		Usuario usuario = usuarioRepository.findById(id).get();
		
		usuario.setNombre(detallesUsuario.getNombre());
		usuario.setFechaNac(detallesUsuario.getFechaNac());
		usuario.setAltura(detallesUsuario.getAltura());
		usuario.setPeso(detallesUsuario.getPeso());
		
		Usuario usuarioActualizado = usuarioRepository.save(usuario);
		return ResponseEntity.ok(usuarioActualizado);
	}
	
	/*
	@PostMapping("u")
	public String uPost(@RequestParam("idUsuario") Long idUsuario, @RequestParam("altura") int altura,
			@RequestParam("peso") int peso, @RequestParam("idPlan") Long idPlan,
			@RequestParam("idEntrenador") Long idEntrenador, @RequestParam("idRutinas[]") Long[] idRutinas

	) throws DangerException {
		String retorno = "redirect:/usuario/r";
		try {

			Plan plan = planService.getPlanById(idPlan);
			Entrenador entrenador = entrenadorService.getEntrenadorById(idEntrenador);

			usuarioService.updateUsuario(idUsuario, altura, peso, plan, entrenador, idRutinas);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/usuario/r");
		}
		return retorno;
	}*/

	@DeleteMapping("/d/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarUsuario(@PathVariable Long id){
		Usuario usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
	
	/*
	@PostMapping("d")
	public String d(@RequestParam("id") Long id) {
		usuarioService.deleteUsuario(id);
		return "redirect:/usuario/r";
	}*/

}
