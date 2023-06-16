package org.agaray.spring.pap2023.controllers.rest;

import java.util.List;

import org.agaray.spring.pap2023.dto.EmpleadoDTO;
import org.agaray.spring.pap2023.exception.DangerException;
import org.agaray.spring.pap2023.helpers.PRG;
import org.agaray.spring.pap2023.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoService empleadoService;


	@PostMapping("")
	public EmpleadoDTO cPost(
			@RequestBody EmpleadoDTO empleadoDTO
			) throws DangerException {
		
		try {
			empleadoDTO = empleadoService.saveEmpleado(empleadoDTO);
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/empleado/r");
		}
		return empleadoDTO;
	}

	@GetMapping("")
	public List<EmpleadoDTO> rGet(ModelMap m) {
		return empleadoService.getEmpleados();
	}

}

