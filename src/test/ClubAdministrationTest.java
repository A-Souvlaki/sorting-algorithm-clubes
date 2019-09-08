package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import model.Club;
import model.ClubAdministration;
import model.ElementExistsExcepcion;

class ClubAdministrationTest {

	private ClubAdministration list;

	private void setupScenary1() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "Serializable.txt", "OwnersTest.CSV", "PetsTest.CSV");
	}

	private void setupScenary2() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("b", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("a", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("d", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("c", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("e", "Club de Prueba", "16/05/2019", "Dinosaurios"));
	}

	private void setupScenary3() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("a", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("b", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("c", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("d", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("e", "Club de Prueba", "16/05/2019", "Dinosaurios"));
	}

	private void setupScenary4() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("e", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("d", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("c", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("b", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("a", "Club de Prueba", "16/05/2019", "Dinosaurios"));
	}

	// _________________________________________________________________________________________________________//
	@Test
	void registerOwnerTest() throws ElementExistsExcepcion {
		setupScenary1();
		boolean found = false;
		list.registerClub("1234567896", "Club de Prueba", "16/05/2019", "Dinosaurios");
		for (int i = 0; i < list.getClubs().size(); i++) {
			if (list.getClubs().get(i).getId().equals("1234567896")) {
				found = true;
			}
		}
		assertTrue(found);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void searchClubTestCase1() throws ElementExistsExcepcion {
		setupScenary1();
		list.registerClub("1234567896", "Club de Prueba", "16/05/2019", "Dinosaurios");
		Club club = list.searchClub("1234567896");
		assertNotNull(club);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void searchClubTestCase2() throws ElementExistsExcepcion {
		setupScenary1();
		Club club = list.searchClub("9876543214");
		assertNull(club);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByIdCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("b", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("c", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("d", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("e", "Club de Prueba", "16/05/2019", "Dinosaurios"));

		setupScenary2();
		list.orderClubsById();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByIdCase2() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("b", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("c", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("d", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("e", "Club de Prueba", "16/05/2019", "Dinosaurios"));

		setupScenary3();
		list.orderClubsById();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByIdCase3() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("b", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("c", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("d", "Club de Prueba", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("e", "Club de Prueba", "16/05/2019", "Dinosaurios"));

		setupScenary4();
		list.orderClubsById();
		assertEquals(sort.toString(), list.getClubs().toString());
	}
}
