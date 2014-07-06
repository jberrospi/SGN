package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_empleado database table.
 * 
 */
@Entity
@Table(name="t_empleado")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idempleado;

	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

	private String pc;

	private Long rol;

	private String usucrea;

	private String usumodi;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="IDPERSONA")
	private Persona TPersona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="IDUSUARIO")
	private Usuario TUsuario;

	//bi-directional many-to-one association to Kardex
	@OneToMany(mappedBy="TEmpleado1")
	private List<Kardex> TKardexs1;

	//bi-directional many-to-one association to Kardex
	@OneToMany(mappedBy="TEmpleado2")
	private List<Kardex> TKardexs2;

	//bi-directional many-to-one association to Kardex
	@OneToMany(mappedBy="TEmpleado3")
	private List<Kardex> TKardexs3;

    public Empleado() {
    }

	public Long getIdempleado() {
		return this.idempleado;
	}

	public void setIdempleado(Long idempleado) {
		this.idempleado = idempleado;
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

	public Long getRol() {
		return this.rol;
	}

	public void setRol(Long rol) {
		this.rol = rol;
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

	public Persona getTPersona() {
		return this.TPersona;
	}

	public void setTPersona(Persona TPersona) {
		this.TPersona = TPersona;
	}
	
	public Usuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(Usuario TUsuario) {
		this.TUsuario = TUsuario;
	}
	
	public List<Kardex> getTKardexs1() {
		return this.TKardexs1;
	}

	public void setTKardexs1(List<Kardex> TKardexs1) {
		this.TKardexs1 = TKardexs1;
	}
	
	public List<Kardex> getTKardexs2() {
		return this.TKardexs2;
	}

	public void setTKardexs2(List<Kardex> TKardexs2) {
		this.TKardexs2 = TKardexs2;
	}
	
	public List<Kardex> getTKardexs3() {
		return this.TKardexs3;
	}

	public void setTKardexs3(List<Kardex> TKardexs3) {
		this.TKardexs3 = TKardexs3;
	}
	
}