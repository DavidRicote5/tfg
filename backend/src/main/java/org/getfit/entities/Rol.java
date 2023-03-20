package org.agaray.spring.pap2023.entities;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * 
 * Roles posibles:
 * <ul>
 * <li>admin</li>
 * <li>user</li>
 * 
 */
@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nombre;
	
	@OneToMany(mappedBy = "rol")
	private Collection<Persona> usuarios;

	// ===========================================

	public Rol() {
		this.nombre = "user";
		this.usuarios = new ArrayList<Persona>();
	}

	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object rol) {
		return 	rol instanceof Rol &&
				((Rol)rol).getNombre().equals(nombre);
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	// ===========================================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Persona> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Persona> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}
