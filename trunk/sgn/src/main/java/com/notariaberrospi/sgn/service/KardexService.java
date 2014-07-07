package com.notariaberrospi.sgn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.KardexDao;
import com.notariaberrospi.sgn.entity.Kardex;

@Service
public class KardexService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private KardexDao kardexDao;
	
	public void grabar(Kardex kardex) {
		logger.debug("");
		kardexDao.grabar(kardex);
	}

	public void modificar(Kardex kardex) {
		logger.debug("");
		kardexDao.modificar(kardex);
		
	}
	
	public Kardex buscar() {
		logger.debug("");
		return kardexDao.buscar("from Kardex where idKardex = ?");
	}
}
