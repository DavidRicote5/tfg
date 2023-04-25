package org.getfit.controllers;

import java.util.List;
import org.getfit.entities.Ejercicio;
import org.getfit.exception.DangerException;
import org.getfit.helpers.PRG;
import org.getfit.services.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

	@Autowired
	private EjercicioService ejercicioService;

	@GetMapping("c")
	public String cGet(ModelMap m) {
		m.put("view", "ejercicio/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("grupomuscular") String grupomuscular,
			@RequestParam("equiponecesario") String equiponecesario) throws DangerException {
		try {
			ejercicioService.saveEjercicio(nombre, descripcion, grupomuscular, equiponecesario);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/ejercicio/r");
		}
		return "redirect:/ejercicio/r";
	}

	@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Ejercicio> ejercicios = ejercicioService.getEjercicios();
		m.put("ejercicios", ejercicios);
		m.put("view", "ejercicio/r");
		return "_t/frame";
	}

	@GetMapping("u")
	public String uGet(@RequestParam("id") Long idEjercicio, ModelMap m) {
		Ejercicio ejercicio = ejercicioService.getEjercicioById(idEjercicio);

		m.put("ejercicio", ejercicio);
		m.put("view", "ejercicio/u");

		return "_t/frame";
	}

	@PostMapping("u")
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
	}

	@PostMapping("d")
	public String d(@RequestParam("id") Long id) {
		ejercicioService.deleteEjercicio(id);
		return "redirect:/ejercicio/r";
	}

}
