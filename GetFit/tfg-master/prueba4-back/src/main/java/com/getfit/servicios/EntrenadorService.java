package com.getfit.servicios;

import java.util.Set;

import com.getfit.modelo.Entrenador;



public interface EntrenadorService {

	Set<Entrenador> obtenerEntrenadores();
	
	Entrenador agregarEntrenador(Entrenador entrenador);
	
	Entrenador actualizarEntrenador(Entrenador entrenador);
	
	Entrenador obtenerEntrenador(Long entrenadorId);
	
	void eliminarEntrenador(Long entrenadorId);
	
	Entrenador listarEntrenador(Long entrenadorId);
	
}
