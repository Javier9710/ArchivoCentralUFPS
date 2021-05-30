package com.ufps.springboot.archivo.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufps.springboot.archivo.app.models.entities.Bloque;
import com.ufps.springboot.archivo.app.models.entities.Estante;
import com.ufps.springboot.archivo.app.models.entities.Rol;
import com.ufps.springboot.archivo.app.models.entities.Usuario;
import com.ufps.springboot.archivo.app.models.service.BloqueServiceImpl;
import com.ufps.springboot.archivo.app.models.service.EstanteServiceImpl;
import com.ufps.springboot.archivo.app.models.service.UsuarioServiceImpl;

@Controller
public class AdminController {

	@Autowired
	private BloqueServiceImpl bloqueService;
	
	@Autowired
	private EstanteServiceImpl estanteService;
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping(value = { "/index", "/" })
	public String home(Model model) {

		return "index";
	}

	@GetMapping(value = "/espacios")
	public String crearBloque(Model model, RedirectAttributes flash) {
		List<Bloque> bloques = bloqueService.findAll();
		model.addAttribute("lista", bloques);
		Estante e = new Estante();
		e.setColumnas(2);
		e.setFilas(5);

		model.addAttribute("bloque",new Bloque());
		model.addAttribute("estante", e);

		return "espacios";
	}

	@PostMapping(value = "/espacios")
	public String registrarBloque(@Valid Bloque bloque, BindingResult result, Model model, RedirectAttributes flash) {		
		Bloque x = bloqueService.findByLetra(bloque.getLetra());
		if (x != null) {
			flash.addFlashAttribute("warning", "El bloque ya existe");
			return "redirect:/espacios";
		}

		bloqueService.save(bloque);
		flash.addFlashAttribute("success", "Bloque Registrado");
		return "redirect:/espacios";
	}

	@PostMapping(value = "/estantes")
	public String registrarEstantes(@RequestParam(value = "bloque2") Long id, @Valid Estante estante, BindingResult result, Model model, RedirectAttributes flash) {
		Bloque x = bloqueService.findById(id);
		Estante e = estanteService.findByNumero(estante.getNumero());
		if (e!=null) {
			flash.addFlashAttribute("warning", "El Estante numero: "+estante.getNumero()+" Ya existe!");
			return "redirect:/espacios";
			
		}
		flash.addFlashAttribute("success", "Estante Registrado con exito");
		estante.setBloque(x);
		estanteService.save(estante);
		estanteService.generar(estante);
		
		return "redirect:espacios";
	}
	
	@GetMapping(value = "/usuario")
	public String crearUsuario(Model model) {
		model.addAttribute("usuario",new Usuario());
		//model.addAttribute("rol",new Rol());
		return "regUsuario";
	}
	
	@PostMapping(value = "/regUsuario")
	public String regUsuario(@Valid Usuario usuario, @RequestParam(value = "roles") int rol, @RequestParam(value = "password2") String pass, Model model, RedirectAttributes flash) {

		Rol rolEdit = usuarioService.findRolById(usuario.getId());

		if(usuario.getPassword().equals(pass)) {
			usuario.setEnable(true);
		if (rol==1) {
			Rol roles = new Rol();
			String bcryptPassword = passwordEncoder.encode(usuario.getPassword());
			roles.setAuthority("ROLE_ADMIN");
			roles.setUsuario(usuario);
			usuario.setPassword(bcryptPassword);
			usuarioService.save(usuario);
			if (rolEdit!=null) {
				rolEdit.setAuthority("ROLE_ADMIN");
				usuarioService.saveRol(rolEdit);
				return "redirect:/listaUsuario";
				
			}
			usuarioService.saveRol(roles);
		
			flash.addFlashAttribute("success", "Usuario "+usuario.getUsername()+" Registrado - ROL:ADMIN");
			return "redirect:/listaUsuario";
			
		}else {
			Rol roles = new Rol();
			String bcryptPassword = passwordEncoder.encode(usuario.getPassword());
			roles.setAuthority("ROLE_USER");
			roles.setUsuario(usuario);
			usuario.setPassword(bcryptPassword);
			usuarioService.save(usuario);
			if (rolEdit!=null) {
				rolEdit.setAuthority("ROLE_USER");
				usuarioService.saveRol(rolEdit);
				return "redirect:/listaUsuario";
				
			}
			usuarioService.saveRol(roles);
			
			flash.addFlashAttribute("success", "Usuario "+usuario.getUsername()+" Registrado - ROL:USER");
			return "redirect:/listaUsuario";
		}
		}else {
			
			flash.addFlashAttribute("error", "Las Contraseñas no coinciden");
			return "redirect:/usuario";
			
		}
		
	
	}
	
	@GetMapping(value = "/listaUsuario")
	public String listarUsuarios(Model model) {
		List<Usuario> usuarios = usuarioService.findAll();
		model.addAttribute("usuarios", usuarios);
		System.out.println("prueba ------ Roles"+ usuarios.get(0).getRoles());
		
		return "listaUsuario";
	}
	
	@GetMapping(value = "/usuario/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
		Usuario u = usuarioService.findById(id);
		if (u==null) {
			flash.addFlashAttribute("warning", "El Usuario no existe en la Base de Datos");
			return "redirect:/listaUsuario";
			
		}
		model.addAttribute("usuario", u);
		return "regUsuario";
		
	}
	
	@GetMapping(value = "/eliminarUser/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
		Usuario u = usuarioService.findById(id);
		if (u==null) {
			flash.addFlashAttribute("warning", "El Usuario no existe en la Base de Datos");
			return "redirect:/listaUsuario";
			
		}
		flash.addFlashAttribute("success", "Usuario "+ u.getUsername()+" eliminado con exito");
		usuarioService.delete(id);
		return "redirect:/listaUsuario";
		
	}

}
