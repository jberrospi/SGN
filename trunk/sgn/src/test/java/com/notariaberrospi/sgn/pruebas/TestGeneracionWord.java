package com.notariaberrospi.sgn.pruebas;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.notariaberrospi.sgn.util.ArchivoUtil;
import com.notariaberrospi.sgn.util.FechaUtil;

public class TestGeneracionWord extends AbstractBaseUnitTest{
	
	@Autowired
	private ArchivoUtil archivoUtil;
	
	@Test
	public void test(){
		
		String dia = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		String temp = FechaUtil.obtenerNombreMes(Calendar.getInstance().get(Calendar.MONTH));
		String mes = temp.substring(0, 1).toUpperCase().concat(temp.substring(1, temp.length()));
		String ano = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		
		Map<String, String> parametros = new HashMap<String, String>();
		
		parametros.put("[INSTRUMENTO]", "CUATROCIENTOS TREINTA (430)");
		parametros.put("[N_KARDEX]", "35409");
		parametros.put("[N_MINUTA]", "371");
		parametros.put("[TIPO_PODER]", "PODER_ESPECIAL");
		
		parametros.put("[PODERDANTE_NOMBRE_COMPLETO]",	"EDUARDO ANTONIO DALLA PORTA ZUÑIGA");
		parametros.put("[APODERADO_NOMBRE_COMPLETO]", "ANA CECILIA ALBAÑIL CIEZA");
		
		parametros.put("[DIA_TEXTO]", "DOCE (12)");
		parametros.put("[MES_TEXTO]", "FEBRERO");
		parametros.put("[AÑO_TEXTO]", "DOS MIL CATORCE (2014)");
		
		parametros.put("[PODERDANTE_N_DNI]", "07262716");
		parametros.put("[PODERNANTE_NACIONALIDAD]", "PERUANO");
		parametros.put("[PODERDANTE_E_CIVIL_COMPLETO]", "CASADO CON JESSICA BERRIO JO");
		parametros.put("[PODERDANTE_DIRECCION]", "AVENIDA MARISCAL CASTILLA 489, URBANIZACION LAS MAGNOLIAS, DISTRITO DE SANTIAGO DE SURCO, PROVINCIA Y DEPARTAMENTO DE LIMA");
		parametros.put("[PODERDANTE_PROFESION]", "ADMINISTRADOR");
		parametros.put("[PODERDANTE_PROCEDENCIA]", "POR SU PROPIO DERECHO");
		parametros.put("[PODERDANTE_ABOGADO_NOMBRE_COMPLETO]", "RUBEN P. BERNABE CHAVEZ");
		parametros.put("[PODERDANTE_ABOGADO_REGIMEN]", "C.A.L.");
		parametros.put("[PODERDANTE_ABOGADO_N_REGIMEN]", "56501");
		
		//parametros.put("[DIA]", dia);
		//parametros.put("[MES]", mes);
		//parametros.put("[A�O]", a�o);
		
		
		//boolean resultado = archivoUtil.generarDocDesdePlantilla("plantilla_escritura.doc", "escritura.doc", parametros);
		//System.out.println("generacion doc: " + resultado);
		
		boolean resultado = archivoUtil.generarDocxDesdePlantilla("plantilla_escritura.docx", "escritura.docx", parametros);
		
		System.out.println("generacion docx: " + resultado);
	}

}
