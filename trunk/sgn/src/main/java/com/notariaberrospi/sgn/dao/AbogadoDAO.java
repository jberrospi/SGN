package com.notariaberrospi.sgn.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.sgn.entity.Abogado;
import com.notariaberrospi.sgn.util.HibernateBaseDao;

@Repository
public class AbogadoDAO {
    
@Autowired
private HibernateBaseDao hibernateBaseDao;


public void grabar(Abogado abogado){

	abogado.setFeccrea(Calendar.getInstance().getTime());
	hibernateBaseDao.grabar(abogado);
}

public void modificar(Abogado abogado){
	
	abogado.setFecmodi(Calendar.getInstance().getTime());
	hibernateBaseDao.modificar(abogado);
}

public void eliminar(Abogado abogado){
	hibernateBaseDao.eliminar(abogado);
}

public List<Abogado> buscar(String query, Object... parametros){
	return hibernateBaseDao.buscarLista(query, parametros);
}
}
