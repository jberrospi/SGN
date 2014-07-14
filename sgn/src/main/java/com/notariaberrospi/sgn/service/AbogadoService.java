package com.notariaberrospi.sgn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.AbogadoDAO;
import com.notariaberrospi.sgn.entity.Abogado;
import com.notariaberrospi.sgn.entity.Kaac;

@Service
public class AbogadoService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private AbogadoDAO abogadoDao;
	
	public List<Abogado> buscar(){
		return  abogadoDao.buscar("from Abogado");
	}
	
	public void grabar(Abogado abogado) {
		logger.debug("");
		abogadoDao.grabar(abogado);
	}

	public void modificar(Abogado abogado) {
		logger.debug("");
		abogadoDao.modificar(abogado);
		
	}	
}
