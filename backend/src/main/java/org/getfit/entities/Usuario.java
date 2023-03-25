package org.getfit.entities;

import java.time.LocalDate;
import jakarta.persistence.Column;
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
public class Usuario {

	/*
	 * =============================================================================
	 */

	// Atributo ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Atributos regulares de la clase
	@Column(unique = true)
	private String loginname;
	
	private String nombre;
	private String contraseña;
	private String correo;
	private LocalDate fechaNac;
	private String extension;
	private String genero;
	private int altura;
	private int peso;

	/*
	 * =============================================================================
	 */

	// RELACIONES
	@ManyToOne
	private Entrenador entrenador;

	@ManyToOne
	private Plan plan;
	
	@ManyToOne
	private Rutina rutina;
	
	@ManyToOne
	private Rol rol;
	

}
