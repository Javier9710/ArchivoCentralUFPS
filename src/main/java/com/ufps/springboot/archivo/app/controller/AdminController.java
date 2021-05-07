package com.ufps.springboot.archivo.app.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@Secured(value = "ROLE_ADMIN")
	@GetMapping(value = {"/index","/"})
	public String home() {
		return "index";
	}

	//@Secured(value = "ROLE_ADMIN")
	@GetMapping(value = {"/validation"})
	public String home1() {
		return "pages/validation";
	}

	

}
