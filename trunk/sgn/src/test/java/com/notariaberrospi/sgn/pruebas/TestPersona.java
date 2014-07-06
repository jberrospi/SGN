package com.notariaberrospi.sgn.pruebas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.notariaberrospi.sgn.entity.Empleado;
import com.notariaberrospi.sgn.entity.Kaac;
import com.notariaberrospi.sgn.entity.Tabla;
import com.notariaberrospi.sgn.service.ActoService;
import com.notariaberrospi.sgn.service.EmpleadoService;
import com.notariaberrospi.sgn.service.MaestroService;
import com.notariaberrospi.sgn.util.Constantes;

public class TestPersona extends AbstractBaseUnitTest {

	@Autowired
	MaestroService maestroService;

	@Autowired
	EmpleadoService empleadoService;

	
	@Autowired
	ActoService actoService;
	
	//@Test
	public void tabla() throws Exception {
	
		List<Tabla> tabla= maestroService.buscarPorGrupo(1);
		Assert.assertNotNull(tabla);
	}
	//@Test
	public void autoIncremental1() throws Exception {
	
		Tabla tabla= maestroService.buscarAutoIncremental(66);
		Assert.assertNotNull(tabla);
	}

	@Test
	public void abogadoInterno() throws Exception {
	
		List<Empleado> lista= empleadoService.buscarEmpleadoRol(Constantes.rolEmpleado.ID_ABOGADO);
		//Assert.assertNotNull(lista.get(0).getTPersona().getNombreCompleto());
		System.out.println(lista.get(0).getTPersona().getNombreCompleto());
		System.out.println(lista.get(0).getTUsuario().getUsuario());
	}
	
	//@Test
	public void actos() throws Exception {
	
		List<Kaac> tabla= actoService.buscar();
		Assert.assertNotNull(tabla);
	}
}
