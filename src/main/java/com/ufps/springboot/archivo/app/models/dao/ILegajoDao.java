package com.ufps.springboot.archivo.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Legajo;

public interface ILegajoDao extends CrudRepository<Legajo, Long>{
	
	@Query("select L from Legajo L where L.caja.id=?1")
	public List<Legajo> findAllById(Long id);

}
