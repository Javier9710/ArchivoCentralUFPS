package com.ufps.springboot.archivo.app.models.service;

import java.util.List;

import com.ufps.springboot.archivo.app.models.entities.Legajo;

public interface ILegajoService {
	
	public void save(Legajo legajo);
	
	public List<Legajo> findAll();
	
	public Legajo findById(Long id);
	
	

}
