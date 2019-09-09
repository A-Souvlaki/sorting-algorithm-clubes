package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Club;
import model.ElementExistsExcepcion;
import model.Owner;

class ClubTest {
	private Club club;

	private void setupScenary1() {
		club = new Club("C123456789", "CSoy un comparador", "16/05/2019", "CDinosaurios");
		club.getOwners().add(new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA"));

	}

	private void setupScenary2() {
		club = new Club("x", "y", "w", "v");
		club.getOwners().add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
		club.getOwners().add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		club.getOwners().add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
	}

	private void setupScenary3() {
		club = new Club("x", "y", "w", "v");
		club.getOwners().add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		club.getOwners().add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		club.getOwners().add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
	}

	private void setupScenary4() {
		club = new Club("x", "y", "w", "v");
		club.getOwners().add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
		club.getOwners().add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		club.getOwners().add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
	}

	private void setupScenary5() throws ElementExistsExcepcion {
		club = new Club("x", "y", "w", "v");
		club.getOwners().add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
		club.getOwners().add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		club.getOwners().add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));

		club.getOwners().get(0).registerPet("X", "ABCD", "Y", "Y", "Y");
		club.getOwners().get(0).registerPet("X", "ERSA", "Y", "Y", "Y");
		club.getOwners().get(0).registerPet("X", "ASDS", "Y", "Y", "Y");

		club.getOwners().get(1).registerPet("X", "ERSA", "Y", "Y", "Y");

