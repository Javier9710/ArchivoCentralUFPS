package com.ufps.springboot.archivo.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufps.springboot.archivo.app.models.entities.Dependencia;
import com.ufps.springboot.archivo.app.models.service.IDependenciaService;

@Controller
public class DependenciaController {
	
	@Autowired
	private IDependenciaService dependenciaService;
	
	@GetMapping(value = "/listaDependencia")
	public String listar(Model model) {
		List<Dependencia> dependencias= dependenciaService.findAll();
		model.addAttribute("dependencias", dependencias);
		model.addAttribute("m", "prueba");
		
		return "listaDependencia";
		
	}
	
	@GetMapping(value = "/crear")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Registro de dependencias");
		model.addAttribute("dependencia", new Dependencia());
		return "regDependencia";
	}
	
	
	@PostMapping(value = "/regDependencia")
	public String registrar(@Valid Dependencia dependencia, Model model, RedirectAttributes flash) {
		
		Dependencia d = dependencia;
		
		if (d==null) {
			System.out.println("ocurrio un error");
			return "otra mierda";
		}
		
		String mensaje = (dependencia.getId() != null) ? "Cliente Editado con exito" : "Cliente Creado con exito";
		System.out.println("Registra");
		dependenciaService.save(dependencia);
		flash.addFlashAttribute("success", mensaje);
		
		return "listaDependencia";
		
	}
	
	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		Dependencia d = dependenciaService.findById(id);
		if (d==null) {
			System.out.println("la Dependencia no existe");
			return "otra mierda";
			
		}
		dependenciaService.delete(id);
		return "listaDependencia";
	}

}
