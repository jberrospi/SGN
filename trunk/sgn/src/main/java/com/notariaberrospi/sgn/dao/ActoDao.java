package com.notariaberrospi.sgn.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.sgn.entity.Kaac;
import com.notariaberrospi.sgn.util.HibernateBaseDao;

@Repository
public class ActoDao {
	    
@Autowired
private HibernateBaseDao hibernateBaseDao;
	
	Date fecha;
	
	public void grabar(Kaac acto){
		fecha = new Date();
		System.out.println (fecha);
		acto.setFeccrea(fecha);
		hibernateBaseDao.grabar(acto);
	}
	
	public void modificar(Kaac acto){
		fecha = new Date();
		acto.setFecmodi(fecha);
		hibernateBaseDao.modificar(acto);
	}
	
	public void eliminar(Kaac acto){
		hibernateBaseDao.eliminar(acto);
	}
	
	public List<Kaac> buscar(String query, Object... parametros){
		return hibernateBaseDao.buscarLista(query, parametros);
	}
}
