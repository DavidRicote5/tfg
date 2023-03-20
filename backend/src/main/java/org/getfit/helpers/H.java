package org.getfit.helpers;

import org.getfit.entities.Cliente;

import org.getfit.entities.Rol;

public class H {
	
	public static void isRolOk(String nombreRol, Cliente usuario) throws Exception {
		if (!usuario.getRol().equals(new Rol(nombreRol))) {
			throw new Exception("Rol inadecuado, rol actual: "+usuario.getRol()+", rol requerido: "+nombreRol);
		}
	}
}
