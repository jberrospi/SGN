package com.notariaberrospi.sgn.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.sgn.entity.DetKaem;
import com.notariaberrospi.sgn.util.HibernateBaseDao;

@Repository
public class IntervinienteEmpresaDao {
	
	@Autowired
	private HibernateBaseDao hibernateBaseDao;
	
	public void grabar(DetKaem detKaem){
		hibernateBaseDao.grabar(detKaem);
	}
	
	public void modificar(DetKaem detKaem){
		hibernateBaseDao.modificar(detKaem);
	}
	
	public void eliminar(DetKaem detKaem){
		hibernateBaseDao.eliminar(detKaem);
	}
	
	public List<DetKaem> buscar(String query, Object... parametros){
		return hibernateBaseDao.buscarLista(query, parametros);
	}

}
