package com.notariaberrospi.sgn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.IntervinientePersonaDao;
import com.notariaberrospi.sgn.entity.Kape;

@Service
public class IntervinientePersonaService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private IntervinientePersonaDao IntervinientePersonaDao;

	public void grabar(Kape kape) {
		logger.debug("");
		IntervinientePersonaDao.grabar(kape);
	}
	
	public void modificar(Kape kape){
		logger.debug("");
		IntervinientePersonaDao.modificar(kape);
	}
	
	public void eliminar(Kape kape){
		logger.debug("");
		IntervinientePersonaDao.eliminar(kape);
	}

	public List<Kape> buscar(Kape kape) {
		logger.debug("");
		return IntervinientePersonaDao.buscar("","");
	}

}
