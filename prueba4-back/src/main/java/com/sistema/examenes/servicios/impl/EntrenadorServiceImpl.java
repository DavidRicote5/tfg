package com.sistema.examenes.servicios.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.modelo.Entrenador;
import com.sistema.examenes.modelo.Pregunta;
import com.sistema.examenes.repositorios.EntrenadorRepository;
import com.sistema.examenes.servicios.EntrenadorService;

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
