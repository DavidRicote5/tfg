package org.getfit.services;

import java.util.List;
import org.getfit.entities.Plan;
import org.getfit.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {

	@Autowired
	private PlanRepository planRepository;
	

	public List<Plan> getPlanes() {
		return planRepository.findAll();
	}

	public void savePlan(
			String nombre,
			String descripcion,
			int duracion,
			int precio) throws Exception {
		Plan plan = Plan.builder().nombre(nombre).descripcion(descripcion).duracion(duracion).precio(precio).build();
		try {
			planRepository.saveAndFlush(plan);
		} catch (Exception e) {
			throw new Exception("El/la plan " + nombre + " ya existe");
		}
	}

	public Plan getPlanById(Long id) {
		return planRepository.findById(id).get();
	}

	public void updatePlan(
			Long id,
			String nombre,
			String descripcion,
			int duracion,
			int precio) throws Exception {
		Plan plan = planRepository.findById(id).get();
		plan.setNombre(nombre);
		plan.setDescripcion(descripcion);
		plan.setDuracion(duracion);
		plan.setPrecio(precio);
		
		try {
			planRepository.saveAndFlush(plan);
		} catch (Exception e) {
			throw new Exception("El/la plan " + nombre + " ya existe");
		}
	}

	public void deletePlan(Long id) {
		Plan plan = planRepository.findById(id).get();
		planRepository.delete(plan);
	}
}

