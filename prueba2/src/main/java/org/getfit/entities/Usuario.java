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

	
	/*======= ATRIBUTOS DE LA CLASE ========*/
	
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

	
	/*======= RELACIONES ========*/
	
	//Lado Muchos a Uno con plan
	@ManyToOne
	private Plan plan;

	//Lado Muchos a Uno con entrenador
	@ManyToOne
	private Entrenador entrenador;

	//Lado Muchos a Muchos con rutinas
	@ManyToMany
	private Collection<Rutina> rutinas;

	//Lado Muchos a Uno con rol
	@ManyToOne
	private Rol rol;

}
