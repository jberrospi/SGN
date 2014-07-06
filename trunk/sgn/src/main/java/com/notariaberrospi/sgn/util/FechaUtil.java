package com.notariaberrospi.sgn.util;

import java.text.DateFormatSymbols;

public class FechaUtil {
	
	public static String obtenerNombreMes(int mes){
		DateFormatSymbols dfs = new DateFormatSymbols();
		return dfs.getMonths()[mes];
	}

}
