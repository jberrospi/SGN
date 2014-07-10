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
import com.notariaberrospi.sgn.service.ServiceFactory;
import com.notariaberrospi.sgn.util.Constantes;

@Controller
@Scope("session")
public class EmpleadoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private List<Empleado> empleados;
	
	private List<Empleado> abogadosInternos;
	
	private Empleado empleado = new Empleado();

	@PostConstruct
	public void init(){
		logger.info("");
		abogadosInternos= serviceFactory.getEmpleadoService().buscarEmpleadoRol(Constantes.rolEmpleado.ID_ABOGADO);
		empleados= serviceFactory.getEmpleadoService().buscarLista();
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getAbogadosInternos() {
		return abogadosInternos;
	}

	public void setAbogadosInternos(List<Empleado> abogadosInternos) {
		this.abogadosInternos = abogadosInternos;
	}
	
}
