package com.ufps.springboot.archivo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value = "/index")
	public String inicio() {
		return "index";
	}
	
	@GetMapping(value = "/home")
	public String home() {
		return "index2";
	}
	

}
