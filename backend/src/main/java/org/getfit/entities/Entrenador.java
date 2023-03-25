package org.getfit.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Entrenador {

	/*
	 * =============================================================================
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String nombre;
	private String correo;
	private String certificaciones;
	private String especializacion;
	private int aniosExperiencia;

	/*
	 * =============================================================================
	 */

	@OneToMany(mappedBy = "entrenador")
	private Collection<Usuario> usuarios;

	@OneToMany(mappedBy = "entrenador")
	private Collection<Rutina> rutinas;
}
