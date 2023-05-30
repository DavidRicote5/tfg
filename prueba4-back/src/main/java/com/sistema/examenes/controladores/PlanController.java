package com.sistema.examenes.controladores;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenes.modelo.Plan;
import com.sistema.examenes.servicios.PlanService;

@RestController
@RequestMapping("/plan")
@CrossOrigin("*")
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@GetMapping("/")
	@PermitAll
    public ResponseEntity<?> listarPlanes(){
        return ResponseEntity.ok(planService.obtenerPlanes());
    }
	
	@PostMapping("/")
    public ResponseEntity<Plan> guardarPlan(@RequestBody Plan plan){
        return ResponseEntity.ok(planService.agregarPlan(plan));
    }
	
	@PutMapping("/")
    public ResponseEntity<Plan> actualizarPlan(@RequestBody Plan plan){
        return ResponseEntity.ok(planService.actualizarPlan(plan));
    }
	
	@GetMapping("/{planId}")
    public Plan listarPlanPorId(@PathVariable("planId") Long planId){
        return planService.obtenerPlan(planId);
    }
	
	@DeleteMapping("/{planId}")
    public void eliminarPlan(@PathVariable("planId") Long planId){
		planService.eliminarPlan(planId);
    }
	
//	@Autowired
//	private PlanRepository planRepository;
//
//	@GetMapping("c")
//	public String cGet(ModelMap m) {
//		m.put("view", "plan/c");
//		return "_t/frame";
//	}
//	
//	@PostMapping("/c")
//	public Plan guardarPlan(@RequestBody Plan plan) {
//		return planRepository.save(plan);
//	}
//	
//	@GetMapping("/r")
//	public List<Plan> planes(){
//		return planRepository.findAll();
//	}
//	
//	@GetMapping("/u/{id}")
//	public ResponseEntity<Plan> obtenerPlanPorId(@PathVariable Long id){
//		Plan plan = planRepository.findById(id).get();
//		return ResponseEntity.ok(plan);
//	}
//	
//	@PutMapping("/u/{id}")
//	public ResponseEntity<Plan> actualizarPlan(@PathVariable Long id, @RequestBody Plan detallesPlan){
//		Plan plan = planRepository.findById(id).get();
//		
//		plan.setNombre(detallesPlan.getNombre());
//		plan.setDescripcion(detallesPlan.getDescripcion());
//		plan.setDuracion(detallesPlan.getDuracion());
//		plan.setPrecio(detallesPlan.getPrecio());
//		
//		Plan planActualizado = planRepository.save(plan);
//		return ResponseEntity.ok(planActualizado);
//	}
//	
//	@DeleteMapping("/d/{id}")
//	public ResponseEntity<Map<String,Boolean>> eliminarPlan(@PathVariable Long id){
//		Plan plan = planRepository.findById(id).get();
//		planRepository.delete(plan);
//		Map<String, Boolean> respuesta = new HashMap<>();
//		respuesta.put("eliminar",Boolean.TRUE);
//		return ResponseEntity.ok(respuesta);
//    }
	
/*
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
*/
}
