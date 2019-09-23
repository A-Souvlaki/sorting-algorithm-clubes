package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.ElementoExisteExcepcion;
import model.Personaje;
import model.Tecnica;

class PersonajeTest {
	private Personaje p;
	
	private void setupScenary1() throws ElementoExisteExcepcion {
		p = new Personaje("Dio Jotaro     ", "Is this a motherfucker jojo's reference!?","19/09/2019", 4500, null);
		p.insertarAlFinal("Anillo del oropel", 6);
		p.insertarAlFinal("Kim Crimson", 3);
		p.insertarAlFinal("Espejo del crepusculo", 5);
		p.insertarAlFinal("Hamon", 2);
		p.insertarAlFinal("Zemiramis", 9);
		p.insertarAlFinal("Hombres del pilar", 8);
		p.insertarAlFinal("Bitral Maria", 7);
		p.insertarAlFinal("Estratogema", 12);
		p.insertarAlFinal("Stand", 4);	
		
	}
	
	@Test
	void testIngresaFinalCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		Tecnica t = new Tecnica("Lunas superiores",15);
		int elementosAntesDe = p.contarElementos();
		p.insertarAlFinal("Lunas superiores",15);
		assertEquals(t.toString(),p.retornarIndice(elementosAntesDe).toString());
	}
	
	@Test
	void testIngresarAlInicioCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		Tecnica t = new Tecnica("Lunas superiores",15);
		p.insertarAlInicio("Lunas superiores",15);
		assertEquals(t.toString(),p.retornarIndice(0).toString());
		
	}
	
	@Test
	void testRepetidoCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		assertTrue(p.repetido("Anillo del oropel"));
	}
	
	@Test
	void testRepetidoCase2() throws ElementoExisteExcepcion {
		setupScenary1();
		assertFalse(p.repetido("Emiramis"));
		
	}
	
	@Test
	void testEliminarTecnicaCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		Tecnica t = new Tecnica("Anillo del oropel", 6);
		assertNotEquals(t.toString(), p.retornarIndice(0));
	}
	
	@Test
	void testEliminarTecnicaCase2() throws ElementoExisteExcepcion {
		setupScenary1();
		Tecnica t = new Tecnica("Stand", 4);
		assertNotEquals(t.toString(), p.retornarIndice(8));
	}
	
	@Test
	void testEliminarTecnicaCase3() throws ElementoExisteExcepcion {
		setupScenary1();
		Tecnica t = new Tecnica("Kim Crimson", 3);
		assertNotEquals(t.toString(), p.retornarIndice(1));
	}
	
	@Test
	void ordenarPorPoderCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		Personaje p1 = new Personaje("Kirito Uzumaki ", "Un tipo con hacks bien chingones que tiene una waffle deliciosa","19/09/2019", 6200, null);
		p1.insertarAlFinal("Hamon", 2);
		p1.insertarAlFinal("Kim Crimson", 3);
		p1.insertarAlFinal("Stand", 4);
		p1.insertarAlFinal("Espejo del crepusculo", 5);
		p1.insertarAlFinal("Anillo del oropel", 6);
		p1.insertarAlFinal("Bitral Maria", 7);
		p1.insertarAlFinal("Hombres del pilar", 8);
		p1.insertarAlFinal("Zemiramis", 9);
		p1.insertarAlFinal("Estratogema", 12);
		String sort =p1.pintar();
		p.ordenarPorPoderInsertionSort();
		String pintar = p.pintar();
		assertEquals(sort, pintar);
		
	}
	
	@Test
	void ordenarPorNombreCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		Personaje p1 = new Personaje("Kirito Uzumaki ", "Un tipo con hacks bien chingones que tiene una waffle deliciosa","19/09/2019", 6200, null);
		p1.insertarAlFinal("Anillo del oropel", 6);
		p1.insertarAlFinal("Bitral Maria", 7);
		p1.insertarAlFinal("Espejo del crepusculo", 5);
		p1.insertarAlFinal("Estratogema", 12);
		p1.insertarAlFinal("Hamon", 2);
		p1.insertarAlFinal("Hombres del pilar", 8);
		p1.insertarAlFinal("Kim Crimson", 3);
		p1.insertarAlFinal("Stand", 4);
		p1.insertarAlFinal("Zemiramis", 9);
	
		String sort =p1.pintar();
		p.ordenarNombresPorSelectionSort();
		String pintar = p.pintar();
		assertEquals(sort, pintar);
		
	}
	
	
	
	
}
