package com.sistema.examenes.servicios.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.modelo.Ejercicio;
import com.sistema.examenes.modelo.Entrenador;
import com.sistema.examenes.modelo.Rutina;
import com.sistema.examenes.repositorios.EjercicioRepository;

import com.sistema.examenes.servicios.EjercicioService;

@Service
public class EjercicioServiceImpl implements EjercicioService {

	@Autowired
	private EjercicioRepository ejercicioRepository;
	
	@Override
	public Set<Ejercicio> obtenerEjercicios() {
		return new LinkedHashSet<>(ejercicioRepository.findAll());
	}

	@Override
	public Ejercicio agregarEjercicio(Ejercicio ejercicio) {
		return ejercicioRepository.save(ejercicio);
	}

	@Override
	public Ejercicio actualizarEjercicio(Ejercicio ejercicio) {
		return ejercicioRepository.save(ejercicio);
	}

	@Override
	public Ejercicio obtenerEjercicio(Long ejercicioId) {
		return ejercicioRepository.findById(ejercicioId).get();
	}

	@Override
	public void eliminarEjercicio(Long ejerciciorId) {
		Ejercicio ejercicio = new Ejercicio();
		ejercicio.setEjercicioId(ejerciciorId);
		ejercicioRepository.delete(ejercicio);
		
	}

	@Override
	public Ejercicio listarEjercicio(Long ejercicioId) {
		return this.ejercicioRepository.getOne(ejercicioId);
	}
	
	@Override
	public Set<Ejercicio> obtenerEjerciciosDeRutina(Rutina rutina){
		return ejercicioRepository.findByRutina(rutina);
	}

}
