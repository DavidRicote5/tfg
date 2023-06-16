package com.getfit.repositorios;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getfit.modelo.Rutina;
import com.getfit.modelo.Usuario;

public interface RutinaRepository extends JpaRepository<Rutina, Long> {

	Set<Rutina> findByUsuario(Usuario usuario);
	
}
