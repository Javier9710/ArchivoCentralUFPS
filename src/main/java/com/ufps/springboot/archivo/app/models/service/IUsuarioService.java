package com.ufps.springboot.archivo.app.models.service;


import java.util.List;

import com.ufps.springboot.archivo.app.models.entities.Rol;
import com.ufps.springboot.archivo.app.models.entities.Usuario;

public interface IUsuarioService {
	
	
	public void save(Usuario usuario);
	
	public List<Usuario> findAll();
	
	public void delete(Long id);
	
	public List<Rol> findRolById(Long id);
	
	public void saveRol(Rol rol);


}
