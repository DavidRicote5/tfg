package org.getfit.controllers;

import java.util.List;
import org.getfit.entities.Plan;
import org.getfit.exception.DangerException;
import org.getfit.helpers.PRG;
import org.getfit.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private PlanService planService;

	@GetMapping("c")
	public String cGet(ModelMap m) {
		m.put("view", "plan/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("duracion") int duracion, @RequestParam("precio") int precio) throws DangerException {
		try {
			planService.savePlan(nombre, descripcion, duracion, precio);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/plan/r");
		}
		return "redirect:/plan/r";
	}

	@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Plan> planes = planService.getPlanes();
		m.put("planes", planes);
		m.put("view", "plan/r");
		return "_t/frame";
	}

	@GetMapping("u")
	public String uGet(@RequestParam("id") Long idPlan, ModelMap m) {
		Plan plan = planService.getPlanById(idPlan);

		m.put("plan", plan);
		m.put("view", "plan/u");

		return "_t/frame";
	}

	@PostMapping("u")
	public String uPost(@RequestParam("idPlan") Long idPlan, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("duracion") int duracion,
			@RequestParam("precio") int precio) throws DangerException {
		String retorno = "redirect:/plan/r";
		try {
			planService.updatePlan(idPlan, nombre, descripcion, duracion, precio);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/plan/r");
		}
		return retorno;
	}

	@PostMapping("d")
	public String d(@RequestParam("id") Long id) {
		planService.deletePlan(id);
		return "redirect:/plan/r";
	}

}
