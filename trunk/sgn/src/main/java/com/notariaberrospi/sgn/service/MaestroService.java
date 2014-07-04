package com.notariaberrospi.sgn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.TablaDAO;
import com.notariaberrospi.sgn.entity.Tabla;

@Service
public class MaestroService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private TablaDAO tablaDAO;
	
	public List<Tabla> buscarPorGrupo(long idGrupo){
		logger.info("idGrupo: " + idGrupo);
		return tablaDAO.buscar("from Tabla where idgrupo = ?", idGrupo);
	}
	
	
	

}
