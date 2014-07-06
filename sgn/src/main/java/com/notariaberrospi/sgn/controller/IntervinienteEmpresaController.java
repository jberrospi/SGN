package com.notariaberrospi.sgn.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.entity.DetKaem;
import com.notariaberrospi.sgn.entity.Tabla;
import com.notariaberrospi.sgn.service.ServiceFactory;
import com.notariaberrospi.sgn.util.Constantes;

@Controller
@Scope("session")
public class IntervinienteEmpresaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private List<DetKaem> intervinientes;
	
	private DetKaem interviniente = new DetKaem();
	
	public IntervinienteEmpresaController() {
		logger.debug("");
	}
	
	@PostConstruct
	public void init(){
		logger.info("");
		//intervinientes = serviceFactory.getTablaService().buscarPorGrupo(Constantes.ID_GRUPO_ESTADO_CIVIL);
	}
	
	@PreDestroy
	public void destroy(){
		logger.info("");
	}

	public List<DetKaem> getIntervinientes() {
		return intervinientes;
	}

	public void setIntervinientes(List<DetKaem> intervinientes) {
		this.intervinientes = intervinientes;
	}

	public DetKaem getInterviniente() {
		return interviniente;
	}

	public void setInterviniente(DetKaem interviniente) {
		this.interviniente = interviniente;
	}


	
	
}
