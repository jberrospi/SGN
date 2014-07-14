package com.notariaberrospi.sgn.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.bean.Busqueda;
import com.notariaberrospi.sgn.entity.Abogado;
import com.notariaberrospi.sgn.service.ServiceFactory;

@Controller
@Scope("request")
public class AbogadoController{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private List<Abogado> abogados;
	
	private Busqueda busqueda;
	
	@PostConstruct
	public void init(){
		logger.info("");
		busqueda = new Busqueda();
		abogados = serviceFactory.getAbogadoService().buscar();
	}

	public void agregarAbogadoMinuta(Long idAbogado){
		
		
		
	}
	
	public List<Abogado> getAbogados() {
		return abogados;
	}

	public void setAbogados(List<Abogado> abogados) {
		this.abogados = abogados;
	}

	public Busqueda getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(Busqueda busqueda) {
		this.busqueda = busqueda;
	}


}
