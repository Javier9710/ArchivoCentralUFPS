package com.ufps.springboot.archivo.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.archivo.app.models.dao.IDependenciaDao;
import com.ufps.springboot.archivo.app.models.entities.Dependencia;

@Service
public class DependenciaServiceImpl implements IDependenciaService {
	
	@Autowired
	private IDependenciaDao dependenciaDao;

	@Override
	public void save(Dependencia dependencia) {
		dependenciaDao.save(dependencia);
	}

	@Override
	public List<Dependencia> findAll() {
		return (List<Dependencia>) dependenciaDao.findAll();
	}

	@Override
	public Dependencia findById(Long id) {
		return dependenciaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		dependenciaDao.deleteById(id);
		
	}

	@Override
	public int cantidadDependencias() {
		return dependenciaDao.cantidadDependencias();
	}

}