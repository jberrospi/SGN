package com.notariaberrospi.sgn.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.entity.Kaac;
import com.notariaberrospi.sgn.service.ServiceFactory;

@Controller
@Scope("session")
public class ActoController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private List<Kaac> actos;
	
	private Kaac acto = new Kaac();
	
	public ActoController() {
		logger.debug("");
	}
	
	@PostConstruct
	public void init(){
		actos = serviceFactory.getActoService().buscar();
	}

	public Kaac getActo() {
		return acto;
	}

	public void setActo(Kaac acto) {
		this.acto = acto;
	}

	public List<Kaac> getActos() {
		return actos;
	}

	public void setActos(List<Kaac> actos) {
		this.actos = actos;
	}

}
