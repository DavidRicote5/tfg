package com.sistema.examenes.controladores;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenes.modelo.Entrenador;
import com.sistema.examenes.servicios.EntrenadorService;

@RestController
@RequestMapping("/entrenador")
@CrossOrigin("*")
public class EntrenadorController {
	@Autowired
	private EntrenadorService entrenadorService;

	@GetMapping("/")
    public ResponseEntity<?> listarEntrenadores(){
        return ResponseEntity.ok(entrenadorService.obtenerEntrenadores());
    }
	
	@PostMapping("/")
    public ResponseEntity<Entrenador> guardarEntrenador(@RequestBody Entrenador entrenador){
        return ResponseEntity.ok(entrenadorService.agregarEntrenador(entrenador));
    }
	
	@PutMapping("/")
    public ResponseEntity<Entrenador> actualizarEntrenador(@RequestBody Entrenador entrenador){
        return ResponseEntity.ok(entrenadorService.actualizarEntrenador(entrenador));
    }
	
	@GetMapping("/{entrenadorId}")
    public Entrenador listarEntrenadorPorId(@PathVariable("entrenadorId") Long entrenadorId){
        return entrenadorService.obtenerEntrenador(entrenadorId);
    }
	
	@DeleteMapping("/{entrenadorId}")
    public void eliminarEntrenador(@PathVariable("entrenadorId") Long entrenadorId){
		entrenadorService.eliminarEntrenador(entrenadorId);
    }
	
	/*
	@GetMapping("c")
	public String cGet(ModelMap m) {
		m.put("view", "entrenador/c");
		return "_t/frame";
	}*/
	
	/*
	@PostMapping("/c")
	public Entrenador guardarEntrenador(@RequestBody Entrenador entrenador) {
		return entrenadorRepository.save(entrenador);
	}*/
	
	/*@PostMapping("c")
	public String cPost(@RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo,
			@RequestParam("certificaciones") String certificaciones,
			@RequestParam("especializacion") String especializacion,
			@RequestParam("aniosExperiencia") int aniosExperiencia
			) throws DangerException {
		
		try {
			entrenadorService.saveEntrenador(nombre,correo,certificaciones,especializacion,aniosExperiencia);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/entrenador/r");
		}
		return "redirect:/entrenador/r";
	}*/
	
	/*
	//Listar entrenadores
	@GetMapping("/r")
	public List<Entrenador> entrenadores(){
		return entrenadorRepository.findAll();
	}*/
	/*@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Entrenador> entrenadores = entrenadorService.getEntrenadores();
		m.put("entrenadores", entrenadores);
		m.put("view", "entrenador/r");
		return "_t/frame";
	}*/
	/*
	@GetMapping("/u/{id}")
	public ResponseEntity<Entrenador> obtenerEntrenadorPorId(@PathVariable Long id){
		Entrenador entrenador = entrenadorRepository.findById(id).get();
		return ResponseEntity.ok(entrenador);
	}*/
	/*@GetMapping("u")
	public String uGet(@RequestParam("id") Long idEntrenador, ModelMap m) {
		
		Entrenador entrenador = entrenadorService.getEntrenadorById(idEntrenador);

		m.put("entrenador", entrenador);
		m.put("view", "entrenador/u");

		return "_t/frame";
	}*/
	
	/*
	@PutMapping("/u/{id}")
	public ResponseEntity<Entrenador> actualizarEntrenador(@PathVariable Long id, @RequestBody Entrenador detallesEntrenador){
		Entrenador entrenador = entrenadorRepository.findById(id).get();
		
		entrenador.setNombre(detallesEntrenador.getNombre());
		entrenador.setCorreo(detallesEntrenador.getCorreo());
		entrenador.setAnosexperiencia(detallesEntrenador.getAnosexperiencia());
		entrenador.setEspecializacion(detallesEntrenador.getEspecializacion());
		
		Entrenador entrenadorActualizado = entrenadorRepository.save(entrenador);
		return ResponseEntity.ok(entrenadorActualizado);
	}*/
	/*@PostMapping("u")
	public String uPost(@RequestParam("idEntrenador") Long idEntrenador,
			@RequestParam("nombre") String nombre,
			@RequestParam("certificaciones") String certificaciones,
			@RequestParam("especializaciones") String especializaciones,
			@RequestParam("aniosExperiencia") int aniosExperiencia) throws DangerException {
		String retorno = "redirect:/entrenador/r";
		
		try {
			entrenadorService.updateEntrenador(idEntrenador, nombre,certificaciones,especializaciones,aniosExperiencia);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/entrenador/r");
		}
		return retorno;
	}*/
	
	/*
	@DeleteMapping("/d/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarEntrenador(@PathVariable Long id){
		Entrenador entrenador = entrenadorRepository.findById(id).get();
		entrenadorRepository.delete(entrenador);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }*/
	/*@PostMapping("d")
	public String d(@RequestParam("id") Long id) {
		entrenadorService.deleteEntrenador(id);
		return "redirect:/entrenador/r";
	}*/

}
