package com.sistema.examenes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Ejercicio {

	/*======= ATRIBUTOS DE LA CLASE ========*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NonNull
	private String nombre;

	private String descripcion;
	private String grupomuscular;
	private String equiponecesario;
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getGrupomuscular() {
		return grupomuscular;
	}
	public void setGrupomuscular(String grupomuscular) {
		this.grupomuscular = grupomuscular;
	}
	public String getEquiponecesario() {
		return equiponecesario;
	}
	public void setEquiponecesario(String equiponecesario) {
		this.equiponecesario = equiponecesario;
	}

	
	
	
	/*======= RELACIONES ========*/
	
	//Lado Muchos a Muchos con rutina (mappedBy)
	//@ManyToMany(mappedBy = "ejercicios")
	//private Collection<Rutina> rutinas;
}
