package com.notariaberrospi.sgn.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.util.Propiedades;

@Controller
@Scope("request")
public class ArchivoController {
	
	@Autowired
	private Propiedades propiedades;

	private StreamedContent file;

	public ArchivoController() {
	}
	
	@PostConstruct
	public void init(){
		InputStream stream = null;
		try {
			stream = new FileInputStream("D:\\minuta.docx");
			file = new DefaultStreamedContent(stream, propiedades.MIME_TYPE_DOCX,"minuta.docx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				if(stream != null)
					stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//InputStream stream = FacesUtils.getServletContext().getResourceAsStream("/resources/images/ajaxloadingbar.gif");
	}

	public StreamedContent getFile() {
		return file;
	}

}
