package com.ufps.springboot.archivo.app.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "posiciones")
public class Posicion implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private int columna;
	private int fila;
	@ManyToOne
	@JoinColumn(name = "estante")
	private Estante estante;
	
	/*
	@OneToOne(mappedBy = "posicion")
	@JoinColumn(name = "caja")
	private Caja caja;
	*/
	
	private Double estado;
	
	//---------------------------------------------------
	
	
	public Posicion() {
		
	}
	
	public Posicion(Long id, int columna, int fila, Estante estante, Double estado) {
		this.id = id;
		this.columna = columna;
		this.fila = fila;
		this.estante = estante;
		this.estado = estado;
	}
	
	@PrePersist
	public void init() {
		estado=4.0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public Estante getEstante() {
		return estante;
	}

	public void setEstante(Estante estante) {
		this.estante = estante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getEstado() {
		return estado;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
	

}
