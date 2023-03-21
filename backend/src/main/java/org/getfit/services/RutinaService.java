package org.getfit.services;

import java.util.List;

import org.getfit.entities.Entrenador;
import org.getfit.entities.Rutina;
import org.getfit.repositories.EntrenadorRepository;
import org.getfit.repositories.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutinaService {

	@Autowired
	private RutinaRepository rutinaRepository;
	
	@Autowired
	private EntrenadorRepository entrenadorRepository;

	public List<Rutina> getRutinas() {
		return rutinaRepository.findAll();
	}

	public void saveRutina(String nombre,String descripcion, String dificultad, int duracion,Long idEntrenador) throws Exception {
		Rutina rutina = Rutina.builder().nombre(nombre).descripcion(descripcion).dificultad(dificultad).duracion(duracion).build();
		
		//GESTION DE ENTRENADOR
		Entrenador entrenador = entrenadorRepository.getById(idEntrenador);
		rutina.setEntrenador(entrenador);
		
		try {
			rutinaRepository.saveAndFlush(rutina);
		} catch (Exception e) {
			throw new Exception("El/la rutina " + nombre + " ya existe");
		}
	}

	public Rutina getRutinaById(Long id) {
		return rutinaRepository.findById(id).get();
	}

	public void updateRutina(Long id, String nombre) throws Exception {
		Rutina rutina = rutinaRepository.findById(id).get();
		rutina.setNombre(nombre);
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

