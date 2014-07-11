package com.notariaberrospi.sgn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notariaberrospi.sgn.dao.UsuarioDao;
import com.notariaberrospi.sgn.entity.Usuario;

@Service
public class UsuarioService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private UsuarioDao usuarioDao;

	public void grabar(Usuario usuario) {
		logger.debug("");
		usuarioDao.grabar(usuario);
	}
	
	public void modificar(Usuario usuario){
		logger.debug("");
		usuarioDao.modificar(usuario);
	}
	
	public void eliminar(Usuario usuario){
		logger.debug("");
		usuarioDao.eliminar(usuario);
	}

	public Usuario buscarLogin(Usuario usuario) {
		logger.debug("");
		return usuarioDao.buscar(
				"from Usuario u where u.usuario = ? and u.clave = ?",
				usuario.getUsuario(), usuario.getClave());
	}

}
