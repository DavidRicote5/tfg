package com.getfit.modelo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "rutinas")
public class Rutina {

	
	/*======= ATRIBUTOS DE LA CLASE ========*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	@OneToMany(mappedBy = "rutina",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Ejercicio> ejercicios = new HashSet<>();
	
	public Set<Ejercicio> getEjercicios() {
		return ejercicios;
	}
	public void setEjercicios(Set<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	//Lado Muchos a Muchos con entrenadores
	@ManyToMany(mappedBy = "rutinas")
	private Collection<Entrenador> entrenadores;
	
	
	public Collection<Entrenador> getEntrenadores() {
		return entrenadores;
	}
	public void setEntrenadores(Collection<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	
	//Lado Muchos a Uno con usuarios (mappedBy)
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
