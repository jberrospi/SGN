package com.notariaberrospi.sgn.controller;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.util.Constantes;

@Controller
@Scope("session")
public class IrPaginaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String listaKardex() {
		return "/paginas/modulos/principal/listaKardex" + Constantes.REDIRECT_JSF;
	}
	
	public String mantKardex() {
		return "/paginas/modulos/principal/mantKardex" + Constantes.REDIRECT_JSF;
	}
	

}
