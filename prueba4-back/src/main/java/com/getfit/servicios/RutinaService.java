package com.getfit.servicios;

import java.util.Set;

import com.getfit.modelo.Ejercicio;
import com.getfit.modelo.Rutina;
import com.getfit.modelo.Usuario;

public interface RutinaService {

	Set<Rutina> obtenerRutinas();

	Rutina agregarRutina(Rutina rutina);

	Rutina actualizarRutina(Rutina rutina);

	Rutina obtenerRutina(Long rutinaId);

	void eliminarRutina(Long rutinaId);

	Rutina listarRutina(Long rutinaId);
	
	Set<Rutina> obtenerRutinasDeUsuario(Usuario usuario);


}
