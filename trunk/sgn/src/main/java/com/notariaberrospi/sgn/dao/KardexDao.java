package com.notariaberrospi.sgn.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notariaberrospi.sgn.entity.Kardex;
import com.notariaberrospi.sgn.entity.Tabla;
import com.notariaberrospi.sgn.util.Constantes;
import com.notariaberrospi.sgn.util.HibernateBaseDao;

@Repository
public class KardexDao {

	@Autowired
	private HibernateBaseDao hibernateBaseDao;

	public TablaDAO tablaDao = new TablaDAO();

	public Tabla tabla;

	Date fecha;

	public void grabar(Kardex kardex) {
		fecha = new Date();
		System.out.println(fecha);
		kardex.setFeccrea(fecha);


		hibernateBaseDao.grabarOModificar(kardex);


	}

	public void modificar(Kardex kardex) {
		fecha = new Date();
		kardex.setFecmodi(fecha);
		hibernateBaseDao.modificar(kardex);
	}

	public void eliminar(Kardex kardex) {
		hibernateBaseDao.eliminar(kardex);
	}

	public Kardex buscarUltimoRegistrado(String query, Object... parametros) {
		Long id = hibernateBaseDao.buscar("select max(idkardex) from Kardex");
		return hibernateBaseDao.buscar(query, id);
	}

	public Kardex buscar(String query, Object... parametros) {

		return hibernateBaseDao.buscar(query, parametros);
	}

	public List<Kardex> buscarLista(String query) {
		return hibernateBaseDao.buscarLista(query);
	}
	
	public String buscarString(String query) {
		return hibernateBaseDao.buscar(query);
	}
}
