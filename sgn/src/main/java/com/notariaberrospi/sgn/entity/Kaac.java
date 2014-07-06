package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_kaac database table.
 * 
 */
@Entity
@Table(name="t_kaac")
public class Kaac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idkaac;

	private String acto;

	private int codpdt;

	private int coduif;

	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

	private String pc;

	private String usucrea;

	private String usumodi;


    public Kaac() {
    }

	public Long getIdkaac() {
		return this.idkaac;
	}

	public void setIdkaac(Long idkaac) {
		this.idkaac = idkaac;
	}

	public String getActo() {
		return this.acto;
	}

	public void setActo(String acto) {
		this.acto = acto;
	}

	public int getCodpdt() {
		return this.codpdt;
	}

	public void setCodpdt(int codpdt) {
		this.codpdt = codpdt;
	}

	public int getCoduif() {
		return this.coduif;
	}

	public void setCoduif(int coduif) {
		this.coduif = coduif;
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

	
}