package com.notariaberrospi.sgn.bean;

import java.util.Date;

public class Busqueda {
	

	private Date fecInicio;
	
	private Date fecFin;
	
	private String nrokardex;
	
	private String razSocial;
	
	private String ruc;

	private String DocIdentidad;
	
	private String nombreCompleto;
	

	public Date getFecInicio() {
		return fecInicio;
	}

	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}

	public Date getFecFin() {
		return fecFin;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}

	public String getNrokardex() {
		return nrokardex;
	}

	public void setNrokardex(String nrokardex) {
		this.nrokardex = nrokardex;
	}

	public String getRazSocial() {
		return razSocial;
	}

	public void setRazSocial(String razSocial) {
		this.razSocial = razSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDocIdentidad() {
		return DocIdentidad;
	}

	public void setDocIdentidad(String docIdentidad) {
		DocIdentidad = docIdentidad;
	}

	
	
}
