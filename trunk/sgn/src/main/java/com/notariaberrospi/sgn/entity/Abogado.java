package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_abogado database table.
 * 
 */
@Entity
@Table(name="t_abogado")
public class Abogado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idabogado;

	private String colegiatura;

	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

	private String pc;

	private String usucrea;

	private String usumodi;

	private int zona;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPERSONA")
	private Persona TPersona;

	//bi-directional many-to-one association to Kardex
	@OneToMany(mappedBy="TAbogado")
	private List<Kardex> TKardexs;

    public Abogado() {
    }

	public Long getIdabogado() {
		return this.idabogado;
	}

	public void setIdabogado(Long idabogado) {
		this.idabogado = idabogado;
	}

	public String getColegiatura() {
		return this.colegiatura;
	}

	public void setColegiatura(String colegiatura) {
		this.colegiatura = colegiatura;
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

	public int getZona() {
		return this.zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public Persona getTPersona() {
		return this.TPersona;
	}

	public void setTPersona(Persona TPersona) {
		this.TPersona = TPersona;
	}
	
	public List<Kardex> getTKardexs() {
		return this.TKardexs;
	}

	public void setTKardexs(List<Kardex> TKardexs) {
		this.TKardexs = TKardexs;
	}
	
}