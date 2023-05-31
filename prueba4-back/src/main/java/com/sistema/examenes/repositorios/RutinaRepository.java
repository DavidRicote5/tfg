package com.sistema.examenes.repositorios;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sistema.examenes.modelo.Rutina;
import com.sistema.examenes.modelo.Usuario;

public interface RutinaRepository extends JpaRepository<Rutina, Long> {

	Set<Rutina> findByUsuario(Usuario usuario);
	
}
