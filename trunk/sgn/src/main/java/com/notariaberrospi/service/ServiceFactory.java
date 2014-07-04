package com.notariaberrospi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.util.Properties;

@Service
public class ServiceFactory {

	@Autowired
	private Properties properties;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private MaestroService tablaService;
	
	@Autowired
	private KardexService kardexService;

	@Autowired
	private ActoService actoService;
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public MaestroService getTablaService() {
		return tablaService;
	}

	public void setTablaService(MaestroService tablaService) {
		this.tablaService = tablaService;
	}

	public KardexService getKardexService() {
		return kardexService;
	}

	public void setKardexService(KardexService kardexService) {
		this.kardexService = kardexService;
	}

	public ActoService getActoService() {
		return actoService;
	}

	public void setActoService(ActoService actoService) {
		this.actoService = actoService;
	}

	
}
