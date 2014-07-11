package com.notariaberrospi.sgn.controller;

import java.io.Serializable;

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
import com.notariaberrospi.sgn.util.FechaUtil;

@Controller
@Scope("session")
public class MantKardexController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private ServiceFactory serviceFactory;
	
	@Autowired
	private IrPaginaController irPaginaController;

	private Kardex kardex;
	
	private String titulo;

	public void init() {
		logger.info("");

		if(kardex == null || kardex.getIdkardex() == null){
			titulo = "Registrar";
			logger.info("Registrar");
			kardex = new Kardex();
			
			Tabla autoKardex = serviceFactory.getTablaService().buscarAutoIncremental(Constantes.autoIncremental.ID_KARDEX);
			//Tabla autoEscritura = serviceFactory.getTablaService().buscarAutoIncremental(Constantes.autoIncremental.ID_ESCRITURA);
			//Tabla autoMinuta = serviceFactory.getTablaService().buscarAutoIncremental(Constantes.autoIncremental.ID_MINUTA);

			kardex.setNrokardex(autoKardex.getValor1().toString());
			//kardex.setEscritura(autoEscritura.getValor1().toString());
			//kardex.setMinuta(autoMinuta.getValor1().toString());
			
			kardex.setTEmpleado1(new Empleado());
			kardex.setTKaac(new Kaac());
			//kardex.setTAbogado(new Abogado());
			//kardex.setTEmpleado2(new Empleado());

			kardex.setFecingreso(FechaUtil.getDate());
		}
		else{
			titulo = "Modificar";
			logger.info("Modificacion id= " + kardex.getIdkardex());
			
			if(kardex.getEscritura() == null || kardex.getEscritura().equals("")){
				Tabla autoEscritura = serviceFactory.getTablaService().buscarAutoIncremental(Constantes.autoIncremental.ID_ESCRITURA);
				kardex.setEscritura(autoEscritura.getValor1().toString());
			}
			if(kardex.getMinuta() == null || kardex.getMinuta().equals("")){
				Tabla autoMinuta = serviceFactory.getTablaService().buscarAutoIncremental(Constantes.autoIncremental.ID_MINUTA);
				kardex.setMinuta(autoMinuta.getValor1().toString());
			}
			
			//if(kardex.getTKaac()== null)
				//kardex.setTKaac(new Kaac());
				if(kardex.getTEmpleado2() == null)
				kardex.setTEmpleado2(new Empleado());
			//kardex.setTEmpleado3(new Empleado());
		}
		
	}

	public String registrarActualizar() {

		if (kardex.getIdkardex() == null || kardex.getIdkardex()==0) {
			logger.debug("Registrar Kardex");
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
	
	public void limpiar(){
		kardex = null;
	}
	
	public Kardex getKardex() {
		return kardex;
	}

	public void setKardex(Kardex kardex) {
		this.kardex = kardex;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
