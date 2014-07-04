package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_emrep database table.
 * 
 */
@Entity
@Table(name="t_emrep")
public class Emrep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idemrep;

	private String cargo;

	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

	private String pc;

	private String usucrea;

	private String usumodi;

	//bi-directional many-to-one association to DetKaem
	@OneToMany(mappedBy="TEmrep")
	private List<DetKaem> TDetKaems;

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDEMPRESA")
	private Empresa TEmpresa;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPERSONA")
	private Persona TPersona;

    public Emrep() {
    }

	public Long getIdemrep() {
		return this.idemrep;
	}

	public void setIdemrep(Long idemrep) {
		this.idemrep = idemrep;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public String getPc() {
		return this.pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
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

	public List<DetKaem> getTDetKaems() {
		return this.TDetKaems;
	}

	public void setTDetKaems(List<DetKaem> TDetKaems) {
		this.TDetKaems = TDetKaems;
	}
	
	public Empresa getTEmpresa() {
		return this.TEmpresa;
	}

	public void setTEmpresa(Empresa TEmpresa) {
		this.TEmpresa = TEmpresa;
	}
	
	public Persona getTPersona() {
		return this.TPersona;
	}

	public void setTPersona(Persona TPersona) {
		this.TPersona = TPersona;
	}
	
}