package com.sistema.examenes.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.modelo.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

}
