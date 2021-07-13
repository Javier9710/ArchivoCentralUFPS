package com.ufps.springboot.archivo.app.models.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Posicion;

public interface IPosicionDao extends CrudRepository<Posicion, Long> {
	
	@Query("select p from Posicion p where p.estante.id=?1")
	public List<Posicion> findAllPosicion(Long id);
}
