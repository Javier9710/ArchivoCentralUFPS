package com.ufps.springboot.archivo.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.archivo.app.models.entities.Rol;

public interface IRolDao extends CrudRepository<Rol, Long> {
	
	@Query("select r from Rol r where r.usuario.id=?1")
	public Rol findRolById(Long username);

}
