package com.getfit.servicios.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getfit.modelo.Entrenador;
import com.getfit.repositorios.EntrenadorRepository;
import com.getfit.servicios.EntrenadorService;

@Service
public class EntrenadorServiceImpl implements EntrenadorService{

	@Autowired
	private EntrenadorRepository entrenadorRepository;
	
	@Override
	public Set<Entrenador> obtenerEntrenadores() {
		return new LinkedHashSet<>(entrenadorRepository.findAll());
	}

	@Override
	public Entrenador agregarEntrenador(Entrenador entrenador) {
		return entrenadorRepository.save(entrenador);
	}

	@Override
	public Entrenador actualizarEntrenador(Entrenador entrenador) {
		return entrenadorRepository.save(entrenador);
	}

	@Override
	public Entrenador obtenerEntrenador(Long entrenadorId) {
		return entrenadorRepository.findById(entrenadorId).get();
	}

	@Override
	public void eliminarEntrenador(Long entrenadorId) {
		Entrenador entrenador = new Entrenador();
		entrenador.setEntrenadorId(entrenadorId);
		entrenadorRepository.delete(entrenador);
		
	}

	@Override
	public Entrenador listarEntrenador(Long entrenadorId) {
		return this.entrenadorRepository.getOne(entrenadorId);
	}

}
