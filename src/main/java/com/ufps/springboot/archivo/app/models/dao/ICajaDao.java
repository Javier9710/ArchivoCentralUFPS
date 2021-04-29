package com.ufps.springboot.archivo.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Caja;

public interface ICajaDao extends CrudRepository<Caja, Long> {

}