package org.getfit.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.getfit.entities.Entrenador;
import org.getfit.entities.Rutina;
import org.getfit.repositories.EntrenadorRepository;
import org.getfit.repositories.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenadorService {

	@Autowired
	private EntrenadorRepository entrenadorRepository;
	
	@Autowired
	private RutinaRepository rutinaRepository;

	public List<Entrenador> getEntrenadors() {
		return entrenadorRepository.findAll();
	}

	public void saveEntrenador(
			String nombre,
			String correo,
			String especializacion,
			int anosexperiencia,
			Long[] idRutinas
			) throws Exception {
		Entrenador entrenador = Entrenador.builder().nombre(nombre).correo(correo).especializacion(especializacion).anosexperiencia(anosexperiencia).build();
		
		// GESTION DE RUTINA
		Collection<Rutina> rutinas = new ArrayList<Rutina>();
		for (Long idRutina : idRutinas) {
			Rutina rutina = rutinaRepository.getById(idRutina);
			rutinas.add(rutina);
			rutina.getEntrenadors().add(entrenador);
		}
		entrenador.setRutinas(rutinas);

		try {
			entrenadorRepository.saveAndFlush(entrenador);
		} catch (Exception e) {
			throw new Exception("El/la entrenador " + nombre + " ya existe");
		}
	}

	public Entrenador getEntrenadorById(Long id) {
		return entrenadorRepository.findById(id).get();
	}

	public void updateEntrenador(
			Long id,
			String nombre,
			String correo,
			String especializacion,
			int anosexperiencia,
			Long[] idRutinas
			) throws Exception {
		Entrenador entrenador = entrenadorRepository.findById(id).get();
		
		entrenador.setNombre(nombre);
		entrenador.setCorreo(correo);
		entrenador.setEspecializacion(especializacion);
		entrenador.setAnosexperiencia(anosexperiencia);

		// GESTION DE EJERCICIOS
		List<Rutina> rutinas = new ArrayList<Rutina>();
		for (Long idRutina : idRutinas) {
			Rutina rutina = rutinaRepository.getById(idRutina);
			rutinas.add(rutina);
			rutina.getEntrenadors().add(entrenador);
		}
		entrenador.getRutinas().addAll(rutinas);

		try {
			entrenadorRepository.saveAndFlush(entrenador);
		} catch (Exception e) {
			throw new Exception("El/la entrenador " + nombre + " ya existe");
		}
	}

	public void deleteEntrenador(Long id) {
		Entrenador entrenador = entrenadorRepository.findById(id).get();
		entrenadorRepository.delete(entrenador);
	}
}


