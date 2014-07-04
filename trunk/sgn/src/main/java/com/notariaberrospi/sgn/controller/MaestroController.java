package com.notariaberrospi.sgn.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.entity.Tabla;
import com.notariaberrospi.sgn.service.ServiceFactory;
import com.notariaberrospi.sgn.util.Constantes;

@Controller
@Scope("session")
public class MaestroController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private List<Tabla> estadosCiviles;
	
	private Tabla tabla = new Tabla();
	
	public MaestroController() {
		logger.debug("");
	}
	
	@PostConstruct
	public void init(){
		logger.info("");
		estadosCiviles = serviceFactory.getTablaService().buscarPorGrupo(Constantes.ID_GRUPO_ESTADO_CIVIL);
	}
	
	@PreDestroy
	public void destroy(){
		logger.info("");
	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}
	
	public List<Tabla> getEstadosCiviles() {
		return estadosCiviles;
	}
	
	public void setEstadosCiviles(List<Tabla> estadosCiviles) {
		this.estadosCiviles = estadosCiviles;
	}
}
