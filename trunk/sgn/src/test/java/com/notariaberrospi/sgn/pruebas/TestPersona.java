package com.notariaberrospi.sgn.pruebas;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.notariaberrospi.sgn.entity.Empleado;
import com.notariaberrospi.sgn.entity.Empresa;
import com.notariaberrospi.sgn.entity.Kaac;
import com.notariaberrospi.sgn.entity.Kardex;
import com.notariaberrospi.sgn.entity.Tabla;
import com.notariaberrospi.sgn.service.ActoService;
import com.notariaberrospi.sgn.service.EmpleadoService;
import com.notariaberrospi.sgn.service.EmpresaService;
import com.notariaberrospi.sgn.service.KardexService;
import com.notariaberrospi.sgn.service.MaestroService;
import com.notariaberrospi.sgn.util.Constantes;

public class TestPersona extends AbstractBaseUnitTest {

	@Autowired
	MaestroService maestroService;

	@Autowired
	EmpleadoService empleadoService;

	@Autowired
	ActoService actoService;

	@Autowired
	EmpresaService empresaService;

	@Autowired
	KardexService kardexService;

	
	// @Test
	public void tabla() throws Exception {

		List<Tabla> tabla = maestroService.buscarPorGrupo(1);
		Assert.assertNotNull(tabla);
	}

	@Test
	public void autoIncremental1() throws Exception {

		Long tabla = maestroService.buscarAutoIncremental(Constantes.autoIncremental.ID_KARDEX).getValor1();
		System.out.println(tabla);
		
		Assert.assertNotNull(tabla);
	}

	// @Test
	public void abogadoInterno() throws Exception {

		List<Empleado> lista = empleadoService
				.buscarEmpleadoRol(Constantes.rolEmpleado.ID_ABOGADO);
		// Assert.assertNotNull(lista.get(0).getTPersona().getNombreCompleto());
		System.out.println(lista.get(0).getTPersona().getNombreCompleto());
		System.out.println(lista.get(0).getTUsuario().getUsuario());
	}

	// @Test
	public void actos() throws Exception {

		List<Kaac> tabla = actoService.buscar();
		Assert.assertNotNull(tabla);
	}

	//@Test
	public void empresas() throws Exception {

		List<Empresa> empresas = empresaService.buscarEmpresas(null);
		System.out.println(empresas.size());
	}
	
	//@Test
	public void registrarKardex() throws Exception {

		Kardex kardex =new Kardex();
		
		kardex.setNrokardex("1");
		kardex.setFecingreso(Calendar.getInstance().getTime());
		
		Kaac kaac = new Kaac();
		kaac.setIdkaac(new Long(1));
		kardex.setTKaac(kaac);
		
		Empleado empleado = new Empleado();
		empleado.setIdempleado(new Long(1));
		
		kardex.setTEmpleado1(empleado);
		
		kardexService.grabar(kardex);

	}
	
	//@Test
	public void obtenerKardex() throws Exception {
		Kardex kardex = kardexService.buscar();
		System.out.println(kardex);
	}
	
	@Test
		public void listaKardex() throws Exception {

			List<Kardex> kardex = kardexService.buscarLista(null);
			System.out.println(kardex.size());
		}
}
