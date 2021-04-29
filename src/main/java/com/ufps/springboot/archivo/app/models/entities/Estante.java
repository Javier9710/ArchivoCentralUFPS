package com.ufps.springboot.archivo.app.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estantes")
public class Estante implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private int columnas;
	private int filas;
	@ManyToOne
	@JoinColumn(name = "bloque")
	private Bloque bloque;
	
	//---------------------------------------------------------
	
	public Estante() {

	}
	
	public Estante(Long id, String numero, int columnas, int filas, Bloque bloque) {
		this.id = id;
		this.numero = numero;
		this.columnas = columnas;
		this.filas = filas;
		this.bloque = bloque;
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public Bloque getBloque() {
		return bloque;
	}

	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
