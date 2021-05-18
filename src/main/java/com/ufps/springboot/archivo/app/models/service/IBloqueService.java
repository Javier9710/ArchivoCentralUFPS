package com.ufps.springboot.archivo.app.models.service;

import java.util.List;

import com.ufps.springboot.archivo.app.models.entities.Bloque;

public interface IBloqueService {
	
	public void save(Bloque bloque);
	
	public Bloque findByLetra(String letra);
	
	public List<Bloque> findAll();
	
	public Bloque findById(Long id);
	
	

}
