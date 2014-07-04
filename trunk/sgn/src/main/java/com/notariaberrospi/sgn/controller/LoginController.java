package com.notariaberrospi.sgn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.notariaberrospi.sgn.entity.Usuario;
import com.notariaberrospi.sgn.service.ServiceFactory;
import com.notariaberrospi.sgn.util.Constantes;
import com.notariaberrospi.sgn.util.FacesUtils;

@Controller
@Scope("request")
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private ServiceFactory serviceFactory;

	private String paginaResultado;

	private Usuario usuario = new Usuario();

	public LoginController() {
		logger.debug("");
	}

	public String login() {
		logger.debug("");
		
		usuario = serviceFactory.getUsuarioService().buscarLogin(usuario);
		
		if (usuario == null) {
			FacesUtils.addMessageErrorBundle("validacion.login.incorrecto");
			paginaResultado = "login";
		} else {
			FacesUtils.addMessageInfoBundle("validacion.login.correcto");
			FacesUtils.keepMessages();
			paginaResultado = "/paginas/modulos/principal/principal" + Constantes.REDIRECT_JSF;
		}

		return paginaResultado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
