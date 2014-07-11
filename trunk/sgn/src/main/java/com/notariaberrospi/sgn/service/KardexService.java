package com.notariaberrospi.sgn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.KardexDao;
import com.notariaberrospi.sgn.entity.Kardex;
import com.notariaberrospi.sgn.util.Constantes;

@Service
public class KardexService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass()
			.getName());

	@Autowired
	private KardexDao kardexDao;

	@Autowired
	private ServiceFactory serviceFactory;

	public void grabar(Kardex kardex) {
		logger.debug("");
		// Obtener ultimos codigo de kardex escritura y minuta
		Long numKardex = serviceFactory.getTablaService()
				.buscarAutoIncremental(Constantes.autoIncremental.ID_KARDEX)
				.getValor1();
		/*
		 * Long numEscritura =
		 * serviceFactory.getTablaService().buscarAutoIncremental
		 * (Constantes.autoIncremental.ID_ESCRITURA).getValor1(); Long numMinuta
		 * = null;
		 * 
		 * // si la minuta es SM es sin minuta if
		 * (!(("SM").equals(kardex.getMinuta()))) {
		 * 
		 * numMinuta
		 * =serviceFactory.getTablaService().buscarAutoIncremental(Constantes
		 * .autoIncremental.ID_MINUTA).getValor1();
		 * kardex.setEscritura(numMinuta.toString()); }
		 * 
		 * kardex.setEscritura(numEscritura.toString());
		 */
		kardex.setNrokardex(numKardex.toString());
		kardexDao.grabar(kardex);
		// serviceFactory.getTablaService().modificarAutoincrement();
		serviceFactory.getTablaService().modificarAutoincrementKardex();

	}

	public String buscarString(String query) {
		logger.debug("");
		return kardexDao.buscarString(query);
	}

	public void modificar(Kardex kardex) {

		// solo deberia autoincrementar escritura y minuta la primera
		// modificación

		String escritura = buscarString("SELECT escritura FROM Kardex WHERE idkardex="+ kardex.getIdkardex() + "");

		if (escritura == null || "0".equals(escritura)) {

			logger.debug("");
			Long numEscritura = serviceFactory
					.getTablaService()
					.buscarAutoIncremental(
							Constantes.autoIncremental.ID_ESCRITURA)
					.getValor1();

			Long numMinuta = null;

			// si la minuta es SM es sin minuta
			if (!(("SM").equals(kardex.getMinuta()))) {

				numMinuta = serviceFactory
						.getTablaService()
						.buscarAutoIncremental(
								Constantes.autoIncremental.ID_MINUTA)
						.getValor1();

				kardex.setEscritura(numMinuta.toString());
			}

			kardex.setEscritura(numEscritura.toString());

		}

		kardexDao.modificar(kardex);

		// Solo autoincremento las variables en la primera modificación

		if (escritura == null || "0".equals(escritura)) {

			serviceFactory.getTablaService().modificarAutoincrement1();
		}
	}

	public Kardex buscar() {
		logger.debug("");
		return kardexDao
				.buscarUltimoRegistrado("from Kardex where idKardex = ?");
	}

	public Kardex buscarPorId(Long idKardex) {
		logger.debug("");
		return kardexDao.buscar("from Kardex where idKardex = ?", idKardex);
	}

	public List<Kardex> buscarLista(Kardex kardex) {
		logger.debug("");
		String query = "From Kardex ";

		if (kardex != null) {

			if (kardex.getIdkardex() != null && kardex.getFecingreso() != null
					&& kardex.getFeccierre() != null)
				query = "WHERE idkardex = " + kardex.getIdkardex()
						+ " and fecingreso beetwen " + kardex.getFecingreso()
						+ " and " + kardex.getFeccierre();

			else if (kardex.getIdkardex() != null
					&& kardex.getFecingreso() != null)
				query = "WHERE idkardex = " + kardex.getIdkardex()
						+ " and fecingreso = " + kardex.getFecingreso();

			else if (kardex.getFecingreso() != null
					&& kardex.getFeccierre() != null)
				query = "WHERE fecingreso beetwen " + kardex.getFecingreso()
						+ " and " + kardex.getFeccierre();

			else if (kardex.getIdkardex() != null
					&& kardex.getFecingreso() != null)
				query = "WHERE idkardex = " + kardex.getIdkardex()
						+ " and fecingreso =" + kardex.getFecingreso();
		}

		return kardexDao.buscarLista(query);
	}
}
