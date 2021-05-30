package com.ufps.springboot.archivo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ufps.springboot.archivo.app.models.entities.Caja;
import com.ufps.springboot.archivo.app.models.entities.Espacio;
import com.ufps.springboot.archivo.app.models.entities.Estante;
import com.ufps.springboot.archivo.app.models.service.EstanteServiceImpl;

@Controller
public class archivoController {
	
	@Autowired
	private EstanteServiceImpl estanteService;
	
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
	public String crearCaja(@PathVariable Long id, Model model) {
		Espacio e = estanteService.findEspacio(id);
		Caja caja = new Caja();
		caja.setEspacio(e);
		model.addAttribute("caja", caja);
		return "regCaja";
		
	}
}
