package org.getfit.helpers;

import org.getfit.entities.Rol;
import org.getfit.entities.Usuario;

public class H {
	
	//Este método estático se utiliza para comprobar si el rol de un usuario coincide con el rol especificado
	//y lanza una excepción si no es así.
	public static void isRolOk(String nombreRol, Usuario usuario) throws Exception {
		if (!usuario.getRol().equals(new Rol(nombreRol))) {
			throw new Exception("Rol inadecuado, rol actual: "+usuario.getRol()+", rol requerido: "+nombreRol);
		}
	}
}
