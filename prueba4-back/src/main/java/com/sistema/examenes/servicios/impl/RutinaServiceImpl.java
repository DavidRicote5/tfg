package com.sistema.examenes.servicios.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.modelo.Entrenador;
import com.sistema.examenes.modelo.Rutina;
import com.sistema.examenes.repositorios.EntrenadorRepository;
import com.sistema.examenes.repositorios.RutinaRepository;
import com.sistema.examenes.servicios.RutinaService;

@Service
public class RutinaServiceImpl implements RutinaService{

	@Autowired
	private RutinaRepository rutinaRepository;
	
	@Override
	public Set<Rutina> obtenerRutinas() {
		return new LinkedHashSet<>(rutinaRepository.findAll());
	}

	@Override
	public Rutina agregarRutina(Rutina rutina) {
		return rutinaRepository.save(rutina);
	}

	@Override
	public Rutina actualizarRutina(Rutina rutina) {
		return rutinaRepository.save(rutina);
	}

	@Override
	public Rutina obtenerRutina(Long rutinaId) {
		return rutinaRepository.findById(rutinaId).get();
	}

	@Override
	public void eliminarRutina(Long rutinaId) {
		Rutina rutina = new Rutina();
		rutina.setRutinaId(rutinaId);
		rutinaRepository.delete(rutina);
		
	}

	@Override
	public Rutina listarRutina(Long rutinaId) {
		return this.rutinaRepository.getOne(rutinaId);
	}

}
