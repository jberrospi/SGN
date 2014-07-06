package com.notariaberrospi.sgn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.EmpresaDao;
import com.notariaberrospi.sgn.entity.Empresa;

@Service
public class EmpresaService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass()
			.getName());

	@Autowired
	private EmpresaDao empresaDAO;

	public void grabar(Empresa empresa) {
		logger.debug("");
		empresaDAO.grabar(empresa);
	}

	public void modificar(Empresa empresa) {
		logger.debug("");
		empresaDAO.modificar(empresa);
	}



	public List<Empresa> buscarEmpresas(Empresa empresa){
		logger.debug("");
		String query="From Empresa ";
		
		if (empresa!=null) {
			if (empresa.getRuc()!=null && empresa.getRazsocial()!=null) {
				query="WHERE ruc="+empresa.getRuc()+" and razonsocial like %"+empresa.getRazsocial()+"%";
			} else if (empresa.getRuc()!=null){
				query="WHERE ruc="+empresa.getRuc();
			}else if(empresa.getRazsocial()!=null){
				query="WHERE razonsocial like %"+empresa.getRazsocial()+"%";
			}
			
			
		}
		return empresaDAO.buscarLista(query);
	}

}
