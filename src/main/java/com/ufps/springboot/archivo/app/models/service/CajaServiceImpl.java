package com.ufps.springboot.archivo.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.archivo.app.models.dao.ICajaDao;
import com.ufps.springboot.archivo.app.models.dao.ILegajoDao;
import com.ufps.springboot.archivo.app.models.entities.Caja;
import com.ufps.springboot.archivo.app.models.entities.Legajo;

@Service
public class CajaServiceImpl implements ICajaService {
	
	@Autowired
	private ILegajoDao legajoDao;
	
	@Autowired
	private ICajaDao cajaDao;
	
	
	//-------------------------------------------

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
	
	public void generarLegajos(Caja caja, String nLegajos) {
		for (int i = 1; i <= Integer.parseInt(nLegajos); i++) {
			Legajo legajo = new Legajo();
			legajo.setCaja(caja);
			this.save(legajo);
		}
	}

	@Override
	public void saveCaja(Caja caja) {
		cajaDao.save(caja);
	}

}
