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
@Table(name = "espacios")
public class Espacio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String columna;
	private String fila;
	private Boolean estado;
	@ManyToOne
	@JoinColumn(name = "posicion")
	private Posicion posicion;
	@ManyToOne
	@JoinColumn(name = "dependencia")
	private Dependencia dependencia;
	
	//------------------------------------------
	
	public Espacio() {
		
	}


	public Espacio(Long id, String columna, String fila, Boolean estado, Posicion posicion, Dependencia dependencia) {
		this.id = id;
		this.columna = columna;
		this.fila = fila;
		this.estado = estado;
		this.posicion = posicion;
		this.dependencia = dependencia;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getColumna() {
		return columna;
	}


	public void setColumna(String columna) {
		this.columna = columna;
	}


	public String getFila() {
		return fila;
	}


	public void setFila(String fila) {
		this.fila = fila;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public Posicion getPosicion() {
		return posicion;
	}


	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}


	public Dependencia getDependencia() {
		return dependencia;
	}


	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}
	
	
	
	

}
