package com.ufps.springboot.archivo.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Rol;

public interface IRolDao extends CrudRepository<Rol, Long> {

}
