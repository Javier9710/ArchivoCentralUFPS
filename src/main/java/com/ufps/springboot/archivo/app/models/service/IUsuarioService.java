package com.ufps.springboot.archivo.app.models.service;


import java.util.List;

import com.ufps.springboot.archivo.app.models.entities.Rol;
import com.ufps.springboot.archivo.app.models.entities.Usuario;

public interface IUsuarioService {
	
	
	public void save(Usuario usuario);
	
	public List<Usuario> findAll();
	
	public void delete(Long id);
	
	public Usuario findById(Long id);
	
	//---------------------------------
	
	public List<Rol> findallRol();
	
	public void saveRol(Rol rol);
	
	public Rol findRolById(Long username);


}
