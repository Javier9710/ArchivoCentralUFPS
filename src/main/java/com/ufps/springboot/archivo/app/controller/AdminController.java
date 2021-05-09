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

import com.ufps.springboot.archivo.app.models.entities.Bloque;
import com.ufps.springboot.archivo.app.models.entities.Estante;
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
		Estante estante = new Estante();
		List<Bloque> bloques = bloqueService.findAll();
		
		model.addAttribute("lista", bloques);

		model.addAttribute("bloque", bloque);
		model.addAttribute("estante", estante);
		
		
		return "espacios";
	}
	
	@PostMapping(value = "/espacios")
	public String registrarBloque(@Valid Bloque bloque, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "ya existe");
			return "espacios";
			
		}
		
		System.out.println("------------ entra 1");
		List<Bloque> bloques = bloqueService.findAll();
		model.addAttribute("lista", bloques);
		System.out.println("------------ entra 2");
		
		Bloque x= bloqueService.findByLetra(bloque.getLetra());
		if (x!=null) {
			return "espacios";
		}

		
		bloqueService.save(bloque);
		model.addAttribute("titulo", "se registro");
		
		return "redirect:espacios";
	}



	

}
