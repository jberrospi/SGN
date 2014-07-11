package com.notariaberrospi.sgn.util;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FechaUtil {
	
	public static String obtenerNombreMes(int mes){
		DateFormatSymbols dfs = new DateFormatSymbols();
		return dfs.getMonths()[mes];
	}
	
	public static Date getDate(){
		Locale local = new Locale("es", "PE");
		TimeZone tz1 = TimeZone.getTimeZone("UTC");
		return Calendar.getInstance(tz1, local).getTime();
	}

}
