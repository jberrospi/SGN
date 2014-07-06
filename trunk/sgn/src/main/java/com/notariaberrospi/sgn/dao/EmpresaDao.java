package com.notariaberrospi.sgn.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.sgn.entity.Empresa;
import com.notariaberrospi.sgn.util.HibernateBaseDao;

@Repository
public class EmpresaDao {
	
	@Autowired
	private HibernateBaseDao hibernateBaseDao;
	
	Date fecha;
	
	public void grabar(Empresa empresa){
		fecha = new Date();
		System.out.println (fecha);
		empresa.setFeccrea(fecha);
		hibernateBaseDao.grabar(empresa);
	}
	
	public void modificar(Empresa empresa){
		fecha = new Date();
		empresa.setFecmodi(fecha);
		hibernateBaseDao.modificar(empresa);
	}
	
	public void eliminar(Empresa empresa){
		hibernateBaseDao.eliminar(empresa);
	}
	

	public Empresa buscar(String query, Object... parametros){
		return hibernateBaseDao.buscar(query,parametros);
	}

	public List<Empresa> buscarLista(String query, Object... parametros){
		return hibernateBaseDao.buscarLista(query,parametros);
	}

	
}
