package com.notariaberrospi.sgn.service;

import java.util.List;

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
		return kardexDao.buscarUltimoRegistrado("from Kardex where idKardex = ?");
	}

	public Kardex buscarPorId(Long idKardex) {

		return kardexDao.buscar("from Kardex where idKardex = ?",idKardex);	
	}
	
	public List<Kardex> buscarLista(Kardex kardex){
		logger.debug("");
		String query="From Kardex ";
		
		if (kardex!=null) {
			if (kardex.getIdkardex()!=null && kardex.getFecingreso()!=null && kardex.getFeccierre()!=null) {
				query="WHERE idkardex="+kardex.getIdkardex()+" and fecingreso beetwen "+kardex.getFecingreso()+" and "+kardex.getFeccierre();
			} else if (kardex.getIdkardex()!=null && kardex.getFecingreso()!=null){
				query="WHERE idkardex="+kardex.getIdkardex()+" and fecingreso ="+kardex.getFecingreso();
			}else if(kardex.getFecingreso()!=null && kardex.getFeccierre()!=null){
				query="WHERE fecingreso ="+kardex.getFecingreso()+" and "+kardex.getFeccierre();
			}else if (kardex.getIdkardex()!=null && kardex.getFecingreso()!=null){
				query="WHERE idkardex="+kardex.getIdkardex()+" and fecingreso ="+kardex.getFecingreso();
			
			
		}
		

		}
		return kardexDao.buscarLista(query);
	}
}
	

