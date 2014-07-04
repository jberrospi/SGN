package com.notariaberrospi.sgn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.ActoDao;
import com.notariaberrospi.sgn.entity.Kaac;

@Service
public class ActoService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private ActoDao actoDao;
	
	public List<Kaac> buscar(){
		return  actoDao.buscar("from Kaac");
	}
	
	public void grabar(Kaac acto) {
		logger.debug("");
		actoDao.grabar(acto);
	}

	public void modificar(Kaac acto) {
		logger.debug("");
		actoDao.modificar(acto);
		
	}	
	
	

}
