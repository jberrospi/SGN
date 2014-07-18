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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Clase utilitaria para Archivos.
 * 
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
	 * Permite Generar un documento word formato doc desde una plantilla.
	 * @param nombrePlantilla nombre de la plantilla.
	 * @param nombreDocumentoGenerado nombre del documento generado.
	 * @param parametros parametros para reemplezar el contenido de la plantilla.
	 * */
	public boolean generarDocDesdePlantilla(String nombrePlantilla,
			String nombreDocumentoGenerado, Map<String, String> parametros) {

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

	/**
	 * Permite Generar un documento word formato docx desde una plantilla.
	 * 
	 * @param nombrePlantilla
	 *            nombre de la plantilla.
	 * @param nombreDocumentoGenerado
	 *            nombre del documento generado.
	 * @param parametros
	 *            parametros para reemplezar el contenido de la plantilla.
	 * */
	@Deprecated
	public boolean generarDocxDesdePlantilla_(String nombrePlantilla,
			String nombreDocumentoGenerado, Map<String, String> parametros) {

		String rutaPlantilla = propiedades.RUTA_WORD_PLANTILLA
				+ nombrePlantilla;
		String rutaDocumentoGenerado = propiedades.RUTA_WORD_GENERADO
				+ nombreDocumentoGenerado;

		OutputStream out = null;
		boolean resultado = false;

		try {

			XWPFDocument doc = new XWPFDocument(new FileInputStream(
					rutaPlantilla));
			List<XWPFParagraph> xwpfParagraphs = doc.getParagraphs();
			for (XWPFParagraph xwpfParagraph : xwpfParagraphs) {
				List<XWPFRun> xwpfRuns = xwpfParagraph.getRuns();
				for (XWPFRun xwpfRun : xwpfRuns) {
					String xwpfRunText = xwpfRun.getText(xwpfRun
							.getTextPosition());
					System.out.println(xwpfRunText);
					for (Map.Entry<String, String> entry : parametros
							.entrySet()) {
						if (xwpfRunText != null
								&& xwpfRunText.contains(entry.getKey())) {
							xwpfRunText = xwpfRunText.replace(entry.getKey(),
									entry.getValue());
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

	public boolean generarDocxDesdePlantilla(String nombrePlantilla,
											 String nombreDocumentoGenerado, 
											 Map<String, String> parametros) {

		String rutaPlantilla = propiedades.RUTA_WORD_PLANTILLA
				+ nombrePlantilla;
		String rutaDocumentoGenerado = propiedades.RUTA_WORD_GENERADO
				+ nombreDocumentoGenerado;

		OutputStream out = null;
		boolean resultado = false;

		try {
			XWPFDocument doc = new XWPFDocument(new FileInputStream(rutaPlantilla));
			List<XWPFParagraph> xwpfParagraphs = doc.getParagraphs();
			this.replaceElementInParagraphs(xwpfParagraphs, parametros);
			out = new FileOutputStream(rutaDocumentoGenerado);
			doc.write(out);
			out.flush();
			resultado = true;
		} catch (FileNotFoundException e) {
			logger.error("Archivo no encontrado", e);
		} catch (IOException e) {
			logger.error("Error en archivo", e);
		} 
		catch (Exception e) {
			logger.error("Error en archivo", e);
		} finally {
			IOUtils.closeQuietly(out);
		}

		return resultado;
	}

	private void replaceElementInParagraphs(List<XWPFParagraph> xwpfParagraphs,
            								Map<String, String> replacedMap) throws Exception{
     
		for(int i=0; i<xwpfParagraphs.size(); i++){
			
			XWPFParagraph xwpfParagraph = xwpfParagraphs.get(i);
            String casoEspecial = "";
            NodeList nodeListWR = xwpfParagraph.getCTP().getDomNode().getChildNodes();
            
            for(int t = 0; t < nodeListWR.getLength(); t++ ){
                   
            	Node nodeWR = nodeListWR.item(t);
                   
            	if(nodeWR != null){
                          
            		if(nodeWR.getNodeName().equals("w:r")){
                                
            			NodeList nodeList = nodeWR.getChildNodes();
            			Node nodeWT = null;

            			if(nodeList != null && nodeList.getLength() > 0){

            				for(int m=0; m<nodeList.getLength(); m++){

            					nodeWT = nodeList.item(m);

            					if(nodeWT.getNodeName().equals("w:t")){
            						break;
            					}
            				}

            			}                                
                                
            			if(nodeWT != null){
            				
            				String nodeTextValue = getTextValue(nodeWT);
            				
            				if (casoEspecial.isEmpty() && !nodeTextValue.isEmpty() && nodeTextValue.contains("[") && !nodeTextValue.contains("]")) {
                                             
            					casoEspecial = casoEspecial + nodeTextValue;
            					nodeWT.getParentNode().removeChild(nodeWT);
            					continue;
            				}
                                       
            				if(casoEspecial.isEmpty()){
                                              
            					for (Map.Entry<String, String> entry : replacedMap.entrySet()) {
                                                    
            						if(!nodeTextValue.isEmpty() && nodeTextValue.contains(entry.getKey())) {
            							nodeTextValue = nodeTextValue.replace(entry.getKey(), entry.getValue());
            						}
            					}
            					
            					setTextValue(nodeWT, nodeTextValue);
                                       
            				}else {
                                              
            					casoEspecial = casoEspecial + nodeTextValue;
            					nodeWT.getParentNode().removeChild(nodeWT);
                                              
            					boolean par = true;
                                              
            					for(int p=0; p<casoEspecial.length(); p++){
                                                    
            						if('[' == casoEspecial.charAt(p)){
                                                           
            							par = false;
                                                           
            							for(int k = (p+1); k<casoEspecial.length(); k++){
            								
            								if(']' == casoEspecial.charAt(k)){
            									p = k + 1;
            									par = true;
            									break;
            								}
            								
            							}
            							
            						}
            						
            					}
            					
            					if(par){
                                                    
            						Node nextNode = null;
                                                    
            						for(int k = (t+1); k<nodeListWR.getLength(); k++){
                                                           
            							Node nodeWRTemp = nodeListWR.item(k);
            							Node nodeWTTemp = nodeWRTemp.getFirstChild();

            							if(nodeWTTemp != null){
            								nextNode = nodeWTTemp.getParentNode();
            								t = k;
            								break;
            							}
            						}

            						for (Map.Entry<String, String> entry : replacedMap.entrySet()) {
                                                           
            							if(casoEspecial.contains(entry.getKey())) {
            								casoEspecial = casoEspecial.replace(entry.getKey(), entry.getValue());
            							}
            							
            						}
                                                    
            						XWPFRun run = xwpfParagraph.createRun();
            						run.setText(casoEspecial);
            						xwpfParagraph.getCTP().getDomNode().insertBefore(run.getCTR().getDomNode(), nextNode);
            						casoEspecial = "";
            					}
            				}
            			}
            		}
            	}
            }
		}
	}

	private String getTextValue(Node node) {
	     
		StringBuffer textValue = new StringBuffer("");

		for (int i = 0; i < node.getChildNodes().getLength(); i ++) {
			Node c = node.getChildNodes().item(i);
			if (c.getNodeType() == Node.TEXT_NODE) {
				textValue.append(c.getNodeValue());
			}
		}
	   
	   return textValue.toString();
	}

	private void setTextValue(Node node, String newValue) {
		
		for (int i = 0; i < node.getChildNodes().getLength(); i ++) {
			Node c = node.getChildNodes().item(i);
			if (c.getNodeType() == Node.TEXT_NODE) {
				c.setNodeValue(newValue);
			}
		}
	}

}
