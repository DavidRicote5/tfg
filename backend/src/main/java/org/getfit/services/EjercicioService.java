package org.getfit.services;

import java.util.List;

import org.getfit.entities.Ejercicio;
import org.getfit.repositories.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjercicioService {

	@Autowired
	private EjercicioRepository ejercicioRepository;
	

	public List<Ejercicio> getEjercicios() {
		return ejercicioRepository.findAll();
	}

	public void saveEjercicio(String nombre,String descripcion,String grupoMuscular,String equipoNecesario) throws Exception {
		Ejercicio ejercicio = Ejercicio.builder().nombre(nombre).build();
		
		try {
			ejercicioRepository.saveAndFlush(ejercicio);
		} catch (Exception e) {
			throw new Exception("El/la ejercicio " + nombre + " ya existe");
		}
	}

	public Ejercicio getEjercicioById(Long id) {
		return ejercicioRepository.findById(id).get();
	}

	public void updateEjercicio(Long id, String nombre) throws Exception {
		Ejercicio ejercicio = ejercicioRepository.findById(id).get();
		ejercicio.setNombre(nombre);
		try {
			ejercicioRepository.saveAndFlush(ejercicio);
		} catch (Exception e) {
			throw new Exception("El/la ejercicio " + nombre + " ya existe");
		}
	}

	public void deleteEjercicio(Long id) {
		Ejercicio ejercicio = ejercicioRepository.findById(id).get();
		ejercicioRepository.delete(ejercicio);
	}
}