		club.getOwners().get(2).registerPet("X", "ERSA", "Y", "Y", "Y");
		club.getOwners().get(2).registerPet("X", "ASDS", "Y", "Y", "Y");

	}

	private void setupScenary6() throws ElementExistsExcepcion {
		club = new Club("x", "y", "w", "v");
		club.getOwners().add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		club.getOwners().add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		club.getOwners().add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		club.getOwners().get(0).registerPet("X", "ERSA", "Y", "Y", "Y");
		club.getOwners().get(1).registerPet("X", "ERSA", "Y", "Y", "Y");
		club.getOwners().get(1).registerPet("X", "ASDS", "Y", "Y", "Y");
		club.getOwners().get(2).registerPet("X", "ABCD", "Y", "Y", "Y");
		club.getOwners().get(2).registerPet("X", "ERSA", "Y", "Y", "Y");
		club.getOwners().get(2).registerPet("X", "ASDS", "Y", "Y", "Y");
	}

	private void setupScenary7() throws ElementExistsExcepcion {
		club = new Club("x", "y", "w", "v");
		club.getOwners().add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
		club.getOwners().add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		club.getOwners().add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		club.getOwners().get(0).registerPet("X", "ABCD", "Y", "Y", "Y");
		club.getOwners().get(0).registerPet("X", "ERSA", "Y", "Y", "Y");
		club.getOwners().get(0).registerPet("X", "ASDS", "Y", "Y", "Y");

		club.getOwners().get(1).registerPet("X", "ERSA", "Y", "Y", "Y");
		club.getOwners().get(1).registerPet("X", "ASDS", "Y", "Y", "Y");

		club.getOwners().get(2).registerPet("X", "ASDS", "Y", "Y", "Y");
	}

	// _________________________________________________________________________________________________________//
	@Test
	void giveOwnerTestCase1() {
		setupScenary1();
		assertTrue(club.giveOwner("7894561235"));
	}

	// _________________________________________________________________________________________________________//
	@Test
	void giveOwnerTestCase2() {
		setupScenary1();
		assertFalse(club.giveOwner("984546545"));
	}

	// _________________________________________________________________________________________________________//
	@Test
	void registerOwnerTest() throws ElementExistsExcepcion {
		setupScenary1();
		club.registerOwner("1234567898", "x", "x", "x", "x");
		assertTrue((club.getOwners().size()) == 2);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void searchOwnerTestCase1() {
		setupScenary1();
		assertNotNull(club.searchOwner("7894561235"));
	}

	// _________________________________________________________________________________________________________//
	@Test
	void searchOwnerTestCase2() {
		setupScenary1();
		assertNull(club.searchOwner("7sadsads"));
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareToTestCase1() {
		Club c = new Club("D123456789", "DSoy un comparador", "Una fecha", "Una mascota");
		setupScenary1();
		int value = club.compareTo(c);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareToTestCase2() {
		Club c = new Club("A123456789", "ASoy un comparador", "Una fecha", "Una mascota");
		setupScenary1();
		int value = club.compareTo(c);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareToTestCase3() {
		Club c = new Club("C123456789", "CSoy un comparador", "Una fecha", "Una mascota");
		setupScenary1();
		int value = club.compareTo(c);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareTestCase1() {
		Club c = new Club("D123456789", "DSoy un comparador", "Una fecha", "Una mascota");
		setupScenary1();
		int value = club.compare(club, c);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareTestCase2() {
		Club c = new Club("A123456789", "ASoy un comparador", "Una fecha", "Una mascota");
		setupScenary1();
		int value = club.compare(club, c);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareTestCase3() {
		Club c = new Club("C123456789", "CSoy un comparador", "Una fecha", "Una mascota");
		setupScenary1();
		int value = club.compare(club, c);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateCase1() {
		Club c = new Club("D123456789", "DSoy un comparador", "12/12/2019", "Una mascota");
		setupScenary1();
		int value = club.compareByDate(c);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateCase2() {
		Club c = new Club("A123456789", "ASoy un comparador", "14/04/2015", "Una mascota");
		setupScenary1();
		int value = club.compareByDate(c);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateCase3() {
		Club c = new Club("C123456789", "CSoy un comparador", "16/05/2019", "CUna mascota");
		setupScenary1();
		int value = club.compareByDate(c);
		assertTrue(value == 0);
	}
	// _________________________________________________________________________________________________________//

	@Test
	void compareByPetCase1() {
		Club c = new Club("D123456789", "DSoy un comparador", "12/12/2019", "DDinosaurios");
		setupScenary1();
		int value = club.compareByPet(c);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetCase2() {
		Club c = new Club("A123456789", "ASoy un comparador", "14/04/2015", "ADinosaurios");
		setupScenary1();
		int value = club.compareByPet(c);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetCase3() {
		Club c = new Club("C123456789", "CSoy un comparador", "16/05/2019", "CDinosaurios");
		setupScenary1();
		int value = club.compareByPet(c);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByIdBSCase1() {
		setupScenary1();
		int value = club.compareByIdBS("D123456789");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByIdBSCase2() {
		setupScenary1();
		int value = club.compareByIdBS("A123456789");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByIdBSCase3() {
		setupScenary1();
		int value = club.compareByIdBS("C123456789");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByNameBSCase1() {
		setupScenary1();
		int value = club.compareByNameBS("DSoy un comparador");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByNameBSCase2() {
		setupScenary1();
		int value = club.compareByNameBS("ASoy un comparador");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByNameBSCase3() {
		setupScenary1();
		int value = club.compareByNameBS("CSoy un comparador");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateBSCase1() {
		setupScenary1();
		int value = club.compareByDateBS("12/12/2019");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateBSCase2() {
		setupScenary1();
		int value = club.compareByDateBS("14/04/2015");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateBSCase3() {
		setupScenary1();
		int value = club.compareByDateBS("16/05/2019");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetBSCase1() {
		setupScenary1();
		int value = club.compareByPetBS("DDinosaurios");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetBSCase2() {
		setupScenary1();
		int value = club.compareByPetBS("ADinosaurios");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetBSCase3() {
		setupScenary1();
		int value = club.compareByPetBS("CDinosaurios");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByIdCase1() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary2();
		club.orderOwnersById();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByIdCase2() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary3();
		club.orderOwnersById();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByIdCase3() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary4();
		club.orderOwnersById();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByNameCase1() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary2();
		club.orderOwnersByName();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByNameCase2() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary3();
		club.orderOwnersByName();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByNameCase3() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary4();
		club.orderOwnersByName();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByLastNameCase1() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary2();
		club.orderOwnersByLastName();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByLastNameCase2() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary3();
		club.orderOwnersByLastName();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByLastNameCase3() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary4();
		club.orderOwnersByLastName();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByDateCase1() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		setupScenary2();
		club.orderOwnersByDate();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByDateCase2() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));

		setupScenary3();
		club.orderOwnersByDate();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByDateCase3() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));

		setupScenary4();
		club.orderOwnersByDate();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByPetCase1() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary2();
		club.orderOwnersByPet();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByPetCase2() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary3();
		club.orderOwnersByPet();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByPetCase3() {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));

		setupScenary4();
		club.orderOwnersByPet();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByNumberPetsCase1() throws ElementExistsExcepcion {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
		
		owners.get(0).registerPet("X", "ERSA", "Y", "Y", "Y");
		owners.get(1).registerPet("X", "ERSA", "Y", "Y", "Y");
		owners.get(1).registerPet("X", "ASDS", "Y", "Y", "Y");
		owners.get(2).registerPet("X", "ABCD", "Y", "Y", "Y");
		owners.get(2).registerPet("X", "ERSA", "Y", "Y", "Y");
		owners.get(2).registerPet("X", "ASDS", "Y", "Y", "Y");

		setupScenary5();
		club.orderOwnersByNumberPets();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByNumberPetsCase2() throws ElementExistsExcepcion {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
		owners.get(0).registerPet("X", "ERSA", "Y", "Y", "Y");
		owners.get(1).registerPet("X", "ERSA", "Y", "Y", "Y");
		owners.get(1).registerPet("X", "ASDS", "Y", "Y", "Y");
		owners.get(2).registerPet("X", "ABCD", "Y", "Y", "Y");
		owners.get(2).registerPet("X", "ERSA", "Y", "Y", "Y");
		owners.get(2).registerPet("X", "ASDS", "Y", "Y", "Y");

		setupScenary6();
		club.orderOwnersByNumberPets();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderOwnersByNumberPetsCase3() throws ElementExistsExcepcion {
		ArrayList<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner("AABCDE", "Dueño A", "Apellido A", "18/05/2001", "Dinosaurio A"));
		owners.add(new Owner("BABCDE", "Dueño B", "Apellido B", "20/05/2001", "Dinosaurio B"));
		owners.add(new Owner("CABCDE", "Dueño C", "Apellido C", "19/05/2001", "Dinosaurio C"));
		owners.get(0).registerPet("X", "ERSA", "Y", "Y", "Y");
		owners.get(1).registerPet("X", "ERSA", "Y", "Y", "Y");
		owners.get(1).registerPet("X", "ASDS", "Y", "Y", "Y");
		owners.get(2).registerPet("X", "ABCD", "Y", "Y", "Y");
		owners.get(2).registerPet("X", "ERSA", "Y", "Y", "Y");
		owners.get(2).registerPet("X", "ASDS", "Y", "Y", "Y");

		setupScenary7();
		club.orderOwnersByNumberPets();
		assertEquals(owners.toString(), club.getOwners().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByIdCase1()  {
		Owner owner = new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA");
		setupScenary1();
		String msg = club.secuencialSearchById("7894561235");
		assertEquals(owner.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByIdCase2()  {
		
		setupScenary1();
		String msg = club.secuencialSearchById("78dre5465r");
		assertEquals("No se encontro ningun dueño con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByINameCase1()  {
		Owner owner = new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA");
		setupScenary1();
		String msg = club.secuencialSearchByName("Sujeto A");
		assertEquals(owner.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByNameCase2()  {
		setupScenary1();
		String msg = club.secuencialSearchByName("78dre5465r");
		assertEquals("No se encontro ningun dueño con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByLastNameCase1()  {
		Owner owner = new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA");
		setupScenary1();
		String msg = club.secuencialSearchByLastName("ApellidoA");
		assertEquals(owner.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByLastNameCase2()  {
		setupScenary1();
		String msg = club.secuencialSearchByLastName("78dre5465r");
		assertEquals("No se encontro ningun dueño con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByIOwnerDateCase1()  {
		Owner owner = new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA");
		setupScenary1();
		String msg = club.secuencialSearchByOwnerDate("19/05/1995");
		assertEquals(owner.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByOwnerDateCase2()  {
		setupScenary1();
		String msg = club.secuencialSearchByOwnerDate("78dre5465r");
		assertEquals("No se encontro ningun dueño con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByPetCase1()  {
		Owner owner = new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA");
		setupScenary1();
		String msg = club.secuencialSearchByPet("DinosauriaA");
		assertEquals(owner.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByPetCase2()  {
		setupScenary1();
		String msg = club.secuencialSearchByPet("78dre5465r");
		assertEquals("No se encontro ningun dueño con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//

	@Test
	void binarySearchByIdCase1()  {
		Owner owner = new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA");
		setupScenary1();
		String msg = club.binarySearchById("7894561235");
		assertEquals(owner.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByIdCase2()  {
		setupScenary1();
		String msg = club.binarySearchById("78dre5465r");
		assertEquals("No se encontro ningun dueño con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByNameCase1()  {
		Owner owner = new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA");
		setupScenary1();
		String msg = club.binarySearchByName("Sujeto A");
		assertEquals(owner.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByNameCase2()  {
		setupScenary1();
		String msg = club.binarySearchByName("78dre5465r");
		assertEquals("No se encontro ningun dueño con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByLastNameCase1() {
		Owner owner = new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA");
		setupScenary1();
		String msg = club.binarySearchByLastName("ApellidoA");
		assertEquals(owner.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByLastNameCase2() {
		setupScenary1();
		String msg = club.binarySearchByLastName("78dre5465r");
		assertEquals("No se encontro ningun dueño con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByOwnerDateCase1()  {
		Owner owner = new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA");
		setupScenary1();
		String msg = club.binarySearchByDate("19/05/1995");
		assertEquals(owner.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByOwnerDateCase2()  {
		setupScenary1();
		String msg = club.binarySearchByDate("16/05/2004");
		assertEquals("No se encontro ningun dueño con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByPetCase1()  {
		Owner owner = new Owner("7894561235", "Sujeto A", "ApellidoA", "19/05/1995", "DinosauriaA");
		setupScenary1();
		String msg = club.binarySearchByPet("DinosauriaA");
		assertEquals(owner.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByPetCase2()  {
		setupScenary1();
		String msg = club.binarySearchByPet("78dre5465r");
		assertEquals("No se encontro ningun dueño con los datos especificados", msg);
	}

}
