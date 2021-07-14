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
import com.ufps.springboot.archivo.app.models.entities.Estante;
import com.ufps.springboot.archivo.app.models.entities.Legajo;
import com.ufps.springboot.archivo.app.models.entities.Posicion;
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
		
		List<Posicion> posiciones = estanteService.findAllPosicion(id);
		for (int i = 0; i < posiciones.size(); i++) {
		   System.out.println(posiciones.get(i).getId());
		}
		model.addAttribute("posiciones", posiciones);
		model.addAttribute("estante", e);
		return "verEstante";
		
	}
	
	@GetMapping(value = "/ingresarCaja/{id}")
	public String crearCaja(@PathVariable Long id, Model model, RedirectAttributes flash) {
		
		Posicion p = estanteService.findByIdPos(id);
		List<Dependencia>  dep=   dependenciaService.findAll();
		if (p==null) {
			flash.addFlashAttribute("error", "El Espacio no Existe");
			return "redirect:/regArchivo";
		}
		Caja caja = new Caja();
		caja.setPosicion(p);
		model.addAttribute("caja", caja);
		model.addAttribute("dependencias", dep);
		model.addAttribute("posicion", p);
		return "regCaja";
		
	}
	
	@PostMapping(value = "/regCaja")
	public String registrarCaja(@Valid Caja caja, @RequestParam(value = "dependencia") Long id, @RequestParam(value = "posicion") Posicion p, Model model, RedirectAttributes flash) {
		Dependencia dep = dependenciaService.findById(id);
		caja.setDependencia(dep.getNombre());
		caja.setDependenciaObject(dep);
		caja.setPosicion(p);
		//e.setEstado(true);
		if (caja.getNlegajos()=="" || Integer.parseInt(caja.getNlegajos())<=0) {
			flash.addFlashAttribute("error", "No Pueden haber cajas con 0 Legajos");
			return "redirect:/verEstante/"+p.getEstante().getId();
			
		}
		cajaService.saveCaja(caja);
		cajaService.generarLegajos(caja, caja.getNlegajos());
		return "redirect:/verCaja/"+caja.getId();
	}
	
	@GetMapping(value = "/verCaja/{id}")
	public String verLegajos(@PathVariable Long id, Model model) {
		List<Legajo> legajos = cajaService.findAllById(id);
		model.addAttribute("legajos", legajos);		
		return "verCaja";
	}
	
	@GetMapping(value = "/regLegajo/{id}")
	public String formularioLegajo(@PathVariable Long id, Model model) {
		Legajo legajo =  cajaService.findById(id);
		model.addAttribute("legajo", legajo);
		return "regLegajo";
	}
	
	@PostMapping(value = "/regLegajo")
	public String registrarLegajo(@Valid Legajo legajo, @RequestParam(value = "id") long id, RedirectAttributes flash, Model model) {
		Legajo leg = cajaService.findById(id);
		if (leg==null) {
			return "redirect:/";	
		}
		cajaService.save(legajo);
		return "redirect:/verCaja/"+legajo.getCaja().getId();
	}
}
