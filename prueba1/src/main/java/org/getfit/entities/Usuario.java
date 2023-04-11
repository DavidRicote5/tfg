package org.getfit.entities;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NonNull
	private String loginname;
	
	private String nombre;
	private String contraseña;
	private String correo;
	private LocalDate fechaNac;
	private String genero;
	private int altura;
	private int peso;
	
	
	@ManyToOne
	private Plan plan;
	
	@ManyToOne
	private Entrenador entrenador;
	
	@ManyToMany
	private Collection<Rutina> rutinas;
	


}

