package com.ufps.springboot.archivo.app.controller;

import java.util.List;
import java.util.Map;

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
	
	@GetMapping(value = "/form")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Registro de dependencias");
		model.addAttribute("dependencia", new Dependencia());
		return "regDependencia";
	}
	
	
	@PostMapping(value = "/regDependencia")
	public String registrar(@Valid Dependencia dependencia, Model model, RedirectAttributes flash) {
		
		String mensaje = (dependencia.getId() != null) ? "Cliente Editado con exito" : "Cliente Creado con exito";
		System.out.println("Registr a"+ dependencia.getId());
		dependenciaService.save(dependencia);
		flash.addFlashAttribute("success", mensaje);
		
		return "redirect:/listaDependencia";
		
	}
	
	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		Dependencia d = dependenciaService.findById(id);
		if (d==null) {
			System.out.println("la Dependencia no existe");
			return "otra mierda";
			
		}
		dependenciaService.delete(id);
		return "redirect:/listaDependencia";
	}
	
	@GetMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Dependencia dependencia = null;
		if (id > 0) {
			dependencia = dependenciaService.findById(id);
			if (dependencia == null) {
				System.out.println("error, no existe");
				flash.addFlashAttribute("error", "El Cliente no Existe en la Base de Datos");
				return "redirect:/listaDependencia";

			}

		} else {
			System.out.println("entra -------");
			return "redirect:/listaDependencia";

		}
		System.out.println(dependencia.getId()+" -----------------------------");
		model.put("dependencia", dependencia);

		return "regDependencia";
	}

}
