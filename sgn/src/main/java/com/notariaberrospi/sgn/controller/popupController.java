package com.notariaberrospi.sgn.controller;

import java.util.HashMap;
import java.util.Map;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class popupController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	Map<String, Object> options = new HashMap<String, Object>();
	
	public void popupListaEmpresa() {
		logger.info("popupListaEmpresa");
		options.put("draggable", false);
		options.put("contentHeight", 320);
        RequestContext.getCurrentInstance().openDialog("popupListaEmpresa", options, null);
    }
	
	public void popupListaPersona() {
		logger.info("popupListaPersona");
		options.put("draggable", false);
		options.put("contentHeight", 320);
        RequestContext.getCurrentInstance().openDialog("popupListaPersona", options, null);
    }
	
	
	

}
