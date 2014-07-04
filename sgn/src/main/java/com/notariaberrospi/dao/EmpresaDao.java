package com.notariaberrospi.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.entity.Empresa;
import com.notariaberrospi.entity.Usuario;
import com.notariaberrospi.util.HibernateBaseDao;

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
	
	public Usuario buscar(String query, Object... parametros){
		return hibernateBaseDao.buscar(query,parametros);
	}

	
}
