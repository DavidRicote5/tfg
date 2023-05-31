package com.getfit.servicios.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getfit.modelo.Ejercicio;
import com.getfit.modelo.Entrenador;
import com.getfit.modelo.Rutina;
import com.getfit.repositorios.EjercicioRepository;
import com.getfit.servicios.EjercicioService;

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
