package com.getfit.servicios;

import java.util.Set;

import com.getfit.modelo.Entrenador;
import com.getfit.modelo.Plan;

public interface PlanService {

	Set<Plan> obtenerPlanes();

	Plan agregarPlan(Plan plan);

	Plan actualizarPlan(Plan plan);

	Plan obtenerPlan(Long planId);

	void eliminarPlan(Long planId);

	Plan listarPlan(Long planId);

}
