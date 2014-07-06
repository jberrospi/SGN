package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the t_persona database table.
 * 
 */
@Entity
@Table(name="t_persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpersona;

	private String apemat;

	private String apepat;

	private String direccion;

	private String docidentidad;

	private String email;

	private String estado;

	private Long estadocivil;

	@Transient
	private String nombreCompleto;
	
    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecnac;

	private Long nacionalidad;

	private Long ocupacion;

	private String pc;

	private String prinom;

	private String ruc;

	private String segnom;

	private Long sexo;

	private String usucrea;

	private String usumodi;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONYUGE")
	private Persona TPersona;

    public Persona() {
    }

	public Long getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	public String getApemat() {
		return this.apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	public String getApepat() {
		return this.apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocidentidad() {
		return this.docidentidad;
	}

	public void setDocidentidad(String docidentidad) {
		this.docidentidad = docidentidad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFeccrea() {
		return this.feccrea;
	}

	public void setFeccrea(Date feccrea) {
		this.feccrea = feccrea;
	}

	public Date getFecmodi() {
		return this.fecmodi;
	}

	public void setFecmodi(Date fecmodi) {
		this.fecmodi = fecmodi;
	}

	public Date getFecnac() {
		return this.fecnac;
	}

	public void setFecnac(Date fecnac) {
		this.fecnac = fecnac;
	}

	public String getPc() {
		return this.pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getPrinom() {
		return this.prinom;
	}

	public void setPrinom(String prinom) {
		this.prinom = prinom;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getSegnom() {
		return this.segnom;
	}

	public void setSegnom(String segnom) {
		this.segnom = segnom;
	}


	public String getUsucrea() {
		return this.usucrea;
	}

	public void setUsucrea(String usucrea) {
		this.usucrea = usucrea;
	}

	public String getUsumodi() {
		return this.usumodi;
	}

	public void setUsumodi(String usumodi) {
		this.usumodi = usumodi;
	}


	public Persona getTPersona() {
		return this.TPersona;
	}

	public void setTPersona(Persona TPersona) {
		this.TPersona = TPersona;
	}

	public String getNombreCompleto() {
		return nombreCompleto=prinom+" "+segnom+" "+apepat+" "+apemat ;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Long getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(Long estadocivil) {
		this.estadocivil = estadocivil;
	}

	public Long getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Long nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Long getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Long ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Long getSexo() {
		return sexo;
	}

	public void setSexo(Long sexo) {
		this.sexo = sexo;
	}	
	
}