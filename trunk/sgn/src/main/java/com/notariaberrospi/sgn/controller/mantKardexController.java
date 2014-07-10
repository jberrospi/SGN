package com.notariaberrospi.sgn.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.entity.Empleado;
import com.notariaberrospi.sgn.entity.Kaac;
import com.notariaberrospi.sgn.entity.Kardex;
import com.notariaberrospi.sgn.entity.Tabla;
import com.notariaberrospi.sgn.service.ServiceFactory;
import com.notariaberrospi.sgn.util.Constantes;
import com.notariaberrospi.sgn.util.FacesUtils;

@Controller
@Scope("session")
public class mantKardexController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private ServiceFactory serviceFactory;
	
	@Autowired
	private IrPaginaController irPaginaController;

	private Kardex kardex;

	//@PostConstruct
	public void init() {
		logger.info("");
		
		if(kardex == null){
			logger.info("Registro");
			kardex = new Kardex();
		}
		else{
			logger.info("Modificacion id= " + kardex.getIdkardex());
		}
		
		kardex.setTEmpleado1(new Empleado());
		kardex.setTKaac(new Kaac());
		//kardex.setTAbogado(new Abogado());
		kardex.setTEmpleado2(new Empleado());
		//kardex.setTEmpleado3(new Empleado());

		// obtener auto incremental kardex
		Tabla autoKardex = serviceFactory.getTablaService()
				.buscarAutoIncremental(Constantes.autoIncremental.ID_KARDEX);

		// obtener auto incremental escritura
		Tabla autoEscritura = serviceFactory.getTablaService()
				.buscarAutoIncremental(Constantes.autoIncremental.ID_ESCRITURA);

		// obtener auto incremental minuta
		Tabla autoMinuta = serviceFactory.getTablaService()
				.buscarAutoIncremental(Constantes.autoIncremental.ID_MINUTA);

		// Seteo los valores auto incrementales
		kardex.setNrokardex(autoKardex.getValor1() + "");
		kardex.setEscritura(autoEscritura.getValor1() + "");
		kardex.setMinuta(autoMinuta.getValor1() + "");

		// Obtener fecha del sistema
		Locale local = new Locale("es", "PE");
		TimeZone tz1 = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(tz1, local);
		kardex.setFecingreso(calendar.getInstance().getTime());
					
	}

	public String registrar() {

		if (kardex.getIdkardex() != null) {
			logger.debug("Registrar Persona");
			kardex.setIdkardex(null);
			serviceFactory.getKardexService().grabar(kardex);
			FacesUtils.keepMessages();
			FacesUtils.addMessageInfo("Se registro correctamente");
		} else {
			logger.debug("Modificar Kardex");
			serviceFactory.getKardexService().modificar(kardex);
			FacesUtils.keepMessages();
			FacesUtils.addMessageInfo("Se modifico correctamente");
		}

		return this.cargar(kardex.getIdkardex());
	}

	public String cargar(Long idKardex){
		logger.debug("idKardex = " + idKardex);
		kardex = serviceFactory.getKardexService().buscarPorId(idKardex);
		return irPaginaController.mantKardex();
	}
	
	public Kardex getKardex() {
		return kardex;
	}

	public void setKardex(Kardex kardex) {
		this.kardex = kardex;
	}


}
