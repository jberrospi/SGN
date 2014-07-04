package com.notariaberrospi.pruebas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.notariaberrospi.entity.Kaac;
import com.notariaberrospi.entity.Tabla;
import com.notariaberrospi.service.ActoService;
import com.notariaberrospi.service.MaestroService;

public class Persona extends AbstractBaseUnitTest {

	@Autowired
	MaestroService maestroService;

	@Autowired
	ActoService actoService;
	@Test
	public void tabla() throws Exception {
	
		List<Tabla> tabla= maestroService.buscarPorGrupo(1);
		Assert.assertNotNull(tabla);
	}

	
	@Test
	public void actos() throws Exception {
	
		List<Kaac> tabla= actoService.buscar();
		Assert.assertNotNull(tabla);
	}
}
