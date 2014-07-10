package com.notariaberrospi.sgn.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.entity.Kardex;
import com.notariaberrospi.sgn.service.ServiceFactory;

@Controller
@Scope("request")
public class ListaKardexController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;

	private List<Kardex> kardexs;

	@PostConstruct
	private void init() {
		logger.info("");
		kardexs= serviceFactory.getKardexService().buscarLista(null);
	}

	public List<Kardex> getKardexs() {
		return kardexs;
	}

	public void setKardexs(List<Kardex> kardes) {
		this.kardexs = kardes;
	}
}
