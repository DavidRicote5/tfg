package org.getfit.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.getfit.entities.Entrenador;
import org.getfit.entities.Plan;
import org.getfit.entities.Rutina;
import org.getfit.entities.Usuario;
import org.getfit.exception.DangerException;
import org.getfit.helpers.PRG;
import org.getfit.services.EntrenadorService;
import org.getfit.services.PlanService;
import org.getfit.services.RutinaService;
import org.getfit.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	//ESTO ES PÀRA LA FOTO DE USUARIO
	@Value("${app.uploadFolder}")
	private String UPLOAD_FOLDER;  

	//ESTO ES PÀRA LA FOTO DE USUARIO
	@Value("${app.uploadURIPath}")
	private String UPLOAD_URI;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EntrenadorService entrenadorService;
	
	@Autowired
	private PlanService planService;
	
	@Autowired
	private RutinaService rutinaService;

	@GetMapping("c")
	public String cGet(ModelMap m) {
		m.put("entrenadores", entrenadorService.getEntrenadores());
		m.put("planes", planService.getPlanes());
		m.put("rutinas", rutinaService.getRutinas());
		m.put("view", "usuario/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(
			@RequestParam("loginname") String loginname,
			@RequestParam("nombre") String nombre,
			@RequestParam("contraseña") String contraseña,
			@RequestParam("correo") String correo,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) //NECESARIO PARA EL FORMATO DE LA FECHANAC
			@RequestParam("fechaNac") LocalDate fechaNac,
			@RequestParam("foto") MultipartFile foto,
			@RequestParam("genero") String genero,
			@RequestParam("altura") int altura,
			@RequestParam("peso") int peso,
			@RequestParam("idEntrenador") Long idEntrenador,
			@RequestParam("idPlan") Long idPlan,
			@RequestParam("idRutina") Long idRutina
			) throws DangerException {
		
		
		try {
			
			byte[] bytes = foto.getBytes();
			String extension = FilenameUtils.getExtension(foto.getOriginalFilename());
			Usuario usuario = usuarioService.saveUsuario(loginname,nombre,contraseña,correo,fechaNac,extension,genero,altura,peso,idEntrenador,idPlan,idRutina);
			
			//guardar imagen
			try {
				Path path = Paths.get(UPLOAD_FOLDER + "user-"+ usuario.getId()+"."+extension);
				Files.write(path, bytes);
			}
			catch (Exception e) {
				PRG.error("No se pudo guardar la foto de perfil de "+usuario.getNombre());
			}
		} catch (Exception e) {
			PRG.error(e.getMessage(), "/usuario/r");
		}
		
		
		return "redirect:/usuario/r";
	}
	

	@GetMapping("r")
	public String rGet(ModelMap m) {
		List<Usuario> usuarios = usuarioService.getUsuarios();
		m.put("usuarios", usuarios);
		m.put("uriIMG", UPLOAD_URI );
		m.put("view", "usuario/r");
		return "_t/frame";
	}
	

	@GetMapping("u")
	public String uGet(
			@RequestParam("id") Long idUsuario, ModelMap m) {
		
		Usuario usuario = usuarioService.getUsuarioById(idUsuario);
		
		m.put("entrenadores", entrenadorService.getEntrenadores());
		m.put("planes", planService.getPlanes());
		m.put("rutinas", rutinaService.getRutinas());
		m.put("usuario", usuario);
		m.put("view", "usuario/u");

		return "_t/frame";
	}

	@PostMapping("u")
	public String uPost(@RequestParam("idUsuario") Long idUsuario,
			@RequestParam("nombre") String nombre,
			@RequestParam(required=false, name="idEntrenador") Long idEntrenador,
			@RequestParam(required=false, name="idPlan") Long idPlan,
			@RequestParam(required=false, name="idRutina") Long idRutina
			) throws DangerException {
		
		
		String retorno = "redirect:/usuario/r";
		try {
			usuarioService.updateUsuario(idUsuario, nombre, idEntrenador, idPlan, idRutina);
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

