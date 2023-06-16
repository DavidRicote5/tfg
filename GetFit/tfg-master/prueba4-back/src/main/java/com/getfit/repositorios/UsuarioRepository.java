package com.getfit.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getfit.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

}
