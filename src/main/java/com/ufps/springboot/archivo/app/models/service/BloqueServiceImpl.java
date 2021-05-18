package com.ufps.springboot.archivo.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.archivo.app.models.dao.IBloqueDao;
import com.ufps.springboot.archivo.app.models.entities.Bloque;

@Service
public class BloqueServiceImpl implements IBloqueService {
	
	@Autowired
	private IBloqueDao bloqueDao;

	@Override
	public void save(Bloque bloque) {
		bloqueDao.save(bloque);
		
	}

	@Override
	public Bloque findByLetra(String letra) {
		return bloqueDao.findByLetra(letra);
	}

	@Override
	public List<Bloque> findAll() {
		return (List<Bloque>)bloqueDao.findAll();
	}

	@Override
	public Bloque findById(Long id) {
		return bloqueDao.findById(id).orElse(null);
	}

}
