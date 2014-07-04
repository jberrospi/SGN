package com.notariaberrospi.sgn.pruebas;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.notariaberrospi.sgn.entity.Usuario;
import com.notariaberrospi.sgn.service.UsuarioService;

public class Pruebas extends AbstractBaseUnitTest {

	@Autowired
	UsuarioService usuarioService;

	@Test
	public void login() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setUsuario("jean");
		usuario.setClave("admin");
		Assert.assertNotNull(usuarioService.buscarLogin(usuario));
	}

}
