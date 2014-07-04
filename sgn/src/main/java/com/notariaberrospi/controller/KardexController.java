package com.notariaberrospi.controller;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.entity.Kardex;
import com.notariaberrospi.service.ServiceFactory;
import com.notariaberrospi.util.FacesUtils;

@Controller
@Scope("request")
public class KardexController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private FacesContext facesContext;
		
	private Kardex kardex;
	
	private Long acto;
	
	private Long responsable;

	private Long idabogado;

	public KardexController() {
		logger.debug("");
		facesContext = FacesUtils.getCurrentInstance();
		kardex = new Kardex();
	}
	
	
	public void registrar() {
		boolean indicador = false;
		if(kardex.getIdkardex()!= null){
			logger.debug("Registrar Persona");
			serviceFactory.getKardexService().grabar(kardex);
			
		}else{
			logger.debug("Modificar Kardex");
			serviceFactory.getKardexService().modificar(kardex);
		}
		

	}
	public Kardex getKardex() {
		return kardex;
	}

	public void setKardex(Kardex kardex) {
		this.kardex = kardex;
	}


	public Long getActo() {
		return acto;
	}


	public void setActo(Long acto) {
		this.acto = acto;
	}


	public Long getResponsable() {
		return responsable;
	}


	public void setResponsable(Long responsable) {
		this.responsable = responsable;
	}


	public Long getIdabogado() {
		return idabogado;
	}


	public void setIdabogado(Long idabogado) {
		this.idabogado = idabogado;
	}

	

	

	

}
