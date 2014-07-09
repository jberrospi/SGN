package com.notariaberrospi.sgn.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.entity.Kardex;
import com.notariaberrospi.sgn.service.ServiceFactory;

@Controller
public class ListaKardexController {

	
	
	@Autowired
	private ServiceFactory serviceFactory;

	private List<Kardex> kardexs;

	@PostConstruct
	private void init() {

		kardexs= serviceFactory.getKardexService().buscarLista(null);

		
		
	}

	public List<Kardex> getKardexs() {
		return kardexs;
	}

	public void setKardexs(List<Kardex> kardes) {
		this.kardexs = kardes;
	}
}
