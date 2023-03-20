package org.agaray.spring.pap2023.repositories;

import org.agaray.spring.pap2023.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
	public Rol findByNombre(String nombre);
}
