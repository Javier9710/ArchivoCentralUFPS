package com.ufps.springboot.archivo.app.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "cajas")
public class Caja implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String dependencia;
	private String codigo1;
	private String serie;
	private String codigo2;
	private String subserie;
	private String codigo3;
	private String Ncaja;
	private String Nlegajos;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaDesde;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaHasta;
	private String retencion;
	private String observaciones;
	private int expediente;
	
	//private String tipoCaja;
	
	private Double tamanio;
	
	
	@ManyToOne
	@JoinColumn(name = "posicion")
	private Posicion posicion;
	
	/*
	@OneToOne
	@JoinColumn(name = "posicion")
	private Posicion posicion; */
	
	@ManyToOne
	@JoinColumn(name = "dependenciaObject")
	private Dependencia dependenciaObject;
	
	//--------------------------------------------------
	
	public Caja() {
		
		
	}

	public Dependencia getDependenciaObject() {
		return dependenciaObject;
	}

	public void setDependenciaObject(Dependencia dependenciaObject) {
		this.dependenciaObject = dependenciaObject;
	}

	public Caja(Long id, String dependencia, String codigo1, String serie, String codigo2, String subserie,
			String codigo3, String ncaja, String nlegajos, Date fechaDesde, Date fechaHasta, String retencion,
			String observaciones, int expediente, String tipoCaja, Posicion posicion, Dependencia dependenciaObject,
			Double tamanio) {
		this.id = id;
		this.dependencia = dependencia;
		this.codigo1 = codigo1;
		this.serie = serie;
		this.codigo2 = codigo2;
		this.subserie = subserie;
		this.codigo3 = codigo3;
		this.Ncaja = ncaja;
		this.Nlegajos = nlegajos;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.retencion = retencion;
		this.observaciones = observaciones;
		this.expediente = expediente;
		//this.tipoCaja = tipoCaja;
		this.posicion = posicion;
		this.dependenciaObject = dependenciaObject;
		this.tamanio = tamanio;
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


	public String getCodigo1() {
		return codigo1;
	}


	public void setCodigo1(String codigo1) {
		this.codigo1 = codigo1;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public String getCodigo2() {
		return codigo2;
	}


	public void setCodigo2(String codigo2) {
		this.codigo2 = codigo2;
	}


	public String getSubserie() {
		return subserie;
	}


	public void setSubserie(String subserie) {
		this.subserie = subserie;
	}


	public String getCodigo3() {
		return codigo3;
	}


	public void setCodigo3(String codigo3) {
		this.codigo3 = codigo3;
	}


	public String getNcaja() {
		return Ncaja;
	}


	public void setNcaja(String ncaja) {
		Ncaja = ncaja;
	}


	public String getNlegajos() {
		return Nlegajos;
	}


	public void setNlegajos(String nlegajos) {
		Nlegajos = nlegajos;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public Date getFechaHasta() {
		return fechaHasta;
	}


	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	public String getRetencion() {
		return retencion;
	}


	public void setRetencion(String retencion) {
		this.retencion = retencion;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Posicion getPosicion() {
		return posicion;
	}


	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getExpediente() {
		return expediente;
	}


	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}


/*	public String getTipoCaja() {
		return tipoCaja;
	}


	public void setTipoCaja(String tipoCaja) {
		this.tipoCaja = tipoCaja;
	}
*/
	public Double getTamanio() {
		return tamanio;
	}

	public void setTamanio(Double tamanio) {
		this.tamanio = tamanio;
	}
	
	
	
	
	
	

}
