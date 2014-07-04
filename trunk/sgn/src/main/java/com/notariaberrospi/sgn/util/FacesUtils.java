package com.notariaberrospi.sgn.util;

/**
 * Clase utilitaria de Java Server Faces.
 * @author Jean Ramal Alvarez
 * @since 31 August 2012
 * @version 1.0
 *
 */

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FacesUtils {

	private FacesUtils() {
	}
	
	/**
	 * Metodo que adiciona un mensaje de Informacion al contexto para ser enviado al cliente.
	 * @param message contenido del mensaje, tipo String.
	 * */
	public static void addMessageInfo(String message){
		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	/**
	 * Metodo que adiciona un mensaje de Error al contexto para ser enviado al cliente.
	 * @param message contenido del mensaje, tipo String.
	 * */
	public static void addMessageError(String message){
		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	/**
	 * Metodo que adiciona un mensaje de Informacion desde properties indicando su clave 
	 * al contexto para ser enviado al cliente.
	 * @param key codigo del mensaje, tipo String.
	 * @param args argumentos , tipo String.
	 * */
	public static void addMessageInfoBundle(String key, String... args){
		addMessageInfo(getMensaje(key, args));
	}
	
	/**
	 * Metodo que adiciona un mensaje de Error desde properties indicando su clave 
	 * al contexto para ser enviado al cliente.
	 * @param key codigo del mensaje, tipo String.
	 * @param args argumentos , tipo String.
	 * */
	public static void addMessageErrorBundle(String key, String... args){
		addMessageError(getMensaje(key, args));
	}

	/**
	 * Metodo que permite mantener el envio de mensaje cuando existe un Redirect.
	 * */
	public static void keepMessages() {
		getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	/**
	 * Metodo que obtiene una instancia de FacesContext.
	 * @return FacesContext.
	 * */
	public static FacesContext getCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}
	
	/**
	 * Metodo que obtiene una instancia de ServletContext.
	 * @return FacesContext.
	 * */
	public static ServletContext getServletContext(){
		return ((ServletContext) getExternalContext().getContext());
	}
	
	/**
	 * Metodo que obtiene una instancia de ExternalContext.
	 * @return FacesContext.
	 * */
	public static ExternalContext getExternalContext(){
		return getCurrentInstance().getExternalContext();
	}

	/**
	 * Metodo que obtiene el request de la instancia de FacesContext.
	 * @return HttpServletRequest.
	 * */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * Metodo que obtiene el response de la instancia de FacesContext.
	 * @return HttpServletResponse.
	 * */
	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) getCurrentInstance().getExternalContext().getResponse();
	}

	/**
	 * Metodo que obtiene la direccion ip.
	 * @return String.
	 * */
	public static String getRemoteAddr() {
		return getRequest().getRemoteAddr();
	}

	/**
	 * Metodo que obtiene la direccion ip.
	 * @return String.
	 * */
	public static String getRemoteHost() {
		return getRequest().getRemoteHost();
	}

	/**
	 * Metodo que obtiene un objeto de la session.
	 * @param objectName nombre del objeto, tipo String.
	 * @return Object.
	 * */
	public static Object getAttribute(String objectName) {
		return getRequest().getSession(false).getAttribute(objectName);
	}

	/**
	 * Metodo que elimina la sesion.
	 * */
	public static void invalidate() {
		((HttpSession) getCurrentInstance().getExternalContext().getSession(false)).invalidate();
	}

	/**
	 * Metodo que obtiene el mensaje del properties en base al codigo.
	 * @param key codigo del mensaje, tipo String.
	 * @param args argumentos , tipo String.
	 * @return mensaje.
	 * */
	public static String getMensaje(String key, String... args) {
		try {
			FacesContext context = getCurrentInstance();
			ResourceBundle res = context.getApplication().getResourceBundle(context, "mensaje");
			MessageFormat format = new MessageFormat((String) res.getObject(key));
			return format.format(args);
		} catch (Exception e) {
			return null;
		}
	}
}
