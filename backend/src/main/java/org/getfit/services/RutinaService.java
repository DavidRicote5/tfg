package org.getfit.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.getfit.entities.Ejercicio;
import org.getfit.entities.Entrenador;
import org.getfit.entities.Rutina;
import org.getfit.repositories.EjercicioRepository;
import org.getfit.repositories.EntrenadorRepository;
import org.getfit.repositories.RutinaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutinaService {

	@Autowired
	private RutinaRepository rutinaRepository;
	
	@Autowired
	private EjercicioRepository ejercicioRepository;
	
	@Autowired
	private EntrenadorRepository entrenadorRepository;

	//BIEN
	public List<Rutina> getRutinas() {
		return rutinaRepository.findAll();
	}

	
	public void saveRutina(String nombre,String descripcion, String dificultad, int duracion,Long idEntrenador, Long[] idEjercicios) throws Exception {
		Rutina rutina = Rutina.builder().nombre(nombre).descripcion(descripcion).dificultad(dificultad).duracion(duracion).build();
		
		//GESTION DE ENTRENADOR
		Entrenador entrenador = entrenadorRepository.getById(idEntrenador);
		rutina.setEntrenador(entrenador);
		
		//GESTION DE EJERCICIOS
		Collection<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		for(Long idEjercicio : idEjercicios) {
			Ejercicio ejercicio = ejercicioRepository.getById(idEjercicio);
			ejercicios.add(ejercicio);
			ejercicio.getRutinas().add(rutina);
		}
		rutina.setEjercicios(ejercicios);
		
		try {
			rutinaRepository.saveAndFlush(rutina);
		} catch (Exception e) {
			throw new Exception("El/la rutina " + nombre + " ya existe");
		}
	}

	public Rutina getRutinaById(Long id) {
		return rutinaRepository.findById(id).get();
	}

	public void updateRutina(
			Long id,
			String nombre,
			Long[] idEjercicios) throws Exception {
		
		Rutina rutina = rutinaRepository.findById(id).get();
		rutina.setNombre(nombre);
		
		//GESTION DE EJERCICIOS
		List<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		for(Long idEjercicio : idEjercicios) {
			Ejercicio ejercicio = ejercicioRepository.getById(idEjercicio);
			ejercicios.add(ejercicio);
			ejercicio.getRutinas().add(rutina);
		}
		rutina.getEjercicios().addAll(ejercicios);
		
		try {
			rutinaRepository.saveAndFlush(rutina);
		} catch (Exception e) {
			throw new Exception("El/la rutina " + nombre + " ya existe");
		}
	}

	public void deleteRutina(Long id) {
		Rutina rutina = rutinaRepository.findById(id).get();
		rutinaRepository.delete(rutina);
	}
}

