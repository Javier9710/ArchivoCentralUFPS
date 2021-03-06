package com.ufps.springboot.archivo.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Caja;

public interface ICajaDao extends CrudRepository<Caja, Long> {
	
	
	@Query("select count(c) from Caja c")
	public int cantidadCajas();
	
	@Query("select SUM(c.tamanio) from Caja c where c.posicion.id = ?1")
	public Double ocupado(Long id);

}
