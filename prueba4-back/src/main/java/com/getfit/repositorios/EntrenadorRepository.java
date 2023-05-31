package com.getfit.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.getfit.modelo.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

}
