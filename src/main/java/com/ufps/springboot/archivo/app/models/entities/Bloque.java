package com.ufps.springboot.archivo.app.models.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Bloques")
public class Bloque implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String letra;
	private String ubicacion;
	
	//----------------------------------------------------
	
	public Bloque() {
		
	}
	
	public Bloque(Long id, String letra, String ubicacion) {
		this.id = id;
		this.letra = letra;
		this.ubicacion = ubicacion;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}
