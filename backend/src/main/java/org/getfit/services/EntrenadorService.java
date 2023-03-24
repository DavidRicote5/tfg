package org.getfit.services;

import java.util.List;
import org.getfit.entities.Entrenador;
import org.getfit.repositories.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenadorService {

	@Autowired
	private EntrenadorRepository entrenadorRepository;

	public List<Entrenador> getEntrenadores() {
		return entrenadorRepository.findAll();
	}

	public void saveEntrenador(String nombre, String correo, String certificaciones, String especializaciones, int añosExperiencia) throws Exception {
		
		Entrenador entrenador = Entrenador.builder().nombre(nombre).correo(correo).certificaciones(certificaciones).añosExperiencia(añosExperiencia).build();
		
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
			String certificaciones,
			String especializaciones,
			int añosExperiencia) throws Exception {
		Entrenador entrenador = entrenadorRepository.findById(id).get();
		entrenador.setNombre(nombre);
		entrenador.setCertificaciones(certificaciones);
		entrenador.setEspecializacion(especializaciones);
		entrenador.setAñosExperiencia(añosExperiencia);
		
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

