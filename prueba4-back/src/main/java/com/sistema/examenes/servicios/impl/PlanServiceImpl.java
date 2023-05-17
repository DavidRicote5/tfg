package com.sistema.examenes.servicios.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sistema.examenes.modelo.Plan;

import com.sistema.examenes.repositorios.PlanRepository;
import com.sistema.examenes.servicios.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;
	
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
		Plan plan = new Plan();
		plan.setPlanId(planId);
		planRepository.delete(plan);
		
	}

	@Override
	public Plan listarPlan(Long planId) {
		return this.planRepository.getOne(planId);
	}

}
