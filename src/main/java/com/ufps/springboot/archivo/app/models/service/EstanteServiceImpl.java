package com.ufps.springboot.archivo.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.archivo.app.models.dao.IEspacioDao;
import com.ufps.springboot.archivo.app.models.dao.IEstanteDao;
import com.ufps.springboot.archivo.app.models.dao.IPosicionDao;
import com.ufps.springboot.archivo.app.models.entities.Espacio;
import com.ufps.springboot.archivo.app.models.entities.Estante;
import com.ufps.springboot.archivo.app.models.entities.Posicion;

@Service
public class EstanteServiceImpl implements IEstanteService {
	
	@Autowired
	private IEstanteDao EstanteDao;
	
	@Autowired
	private IPosicionDao posicionDao;
	
	@Autowired
	private IEspacioDao espacioDao;

	@Override
	public void save(Estante estante) {
		EstanteDao.save(estante);
		
	}

	@Override
	public void savePosicion(Posicion posicion) {
		posicionDao.save(posicion);
	}
	
	public void generar(Estante estante) {
		
		
		for (int i = 1; i <= estante.getColumnas(); i++) {
			for (int j = 1; j <= estante.getFilas(); j++) {
				Posicion posicion = new Posicion();
				posicion.setColumna(i);
				posicion.setFila(j);
				posicion.setEstante(estante);
				this.savePosicion(posicion);
				for (int k = 1; k <= 4; k++) {
					Espacio espacio = new Espacio(); 
					espacio.setEstado(null);
					espacio.setPosicion(posicion);
					espacio.setDependencia(null);
					this.saveEspacio(espacio);
					
					
				}
				
			}
		}
		

	}

	@Override
	public void saveEspacio(Espacio espacio) {
		espacioDao.save(espacio);
	}
	
	

}