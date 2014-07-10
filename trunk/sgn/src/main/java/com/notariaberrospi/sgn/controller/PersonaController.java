package com.notariaberrospi.sgn.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.entity.Persona;
import com.notariaberrospi.sgn.service.ServiceFactory;

@Controller
@Scope("request")
public class PersonaController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private ServiceFactory serviceFactory;

	private Persona persona;
	
	private List<Persona> personas;

	private String conyuge;

	public PersonaController() {
		logger.debug("");
		persona = new Persona();
	}

	@PostConstruct
	public void init(){
		logger.info("");
		personas= serviceFactory.getPersonaService().buscarPersonas(persona);
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

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	
}
