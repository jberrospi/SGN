package com.notariaberrospi.sgn.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_perep database table.
 * 
 */
@Entity
@Table(name="t_perep")
public class Perep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idperep;

	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecfirma;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

	private String partida;

	private String pc;

	private String usucrea;

	private String usumodi;

	private int zona;

	//bi-directional many-to-one association to Kape
	@OneToMany(mappedBy="TPerep")
	private List<Kape> TKapes;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPERSONA")
	private Persona TPersona;
	
	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDREPRESENTANTE")
	private Persona Representante;

	
	public Perep() {
    }

	public Long getIdperep() {
		return this.idperep;
	}

	public void setIdperep(Long idperep) {
		this.idperep = idperep;
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

	public Date getFecfirma() {
		return this.fecfirma;
	}

	public void setFecfirma(Date fecfirma) {
		this.fecfirma = fecfirma;
	}

	public Date getFecmodi() {
		return this.fecmodi;
	}

	public void setFecmodi(Date fecmodi) {
		this.fecmodi = fecmodi;
	}

	public String getPartida() {
		return this.partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
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

	public int getZona() {
		return this.zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public List<Kape> getTKapes() {
		return this.TKapes;
	}

	public void setTKapes(List<Kape> TKapes) {
		this.TKapes = TKapes;
	}
	
	public Persona getTPersona() {
		return this.TPersona;
	}

	public void setTPersona(Persona TPersona) {
		this.TPersona = TPersona;
	}

	public Persona getRepresentante() {
		return Representante;
	}

	public void setRepresentante(Persona representante) {
		Representante = representante;
	}
	
}