package com.notariaberrospi.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.entity.Kardex;
import com.notariaberrospi.entity.Usuario;
import com.notariaberrospi.util.HibernateBaseDao;

@Repository
public class KardexDao {
	
	@Autowired
	private HibernateBaseDao hibernateBaseDao;
	
	Date fecha;
	
	public void grabar(Kardex kardex){
		fecha = new Date();
		System.out.println (fecha);
		kardex.setFeccrea(fecha);
		hibernateBaseDao.grabar(kardex);
	}
	
	public void modificar(Kardex kardex){
		fecha = new Date();
		kardex.setFecmodi(fecha);
		hibernateBaseDao.modificar(kardex);
	}
	
	public void eliminar(Kardex kardex){
		hibernateBaseDao.eliminar(kardex);
	}
	
	public Usuario buscar(String query, Object... parametros){
		return hibernateBaseDao.buscar(query,parametros);
	}

	
}
