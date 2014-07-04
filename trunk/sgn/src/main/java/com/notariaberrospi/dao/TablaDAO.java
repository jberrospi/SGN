package com.notariaberrospi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.entity.Tabla;
import com.notariaberrospi.util.HibernateBaseDao;

@Repository
public class TablaDAO {
	
	@Autowired
	private HibernateBaseDao hibernateBaseDao;
	
	public List<Tabla> buscar(String query, Object... parametros){
		return hibernateBaseDao.buscarLista(query, parametros);
	}

	
}
