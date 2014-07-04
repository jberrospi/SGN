package com.notariaberrospi.controller;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.entity.Persona;
import com.notariaberrospi.service.ServiceFactory;
import com.notariaberrospi.util.FacesUtils;

@Controller
@Scope("request")
public class PersonaController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private ServiceFactory serviceFactory;

	private FacesContext facesContext;
	

	private Persona persona;
	
	private String conyuge;

	public PersonaController() {
		logger.debug("");
		facesContext = FacesUtils.getCurrentInstance();
		persona = new Persona();

	}

	public Persona getPersona() {
		
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	

	public String getConyuge() {
		return conyuge;
	}

	public void setConyuge(String conyuge) {
		this.conyuge = conyuge;
	}

	public void registrar() {
		boolean indicador = false;
		if(persona.getIdpersona()!= null){
			logger.debug("Registrar Persona");
			serviceFactory.getPersonaService().grabar(persona);
			
		}else{
			logger.debug("Modificar Persona");
			serviceFactory.getPersonaService().modificar(persona);
		}
		

	}

}
