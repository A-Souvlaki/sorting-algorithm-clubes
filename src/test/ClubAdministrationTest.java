package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
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

	private void setupScenary5() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));
	}

	private void setupScenary6() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));
	}

	private void setupScenary7() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/05/2019", "Dinosaurios"));
	}

	private void setupScenary8() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/02/2019", "Dinosaurios"));
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/01/2019", "Dinosaurios"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/04/2019", "Dinosaurios"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/03/2019", "Dinosaurios"));
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));
	}

	private void setupScenary9() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/01/2019", "Dinosaurios"));
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/02/2019", "Dinosaurios"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/03/2019", "Dinosaurios"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/04/2019", "Dinosaurios"));
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));
	}

	private void setupScenary10() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/04/2019", "Dinosaurios"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/03/2019", "Dinosaurios"));
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/02/2019", "Dinosaurios"));
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/01/2019", "Dinosaurios"));
	}

	private void setupScenary11() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));
	}

	private void setupScenary12() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));
	}

	private void setupScenary13() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
	}

	private void setupScenary14() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));

		list.getClubs().get(0).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(0).registerOwner("b", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(1).registerOwner("a", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(2).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(2).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(2).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(2).registerOwner("d", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(3).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(3).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(3).registerOwner("c", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(4).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(4).registerOwner("asdasd", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(4).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(4).registerOwner("d", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(4).registerOwner("eqeqweqwe", "Dueño de Prueba", "x", "x", "x");
	}

	private void setupScenary15() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));

		list.getClubs().get(4).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(4).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(4).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(4).registerOwner("d", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(4).registerOwner("e", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(3).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(3).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(3).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(3).registerOwner("d", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(2).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(2).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(2).registerOwner("c", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(1).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(1).registerOwner("b", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(0).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
	}

	private void setupScenary16() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));
		list.getClubs().add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		list.getClubs().add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		list.getClubs().add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		list.getClubs().add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));

		list.getClubs().get(0).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(0).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(0).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(0).registerOwner("d", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(0).registerOwner("e", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(1).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(1).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(1).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(1).registerOwner("d", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(2).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(2).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(2).registerOwner("c", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(3).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		list.getClubs().get(3).registerOwner("b", "Dueño de Prueba", "x", "x", "x");

		list.getClubs().get(4).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
	}

	private void setupScenary17() throws ElementExistsExcepcion {
		list = new ClubAdministration("ClubesTest.txt", "SerializableTest.dat", "OwnersTest.CSV", "PetsTest.CSV");
		list.getClubs().add(new Club("123456789", "Club de PruebaA", "16/01/2019", "DinosauriosA"));
		list.getClubs().add(new Club("789878787", "Club de PruebaB", "16/02/2019", "DinosauriosB"));
		list.getClubs().add(new Club("896512345", "Club de PruebaC", "16/03/2019", "DinosauriosC"));
		list.getClubs().add(new Club("998754655", "Club de PruebaD", "16/04/2019", "DinosauriosD"));
		list.getClubs().add(new Club("132143244", "Club de PruebaE", "16/05/2019", "DinosauriosE"));
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

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByClubNameCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("b", "Club de Prueba2", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("c", "Club de Prueba3", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("d", "Club de Prueba4", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));

		setupScenary5();
		list.orderClubsByClubName();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByClubNameCase2() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("b", "Club de Prueba2", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("c", "Club de Prueba3", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("d", "Club de Prueba4", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));

		setupScenary6();
		list.orderClubsByClubName();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByClubNameCase3() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("b", "Club de Prueba2", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("c", "Club de Prueba3", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("d", "Club de Prueba4", "16/05/2019", "Dinosaurios"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));

		setupScenary7();
		list.orderClubsByClubName();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByDateCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/01/2019", "Dinosaurios"));
		sort.add(new Club("b", "Club de Prueba2", "16/02/2019", "Dinosaurios"));
		sort.add(new Club("c", "Club de Prueba3", "16/03/2019", "Dinosaurios"));
		sort.add(new Club("d", "Club de Prueba4", "16/04/2019", "Dinosaurios"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));

		setupScenary8();
		list.orderClubsByDate();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByDateCase2() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/01/2019", "Dinosaurios"));
		sort.add(new Club("b", "Club de Prueba2", "16/02/2019", "Dinosaurios"));
		sort.add(new Club("c", "Club de Prueba3", "16/03/2019", "Dinosaurios"));
		sort.add(new Club("d", "Club de Prueba4", "16/04/2019", "Dinosaurios"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));

		setupScenary9();
		list.orderClubsByDate();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByDateCase3() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/01/2019", "Dinosaurios"));
		sort.add(new Club("b", "Club de Prueba2", "16/02/2019", "Dinosaurios"));
		sort.add(new Club("c", "Club de Prueba3", "16/03/2019", "Dinosaurios"));
		sort.add(new Club("d", "Club de Prueba4", "16/04/2019", "Dinosaurios"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "Dinosaurios"));

		setupScenary10();
		list.orderClubsByDate();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByPetCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
		sort.add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		sort.add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		sort.add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));

		setupScenary11();
		list.orderClubsByPet();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByPetCase2() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
		sort.add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		sort.add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		sort.add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));

		setupScenary12();
		list.orderClubsByPet();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByPetCase3() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
		sort.add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		sort.add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		sort.add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));

		setupScenary13();
		list.orderClubsByPet();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByNumberOwnersCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
		sort.add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		sort.add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		sort.add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));

		sort.get(4).registerOwner("123456789", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("223456789", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("789456123", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("456487989", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("564456456", "Dueño de Prueba", "x", "x", "x");

		sort.get(3).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(3).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		sort.get(3).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		sort.get(3).registerOwner("d", "Dueño de Prueba", "x", "x", "x");

		sort.get(2).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(2).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		sort.get(2).registerOwner("c", "Dueño de Prueba", "x", "x", "x");

		sort.get(1).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(1).registerOwner("b", "Dueño de Prueba", "x", "x", "x");

		sort.get(0).registerOwner("b", "Dueño de Prueba", "x", "x", "x");

		setupScenary14();
		list.orderClubsByNumberOwners();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByNumberOwnersCase2() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
		sort.add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		sort.add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		sort.add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));

		sort.get(4).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("2", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("d", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("e", "Dueño de Prueba", "x", "x", "x");

		sort.get(3).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(3).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		sort.get(3).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		sort.get(3).registerOwner("d", "Dueño de Prueba", "x", "x", "x");

		sort.get(2).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(2).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		sort.get(2).registerOwner("c", "Dueño de Prueba", "x", "x", "x");

		sort.get(1).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(1).registerOwner("b", "Dueño de Prueba", "x", "x", "x");

		sort.get(0).registerOwner("b", "Dueño de Prueba", "x", "x", "x");

		setupScenary15();
		list.orderClubsByNumberOwners();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderClubsByNumberOwnersCase3() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("a", "Club de Prueba1", "16/01/2019", "DinosauriosA"));
		sort.add(new Club("b", "Club de Prueba2", "16/02/2019", "DinosauriosB"));
		sort.add(new Club("c", "Club de Prueba3", "16/03/2019", "DinosauriosC"));
		sort.add(new Club("d", "Club de Prueba4", "16/04/2019", "DinosauriosD"));
		sort.add(new Club("e", "Club de Prueba5", "16/05/2019", "DinosauriosE"));

		sort.get(4).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("2", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("d", "Dueño de Prueba", "x", "x", "x");
		sort.get(4).registerOwner("e", "Dueño de Prueba", "x", "x", "x");

		sort.get(3).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(3).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		sort.get(3).registerOwner("c", "Dueño de Prueba", "x", "x", "x");
		sort.get(3).registerOwner("d", "Dueño de Prueba", "x", "x", "x");

		sort.get(2).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(2).registerOwner("b", "Dueño de Prueba", "x", "x", "x");
		sort.get(2).registerOwner("c", "Dueño de Prueba", "x", "x", "x");

		sort.get(1).registerOwner("a", "Dueño de Prueba", "x", "x", "x");
		sort.get(1).registerOwner("b", "Dueño de Prueba", "x", "x", "x");

		sort.get(0).registerOwner("b", "Dueño de Prueba", "x", "x", "x");

		setupScenary16();
		list.orderClubsByNumberOwners();
		assertEquals(sort.toString(), list.getClubs().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByIdCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("789878787", "Club de PruebaB", "16/02/2019", "DinosauriosB"));
		setupScenary17();
		String msg = list.secuencialSearchById("789878787");
		assertEquals(sort.get(0).toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByIdCase2() throws ElementExistsExcepcion {
		setupScenary17();
		String msg = list.secuencialSearchById("78dre5465r");
		assertEquals("No se encontro ningun club con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByIClubNameCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("789878787", "Club de PruebaB", "16/02/2019", "DinosauriosB"));
		setupScenary17();
		String msg = list.secuencialSearchByClubName("Club de pruebaB");
		assertEquals(sort.get(0).toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByClubNameCase2() throws ElementExistsExcepcion {
		setupScenary17();
		String msg = list.secuencialSearchByClubName("78dre5465r");
		assertEquals("No se encontro ningun club con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByIClubDateCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("789878787", "Club de PruebaB", "16/02/2019", "DinosauriosB"));
		setupScenary17();
		String msg = list.secuencialSearchByClubDate("16/02/2019");
		assertEquals(sort.get(0).toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByClubDateCase2() throws ElementExistsExcepcion {
		setupScenary17();
		String msg = list.secuencialSearchByClubDate("78dre5465r");
		assertEquals("No se encontro ningun club con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByPetCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("789878787", "Club de PruebaB", "16/02/2019", "DinosauriosB"));
		setupScenary17();
		String msg = list.secuencialSearchByPet("DinosauriosB");
		assertEquals(sort.get(0).toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByPetbDateCase2() throws ElementExistsExcepcion {
		setupScenary17();
		String msg = list.secuencialSearchByPet("78dre5465r");
		assertEquals("No se encontro ningun club con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByIdCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("789878787", "Club de PruebaB", "16/02/2019", "DinosauriosB"));
		setupScenary17();
		String msg = list.binarySearchById("789878787");
		assertEquals(sort.get(0).toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByIdCase2() throws ElementExistsExcepcion {
		setupScenary17();
		String msg = list.binarySearchById("78dre5465r");
		assertEquals("No se encontro ningun club con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByClubNameCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("789878787", "Club de PruebaB", "16/02/2019", "DinosauriosB"));
		setupScenary17();
		String msg = list.binarySearchByClubName("Club de PruebaB");
		assertEquals(sort.get(0).toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByClubNameCase2() throws ElementExistsExcepcion {
		setupScenary17();
		String msg = list.binarySearchByClubName("78dre5465r");
		assertEquals("No se encontro ningun club con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByClubDateCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("789878787", "Club de PruebaB", "16/02/2019", "DinosauriosB"));
		setupScenary17();
		String msg = list.binarySearchByClubDate("16/02/2019");
		assertEquals(sort.get(0).toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByClubDateCase2() throws ElementExistsExcepcion {
		setupScenary17();
		String msg = list.binarySearchByClubDate("16/05/2004");
		assertEquals("No se encontro ningun club con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByPetCase1() throws ElementExistsExcepcion {
		ArrayList<Club> sort = new ArrayList<Club>();
		sort.add(new Club("789878787", "Club de PruebaB", "16/02/2019", "DinosauriosB"));
		setupScenary17();
		String msg = list.binarySearchByPet("DinosauriosB");
		assertEquals(sort.get(0).toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByPetCase2() throws ElementExistsExcepcion {
		setupScenary17();
		String msg = list.binarySearchByPet("78dre5465r");
		assertEquals("No se encontro ningun club con los datos especificados", msg);
	}

}
