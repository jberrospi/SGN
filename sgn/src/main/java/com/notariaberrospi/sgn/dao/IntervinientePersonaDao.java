package com.notariaberrospi.sgn.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.sgn.entity.Kape;
import com.notariaberrospi.sgn.util.HibernateBaseDao;

@Repository
public class IntervinientePersonaDao {
	
	@Autowired
	private HibernateBaseDao hibernateBaseDao;
	
	public void grabar(Kape kape){
		hibernateBaseDao.grabar(kape);
	}
	
	public void modificar(Kape kape){
		hibernateBaseDao.modificar(kape);
	}
	
	public void eliminar(Kape kape){
		hibernateBaseDao.eliminar(kape);
	}
	
	public List<Kape> buscar(String query, Object... parametros){
		return hibernateBaseDao.buscarLista(query, parametros);
	}

}
