package com.notariaberrospi.dao;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.entity.Persona;
import com.notariaberrospi.entity.Usuario;
import com.notariaberrospi.util.HibernateBaseDao;

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
	
	public Usuario buscar(String query, Object... parametros){
		return hibernateBaseDao.buscar(query,parametros);
	}

	
}
