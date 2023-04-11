package org.getfit.controllers;

import java.util.List;
import org.getfit.entities.Entrenador;
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
@RequestMapping("/entrenador")
public class EntrenadorController {

	@Autowired
	private EntrenadorService entrenadorService;
	
	@Autowired
	private RutinaService rutinaService;

	@GetMapping("c")
	public String cGet(ModelMap m) {
		m.put("rutinas", rutinaService.getRutinas());
		m.put("view", "entrenador/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(
			@RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo,
			@RequestParam("especializacion") String especializacion,
			@RequestParam("anosexperiencia") int anosexperiencia,
			@RequestParam(required=false, name="idRutinas[]") Long[] idRutinas
			) throws DangerException {
		try {
			entrenadorService.saveEntrenador(nombre,correo,especializacion,anosexperiencia,idRutinas);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/entrenador/r");
		}
		return "redirect:/entrenador/r";
	}

	@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Entrenador> entrenadors = entrenadorService.getEntrenadors();
		m.put("entrenadors", entrenadors);
		m.put("view", "entrenador/r");
		return "_t/frame";
	}

	@GetMapping("u")
	public String uGet(@RequestParam("id") Long idEntrenador, ModelMap m) {
		Entrenador entrenador = entrenadorService.getEntrenadorById(idEntrenador);

		m.put("rutinas", rutinaService.getRutinas());
		m.put("entrenador", entrenador);
		m.put("view", "entrenador/u");

		return "_t/frame";
	}

	@PostMapping("u")
	public String uPost(
			@RequestParam("idEntrenador") Long idEntrenador,
			@RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo,
			@RequestParam("especializacion") String especializacion,
			@RequestParam("anosexperiencia") int anosexperiencia,
			@RequestParam("idRutinas[]") Long[] idRutinas
			) throws DangerException {
		String retorno = "redirect:/entrenador/r";
		try {
			entrenadorService.updateEntrenador(idEntrenador, nombre,correo,especializacion,anosexperiencia,idRutinas);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/entrenador/r");
		}
		return retorno;
	}

	@PostMapping("d")
	public String d(@RequestParam("id") Long id) {
		entrenadorService.deleteEntrenador(id);
		return "redirect:/entrenador/r";
	}

}
