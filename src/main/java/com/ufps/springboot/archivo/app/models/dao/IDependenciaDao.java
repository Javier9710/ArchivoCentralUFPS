package com.ufps.springboot.archivo.app.models.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Dependencia;

public interface IDependenciaDao extends CrudRepository<Dependencia, Long> {
	
	@Query("select count(d) from Dependencia d")
	public int cantidadDependencias();
	

}
