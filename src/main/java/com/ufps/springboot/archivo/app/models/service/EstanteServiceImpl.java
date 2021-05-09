package com.ufps.springboot.archivo.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.archivo.app.models.dao.IEstanteDao;
import com.ufps.springboot.archivo.app.models.entities.Estante;

@Service
public class EstanteServiceImpl implements IEstanteService {
	
	@Autowired
	private IEstanteDao EstanteDao;

	@Override
	public void save(Estante estante) {
		EstanteDao.save(estante);
		
	}

}
