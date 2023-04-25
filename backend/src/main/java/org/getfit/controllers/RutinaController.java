package org.getfit.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.getfit.entities.Entrenador;
import org.getfit.entities.Rutina;
import org.getfit.exception.DangerException;
import org.getfit.helpers.PRG;
import org.getfit.repositories.RutinaRepository;
import org.getfit.services.EjercicioService;
import org.getfit.services.RutinaService;
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
@RequestMapping("/rutina")
@CrossOrigin(origins = "http://localhost:4200")
public class RutinaController {

	@Autowired
	private RutinaRepository rutinaRepository;

	@Autowired
	private EjercicioService ejercicioService;

	@GetMapping("c")
	public String cGet(ModelMap m) {
		m.put("view", "rutina/c");
		return "_t/frame";
	}

	@PostMapping("/c")
	public Rutina guardarRutina(@RequestBody Rutina rutina) {
		return rutinaRepository.save(rutina);
	}
	
	/*
	@PostMapping("c")
	public String cPost(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("dificultad") String dificultad, @RequestParam("duracion") int duracion,
			@RequestParam(required = false, name = "idEjercicios[]") Long[] idEjercicios) throws DangerException {
		try {
			rutinaService.saveRutina(nombre, descripcion, dificultad, duracion, idEjercicios);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/rutina/r");
		}
		return "redirect:/rutina/r";
	}*/

	@GetMapping("/r")
	public List<Rutina> rutinas(){
		return rutinaRepository.findAll();
	}
	
	/*
	@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Rutina> rutinas = rutinaService.getRutinas();
		m.put("rutinas", rutinas);
		m.put("view", "rutina/r");
		return "_t/frame";
	}
	 */
	
	@GetMapping("/u/{id}")
	public ResponseEntity<Rutina> obtenerRutinaPorId(@PathVariable Long id){
		Rutina rutina = rutinaRepository.findById(id).get();
		return ResponseEntity.ok(rutina);
	}
	
	/*
	@GetMapping("u")
	public String uGet(@RequestParam("id") Long idRutina, ModelMap m) {
		Rutina rutina = rutinaService.getRutinaById(idRutina);

		m.put("ejercicios", ejercicioService.getEjercicios());
		m.put("rutina", rutina);
		m.put("view", "rutina/u");

		return "_t/frame";
	}*/

	@PutMapping("/u/{id}")
	public ResponseEntity<Rutina> actualizarRutina(@PathVariable Long id, @RequestBody Rutina detallesRutina){
		Rutina rutina = rutinaRepository.findById(id).get();
		
		rutina.setNombre(detallesRutina.getNombre());
		rutina.setDescripcion(detallesRutina.getDescripcion());
		rutina.setDificultad(detallesRutina.getDificultad());
		rutina.setDuracion(detallesRutina.getDuracion());
		
		Rutina rutinaActualizado = rutinaRepository.save(rutina);
		return ResponseEntity.ok(rutinaActualizado);
	}
	
	/*
	@PostMapping("u")
	public String uPost(@RequestParam("idRutina") Long idRutina, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("dificultad") String dificultad,
			@RequestParam("duracion") int duracion, @RequestParam("idEjercicios[]") Long[] idEjercicios)
			throws DangerException {
		String retorno = "redirect:/rutina/r";
		try {
			rutinaService.updateRutina(idRutina, nombre, descripcion, dificultad, duracion, idEjercicios);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/rutina/r");
		}
		return retorno;
	}*/

	
	@DeleteMapping("/d/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarRutina(@PathVariable Long id){
		Rutina rutina = rutinaRepository.findById(id).get();
		rutinaRepository.delete(rutina);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
	
	/*
	@PostMapping("d")
	public String d(@RequestParam("id") Long id) {
		rutinaService.deleteRutina(id);
		return "redirect:/rutina/r";
	}*/

}
