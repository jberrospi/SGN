package com.notariaberrospi.sgn.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Clase utilitaria para Archivos.
 * @author Jean Ramal Alvarez
 * @since 06 July 2014
 * @version 1.0
 *
 */

@Component
public class ArchivoUtil {
	
	private final Logger logger = LoggerFactory.getLogger(ArchivoUtil.class);
	
	@Autowired
	Propiedades propiedades;

	/**
	 * Permite Generar un documento word formato docx desde una plantilla.
	 * @param nombrePlantilla nombre de la plantilla.
	 * @param nombreDocumentoGenerado nombre del documento generado.
	 * @param parametros parametros para reemplezar el contenido de la plantilla.
	 * */
	public boolean generarDocxDesdePlantilla(String nombrePlantilla,
									  		 String nombreDocumentoGenerado, 
									  		 Map<String, String> parametros) {

		String rutaPlantilla = propiedades.RUTA_WORD_PLANTILLA + nombrePlantilla;
		String rutaDocumentoGenerado = propiedades.RUTA_WORD_GENERADO + nombreDocumentoGenerado;

		OutputStream out = null;
		boolean resultado = false;

		try {

			XWPFDocument doc = new XWPFDocument(new FileInputStream(rutaPlantilla));
			List<XWPFParagraph> xwpfParagraphs = doc.getParagraphs();
			for (XWPFParagraph xwpfParagraph : xwpfParagraphs) {
				List<XWPFRun> xwpfRuns = xwpfParagraph.getRuns();
				for (XWPFRun xwpfRun : xwpfRuns) {
					String xwpfRunText = xwpfRun.getText(xwpfRun.getTextPosition());
					for (Map.Entry<String, String> entry : parametros.entrySet()) {
						if (xwpfRunText != null && xwpfRunText.contains(entry.getKey())) {
							xwpfRunText = xwpfRunText.replace(entry.getKey(),entry.getValue());
						}
					}
					xwpfRun.setText(xwpfRunText, 0);
				}
			}

			out = new FileOutputStream(rutaDocumentoGenerado);
			doc.write(out);
			out.flush();
			resultado = true;
		} catch (FileNotFoundException e) {
			logger.error("Archivo no encontrado", e);
		} catch (IOException e) {
			logger.error("Error en archivo", e);
		} finally {
			IOUtils.closeQuietly(out);
		}
		return resultado;
	}

	/**
	 * Permite Generar un documento word formato doc desde una plantilla.
	 * @param nombrePlantilla nombre de la plantilla.
	 * @param nombreDocumentoGenerado nombre del documento generado.
	 * @param parametros parametros para reemplezar el contenido de la plantilla.
	 * */
	public boolean generarDocDesdePlantilla(String nombrePlantilla, 
											String nombreDocumentoGenerado, 
											Map<String, String> parametros) {

		String rutaPlantilla = propiedades.RUTA_WORD_PLANTILLA + nombrePlantilla;
		String rutaDocumentoGenerado = propiedades.RUTA_WORD_GENERADO + nombreDocumentoGenerado;
		
		OutputStream out = null;
		boolean resultado = false;

		try {

			HWPFDocument doc = new HWPFDocument(new FileInputStream(rutaPlantilla));
			Range rango = doc.getRange();

			for (Map.Entry<String, String> entry : parametros.entrySet()) {
				rango.replaceText(entry.getKey(), entry.getValue());
			}

			out = new FileOutputStream(rutaDocumentoGenerado);
			doc.write(out);
			out.flush();
			resultado = true;
		} catch (FileNotFoundException e) {
			logger.error("Archivo no encontrado", e);
		} catch (IOException e) {
			logger.error("Error en archivo", e);
		} finally {
			IOUtils.closeQuietly(out);
		}
		return resultado;
	}

}
