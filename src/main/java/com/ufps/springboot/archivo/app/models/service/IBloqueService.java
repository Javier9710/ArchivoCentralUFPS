package com.ufps.springboot.archivo.app.models.service;

import com.ufps.springboot.archivo.app.models.entities.Bloque;

public interface IBloqueService {
	
	public void save(Bloque bloque);
	
	public Bloque findByLetra(String letra);
	
	

}
