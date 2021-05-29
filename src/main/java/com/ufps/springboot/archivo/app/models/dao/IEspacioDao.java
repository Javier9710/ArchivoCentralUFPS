package com.ufps.springboot.archivo.app.models.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Espacio;

public interface IEspacioDao extends CrudRepository<Espacio, Long> {
	
	@Query("select e from Espacio e where e.posicion.estante.id=?1")
	public List<Espacio> listEspacio(Long id);	

}
