package org.getfit.controllers;

import java.util.List;
import org.getfit.entities.Cliente;
import org.getfit.exception.DangerException;
import org.getfit.helpers.PRG;
import org.getfit.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("c")
	public String cGet(ModelMap m) {
		m.put("view", "cliente/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(@RequestParam("nombre") String nombre) throws DangerException {
		try {
			clienteService.saveCliente(nombre);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/cliente/r");
		}
		return "redirect:/cliente/r";
	}

	@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Cliente> clientes = clienteService.getClientes();
		m.put("clientes", clientes);
		m.put("view", "cliente/r");
		return "_t/frame";
	}

	@GetMapping("u")
	public String uGet(@RequestParam("id") Long idCliente, ModelMap m) {
		Cliente cliente = clienteService.getClienteById(idCliente);

		m.put("cliente", cliente);
		m.put("view", "cliente/u");

		return "_t/frame";
	}

	@PostMapping("u")
	public String uPost(@RequestParam("idCliente") Long idCliente,
			@RequestParam("nombre") String nombre) throws DangerException {
		String retorno = "redirect:/cliente/r";
		try {
			clienteService.updateCliente(idCliente, nombre);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/cliente/r");
		}
		return retorno;
	}

	@PostMapping("d")
	public String d(@RequestParam("id") Long id) {
		clienteService.deleteCliente(id);
		return "redirect:/cliente/r";
	}

}
