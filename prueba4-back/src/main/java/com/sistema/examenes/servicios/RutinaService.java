package com.sistema.examenes.servicios;

import java.util.Set;


import com.sistema.examenes.modelo.Rutina;

public interface RutinaService {

	Set<Rutina> obtenerRutinas();

	Rutina agregarRutina(Rutina rutina);

	Rutina actualizarRutina(Rutina rutina);

	Rutina obtenerRutina(Long rutinaId);

	void eliminarRutina(Long rutinaId);

	Rutina listarRutina(Long rutinaId);

}
