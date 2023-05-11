package com.sistema.examenes.servicios;

import java.util.Set;

import com.sistema.examenes.modelo.Entrenador;
import com.sistema.examenes.modelo.Plan;

public interface PlanService {

	Set<Plan> obtenerPlanes();

	Plan agregarPlan(Plan plan);

	Plan actualizarPlan(Plan plan);

	Plan obtenerPlan(Long planId);

	void eliminarPlan(Long planId);

	Plan listarPlan(Long planId);

}
