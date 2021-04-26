package com.ufps.springboot.archivo.app.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cajas")
public class Caja implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String codigo;
	private String version;
	private String dependencia;
	private String codigo1;
	private String serie;
	private String codigo2;
	private String subserie;
	private String codigo3;
	private String Ncaja;
	private String Nlegajos;
	private String rangoFecha;
	private String retencion;
	private String observaciones;
	private int expediente;
	private String tipoCaja;
	private Espacio espacio;
	
	//--------------------------------------------------
	
	public Caja() {
		
		
	}


	public Caja(Long id, String codigo, String version, String dependencia, String codigo1, String serie,
			String codigo2, String subserie, String codigo3, String ncaja, String nlegajos, String rangoFecha,
			String retencion, String observaciones,int expediente, String tipoCaja, Espacio espacio) {
		this.id = id;
		this.codigo = codigo;
		this.version = version;
		this.dependencia = dependencia;
		this.codigo1 = codigo1;
		this.serie = serie;
		this.codigo2 = codigo2;
		this.subserie = subserie;
		this.codigo3 = codigo3;
		this.Ncaja = ncaja;
		this.Nlegajos = nlegajos;
		this.rangoFecha = rangoFecha;
		this.retencion = retencion;
		this.observaciones = observaciones;
		this.expediente = expediente;
		this.tipoCaja= tipoCaja;
		this.espacio = espacio;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
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


	public String getRangoFecha() {
		return rangoFecha;
	}


	public void setRangoFecha(String rangoFecha) {
		this.rangoFecha = rangoFecha;
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


	public Espacio getEspacio() {
		return espacio;
	}


	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
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


	public String getTipoCaja() {
		return tipoCaja;
	}


	public void setTipoCaja(String tipoCaja) {
		this.tipoCaja = tipoCaja;
	}
	
	
	
	
	

}
