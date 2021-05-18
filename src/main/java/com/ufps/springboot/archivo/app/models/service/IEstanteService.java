package com.ufps.springboot.archivo.app.models.service;

import java.util.List;

import com.ufps.springboot.archivo.app.models.entities.Espacio;

//import java.util.List;

import com.ufps.springboot.archivo.app.models.entities.Estante;
import com.ufps.springboot.archivo.app.models.entities.Posicion;

public interface IEstanteService {
	
	public void save(Estante estante);
	
	public Estante findById(Long Id);
	
	public List<Estante> findAll();
	
	public void savePosicion(Posicion posicion);
	
	public void saveEspacio(Espacio espacio);
	
	public Estante findByNumero(String numero);
	
	

}
