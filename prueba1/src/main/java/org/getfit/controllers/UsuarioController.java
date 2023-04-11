package org.getfit.controllers;

import java.time.LocalDate;
import java.util.List;
import org.getfit.entities.Usuario;
import org.getfit.exception.DangerException;
import org.getfit.helpers.PRG;
import org.getfit.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("c")
	public String cGet(ModelMap m) {
		m.put("view", "usuario/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(
			@RequestParam("loginname") String loginname,
			@RequestParam("nombre") String nombre,
			@RequestParam("contraseña") String contraseña,
			@RequestParam("correo") String correo,
			@RequestParam("fechaNac") LocalDate fechaNac,
			@RequestParam("genero") String genero,
			@RequestParam("altura") int altura,
			@RequestParam("peso") int peso
			) throws DangerException {
		try {
			usuarioService.saveUsuario(loginname,nombre,contraseña,correo,fechaNac,genero,altura,peso);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/usuario/r");
		}
		return "redirect:/usuario/r";
	}

	@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Usuario> usuarios = usuarioService.getUsuarios();
		m.put("usuarios", usuarios);
		m.put("view", "usuario/r");
		return "_t/frame";
	}

	@GetMapping("u")
	public String uGet(@RequestParam("id") Long idUsuario, ModelMap m) {
		Usuario usuario = usuarioService.getUsuarioById(idUsuario);

		m.put("usuario", usuario);
		m.put("view", "usuario/u");

		return "_t/frame";
	}

	@PostMapping("u")
	public String uPost(
			@RequestParam("idUsuario") Long idUsuario,
			@RequestParam("nombre") String nombre,
			@RequestParam("fechaNac") LocalDate fechaNac,
			@RequestParam("genero") String genero,
			@RequestParam("altura") int altura,
			@RequestParam("peso") int peso
			) throws DangerException {
		String retorno = "redirect:/usuario/r";
		try {
			usuarioService.updateUsuario(idUsuario, nombre,fechaNac,genero,altura,peso);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/usuario/r");
		}
		return retorno;
	}

	@PostMapping("d")
	public String d(@RequestParam("id") Long id) {
		usuarioService.deleteUsuario(id);
		return "redirect:/usuario/r";
	}

}
