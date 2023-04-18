package org.getfit;

import org.getfit.services.RolService;
import org.getfit.services.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class} )
public class Prueba2Application {

	public static void main(String[] args) {
		SpringApplication.run(Prueba2Application.class, args);
	}
	
	@Bean
	CommandLineRunner run (UsuarioService usuarioService,RolService rolService) {
		return (args -> crearRolesYUsuarios(rolService,usuarioService));
	}

	
	private static void crearRolesYUsuarios(RolService rs, UsuarioService ps) {
		try {

			if (! rs.existeRol("admin") ) {
				rs.saveRol("admin");
			}

			if (! rs.existeRol("user") ) {
				rs.saveRol("user");
			}

		}
		catch (Exception e) {
			System.out.println("Error al crear roles por defecto");
			System.out.println(e.getMessage());
		}
		try {

			if (! ps.existeUsuario("admin")) {
				ps.saveAdmin("admin", "admin", "admin", "getfit@getfit.org");
			}
		}
		catch (Exception e) {
			System.out.println("Error al crear usuario admin");
			System.out.println(e.getMessage());
		}

	}

}
