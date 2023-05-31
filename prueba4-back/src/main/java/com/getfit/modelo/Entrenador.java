package com.getfit.modelo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.lang.NonNull;

@Entity
public class Entrenador {

	
	/*======= ATRIBUTOS DE LA CLASE ========*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = false)
	@NonNull
	private String nombre;

	private String correo;
	private String especializacion;
	private int anosexperiencia;
	
	public Long getEntrenadorId() {
		return id;
	}
	public void setEntrenadorId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getEspecializacion() {
		return especializacion;
	}
	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
	public int getAnosexperiencia() {
		return anosexperiencia;
	}
	public void setAnosexperiencia(int anosexperiencia) {
		this.anosexperiencia = anosexperiencia;
	}

	
	
	/*======= RELACIONES ========*/
	
	//Lado Muchos a Muchos con rutina
	/**/@ManyToMany
	private Collection<Rutina> rutinas;

	public Collection<Rutina> getRutinas() {
		return rutinas;
	}
	public void setRutinas(Collection<Rutina> rutinas) {
		this.rutinas = rutinas;
	}
}
