package org.getfit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne
	private Rutina rutina;
}
