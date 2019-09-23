package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Clan;
import model.ElementoExisteExcepcion;
import model.Personaje;

class ClanTest {
	private Clan a;
	private void setupScenary1() throws ElementoExisteExcepcion {
		a = new Clan("Prueba");
		a.ingresarPersonajeAlFinal("Kazuma God     ", "PUES NO HAY MUCHO QUE DECIR ES EL MISMISIMO CRISTO!","19/09/2019", 8000, null);
		a.ingresarPersonajeAlFinal("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
		a.ingresarPersonajeAlFinal("Kirito Uzumaki ", "Un tipo con hacks bien chingones que tiene una waffle deliciosa","19/09/2019", 6200, null);
		a.ingresarPersonajeAlFinal("Anata wa       ", "Oki desu! hashimemaste","19/09/2019", 1250, null);
		a.ingresarPersonajeAlFinal("Jhon Wick      ", "Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
		
	}
	private void setupScenary2() throws ElementoExisteExcepcion {
		a = new Clan("Prueba");
		a.ingresarPersonajeAlFinal("Anata wa       ", "Oki desu! hashimemaste","19/09/2019", 1250, null);
		a.ingresarPersonajeAlFinal("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
		a.ingresarPersonajeAlFinal("Jhon Wick      ", "Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
		a.ingresarPersonajeAlFinal("Kazuma God     ", "PUES NO HAY MUCHO QUE DECIR ES EL MISMISIMO CRISTO!","19/09/2019", 8000, null);
		a.ingresarPersonajeAlFinal("Kirito Uzumaki ", "Un tipo con hacks bien chingones que tiene una waffle deliciosa","19/09/2019", 6200, null);
		
	}
	private void setupScenary3() throws ElementoExisteExcepcion {
		a = new Clan("Prueba");
		a.ingresarPersonajeAlFinal("Kirito Uzumaki ", "Un tipo con hacks bien chingones que tiene una waffle deliciosa","19/09/2019", 6200, null);
		a.ingresarPersonajeAlFinal("Kazuma God     ", "PUES NO HAY MUCHO QUE DECIR ES EL MISMISIMO CRISTO!","19/09/2019", 8000, null);
		a.ingresarPersonajeAlFinal("Jhon Wick      ", "Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
		a.ingresarPersonajeAlFinal("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
		a.ingresarPersonajeAlFinal("Anata wa       ", "Oki desu! hashimemaste","19/09/2019", 1250, null);
		
	}
	@Test
	void testIngresarPersonajeAlFinalCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		Personaje p = new Personaje("Ganta Saiyayin ", "Que los fans de Deadman wonderland no estaba extintos?","19/09/2019", 2596, null);
		int elementosAntesDe = a.contarElementos();
		a.ingresarPersonajeAlFinal("Ganta Saiyayin ", "Que los fans de Deadman wonderland no estaba extintos?","19/09/2019", 2596, null);
		assertEquals(p.toString(),a.retornarIndice(elementosAntesDe).toString());
	}
	
	@Test
	void testIngresarPersonajeAlInicioCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		Personaje p = new Personaje("Ganta Saiyayin ", "Que los fans de Deadman wonderland no estaba extintos?","19/09/2019", 2596, null);
		a.ingresarPersonajeAlInicio("Ganta Saiyayin ", "Que los fans de Deadman wonderland no estaba extintos?","19/09/2019", 2596, null);
		assertEquals(p.toString(),a.retornarIndice(0).toString());
	}
	
	@Test
	void testBuscarPersonajeRepetidoCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		assertTrue(a.repetido("Kazuma God     "));
	}

	@Test
	void testEliminarPersonajeCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		Personaje p = new Personaje("Kazuma God     ", "PUES NO HAY MUCHO QUE DECIR ES EL MISMISIMO CRISTO!","19/09/2019", 8000, null);
		a.eliminarPersonaje("Kazuma God     ");
		assertNotEquals(p.toString(), a.retornarIndice(0));
	}
	
	@Test
	void testEliminarPersonajeCase2() throws ElementoExisteExcepcion {
		setupScenary1();
		Personaje p = new Personaje("Jhon Wick      ", "Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
		a.eliminarPersonaje("Jhon Wick      ");
		assertNotEquals(p.toString(), a.retornarIndice(a.contarElementos()-1));
	}
	
	@Test
	void testEliminarPersonajeCase3() throws ElementoExisteExcepcion {
		setupScenary1();
		Personaje p = new Personaje("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
		a.eliminarPersonaje("Dio Jotaro      ");
		assertNotEquals(p.toString(), a.retornarIndice(1));
	}
	
	@Test
	void testModificarNombreCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		a.modificarNombrePersonaje("Kazuma God     ", "Dio Jotaro     ");
		assertEquals("Dio Jotaro     ", a.retornarIndice(0).getNombre());
	}
	
	@Test
	void testModificarNombreCase2() throws ElementoExisteExcepcion {
		setupScenary1();
		a.modificarPersonalidadPersonaje("Kazuma God     ","Is this a motherfucker jojo's reference!?");
		assertEquals("Is this a motherfucker jojo's reference!?", a.retornarIndice(0).getPersonalidad());
	}
	
	@Test
	void contarElementosTest() throws ElementoExisteExcepcion {
		setupScenary1();
		int elementos = a.contarElementos();
		assertEquals(5, elementos);
	}
	
	@Test
	void retornarIndiceTestCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		Personaje indice = a.retornarIndice(0);
		Personaje p = new Personaje("Kazuma God     ", "PUES NO HAY MUCHO QUE DECIR ES EL MISMISIMO CRISTO!","19/09/2019", 8000, null);
		assertEquals(p.toString(), indice.toString());
	}
	
	@Test
	void retornarIndiceTestCase2() throws ElementoExisteExcepcion {
		setupScenary1();
		Personaje indice = a.retornarIndice(4);
		Personaje p = new Personaje("Jhon Wick      ", "Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
		assertEquals(p.toString(), indice.toString());
	}
	
	@Test
	void retornarIndiceTestCase3() throws ElementoExisteExcepcion {
		setupScenary1();
		Personaje indice = a.retornarIndice(1);
		Personaje p = new Personaje("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
		assertEquals(p.toString(), indice.toString());
	}
	
	@Test
	void ordenarNombresCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		Clan b = new Clan("Prueba2");
		b.ingresarPersonajeAlFinal("Anata wa       ", "Oki desu! hashimemaste","19/09/2019", 1250, null);
		b.ingresarPersonajeAlFinal("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
		b.ingresarPersonajeAlFinal("Jhon Wick      ", "Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
		b.ingresarPersonajeAlFinal("Kazuma God     ", "PUES NO HAY MUCHO QUE DECIR ES EL MISMISIMO CRISTO!","19/09/2019", 8000, null);
		b.ingresarPersonajeAlFinal("Kirito Uzumaki ", "Un tipo con hacks bien chingones que tiene una waffle deliciosa","19/09/2019", 6200, null);
		String ordenado = b.pintar();
		a.ordenarPorNombreBubbleSort();
		String sort = a.pintar();
		assertEquals(ordenado, sort);
	}
	
	@Test
	void ordenarNombresCase2() throws ElementoExisteExcepcion {
		setupScenary2();
		Clan b = new Clan("Prueba2");
		b.ingresarPersonajeAlFinal("Anata wa       ", "Oki desu! hashimemaste","19/09/2019", 1250, null);
		b.ingresarPersonajeAlFinal("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
		b.ingresarPersonajeAlFinal("Jhon Wick      ", "Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
		b.ingresarPersonajeAlFinal("Kazuma God     ", "PUES NO HAY MUCHO QUE DECIR ES EL MISMISIMO CRISTO!","19/09/2019", 8000, null);
		b.ingresarPersonajeAlFinal("Kirito Uzumaki ", "Un tipo con hacks bien chingones que tiene una waffle deliciosa","19/09/2019", 6200, null);
		String ordenado = b.pintar();
		a.ordenarPorNombreBubbleSort();
		String sort = a.pintar();
		assertEquals(ordenado, sort);
	}
	
	@Test
	void ordenarNombresCase3() throws ElementoExisteExcepcion {
		setupScenary2();
		Clan b = new Clan("Prueba2");
		b.ingresarPersonajeAlFinal("Anata wa       ", "Oki desu! hashimemaste","19/09/2019", 1250, null);
		b.ingresarPersonajeAlFinal("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
		b.ingresarPersonajeAlFinal("Jhon Wick      ", "Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
		b.ingresarPersonajeAlFinal("Kazuma God     ", "PUES NO HAY MUCHO QUE DECIR ES EL MISMISIMO CRISTO!","19/09/2019", 8000, null);
		b.ingresarPersonajeAlFinal("Kirito Uzumaki ", "Un tipo con hacks bien chingones que tiene una waffle deliciosa","19/09/2019", 6200, null);
		String ordenado = b.pintar();
		a.ordenarPorNombreBubbleSort();
		String sort = a.pintar();
		assertEquals(ordenado, sort);
	}
	
	@Test
	void buscarSecuencialPorNombreCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		String indice = a.buscarSecuencialPorNombre("Jhon Wick      ");
		Personaje p = new Personaje("Jhon Wick      ", "Que Dios se apiade de los que enfrenten a Jhon papasito Wick","19/09/2019", 8002, null);
		assertEquals(p.toString(), indice);
	}
	
	@Test
	void buscarSecuencialPorNombreCase2() throws ElementoExisteExcepcion {
		setupScenary1();
		String indice = a.buscarSecuencialPorNombre("BellaEnMiCabezaParaSiempre");
		assertEquals("No se encontro o no existe el personaje buscado", indice);
	}

}
