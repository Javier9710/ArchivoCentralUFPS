package com.ufps.springboot.archivo.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ufps.springboot.archivo.app.models.dao.ILegajoDao;
import com.ufps.springboot.archivo.app.models.entities.Legajo;

public class LegajoServiceImpl implements ILegajoService {
	
	@Autowired
	private ILegajoDao legajoDao;

	@Override
	public void save(Legajo legajo) {
		legajoDao.save(legajo);
	}

	@Override
	public List<Legajo> findAll() {
		return (List<Legajo>)legajoDao.findAll();
	}

	@Override
	public Legajo findById(Long id) {
		return legajoDao.findById(id).orElse(null);
	}

}
