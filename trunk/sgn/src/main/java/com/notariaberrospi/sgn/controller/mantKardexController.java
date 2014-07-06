package com.notariaberrospi.sgn.controller;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.entity.Abogado;
import com.notariaberrospi.sgn.entity.Empleado;
import com.notariaberrospi.sgn.entity.Kardex;
import com.notariaberrospi.sgn.entity.Persona;
import com.notariaberrospi.sgn.entity.Tabla;
import com.notariaberrospi.sgn.service.ServiceFactory;
import com.notariaberrospi.sgn.util.Constantes;

@Controller
@Scope("request")
public class mantKardexController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass()
			.getName());

	@Autowired
	private ServiceFactory serviceFactory;

	private Kardex kardex;

	private Long acto;

	private Persona digitador;

	public mantKardexController() {
		logger.debug("");
		kardex = new Kardex();
		kardex.setTEmpleado1(new Empleado());
		kardex.setTAbogado(new Abogado());
		kardex.setTEmpleado2(new Empleado());
		kardex.setTEmpleado3(new Empleado());

		if (kardex.getIdkardex() != null) {

		} else {

		}

	}

	@PostConstruct
	public void init() {
		logger.info("");

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
		
		//Abogodaos internos
		
		
		
	}

	public void registrar() {
		boolean indicador = false;
		if (kardex.getIdkardex() != null) {
			logger.debug("Registrar Persona");
			serviceFactory.getKardexService().grabar(kardex);

		} else {
			logger.debug("Modificar Kardex");
			serviceFactory.getKardexService().modificar(kardex);
		}
	}

	public Kardex getKardex() {
		return kardex;
	}

	public void setKardex(Kardex kardex) {
		this.kardex = kardex;
	}

	public Long getActo() {
		return acto;
	}

	public void setActo(Long acto) {
		this.acto = acto;
	}

	public Persona getDigitador() {
		return digitador;
	}

	public void setDigitador(Persona digitador) {
		this.digitador = digitador;
	}

}
