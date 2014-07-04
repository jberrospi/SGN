package com.notariaberrospi.sgn.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Propiedades {
	
	@Value("${mensaje}")
	public String MENSAJE;
	
	@Value("${mime.type.docx}")
	public String MIME_TYPE_DOCX;

}
