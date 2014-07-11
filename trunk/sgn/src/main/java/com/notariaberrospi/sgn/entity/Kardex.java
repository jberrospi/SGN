package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_kardex database table.
 * 
 */
@Entity
@Table(name="t_kardex")
public class Kardex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idkardex;

	private String escritura;

	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccierre;

    @Temporal( TemporalType.TIMESTAMP)
	private Date feccrea;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecescritura;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecfirmanot;

    //@Temporal( TemporalType.TIMESTAMP)
	private Date fecingreso;

    @Temporal( TemporalType.TIMESTAMP)
	private Date fecmodi;

	private String flagnocorre;

	private String flagpdt;

	private String flaguit;

	private String folio;

	private int foliofin;

	private int folioini;

	private String minuta;

	private int nrofojas;

	private String nrokardex;

	private String pc;

	private String protegido;

	private int registro;

	private int tomo;

	private String usucrea;

	private String usumodi;

	//bi-directional many-to-one association to DetKado
	@OneToMany(mappedBy="TKardex")
	private List<DetKado> TDetKados;

	//bi-directional many-to-one association to DetKaem
	@OneToMany(mappedBy="TKardex")
	private List<DetKaem> TDetKaems;

	//bi-directional many-to-one association to DetKapa
	@OneToMany(mappedBy="TKardex")
	private List<DetKapa> TDetKapas;

	//bi-directional many-to-one association to DetKate
	@OneToMany(mappedBy="TKardex")
	private List<DetKate> TDetKates;

	//bi-directional many-to-one association to Kape
	@OneToMany(mappedBy="TKardex")
	private List<Kape> TKapes;

	//bi-directional many-to-one association to Abogado
	@ManyToOne
	@JoinColumn(name="IDABOGADO")
	private Abogado TAbogado;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="RESPONSABLE")
	private Empleado TEmpleado1;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="DIGITADOR")
	private Empleado TEmpleado2;

	//bi-directional many-to-one association to Empleado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONFRONTADOR")
	private Empleado TEmpleado3;

	//bi-directional many-to-one association to Kaac
	@ManyToOne
	@JoinColumn(name="IDKAAC")
	private Kaac TKaac;

    public Kardex() {
    }

	public Long getIdkardex() {
		return this.idkardex;
	}

	public void setIdkardex(Long idkardex) {
		this.idkardex = idkardex;
	}

	public String getEscritura() {
		return this.escritura;
	}

	public void setEscritura(String escritura) {
		this.escritura = escritura;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFeccierre() {
		return this.feccierre;
	}

	public void setFeccierre(Date feccierre) {
		this.feccierre = feccierre;
	}

	public Date getFeccrea() {
		return this.feccrea;
	}

	public void setFeccrea(Date feccrea) {
		this.feccrea = feccrea;
	}

	public Date getFecescritura() {
		return this.fecescritura;
	}

	public void setFecescritura(Date fecescritura) {
		this.fecescritura = fecescritura;
	}

	public Date getFecfirmanot() {
		return this.fecfirmanot;
	}

	public void setFecfirmanot(Date fecfirmanot) {
		this.fecfirmanot = fecfirmanot;
	}

	public Date getFecingreso() {
		return this.fecingreso;
	}

	public void setFecingreso(Date fecingreso) {
		this.fecingreso = fecingreso;
	}

	public Date getFecmodi() {
		return this.fecmodi;
	}

	public void setFecmodi(Date fecmodi) {
		this.fecmodi = fecmodi;
	}

	public String getFlagnocorre() {
		return this.flagnocorre;
	}

	public void setFlagnocorre(String flagnocorre) {
		this.flagnocorre = flagnocorre;
	}

	public String getFlagpdt() {
		return this.flagpdt;
	}

	public void setFlagpdt(String flagpdt) {
		this.flagpdt = flagpdt;
	}

	public String getFlaguit() {
		return this.flaguit;
	}

	public void setFlaguit(String flaguit) {
		this.flaguit = flaguit;
	}

	public String getFolio() {
		return this.folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public int getFoliofin() {
		return this.foliofin;
	}

	public void setFoliofin(int foliofin) {
		this.foliofin = foliofin;
	}

	public int getFolioini() {
		return this.folioini;
	}

	public void setFolioini(int folioini) {
		this.folioini = folioini;
	}

	public String getMinuta() {
		return this.minuta;
	}

	public void setMinuta(String minuta) {
		this.minuta = minuta;
	}

	public int getNrofojas() {
		return this.nrofojas;
	}

	public void setNrofojas(int nrofojas) {
		this.nrofojas = nrofojas;
	}

	public String getNrokardex() {
		return this.nrokardex;
	}

	public void setNrokardex(String nrokardex) {
		this.nrokardex = nrokardex;
	}

	public String getPc() {
		return this.pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getProtegido() {
		return this.protegido;
	}

	public void setProtegido(String protegido) {
		this.protegido = protegido;
	}

	public int getRegistro() {
		return this.registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public int getTomo() {
		return this.tomo;
	}

	public void setTomo(int tomo) {
		this.tomo = tomo;
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

	public List<DetKado> getTDetKados() {
		return this.TDetKados;
	}

	public void setTDetKados(List<DetKado> TDetKados) {
		this.TDetKados = TDetKados;
	}
	
	public List<DetKaem> getTDetKaems() {
		return this.TDetKaems;
	}

	public void setTDetKaems(List<DetKaem> TDetKaems) {
		this.TDetKaems = TDetKaems;
	}
	
	public List<DetKapa> getTDetKapas() {
		return this.TDetKapas;
	}

	public void setTDetKapas(List<DetKapa> TDetKapas) {
		this.TDetKapas = TDetKapas;
	}
	
	public List<DetKate> getTDetKates() {
		return this.TDetKates;
	}

	public void setTDetKates(List<DetKate> TDetKates) {
		this.TDetKates = TDetKates;
	}
	
	public List<Kape> getTKapes() {
		return this.TKapes;
	}

	public void setTKapes(List<Kape> TKapes) {
		this.TKapes = TKapes;
	}
	
	public Abogado getTAbogado() {
		return this.TAbogado;
	}

	public void setTAbogado(Abogado TAbogado) {
		this.TAbogado = TAbogado;
	}
	
	public Empleado getTEmpleado1() {
		return this.TEmpleado1;
	}

	public void setTEmpleado1(Empleado TEmpleado1) {
		this.TEmpleado1 = TEmpleado1;
	}
	
	public Empleado getTEmpleado2() {
		return this.TEmpleado2;
	}

	public void setTEmpleado2(Empleado TEmpleado2) {
		this.TEmpleado2 = TEmpleado2;
	}
	
	public Empleado getTEmpleado3() {
		return this.TEmpleado3;
	}

	public void setTEmpleado3(Empleado TEmpleado3) {
		this.TEmpleado3 = TEmpleado3;
	}
	
	public Kaac getTKaac() {
		return this.TKaac;
	}

	public void setTKaac(Kaac TKaac) {
		this.TKaac = TKaac;
	}
	
}