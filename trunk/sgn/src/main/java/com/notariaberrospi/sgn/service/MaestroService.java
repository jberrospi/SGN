package com.notariaberrospi.sgn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.TablaDAO;
import com.notariaberrospi.sgn.entity.Tabla;
import com.notariaberrospi.sgn.util.Constantes;

@Service
public class MaestroService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass()
			.getName());

	@Autowired
	private TablaDAO tablaDAO;

	public List<Tabla> buscarPorGrupo(long idGrupo) {
		logger.info("idGrupo: " + idGrupo);
		return tablaDAO.buscarLista("from Tabla where idgrupo = ?", idGrupo);
	}

	public Tabla buscarAutoIncremental(long id) {
		logger.info("idG: " + id);
		return tablaDAO.buscar("from Tabla where id= ?", id);
		
		
	}
	
	public void modificarAutoincrementKardex() {

		Tabla tablaNumKardex = tablaDAO.buscar("from Tabla where id= ?", Constantes.autoIncremental.ID_KARDEX);

		Long numKardex = tablaNumKardex.getValor1() + 1;

		tablaNumKardex.setValor1(numKardex);
		tablaDAO.modificar(tablaNumKardex);

	}
	
	public void modificarAutoincrement1() {

		Tabla tablaNumEscritura = tablaDAO.buscar("from Tabla where id= ?", Constantes.autoIncremental.ID_ESCRITURA);
		Tabla tablaNumMinuta = tablaDAO.buscar("from Tabla where id= ?", Constantes.autoIncremental.ID_MINUTA);
		String numMinutakardex = null;

		Long numEscritura = tablaNumEscritura.getValor1() + 1;
		Long numMinuta = tablaNumMinuta.getValor1() + 1;

		// Obtener minuta de Kardex
		numMinutakardex = tablaDAO.buscarString("select max(minuta) from Kardex");

		// Actualiza los campos autoincrementados en 1

		if (!(tablaNumMinuta.getValor1().equals(numMinutakardex))) {

			tablaNumMinuta.setValor1(numMinuta);
			tablaDAO.modificar(tablaNumMinuta);
		}

		tablaNumEscritura.setValor1(numEscritura);
		tablaDAO.modificar(tablaNumEscritura);

	}
	
	
	//realiza el auto increment para los  3: kardex, minuta y escritura
	public void modificarAutoincrement() {

		// Obtener ultimos codigo de kardex escritura y minuta
		Tabla tablaNumKardex = tablaDAO.buscar("from Tabla where id= ?", Constantes.autoIncremental.ID_KARDEX);
		Tabla tablaNumEscritura = tablaDAO.buscar("from Tabla where id= ?", Constantes.autoIncremental.ID_ESCRITURA);
		Tabla tablaNumMinuta = tablaDAO.buscar("from Tabla where id= ?", Constantes.autoIncremental.ID_MINUTA);
		String numMinutakardex = null;

		// obtener los valores para incrementar en 1
		Long numKardex = tablaNumKardex.getValor1() + 1;
		Long numEscritura = tablaNumEscritura.getValor1() + 1;
		Long numMinuta = tablaNumMinuta.getValor1() + 1;

		// Obtener minuta de Kardex
		numMinutakardex = tablaDAO.buscarString("select max(minuta) from Kardex");

		// Actualiza los campos autoincrementados en 1

		if (!(tablaNumMinuta.getValor1().equals(numMinutakardex))) {

			tablaNumMinuta.setValor1(numMinuta);
			tablaDAO.modificar(tablaNumMinuta);
		}

		tablaNumKardex.setValor1(numKardex);
		tablaDAO.modificar(tablaNumKardex);

		tablaNumEscritura.setValor1(numEscritura);
		tablaDAO.modificar(tablaNumEscritura);

	}

}
