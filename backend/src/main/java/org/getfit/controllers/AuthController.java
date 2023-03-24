package org.getfit.controllers;

import org.getfit.exception.DangerException;
import org.getfit.helpers.PRG;
import org.getfit.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

//CLASE CONTROLLER PARA AUTENTICAR UN USUARIO

@Controller
public class AuthController {
	
	
	@Autowired
	UsuarioService usuarioService;

	//REDIRIGE HACIA LA VISTA DE LOGIN
	@GetMapping("/login")
	public String login(
			ModelMap m
			) {
		m.put("view", "home/login");
		return "_t/frame";
	}
	
	//OBTIENE LOS DATOS QUE SE PASAN EN EL LOGIN
	@PostMapping("/login")
	public String loginPost(
			@RequestParam("loginname") String loginname,
			@RequestParam("contraseña") String contraseña,
			HttpSession s
			) throws DangerException {
		
		try {
			s.setAttribute("usuario", usuarioService.autenticarUsuario(loginname, contraseña));
		}
		catch (Exception e) {
			PRG.error(e.getMessage(),"/");
		}
		return "redirect:/";
	}
	
	//REFIRIGE HACIA EL HOME Y DESLOGUEA AL USUARIO
	@GetMapping("/logout")
	public String logout(
			HttpSession s
			) {
		if (s.getAttribute("usuario")!=null) {
			s.removeAttribute("usuario");
		}
		return "redirect:/";
	}
}
