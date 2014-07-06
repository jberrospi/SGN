package com.notariaberrospi.sgn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.IntervinienteEmpresaDao;
import com.notariaberrospi.sgn.entity.DetKaem;

@Service
public class IntervinienteEmpresaService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private IntervinienteEmpresaDao intervinienteEmpresaDao;

	public void grabar(DetKaem detKaem) {
		logger.debug("");
		intervinienteEmpresaDao.grabar(detKaem);
	}
	
	public void modificar(DetKaem detKaem){
		logger.debug("");
		intervinienteEmpresaDao.modificar(detKaem);
	}
	
	public void eliminar(DetKaem detKaem){
		logger.debug("");
		intervinienteEmpresaDao.eliminar(detKaem);
	}

	public List<DetKaem> buscar(DetKaem detKaem) {
		logger.debug("");
		return intervinienteEmpresaDao.buscar("","");
	}

}
