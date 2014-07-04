package com.notariaberrospi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.dao.PersonaDAO;
import com.notariaberrospi.entity.Persona;

@Service
public class PersonaService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private PersonaDAO personaDAO;

	public void grabar(Persona persona) {
		logger.debug("");
		personaDAO.grabar(persona);
	}
	
	public void modificar(Persona persona){
		logger.debug("");
		personaDAO.modificar(persona);
	}
	
	public void eliminar(Persona persona){
		logger.debug("");
		personaDAO.eliminar(persona);
	}

	
}
