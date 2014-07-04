package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_det_kado database table.
 * 
 */
@Entity
@Table(name="t_det_kado")
public class DetKado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddetkado;

	private int descripcion;

	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

	private String flaglectura;

	private String flagprotegido;

	private String pc;

	private String ruta;

	private String usucrea;

	private String usumodi;

	//bi-directional many-to-one association to Kardex
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDKARDEX")
	private Kardex TKardex;

    public DetKado() {
    }

	public Long getIddetkado() {
		return this.iddetkado;
	}

	public void setIddetkado(Long iddetkado) {
		this.iddetkado = iddetkado;
	}

	public int getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
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

	public String getFlaglectura() {
		return this.flaglectura;
	}

	public void setFlaglectura(String flaglectura) {
		this.flaglectura = flaglectura;
	}

	public String getFlagprotegido() {
		return this.flagprotegido;
	}

	public void setFlagprotegido(String flagprotegido) {
		this.flagprotegido = flagprotegido;
	}

	public String getPc() {
		return this.pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
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