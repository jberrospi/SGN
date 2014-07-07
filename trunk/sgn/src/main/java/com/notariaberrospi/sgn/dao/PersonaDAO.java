package com.notariaberrospi.sgn.dao;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.sgn.entity.Persona;
import com.notariaberrospi.sgn.util.HibernateBaseDao;

@Repository
public class PersonaDAO {
	
	@Autowired
	private HibernateBaseDao hibernateBaseDao;
	
	Date fecha;
	
	public void grabar(Persona persona){
		fecha = new Date();
		System.out.println (fecha);
		persona.setFeccrea(fecha);
		hibernateBaseDao.grabar(persona);
	}
	
	public void modificar(Persona persona){
		fecha = new Date();
		persona.setFecmodi(fecha);
		hibernateBaseDao.modificar(persona);
	}
	
	public void eliminar(Persona persona){
		hibernateBaseDao.eliminar(persona);
	}
	
	public Persona buscar(String query, Object... parametros){
		return hibernateBaseDao.buscar(query,parametros);
	}

	public List<Persona> buscarLista(String query, Object... parametros){
		return hibernateBaseDao.buscarLista(query,parametros);
	}
}
