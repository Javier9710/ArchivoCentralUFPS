package com.ufps.springboot.archivo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ufps.springboot.archivo.app.models.entities.Dependencia;

@Controller
public class DependenciaController {
	
	@GetMapping(value = "/listaDependencia")
	public String listar(Model model) {
		
		return "listaDependencia";
		
	}
	
	@GetMapping(value = "/crear")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Registro de dependencias");
		model.addAttribute("dependencia", new Dependencia());
		return "regDependencia";
	}

}
