package com.notariaberrospi.controller;

import java.util.List;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.entity.Kaac;
import com.notariaberrospi.service.ServiceFactory;
import com.notariaberrospi.util.FacesUtils;

@Controller
@Scope("request")
public class ActoController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private FacesContext facesContext;
	
	private List<Kaac> actos;
	
	private Kaac acto;
	
	public ActoController() {
		logger.debug("");
		facesContext = FacesUtils.getCurrentInstance();
		actos = serviceFactory.getActoService().buscar();
		acto = new Kaac();
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
