package com.ufps.springboot.archivo.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufps.springboot.archivo.app.models.entities.Caja;
import com.ufps.springboot.archivo.app.models.entities.Dependencia;
import com.ufps.springboot.archivo.app.models.entities.Espacio;
import com.ufps.springboot.archivo.app.models.entities.Estante;
import com.ufps.springboot.archivo.app.models.service.CajaServiceImpl;
import com.ufps.springboot.archivo.app.models.service.DependenciaServiceImpl;
import com.ufps.springboot.archivo.app.models.service.EstanteServiceImpl;

@Controller
public class archivoController {
	
	@Autowired
	private EstanteServiceImpl estanteService;
	
	@Autowired
	private DependenciaServiceImpl dependenciaService;
	
	@Autowired
	private CajaServiceImpl cajaService;
	
	
	
	//-----------------------------------------------------------------
	
	@GetMapping(value = "/regArchivo")
	public String crear(Model model) {
		List<Estante> estantes = estanteService.findAll();
		model.addAttribute("estantes", estantes);
		return "listaEstante";
	}
	
	@GetMapping(value = "/verEstante/{id}")
	public String ver(@PathVariable Long id, Model model) {
		Estante e =  estanteService.findById(id);
		List<Espacio> espacios = estanteService.listaEspacios(id);
		model.addAttribute("espacios", espacios);
		model.addAttribute("estante", e);
		return "verEstante";
		
	}
	
	@GetMapping(value = "/ingresarCaja/{id}")
	public String crearCaja(@PathVariable Long id, Model model, RedirectAttributes flash) {
		Espacio e = estanteService.findEspacio(id);
		List<Dependencia>  dep=   dependenciaService.findAll();
		if (e==null) {
			flash.addFlashAttribute("error", "El Espacio no Existe");
			return "redirect:/regArchivo";
		}
		Caja caja = new Caja();
		caja.setEspacio(e);
		model.addAttribute("caja", caja);
		model.addAttribute("dependencias", dep);
		model.addAttribute("espacio", e);
		return "regCaja";
		
	}
	
	@PostMapping(value = "/regCaja")
	public String registrarCaja(@Valid Caja caja, @RequestParam(value = "bloque2") Long id, @RequestParam(value = "espacio") Espacio e, Model model) {
		Dependencia dep = dependenciaService.findById(id);
		caja.setDependencia(dep.getNombre());
		caja.setDependenciaObject(dep);
		caja.setEspacio(e);
		e.setEstado(true);
		cajaService.saveCaja(caja);
		return "verCaja";
	}
}
