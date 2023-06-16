package com.getfit.servicios.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getfit.modelo.Plan;
import com.getfit.modelo.Usuario;
import com.getfit.repositorios.PlanRepository;
import com.getfit.repositorios.UsuarioRepository;
import com.getfit.servicios.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Set<Plan> obtenerPlanes() {
		return new LinkedHashSet<>(planRepository.findAll());
	}

	@Override
	public Plan agregarPlan(Plan plan) {
		return planRepository.save(plan);
	}

	@Override
	public Plan actualizarPlan(Plan plan) {
		return planRepository.save(plan);
	}

	@Override
	public Plan obtenerPlan(Long planId) {
		return planRepository.findById(planId).get();
	}

	@Override
	public void eliminarPlan(Long planId) {
		Optional<Plan> optionalPlan = planRepository.findById(planId);
	    if (optionalPlan.isPresent()) {
	        Plan plan = optionalPlan.get();
	        
	        for (Usuario usuario : plan.getUsuarios()) {
	            
	            usuario.setPlan(null);  // Establecer el plan como null
	            usuarioRepository.save(usuario);
	        }
	        
	        plan.getUsuarios().clear();
	        planRepository.delete(plan);
	    } else {
	        throw new IllegalArgumentException("El plan no existe");
	    }
		
	}

	@Override
	public Plan listarPlan(Long planId) {
		return this.planRepository.getOne(planId);
	}

}
