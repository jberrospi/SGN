package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_kape database table.
 * 
 */
@Entity
@Table(name="t_kape")
public class Kape implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idkape;

	private int condicion;

	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecfirma;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

	private String participaconyuge;

	private String pc;

	private String usucrea;

	private String usumodi;

	//bi-directional many-to-one association to Kardex
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDKARDEX")
	private Kardex TKardex;

	//bi-directional many-to-one association to Perep
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPEREP")
	private Perep TPerep;



    public Kape() {
    }

	public Long getIdkape() {
		return this.idkape;
	}

	public void setIdkape(Long idkape) {
		this.idkape = idkape;
	}

	public int getCondicion() {
		return this.condicion;
	}

	public void setCondicion(int condicion) {
		this.condicion = condicion;
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

	public String getParticipaconyuge() {
		return this.participaconyuge;
	}

	public void setParticipaconyuge(String participaconyuge) {
		this.participaconyuge = participaconyuge;
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

	public Kardex getTKardex() {
		return this.TKardex;
	}

	public void setTKardex(Kardex TKardex) {
		this.TKardex = TKardex;
	}
	
	public Perep getTPerep() {
		return this.TPerep;
	}

	public void setTPerep(Perep TPerep) {
		this.TPerep = TPerep;
	}
	

	
}