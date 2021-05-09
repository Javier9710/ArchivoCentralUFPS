package com.ufps.springboot.archivo.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Bloque;

public interface IBloqueDao extends CrudRepository<Bloque, Long> {
	
	//@Query("select b from Bloque b where b.letra=?1")
	public Bloque findByLetra(String letra);

}
