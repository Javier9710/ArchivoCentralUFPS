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
@Table(name = "legajos")
public class Legajo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dependencia;
	private String serie;
	private String subSerie;
	private String expediente;
	private String rangoFecha;
	private String Nlegajo;
	private String totalFoleos;
	@ManyToOne
	@JoinColumn(name = "caja")
	private Caja caja;
	
	//--------------------------------------------------
	
	public Legajo() {
		
	}

	public Legajo(Long id, String dependencia, String serie, String subSerie, String expediente, String rangoFecha,
			String nlegajo, String totalFoleos) {
		this.id = id;
		this.dependencia = dependencia;
		this.serie = serie;
		this.subSerie = subSerie;
		this.expediente = expediente;
		this.rangoFecha = rangoFecha;
		this.Nlegajo = nlegajo;
		this.totalFoleos = totalFoleos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSubSerie() {
		return subSerie;
	}

	public void setSubSerie(String subSerie) {
		this.subSerie = subSerie;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getRangoFecha() {
		return rangoFecha;
	}

	public void setRangoFecha(String rangoFecha) {
		this.rangoFecha = rangoFecha;
	}

	public String getNlegajo() {
		return Nlegajo;
	}

	public void setNlegajo(String nlegajo) {
		Nlegajo = nlegajo;
	}

	public String getTotalFoleos() {
		return totalFoleos;
	}

	public void setTotalFoleos(String totalFoleos) {
		this.totalFoleos = totalFoleos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

	
}
