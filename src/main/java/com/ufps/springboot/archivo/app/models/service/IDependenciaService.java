package com.ufps.springboot.archivo.app.models.service;

import java.util.List;

import com.ufps.springboot.archivo.app.models.entities.Dependencia;

public interface IDependenciaService {
	
	public void save(Dependencia dependencia);
	
	public List<Dependencia> findAll();
	
	public Dependencia findById(Long id);
	
	public void delete(Long id);
	
	public int cantidadDependencias();
	
	

}
