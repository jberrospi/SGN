package com.notariaberrospi.sgn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.bean.Busqueda;
import com.notariaberrospi.sgn.dao.PersonaDAO;
import com.notariaberrospi.sgn.entity.Persona;

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

	public List<Persona> buscarPersonas(Persona persona) {
		logger.debug("");
		String query="From Persona ";
		
		if (persona!=null) {
			if (persona.getDocidentidad()!=null && persona.getPrinom()!=null) {
				query="WHERE docidentidad="+persona.getDocidentidad()+" and prinom like %"+persona.getPrinom()+"%";
			} else if (persona.getRuc()!=null){
				query="WHERE docidentidad="+persona.getRuc();
			}else if(persona.getPrinom()!=null){
				query="WHERE prinom like %"+persona.getPrinom()+"%";
			}
			
			
		}
		return personaDAO.buscarLista(query);
		
	}

	public List<Persona> buscarPersonas(Busqueda busqueda) {
		logger.debug("");
		String query="From Persona ";
		
		/*if (busqueda!=null) {
			if (busqueda.getDocidentidad()!=null && busqueda.getNombreCompleto()!=null) {
				query="WHERE ="+busqueda.getDocidentidad()+" and prinom like %"+busqueda.getDocidentidad()+"%";
			} else if (busqueda.getDocidentidad()!=null){
				query="WHERE docidentidad="+busqueda.getRuc();
			}else if(busqueda.getFecFin()!=null){
				query="WHERE prinom like %"+busqueda.getFecFin()+"%";
			}
			
			
		}*/
		return personaDAO.buscarLista(query);
	}

	public List<Persona> buscarIntervinienteEmpresa(Long idEmpresa) {
	
		logger.debug("");
		String query="Select rep.TPersona From Emrep rep  where rep.TEmpresa.idempresa="+idEmpresa;
		
		
		return personaDAO.buscarLista(query);
	}

	
}
