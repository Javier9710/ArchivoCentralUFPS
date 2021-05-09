package com.ufps.springboot.archivo.app.models.service;

import com.ufps.springboot.archivo.app.models.entities.Espacio;

//import java.util.List;

import com.ufps.springboot.archivo.app.models.entities.Estante;
import com.ufps.springboot.archivo.app.models.entities.Posicion;

public interface IEstanteService {
	
	public void save(Estante estante);
	
	//public Bloque findByLetra(String letra);
	
	//public List<Bloque> findAll();
	
	public void savePosicion(Posicion posicion);
	
	public void saveEspacio(Espacio espacio);
	
	

}
