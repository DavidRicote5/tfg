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
	

}
