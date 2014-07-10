package com.notariaberrospi.sgn.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.sgn.entity.Tabla;
import com.notariaberrospi.sgn.util.HibernateBaseDao;

@Repository
public class TablaDAO {
	
	@Autowired
	private HibernateBaseDao hibernateBaseDao;

	
	public List<Tabla> buscarLista(String query, Object... parametros){
		return hibernateBaseDao.buscarLista(query, parametros);
	}
	
	public Tabla buscar(String query, Object... parametros){
		return hibernateBaseDao.buscar(query, parametros);
	}
	
	public void modificar(Tabla tabla){

		hibernateBaseDao.modificar(tabla);
	}
	
	public String buscarString(String query){
		return hibernateBaseDao.buscar(query);
	}
	
	
}
