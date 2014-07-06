package com.notariaberrospi.sgn.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.poi.util.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.util.ArchivoUtil;
import com.notariaberrospi.sgn.util.Propiedades;

@Controller
@Scope("request")
public class ArchivoController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private Propiedades propiedades;
	
	@Autowired
	private ArchivoUtil archivoUtil;

	private StreamedContent file;

	public ArchivoController() {
	}
	
	@PostConstruct
	public void init(){
		
		Map<String, String> parametros = new HashMap<String, String>();
		
		parametros.put("[INSTRUMENTO]", "CUATROCIENTOS TREINTA (430)");
		parametros.put("[N_KARDEX]", "35409");
		parametros.put("[N_MINUTA]", "371");
		parametros.put("[TIPO_PODER]", "PODER_ESPECIAL");
		
		parametros.put("[PODERDANTE_NOMBRE_COMPLETO]",	"EDUARDO ANTONIO DALLA PORTA Z��IGA");
		parametros.put("[APODERADO_NOMBRE_COMPLETO]", "ANA CECILIA ALBA�IL CIEZA");
		
		parametros.put("[DIA_TEXTO]", "DOCE (12)");
		parametros.put("[MES_TEXTO]", "FEBRERO");
		parametros.put("[A�O_TEXTO]", "DOS MIL CATORCE (2014)");
		
		parametros.put("[PODERDANTE_N_DNI]", "07262716");
		parametros.put("[PODERNANTE_NACIONALIDAD]", "PERUANO");
		parametros.put("[PODERDANDE_E_CIVIL_COMPLETO]", "CASADO CON JESSICA BERRIO JO");
		parametros.put("[PODERDANTE_DIRECCION]", "AVENIDA MARISCAL CASTILLA 489, URBANIZACI�N LAS MAGNOLIAS, DISTRITO DE SANTIAGO DE SURCO, PROVINCIA Y DEPARTAMENTO DE LIMA");
		parametros.put("[PODERDANTE_PROFESION]", "ADMINISTRADOR");
		parametros.put("[PODERDANDE_PROCEDENCIA]", "POR SU PROPIO DERECHO");
		parametros.put("[PODERDANDE_ABOGADO_NOMBRE_COMPLETO]", "RUBEN P. BERNABE CHAVEZ");
		parametros.put("[PODERDANTE_ABOGADO_REGIMEN]", "C.A.L.");
		parametros.put("[PODERDANTE_ABOGADO_N_REGIMEN]", "56501");
		
		
		InputStream stream = null;
		try {
			
			String nombrePlantilla = "plantilla_escritura.docx";
			String nombreGenerado = "generado.docx";
			
			boolean resultado = archivoUtil.generarDocxDesdePlantilla(nombrePlantilla, nombreGenerado, parametros);
			
			if(resultado){
				logger.info("Se genero correctamente el archivo");
				stream = new FileInputStream(propiedades.RUTA_WORD_GENERADO + nombreGenerado);
				file = new DefaultStreamedContent(stream, propiedades.MIME_TYPE_DOCX, nombreGenerado);
				logger.info("Se transformo correctamente el archivo");
			}

		} catch (FileNotFoundException e) {
			logger.error("");
		} 
//		finally{
//			if(stream != null)
//				try {
//					stream.close();
//				} catch (IOException e) {
//					logger.error("");
//				}
//			//IOUtils.closeQuietly(stream);
//		}
	}

	public StreamedContent getFile() {
		return file;
	}

}
