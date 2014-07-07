package com.notariaberrospi.sgn.controller;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class popupController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	public void popupListaEmpresa() {
		logger.info("popupListaEmpresa");
        RequestContext.getCurrentInstance().openDialog("popupListaEmpresa");
    }

}
