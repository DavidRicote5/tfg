package com.sistema.examenes.modelo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.lang.NonNull;



@Entity
public class Rutina {

	
	/*======= ATRIBUTOS DE LA CLASE ========*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NonNull
	private String nombre;

	private String descripcion;
	private String dificultad;
	private int duracion;
	
	public Long getRutinaId() {
		return id;
	}
	public void setRutinaId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/*======= RELACIONES ========*/

	//Lado Muchos a Muchos con ejercicios
	@ManyToMany
	private Collection<Ejercicio> ejercicios;

	public Collection<Ejercicio> getEjercicios() {
		return ejercicios;
	}
	public void setEjercicios(Collection<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
	
	
	//Lado Muchos a Muchos con entrenadores (mappedBy)
	@ManyToMany(mappedBy = "rutinas")
	private Collection<Entrenador> entrenadores;
	
	
	public Collection<Entrenador> getEntrenadores() {
		return entrenadores;
	}
	public void setEntrenadores(Collection<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	
	//Lado Muchos a Muchos con usuarios (mappedBy)
	@ManyToMany(mappedBy = "rutinas")
	private Collection<Usuario> usuarios;

	
	
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}/**/

}
