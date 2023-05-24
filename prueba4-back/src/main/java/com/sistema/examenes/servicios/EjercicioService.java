package com.sistema.examenes.servicios;

import java.util.Set;

import com.sistema.examenes.modelo.Ejercicio;
import com.sistema.examenes.modelo.Rutina;

public interface EjercicioService {

	Set<Ejercicio> obtenerEjercicios();

	Ejercicio agregarEjercicio(Ejercicio ejercicio);

	Ejercicio actualizarEjercicio(Ejercicio ejercicio);

	Ejercicio obtenerEjercicio(Long ejercicioId);

	void eliminarEjercicio(Long ejerciciorId);

	Ejercicio listarEjercicio(Long ejercicioId);

	Set<Ejercicio> obtenerEjerciciosDeRutina(Rutina rutina);
}
