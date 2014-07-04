package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

	private int estadocivil;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecnac;

	private int nacionalidad;

	private int ocupacion;

	private String pc;

	private String prinom;

	private String ruc;

	private String segnom;

	private int sexo;

	private String usucrea;

	private String usumodi;

	//bi-directional many-to-one association to Abogado
	@OneToMany(mappedBy="TPersona")
	private List<Abogado> TAbogados;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="TPersona")
	private List<Empleado> TEmpleados;

	//bi-directional many-to-one association to Emrep
	@OneToMany(mappedBy="TPersona")
	private List<Emrep> TEmreps;

	//bi-directional many-to-one association to Kape
	@OneToMany(mappedBy="TPersona")
	private List<Kape> TKapes;

	//bi-directional many-to-one association to Perep
	@OneToMany(mappedBy="TPersona")
	private List<Perep> TPereps;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONYUGE")
	private Persona TPersona;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="TPersona")
	private List<Persona> TPersonas;

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

	public int getEstadocivil() {
		return this.estadocivil;
	}

	public void setEstadocivil(int estadocivil) {
		this.estadocivil = estadocivil;
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

	public int getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(int nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(int ocupacion) {
		this.ocupacion = ocupacion;
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

	public int getSexo() {
		return this.sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
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

	public List<Abogado> getTAbogados() {
		return this.TAbogados;
	}

	public void setTAbogados(List<Abogado> TAbogados) {
		this.TAbogados = TAbogados;
	}
	
	public List<Empleado> getTEmpleados() {
		return this.TEmpleados;
	}

	public void setTEmpleados(List<Empleado> TEmpleados) {
		this.TEmpleados = TEmpleados;
	}
	
	public List<Emrep> getTEmreps() {
		return this.TEmreps;
	}

	public void setTEmreps(List<Emrep> TEmreps) {
		this.TEmreps = TEmreps;
	}
	
	public List<Kape> getTKapes() {
		return this.TKapes;
	}

	public void setTKapes(List<Kape> TKapes) {
		this.TKapes = TKapes;
	}
	
	public List<Perep> getTPereps() {
		return this.TPereps;
	}

	public void setTPereps(List<Perep> TPereps) {
		this.TPereps = TPereps;
	}
	
	public Persona getTPersona() {
		return this.TPersona;
	}

	public void setTPersona(Persona TPersona) {
		this.TPersona = TPersona;
	}
	
	public List<Persona> getTPersonas() {
		return this.TPersonas;
	}

	public void setTPersonas(List<Persona> TPersonas) {
		this.TPersonas = TPersonas;
	}
	
}