package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_empresa database table.
 * 
 */
@Entity
@Table(name="t_empresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idempresa;

	private String direccion;

	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

	private String pc;

	private String razsocial;

	private String ruc;

	private String usucrea;

	private String usumodi;

	//bi-directional many-to-one association to Emrep
	@OneToMany(mappedBy="TEmpresa")
	private List<Emrep> TEmreps;

    public Empresa() {
    }

	public Long getIdempresa() {
		return this.idempresa;
	}

	public void setIdempresa(Long idempresa) {
		this.idempresa = idempresa;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getRazsocial() {
		return this.razsocial;
	}

	public void setRazsocial(String razsocial) {
		this.razsocial = razsocial;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
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

	public List<Emrep> getTEmreps() {
		return this.TEmreps;
	}

	public void setTEmreps(List<Emrep> TEmreps) {
		this.TEmreps = TEmreps;
	}
	
}