package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_det_kate database table.
 * 
 */
@Entity
@Table(name="t_det_kate")
public class DetKate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddetkate;

	private String entregpers;

	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecha;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

	private String orden;

	private String pc;

	private String usucrea;

	private String usumodi;

	//bi-directional many-to-one association to Kardex
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDKARDEX")
	private Kardex TKardex;

    public DetKate() {
    }

	public Long getIddetkate() {
		return this.iddetkate;
	}

	public void setIddetkate(Long iddetkate) {
		this.iddetkate = iddetkate;
	}

	public String getEntregpers() {
		return this.entregpers;
	}

	public void setEntregpers(String entregpers) {
		this.entregpers = entregpers;
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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecmodi() {
		return this.fecmodi;
	}

	public void setFecmodi(Date fecmodi) {
		this.fecmodi = fecmodi;
	}

	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
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
	
}