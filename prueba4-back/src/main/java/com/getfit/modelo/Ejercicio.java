package com.getfit.modelo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "ejercicios")
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
	private int series;
	private int repeticiones;
	private int peso;
	
	
	public int getSeries() {
		return series;
	}
	public void setSeries(int series) {
		this.series = series;
	}
	public int getRepeticiones() {
		return repeticiones;
	}
	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public Long getEjercicioId() {
		return id;
	}
	public void setEjercicioId(Long id) {
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
	
	//Lado Muchos a Uno con rutina (mappedBy)
	@ManyToOne(fetch = FetchType.EAGER)
	private Rutina rutina;

	public Rutina getRutina() {
		return rutina;
	}
	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

}
