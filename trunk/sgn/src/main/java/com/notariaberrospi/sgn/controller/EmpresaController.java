package com.notariaberrospi.sgn.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.entity.Empleado;
import com.notariaberrospi.sgn.entity.Empresa;
import com.notariaberrospi.sgn.service.ServiceFactory;

@Controller
@Scope("session")
public class EmpresaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private List<Empresa> empresas;
	
	private Empresa empresa;
	
	private Empleado empleado = new Empleado();
	
	public EmpresaController() {
		logger.debug("");
	}
	
	@PostConstruct
	public void init(){
		logger.info("");
		empresas= serviceFactory.getEmpresaService().buscarEmpresas(empresa);
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}


	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}
