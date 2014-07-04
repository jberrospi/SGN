package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_det_kaem database table.
 * 
 */
@Entity
@Table(name="t_det_kaem")
public class DetKaem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idkaem;

	private int condicion;

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

	//bi-directional many-to-one association to Emrep
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDEMREP")
	private Emrep TEmrep;

	//bi-directional many-to-one association to Kardex
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDKARDEX")
	private Kardex TKardex;

    public DetKaem() {
    }

	public Long getIdkaem() {
		return this.idkaem;
	}

	public void setIdkaem(Long idkaem) {
		this.idkaem = idkaem;
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

	public Emrep getTEmrep() {
		return this.TEmrep;
	}

	public void setTEmrep(Emrep TEmrep) {
		this.TEmrep = TEmrep;
	}
	
	public Kardex getTKardex() {
		return this.TKardex;
	}

	public void setTKardex(Kardex TKardex) {
		this.TKardex = TKardex;
	}
	
}