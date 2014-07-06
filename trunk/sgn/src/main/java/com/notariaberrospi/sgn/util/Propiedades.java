package com.notariaberrospi.sgn.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Propiedades {
	
	@Value("${mime.type.docx}")
	public String MIME_TYPE_DOCX;
	
	@Value("${mime.type.doc}")
	public String MIME_TYPE_DOC;
	
	@Value("${ruta.word.plantilla}")
	public String RUTA_WORD_PLANTILLA;
	
	@Value("${ruta.word.generado}")
	public String RUTA_WORD_GENERADO;
	

}
