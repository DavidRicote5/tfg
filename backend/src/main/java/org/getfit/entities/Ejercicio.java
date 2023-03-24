package org.getfit.entities;

import java.util.Collection;


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
public class Ejercicio {

	/*
	 * =============================================================================
	 */

	// Atributo ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Atributos regulares
	@NonNull
	private String nombre;
	private String descripcion;
	private String grupoMuscular;
	private String equipoNecesario;

	/*
	 * =============================================================================
	 */

	@ManyToMany(mappedBy = "ejercicios")
	private Collection<Rutina> rutinas;
	
}
