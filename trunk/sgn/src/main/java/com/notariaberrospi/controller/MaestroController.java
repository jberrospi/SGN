package com.notariaberrospi.controller;

import java.util.List;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.entity.Tabla;
import com.notariaberrospi.service.ServiceFactory;
import com.notariaberrospi.util.FacesUtils;

@Controller
@Scope("request")
public class MaestroController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private FacesContext facesContext;
	
	private List<Tabla> listaTabla;
	
	private Tabla tabla;
	
	public MaestroController() {
		logger.debug("");
		facesContext = FacesUtils.getCurrentInstance();
		tabla = new Tabla();
	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}

	public List<Tabla> getListaTabla() {
		
		return serviceFactory.getTablaService().buscarPorGrupo(1);
	}

	
	
	

	

	

}
