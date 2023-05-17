package com.sistema.examenes.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.modelo.Ejercicio;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long>{

}
