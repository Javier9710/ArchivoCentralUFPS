package com.ufps.springboot.archivo.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Legajo;

public interface ILegajoDao extends CrudRepository<Legajo, Long>{

}
