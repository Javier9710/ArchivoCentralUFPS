package com.ufps.springboot.archivo.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ufps.springboot.archivo.app.models.entities.Bloque;
import com.ufps.springboot.archivo.app.models.service.BloqueServiceImpl;

@Controller
public class AdminController {
	
	@Autowired
	private BloqueServiceImpl bloqueService;
	
	@Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping(value = {"/index","/"})
	public String home(Model model) {

		return "index";
	}
	
	@GetMapping(value = "/espacios")
	public String crearBloque(Model model) {
		Bloque bloque = new Bloque();
		model.addAttribute("titulo", "Registro de Bloques");
		model.addAttribute("bloque", bloque);
		
		return "espacios";
	}
	
	@PostMapping(value = "/espacios")
	public String registrarBloque(@Valid Bloque bloque, BindingResult result, Model model) {
		System.out.println("verdad------"+ bloque.getLetra());
		System.out.println("verdad------"+ bloque.getUbicacion());
		System.out.println("verdad------"+ bloque.getId());
		bloqueService.save(bloque);
		model.addAttribute("titulo", "se registro");
		
		return "espacios";
	}



	

}
