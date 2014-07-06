package com.notariaberrospi.sgn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.EmpleadoDao;
import com.notariaberrospi.sgn.entity.Empleado;

@Service
public class EmpleadoService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private EmpleadoDao empleadoDAO;

	public void grabar(Empleado empleado) {
		logger.debug("");
		empleadoDAO.grabar(empleado);
	}
	
	public void modificar(Empleado empleado){
		logger.debug("");
		empleadoDAO.modificar(empleado);
	}

	public void buscar(Empleado empleado){
		logger.debug("");
		empleadoDAO.buscar("", "");
	}
	
	public List<Empleado> buscarEmpleadoRol(long rol){
		logger.debug("");
		return empleadoDAO.buscarLista("FROM Empleado WHERE rol=? ", rol);
	}

	public List<Empleado> buscarLista() {
		return empleadoDAO.buscarLista("FROM Empleado");
	}

	

	
}
