package org.getfit.entities;

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

//NO SE UTLIZA LOMBOK CON LA ESTRUCTURA DE CONSTRUCTORES
@Entity
public class Rol {

	
	/*======= ATRIBUTOS DE LA CLASE ========*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nombre;

	
	/*======= RELACIONES ========*/
	
	//Lado Uno a Muchos con usuarios
	@OneToMany(mappedBy = "rol")
	private Collection<Usuario> usuarios;
	

	/*======= CONSTRUCTORES ========*/
	
	public Rol() {
		this.nombre = "user";
		this.usuarios = new ArrayList<Usuario>();
	}


	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}

	
	/*======= METODOS SOBREESCRITOS ========*/
	
	@Override
	public boolean equals(Object rol) {
		return rol instanceof Rol && ((Rol) rol).getNombre().equals(nombre);
	}

	
	@Override
	public String toString() {
		return this.nombre;
	}

	/*======= GETTERS & SETTERS ========*/
	
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

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
