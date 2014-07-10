package com.notariaberrospi.sgn.controller;

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
@Scope("request")
public class ActoController{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private List<Kaac> actos;
	
	private Kaac acto = new Kaac();
	
	@PostConstruct
	public void init(){
		logger.info("");
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
