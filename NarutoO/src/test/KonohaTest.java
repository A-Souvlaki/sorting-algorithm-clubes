package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Clan;
import model.ElementoExisteExcepcion;
import model.Konoha;

class KonohaTest {

	private Konoha konoha;

	private void setupScenary1() throws ElementoExisteExcepcion {
		konoha = new Konoha("SomePruebas.txt");
		konoha.crearClan("Konohamaru");
		konoha.crearClan("Uchicha");
	}

	private void setupScenary2() throws ElementoExisteExcepcion {
		konoha = new Konoha("SomePruebas.txt");
		konoha.crearClan("Konohamaru");
		konoha.crearClan("Uchicha");
		konoha.crearClan("Aburame");
		konoha.crearClan("Saturobi");
		konoha.crearClan("Kabuzaki");
	}

	private void setupScenary3() throws ElementoExisteExcepcion {
		konoha = new Konoha("SomePruebas.txt");
		konoha.crearClan("Uchicha");
		konoha.crearClan("Saturobi");
		konoha.crearClan("Konohamaru");
		konoha.crearClan("Kabuzaki");
		konoha.crearClan("Aburame");
	}

	private void setupScenary4() throws ElementoExisteExcepcion {
		konoha = new Konoha("SomePruebas.txt");
		konoha.crearClan("Aburame");
		konoha.crearClan("Kabuzaki");
		konoha.crearClan("Konohamaru");
		konoha.crearClan("Saturobi");
		konoha.crearClan("Uchicha");
	}

	@Test
	void testBuscarClanRepetidoCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		assertTrue(konoha.buscarClanRepetido("Konohamaru"));
	}

	@Test
	void testBuscarClanRepetidoCase2() throws ElementoExisteExcepcion {
		setupScenary1();
		assertFalse(konoha.buscarClanRepetido("Uzumaki"));
	}

	@Test
	void testEliminarClanCase1() throws ElementoExisteExcepcion {
		setupScenary1();
		konoha.eliminarClan("Konohamaru");
		assertTrue(konoha.getClanes().size() == 1);
	}
	
	@Test
	void testEliminarClanCase2() throws ElementoExisteExcepcion {
		setupScenary1();
		konoha.eliminarClan("Uchicha");
		assertTrue(konoha.getClanes().size() == 1);
	}
	
	@Test
	void testEliminarClanCase3() throws ElementoExisteExcepcion {
		setupScenary2();
		konoha.eliminarClan("Aburame");
		assertTrue(konoha.getClanes().size() == 4);
	}
	
	@Test
	void ordenarClanesTest1() throws ElementoExisteExcepcion {
		setupScenary2();
		ArrayList<Clan> c = new ArrayList<Clan>();
		c.add(new Clan("Aburame"));
		c.add(new Clan("Kabuzaki"));
		c.add(new Clan("Konohamaru"));
		c.add(new Clan("Saturobi"));
		c.add(new Clan("Uchicha"));
		konoha.ordenarPorNombreSeleccionSort();
		assertEquals(c.toString(), konoha.getClanes().toString());
	}
	
	@Test
	void ordenarClanesTest2() throws ElementoExisteExcepcion {
		setupScenary3();
		ArrayList<Clan> c = new ArrayList<Clan>();
		c.add(new Clan("Aburame"));
		c.add(new Clan("Kabuzaki"));
		c.add(new Clan("Konohamaru"));
		c.add(new Clan("Saturobi"));
		c.add(new Clan("Uchicha"));
		konoha.ordenarPorNombreSeleccionSort();
		assertEquals(c.toString(), konoha.getClanes().toString());
	}
	
	@Test
	void ordenarClanesTest3() throws ElementoExisteExcepcion {
		setupScenary4();
		ArrayList<Clan> c = new ArrayList<Clan>();
		c.add(new Clan("Aburame"));
		c.add(new Clan("Kabuzaki"));
		c.add(new Clan("Konohamaru"));
		c.add(new Clan("Saturobi"));
		c.add(new Clan("Uchicha"));
		konoha.ordenarPorNombreSeleccionSort();
		assertEquals(c.toString(), konoha.getClanes().toString());
	}
	
	@Test
	void buscarClanTest1() throws ElementoExisteExcepcion {
		setupScenary2();
		Clan c = new Clan("Aburame");
		assertEquals(c.toString(), konoha.buscarClan("Aburame"));
	}
	
	@Test
	void buscarClanTest2() throws ElementoExisteExcepcion {
		setupScenary2();
		assertEquals("No existe ningun clan con el nombre ingresado",konoha.buscarClan("LasRuinasDelRemotoAyer"));
	}

}

