package com.ufps.springboot.archivo.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufps.springboot.archivo.app.models.entities.Bloque;
import com.ufps.springboot.archivo.app.models.entities.Estante;
import com.ufps.springboot.archivo.app.models.entities.Rol;
import com.ufps.springboot.archivo.app.models.entities.Usuario;
import com.ufps.springboot.archivo.app.models.service.BloqueServiceImpl;
import com.ufps.springboot.archivo.app.models.service.EstanteServiceImpl;
import com.ufps.springboot.archivo.app.models.service.UsuarioServiceImpl;

@Controller
public class AdminController {

	@Autowired
	private BloqueServiceImpl bloqueService;
	
	@Autowired
	private EstanteServiceImpl estanteService;
	
	@Autowired
	private UsuarioServiceImpl usuarioService;

	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping(value = { "/index", "/" })
	public String home(Model model) {

		return "index";
	}

	@GetMapping(value = "/espacios")
	public String crearBloque(Model model, RedirectAttributes flash) {
		List<Bloque> bloques = bloqueService.findAll();
		model.addAttribute("lista", bloques);

		model.addAttribute("bloque",new Bloque());
		model.addAttribute("estante",new Estante());

		return "espacios";
	}

	@PostMapping(value = "/espacios")
	public String registrarBloque(@Valid Bloque bloque, BindingResult result, Model model, RedirectAttributes flash) {		
		Bloque x = bloqueService.findByLetra(bloque.getLetra());
		if (x != null) {
			flash.addFlashAttribute("warning", "El bloque ya existe");
			return "redirect:/espacios";
		}

		bloqueService.save(bloque);
		flash.addFlashAttribute("success", "Bloque Registrado");
		return "redirect:/espacios";
	}

	@PostMapping(value = "/estantes")
	public String registrarEstantes(@RequestParam(value = "bloque2") Long id, @Valid Estante estante, BindingResult result, Model model, RedirectAttributes flash) {
		Bloque x = bloqueService.findById(id);
		Estante e = estanteService.findByNumero(estante.getNumero());
		if (e!=null) {
			flash.addFlashAttribute("warning", "El Estante numero: "+estante.getNumero()+" Ya existe!");
			return "redirect:/espacios";
			
		}
		flash.addFlashAttribute("success", "Estante Registrado con exito");
		estante.setBloque(x);
		estanteService.save(estante);
		estanteService.generar(estante);
		
		return "redirect:espacios";
	}
	
	@GetMapping(value = "/usuario")
	public String crearUsuario(Model model) {
		List<Rol> roles =usuarioService.findAllRol();
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("roles", roles);
		return "regUsuario";
	}

}
