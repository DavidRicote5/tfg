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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nombre;
	
	//TIENE QUE ESTAR MAPEADO CON LA CLASE PERSONA | EN MI CASO CON LA CLASE USUARIO
	@OneToMany(mappedBy = "rol")
	private Collection<Usuario> usuarios;

	// ===========================================

	//CONSTRUCTOR QUE SE LE PASA COMO PARAMETROS EL NOMBRE QUE ESTABLECE QUE ES UN USUARIO ESTANDAR
	//Y A LA COLECCION DE USUARIOS SE LE PASA UN ARRAYLIST DE PERSONAS | EN MI CASO DE USUARIOS
	public Rol() {
		this.nombre = "user";
		this.usuarios = new ArrayList<Usuario>();
	}

	//EN ESTE CONSTRUCTOR SOLO SE PASA COMO PARAMETRO EL NOMBRE QUE VA A TENER, YA SEA ADMIN O USER
	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}

	//ESTE METODO COMPARA DOS OBJETOS ROL BASANDOSE EN SU NOMBRE "USER" O "ADMIN"
	@Override
	public boolean equals(Object rol) {
		return 	rol instanceof Rol &&
				((Rol)rol).getNombre().equals(nombre);
	}
	
	//DEVUELVE "USER" O "ADMIN"
	@Override
	public String toString() {
		return this.nombre;
	}
	// ===========================================

	//GETTERS && SETTERS
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
