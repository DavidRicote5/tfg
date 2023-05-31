package com.sistema.examenes.repositorios;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.modelo.Ejercicio;
import com.sistema.examenes.modelo.Rutina;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long>{
	
	Set<Ejercicio> findByRutina(Rutina rutina);
}
