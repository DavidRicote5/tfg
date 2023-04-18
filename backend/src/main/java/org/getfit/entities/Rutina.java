package org.getfit.entities;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

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

	/*======= RELACIONES ========*/

	//Lado Muchos a Muchos con ejercicios
	@ManyToMany
	private Collection<Ejercicio> ejercicios;

	
	//Lado Muchos a Muchos con entrenadores (mappedBy)
	@ManyToMany(mappedBy = "rutinas")
	private Collection<Entrenador> entrenadors;

	
	//Lado Muchos a Muchos con usuarios (mappedBy)
	@ManyToMany(mappedBy = "rutinas")
	private Collection<Usuario> usuarios;

}
