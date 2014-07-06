package com.notariaberrospi.sgn.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_tabla database table.
 * 
 */
@Entity
@Table(name="t_tabla")
public class Tabla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String descripcion;

	private String estado;

	private Long idgrupo;

	private Long valor1;

    public Long getValor1() {
		return valor1;
	}

	public void setValor1(Long valor1) {
		this.valor1 = valor1;
	}

	public Tabla() {
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getIdgrupo() {
		return this.idgrupo;
	}

	public void setIdgrupo(Long idgrupo) {
		this.idgrupo = idgrupo;
	}

}