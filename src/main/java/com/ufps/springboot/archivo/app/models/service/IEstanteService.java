package com.ufps.springboot.archivo.app.models.service;

import java.util.List;


//import java.util.List;

import com.ufps.springboot.archivo.app.models.entities.Estante;
import com.ufps.springboot.archivo.app.models.entities.Posicion;

public interface IEstanteService {
	
	public void save(Estante estante);
	
	public Estante findById(Long Id);
	
	public List<Estante> findAll();
	
	public Estante findByNumero(String numero);
	
	//----------------------------------------------------
	
	public void savePosicion(Posicion posicion);
	
	//----------------------------------------------------
	
	
	
	
	

}
