package com.notariaberrospi.sgn.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.sgn.entity.Empleado;
import com.notariaberrospi.sgn.util.HibernateBaseDao;

@Repository
public class EmpleadoDao {
	
	@Autowired
	private HibernateBaseDao hibernateBaseDao;
	
	public void grabar(Empleado empleado){
		hibernateBaseDao.grabar(empleado);
	}
	
	public void modificar(Empleado empleado){
		hibernateBaseDao.modificar(empleado);
	}
	
	public void eliminar(Empleado empleado){
		hibernateBaseDao.eliminar(empleado);
	}
	
	public Empleado buscar(String query, Object... parametros){
		return hibernateBaseDao.buscar(query,parametros);
	}

	public List<Empleado> buscarLista(String query, Object... parametros){
		return hibernateBaseDao.buscarLista(query,parametros);
	}
}
