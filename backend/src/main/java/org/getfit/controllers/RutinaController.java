package org.getfit.controllers;

import java.util.List;
import org.getfit.entities.Rutina;
import org.getfit.exception.DangerException;
import org.getfit.helpers.PRG;
import org.getfit.services.EntrenadorService;
import org.getfit.services.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rutina")
public class RutinaController {

	@Autowired
	private RutinaService rutinaService;
	
	@Autowired
	private EntrenadorService entrenadorService;

	@GetMapping("c")
	public String cGet(ModelMap m) {
		
		m.put("entrenadores", entrenadorService.getEntrenadores());
		m.put("view", "rutina/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("dificultad") String dificultad,
			@RequestParam("duracion") int duracion,
			@RequestParam(required=false, name="idEntrenador") Long idEntrenador
			) throws DangerException {
		try {
			rutinaService.saveRutina(nombre,descripcion,dificultad,duracion,idEntrenador);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/rutina/r");
		}
		return "redirect:/rutina/r";
	}

	@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Rutina> rutinas = rutinaService.getRutinas();
		m.put("rutinas", rutinas);
		m.put("view", "rutina/r");
		return "_t/frame";
	}

	@GetMapping("u")
	public String uGet(@RequestParam("id") Long idRutina, ModelMap m) {
		Rutina rutina = rutinaService.getRutinaById(idRutina);
		m.put("entrenadores", entrenadorService.getEntrenadores());
		m.put("rutina", rutina);
		m.put("view", "rutina/u");

		return "_t/frame";
	}

	@PostMapping("u")
	public String uPost(@RequestParam("idRutina") Long idRutina,
			@RequestParam("nombre") String nombre,
			@RequestParam(required=false, name="idEntrenador") Long idEntrenador
			) throws DangerException {
		String retorno = "redirect:/rutina/r";
		try {
			rutinaService.updateRutina(idRutina, nombre);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/rutina/r");
		}
		return retorno;
	}

	@PostMapping("d")
	public String d(@RequestParam("id") Long id) {
		rutinaService.deleteRutina(id);
		return "redirect:/rutina/r";
	}

}

