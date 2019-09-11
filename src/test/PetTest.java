package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Pet;

class PetTest {
	private Pet pet;

	private void setupScenary1() {
		pet = new Pet("B123456789", "Nombre de Mascota B", "12/05/2015", "Male", "Dinosauria B");
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareToTestCase1() {
		Pet p = new Pet("C123456789", "Nombre de Mascota C", "13/05/2015", "Male", "Dinosauria C");
		setupScenary1();
		int value = pet.compareTo(p);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareToTestCase2() {
		Pet p = new Pet("A123456789", "Nombre de Mascota A", "11/05/2015", "Male", "Dinosauria A");
		setupScenary1();
		int value = pet.compareTo(p);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareToTestCase3() {
		Pet p = new Pet("B123456789", "Nombre de Mascota B", "12/05/2015", "Male", "Dinosauria B");
		setupScenary1();
		int value = pet.compareTo(p);
		assertTrue(value == 0);
	}
	// _________________________________________________________________________________________________________//
	@Test
	void compareTestCase1() {
		Pet p = new Pet("C123456789", "Nombre de Mascota C", "13/05/2015", "Male", "Dinosauria C");
		setupScenary1();
		int value = pet.compare(pet, p);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareTestCase2() {
		Pet p = new Pet("A123456789", "Nombre de Mascota A", "11/05/2015", "Male", "Dinosauria A");
		setupScenary1();
		int value = pet.compare(pet, p);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareTestCase3() {
		Pet p = new Pet("B123456789", "Nombre de Mascota B", "12/05/2015", "Male", "Dinosauria B");
		setupScenary1();
		int value = pet.compare(pet, p);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateCase1() {
		Pet p = new Pet("C123456789", "Nombre de Mascota C", "13/05/2015", "Male", "Dinosauria C");
		setupScenary1();
		int value = pet.compareByDate(p);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateCase2() {
		Pet p = new Pet("A123456789", "Nombre de Mascota A", "11/05/2015", "Male", "Dinosauria A");
		setupScenary1();
		int value = pet.compareByDate(p);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateCase3() {
		Pet p = new Pet("B123456789", "Nombre de Mascota B", "12/05/2015", "Male", "Dinosauria B");
		setupScenary1();
		int value = pet.compareByDate(p);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByTypeCase1() {
		Pet p = new Pet("C123456789", "Nombre de Mascota C", "13/05/2015", "Male", "Dinosauria C");
		setupScenary1();
		int value = pet.compareByType(p);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetType2() {
		Pet p = new Pet("A123456789", "Nombre de Mascota A", "11/05/2015", "Male", "Dinosauria A");
		setupScenary1();
		int value = pet.compareByType(p);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByTypeCase3() {
		Pet p = new Pet("B123456789", "Nombre de Mascota B", "12/05/2015", "Male", "Dinosauria B");
		setupScenary1();
		int value = pet.compareByType(p);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByIdBSCase1() {
		setupScenary1();
		int value = pet.compareByIdBS("C123456789");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByIdBSCase2() {
		setupScenary1();
		int value = pet.compareByIdBS("A123456789");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByIdBSCase3() {
		setupScenary1();
		int value = pet.compareByIdBS("B123456789");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByNameBSCase1() {
		setupScenary1();
		int value = pet.compareByNameBS("Nombre de Mascota C");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByNameBSCase2() {
		setupScenary1();
		int value = pet.compareByNameBS("Nombre de Mascota A");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByNameBSCase3() {
		setupScenary1();
		int value = pet.compareByNameBS("Nombre de Mascota B");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateBSCase1() {
		setupScenary1();
		int value = pet.compareByDateBS("13/05/2015");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateBSCase2() {
		setupScenary1();
		int value = pet.compareByDateBS("11/05/2015");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateBSCase3() {
		setupScenary1();
		int value = pet.compareByDateBS("12/05/2015");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetBSCase1() {
		setupScenary1();
		int value = pet.compareByPetBS("Dinosauria C");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetBSCase2() {
		setupScenary1();
		int value = pet.compareByPetBS("Dinosauria A");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetBSCase3() {
		setupScenary1();
		int value = pet.compareByPetBS("Dinosauria B");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//

}
