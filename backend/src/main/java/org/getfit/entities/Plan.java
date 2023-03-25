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
public class Plan {

	/*
	 * =============================================================================
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String nombre;
	private String descripcion;
	private int duracion;
	private int precio;

	/*
	 * =============================================================================
	 */

	// RELACIONES
	@OneToMany(mappedBy = "plan")
	private Collection<Usuario> usuarios;

}
