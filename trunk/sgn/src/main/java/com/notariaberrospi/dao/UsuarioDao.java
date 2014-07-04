package com.notariaberrospi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.entity.Usuario;
import com.notariaberrospi.util.HibernateBaseDao;

@Repository
public class UsuarioDao {
	
	@Autowired
	private HibernateBaseDao hibernateBaseDao;
	
	public void grabar(Usuario usuario){
		hibernateBaseDao.grabar(usuario);
	}
	
	public void modificar(Usuario usuario){
		hibernateBaseDao.modificar(usuario);
	}
	
	public void eliminar(Usuario usuario){
		hibernateBaseDao.eliminar(usuario);
	}
	
	public Usuario buscar(String query, Object... parametros){
		return hibernateBaseDao.buscar(query,parametros);
	}

}
