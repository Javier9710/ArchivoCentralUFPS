package com.ufps.springboot.archivo.app.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping(value = {"/index","/"})
	public String home(Model model) {

		return "index";
	}



	

}
