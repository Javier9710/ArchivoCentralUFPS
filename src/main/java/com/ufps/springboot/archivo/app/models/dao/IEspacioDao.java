package com.ufps.springboot.archivo.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Espacio;

public interface IEspacioDao extends CrudRepository<Espacio, Long> {
	

}
