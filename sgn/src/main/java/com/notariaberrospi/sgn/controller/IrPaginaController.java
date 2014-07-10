package com.notariaberrospi.sgn.controller;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.util.Constantes;

@Controller
@SessionScoped
public class IrPaginaController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public String listaKardex() {
		return "/paginas/modulos/principal/listaKardex" + Constantes.REDIRECT_JSF;
	}
	
	public String mantKardex() {
		return "/paginas/modulos/principal/mantKardex" + Constantes.REDIRECT_JSF;
	}
	

}
