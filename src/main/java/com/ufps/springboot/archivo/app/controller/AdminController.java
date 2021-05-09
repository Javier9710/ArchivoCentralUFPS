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
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufps.springboot.archivo.app.models.entities.Bloque;
import com.ufps.springboot.archivo.app.models.entities.Estante;
import com.ufps.springboot.archivo.app.models.service.BloqueServiceImpl;
import com.ufps.springboot.archivo.app.models.service.EstanteServiceImpl;

@Controller
public class AdminController {

	@Autowired
	private BloqueServiceImpl bloqueService;
	
	@Autowired
	private EstanteServiceImpl estanteService;

	
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
	public String registrarBloque(@Valid Bloque bloque, BindingResult result, Model model) {		
		Bloque x = bloqueService.findByLetra(bloque.getLetra());
		if (x != null) {
			return "espacios";
		}

		bloqueService.save(bloque);
		model.addAttribute("titulo", "se registro");

		return "redirect:espacios";
	}

	@PostMapping(value = "/estantes")
	public String registrarEstantes(@RequestParam(value = "bloque2") Long id, @Valid Estante estante, BindingResult result, Model model) {
		Bloque x = bloqueService.findOne(id);
		if (x==null) {
			model.addAttribute("mensaje","La letra no existe");
			return "espacios";
			
		}

		estante.setBloque(x);
		estanteService.save(estante);
		return "redirect:espacios";
	}

}
