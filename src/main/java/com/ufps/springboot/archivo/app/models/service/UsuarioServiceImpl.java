package com.ufps.springboot.archivo.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.archivo.app.models.dao.IRolDao;
import com.ufps.springboot.archivo.app.models.dao.IUsuarioDao;
import com.ufps.springboot.archivo.app.models.entities.Rol;
import com.ufps.springboot.archivo.app.models.entities.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IRolDao rolDao;
	
	@Override
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
		
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public void delete(Long id) {
		usuarioDao.deleteById(id);
		
	}

	@Override
	public List<Rol> findAllRol() {
		return (List<Rol>)rolDao.findAll();
	}

}
