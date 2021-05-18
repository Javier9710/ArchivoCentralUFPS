package com.ufps.springboot.archivo.app.models.dao;


import org.springframework.data.repository.CrudRepository;


import com.ufps.springboot.archivo.app.models.entities.Estante;

public interface IEstanteDao extends CrudRepository<Estante, Long> {
	
	public Estante findByNumero(String numero);


}
