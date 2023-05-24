package com.sistema.examenes.controladores;

import java.util.Set;

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

import com.sistema.examenes.modelo.Ejercicio;
import com.sistema.examenes.modelo.Pregunta;
import com.sistema.examenes.modelo.Rutina;
import com.sistema.examenes.servicios.EjercicioService;

@RestController
@RequestMapping("/ejercicio")
@CrossOrigin("*")
public class EjercicioController {
	
	@Autowired
	private EjercicioService ejercicioService;
	
	@GetMapping("/rutina/{rutinaId}")
    public ResponseEntity<?> listarEjerciciosDeRutina(@PathVariable("rutinaId") Long rutinaId){
        Rutina rutina = new Rutina();
        rutina.setRutinaId(rutinaId);
        Set<Ejercicio> ejercicios = ejercicioService.obtenerEjerciciosDeRutina(rutina);
		return ResponseEntity.ok(ejercicios);
    }
	
	@GetMapping("/")
    public ResponseEntity<?> listarEjercicios(){
        return ResponseEntity.ok(ejercicioService.obtenerEjercicios());
    }
	
	@PostMapping("/")
    public ResponseEntity<Ejercicio> guardarEjercicio(@RequestBody Ejercicio ejercicio){
        return ResponseEntity.ok(ejercicioService.agregarEjercicio(ejercicio));
    }
	
	@PutMapping("/")
    public ResponseEntity<Ejercicio> actualizarEjercicio(@RequestBody Ejercicio ejercicio){
        return ResponseEntity.ok(ejercicioService.actualizarEjercicio(ejercicio));
    }
	
	@GetMapping("/{ejercicioId}")
    public Ejercicio listarEjercicioPorId(@PathVariable("ejercicioId") Long ejercicioId){
        return ejercicioService.obtenerEjercicio(ejercicioId);
    }
	
	@DeleteMapping("/{ejercicioId}")
    public void eliminarEjercicio(@PathVariable("ejercicioId") Long ejercicioId){
		ejercicioService.eliminarEjercicio(ejercicioId);
    }
	
//	@Autowired
//	private EjercicioRepository ejercicioRepository;
//	
//
//
//	@GetMapping("c")
//	public String cGet(ModelMap m) {
//		m.put("view", "ejercicio/c");
//		return "_t/frame";
//	}
//	
//	@PostMapping("/c")
//	public Ejercicio guardarEjercicio(@RequestBody Ejercicio ejercicio) {
//		return ejercicioRepository.save(ejercicio);
//	}
	/*@PostMapping("c")
	public String cPost(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("grupomuscular") String grupomuscular,
			@RequestParam("equiponecesario") String equiponecesario) throws DangerException {
		try {
			ejercicioService.saveEjercicio(nombre, descripcion, grupomuscular, equiponecesario);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/ejercicio/r");
		}
		return "redirect:/ejercicio/r";
	}*/
	
//	@GetMapping("/r")
//	public List<Ejercicio> ejercicios(){
//		return ejercicioRepository.findAll();
//	}
	/*@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Ejercicio> ejercicios = ejercicioService.getEjercicios();
		m.put("ejercicios", ejercicios);
		m.put("view", "ejercicio/r");
		return "_t/frame";
	}*/

//	@GetMapping("/u/{id}")
//	public ResponseEntity<Ejercicio> obtenerEjercicioPorId(@PathVariable Long id){
//		Ejercicio ejercicio = ejercicioRepository.findById(id).get();
//		return ResponseEntity.ok(ejercicio);
//	}
	/*@GetMapping("u")
	public String uGet(@RequestParam("id") Long idEjercicio, ModelMap m) {
		Ejercicio ejercicio = ejercicioService.getEjercicioById(idEjercicio);

		m.put("ejercicio", ejercicio);
		m.put("view", "ejercicio/u");

		return "_t/frame";
	}*/

//	@PutMapping("/u/{id}")
//	public ResponseEntity<Ejercicio> actualizarEjercicio(@PathVariable Long id, @RequestBody Ejercicio detallesEjercicio){
//		Ejercicio ejercicio = ejercicioRepository.findById(id).get();
//		
//		ejercicio.setNombre(detallesEjercicio.getNombre());
//		ejercicio.setDescripcion(detallesEjercicio.getDescripcion());
//		ejercicio.setGrupomuscular(detallesEjercicio.getGrupomuscular());
//		ejercicio.setEquiponecesario(detallesEjercicio.getEquiponecesario());
//
//		
//		Ejercicio ejercicioActualizado = ejercicioRepository.save(ejercicio);
//		return ResponseEntity.ok(ejercicioActualizado);
//	}
	/*@PostMapping("u")
	public String uPost(@RequestParam("idEjercicio") Long idEjercicio, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("grupomuscular") String grupomuscular,
			@RequestParam("equiponecesario") String equiponecesario) throws DangerException {
		String retorno = "redirect:/ejercicio/r";
		try {
			ejercicioService.updateEjercicio(idEjercicio, nombre, descripcion, grupomuscular, equiponecesario);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/ejercicio/r");
		}
		return retorno;
	}*/
	
//	@DeleteMapping("/d/{id}")
//	public ResponseEntity<Map<String,Boolean>> eliminarEjercicio(@PathVariable Long id){
//		Ejercicio ejercicio = ejercicioRepository.findById(id).get();
//		ejercicioRepository.delete(ejercicio);
//		Map<String, Boolean> respuesta = new HashMap<>();
//		respuesta.put("eliminar",Boolean.TRUE);
//		return ResponseEntity.ok(respuesta);
//    }
	/*@PostMapping("d")
	public String d(@RequestParam("id") Long id) {
		ejercicioService.deleteEjercicio(id);
		return "redirect:/ejercicio/r";
	}*/

}
