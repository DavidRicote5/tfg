package org.getfit.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private String dificultad;
	private int duracion;

	/*
	 * =============================================================================
	 */

	@OneToMany(mappedBy = "rutina")
	private Collection<Usuario> usuarios;

	@ManyToOne
	private Entrenador entrenador;

	@ManyToMany
	private Collection<Ejercicio> ejercicios;

}
