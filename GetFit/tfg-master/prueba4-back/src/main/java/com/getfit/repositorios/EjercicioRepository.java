package com.getfit.repositorios;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getfit.modelo.Ejercicio;
import com.getfit.modelo.Rutina;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long>{
	
	Set<Ejercicio> findByRutina(Rutina rutina);
}
