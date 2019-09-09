package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import model.ElementExistsExcepcion;
import model.Owner;
import model.Pet;

class OwnerTest {
	private Owner owner;

	private void setupScenary1() {
		owner = new Owner("C123456789", "Soy un DueñoC", "Tengo un apellido C", "16/05/2000", "DinosauriaC");
		owner.getPets().add(new Pet("AABCDEF", "MascotaA", "16/05/2015", "Male", "DinosaurioA"));
	}

	private void setupScenary2() {
		owner = new Owner("x", "y", "z", "i", "k");
		owner.getPets().add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));
		owner.getPets().add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		owner.getPets().add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
	}

	private void setupScenary3() {
		owner = new Owner("x", "y", "z", "i", "k");
		owner.getPets().add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		owner.getPets().add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		owner.getPets().add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));
	}

	private void setupScenary4() {
		owner = new Owner("x", "y", "z", "i", "k");
		owner.getPets().add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));
		owner.getPets().add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		owner.getPets().add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));

	}

	// _________________________________________________________________________________________________________//
	@Test
	void givePetTestCase1() {
		setupScenary1();
		assertTrue(owner.givePet("AABCDEF"));
	}

	// _________________________________________________________________________________________________________//
	@Test
	void givePetTestCase2() {
		setupScenary1();
		assertFalse(owner.givePet("984546545"));
	}

	// _________________________________________________________________________________________________________//
	@Test
	void registerPetTest() throws ElementExistsExcepcion {
		setupScenary1();
		owner.registerPet("1234567898", "x", "x", "x", "x");
		assertTrue((owner.getPets().size()) == 2);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareToTestCase1() {
		Owner o = new Owner("D123456789", "Soy un DueñoA", "Tengo un apellido A", "16/05/2000", "DinosauriaA");
		setupScenary1();
		int value = owner.compareTo(o);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareToTestCase2() {
		Owner o = new Owner("A123456789", "Soy un DueñoA", "Tengo un apellido A", "16/05/2000", "DinosauriaA");
		setupScenary1();
		int value = owner.compareTo(o);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareToTestCase3() {
		Owner o = new Owner("C123456789", "Soy un DueñoA", "Tengo un apellido A", "16/05/2000", "DinosauriaA");
		setupScenary1();
		int value = owner.compareTo(o);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareTestCase1() {
		Owner o = new Owner("D123456789", "Soy un DueñoD", "Tengo un apellido D", "16/05/2002", "DinosauriaD");
		setupScenary1();
		int value = owner.compare(owner, o);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareTestCase2() {
		Owner o = new Owner("A123456789", "Soy un DueñoA", "Tengo un apellido A", "16/05/1999", "DinosauriaA");
		setupScenary1();
		int value = owner.compare(owner, o);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareTestCase3() {
		Owner o = new Owner("C123456789", "Soy un DueñoC", "Tengo un apellido C", "16/05/2000", "DinosauriaC");
		setupScenary1();
		int value = owner.compare(owner, o);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByLastNameCase1() {
		Owner o = new Owner("D123456789", "Soy un DueñoD", "Tengo un apellido D", "16/05/2002", "DinosauriaD");
		setupScenary1();
		int value = owner.compareByLastName(o);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByLastNameCase2() {
		Owner o = new Owner("A123456789", "Soy un DueñoA", "Tengo un apellido A", "16/05/1999", "DinosauriaA");
		setupScenary1();
		int value = owner.compareByLastName(o);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByLastNameCase3() {
		Owner o = new Owner("C123456789", "Soy un DueñoC", "Tengo un apellido C", "16/05/2000", "DinosauriaC");
		setupScenary1();
		int value = owner.compareByLastName(o);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateCase1() {
		Owner o = new Owner("D123456789", "Soy un DueñoD", "Tengo un apellido D", "16/05/2002", "DinosauriaD");
		setupScenary1();
		int value = owner.compareByDate(o);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateCase2() {
		Owner o = new Owner("A123456789", "Soy un DueñoA", "Tengo un apellido A", "16/05/1999", "DinosauriaA");
		setupScenary1();
		int value = owner.compareByDate(o);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateCase3() {
		Owner o = new Owner("C123456789", "Soy un DueñoC", "Tengo un apellido C", "16/05/2000", "DinosauriaC");
		setupScenary1();
		int value = owner.compareByDate(o);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetCase1() {
		Owner o = new Owner("D123456789", "Soy un DueñoD", "Tengo un apellido D", "16/05/2002", "DinosauriaD");
		setupScenary1();
		int value = owner.compareByPet(o);
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetCase2() {
		Owner o = new Owner("A123456789", "Soy un DueñoA", "Tengo un apellido A", "16/05/1999", "DinosauriaA");
		setupScenary1();
		int value = owner.compareByPet(o);
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetCase3() {
		Owner o = new Owner("C123456789", "Soy un DueñoC", "Tengo un apellido C", "16/05/2000", "DinosauriaC");
		setupScenary1();
		int value = owner.compareByPet(o);
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByIdBSCase1() {
		setupScenary1();
		int value = owner.compareByIdBS("D123456789");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByIdBSCase2() {
		setupScenary1();
		int value = owner.compareByIdBS("A123456789");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByIdBSCase3() {
		setupScenary1();
		int value = owner.compareByIdBS("C123456789");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByNameBSCase1() {
		setupScenary1();
		int value = owner.compareByNameBS("Soy un DueñoD");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByNameBSCase2() {
		setupScenary1();
		int value = owner.compareByNameBS("Soy un DueñoA");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByNameBSCase3() {
		setupScenary1();
		int value = owner.compareByNameBS("Soy un DueñoC");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByLastNameBSCase1() {
		setupScenary1();
		int value = owner.compareByLastNameBS("Tengo un apellido D");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByLastNameBSCase2() {
		setupScenary1();
		int value = owner.compareByLastNameBS("Tengo un apellido A");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByLastNameBSCase3() {
		setupScenary1();
		int value = owner.compareByLastNameBS("Tengo un apellido C");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateBSCase1() {
		setupScenary1();
		int value = owner.compareByDateBS("16/05/2002");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateBSCase2() {
		setupScenary1();
		int value = owner.compareByDateBS("16/05/1999");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByDateBSCase3() {
		setupScenary1();
		int value = owner.compareByDateBS("16/05/2000");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetBSCase1() {
		setupScenary1();
		int value = owner.compareByPetBS("DinosauriaD");
		assertTrue(value < 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetBSCase2() {
		setupScenary1();
		int value = owner.compareByPetBS("DinosauriaA");
		assertTrue(value > 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void compareByPetBSCase3() {
		setupScenary1();
		int value = owner.compareByPetBS("DinosauriaC");
		assertTrue(value == 0);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByIdCase1() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));

		setupScenary2();
		owner.orderPetsById();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByIdCase2() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));

		setupScenary3();
		owner.orderPetsById();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByIdCase3() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));

		setupScenary4();
		owner.orderPetsById();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByNameCase1() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));

		setupScenary2();
		owner.orderPetsByName();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByNameCase2() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));

		setupScenary3();
		owner.orderPetsByName();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByNameCase3() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));

		setupScenary4();
		owner.orderPetsByName();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByDateCase1() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));

		setupScenary2();
		owner.orderPetsByDate();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByDateCase2() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));

		setupScenary3();
		owner.orderPetsByDate();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByDateCase3() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));

		setupScenary4();
		owner.orderPetsByDate();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByPetCase1() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));

		setupScenary2();
		owner.orderPetsByType();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByPetCase2() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));

		setupScenary3();
		owner.orderPetsByType();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void orderPetsByPetCase3() {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet("AABCDE", "Me llamo A", "14/05/2006", "Male", "Tipo A"));
		pets.add(new Pet("BABCDE", "Me llamo B", "16/05/2006", "Male", "Tipo B"));
		pets.add(new Pet("CABCDE", "Me llamo C", "15/05/2006", "Male", "Tipo C"));

		setupScenary4();
		owner.orderPetsByType();
		assertEquals(pets.toString(), owner.getPets().toString());
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByIdCase1() {
		Pet pet = new Pet("AABCDEF", "MascotaA", "16/05/2015", "Male", "DinosaurioA");
		setupScenary1();
		String msg = owner.secuencialSearchById("AABCDEF");
		assertEquals(pet.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByIdCase2() {
		setupScenary1();
		String msg = owner.secuencialSearchById("78dre5465r");
		assertEquals("No se encontro ninguna mascota con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByNameCase1() {
		Pet pet = new Pet("AABCDEF", "MascotaA", "16/05/2015", "Male", "DinosaurioA");
		setupScenary1();
		String msg = owner.secuencialSearchByName("MascotaA");
		assertEquals(pet.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByNameCase2() {
		setupScenary1();
		String msg = owner.secuencialSearchByName("78dre5465r");
		assertEquals("No se encontro ninguna mascota con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByDateCase1() {
		Pet pet = new Pet("AABCDEF", "MascotaA", "16/05/2015", "Male", "DinosaurioA");
		setupScenary1();
		String msg = owner.secuencialSearchByDate("16/05/2015");
		assertEquals(pet.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByDateCase2() {
		setupScenary1();
		String msg = owner.secuencialSearchByDate("15/04/2004");
		assertEquals("No se encontro ninguna mascota con los datos especificados", msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByTypeCase1() {
		Pet pet = new Pet("AABCDEF", "MascotaA", "16/05/2015", "Male", "DinosaurioA");
		setupScenary1();
		String msg = owner.secuencialSearchByPet("DinosaurioA");
		assertEquals(pet.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void secuencialSearchByTypeCase2() {
		setupScenary1();
		String msg = owner.secuencialSearchByPet("15/04/2004");
		assertEquals("No se encontro ninguna mascota con los datos especificados", msg);
	}
	// _________________________________________________________________________________________________________//

	@Test
	void binarySearchByIdCase1() {
		Pet pet = new Pet("AABCDEF", "MascotaA", "16/05/2015", "Male", "DinosaurioA");
		setupScenary1();
		String msg = owner.binarySearchById("AABCDEF");
		assertEquals(pet.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByIdCase2() {
		setupScenary1();
		String msg = owner.binarySearchById("78dre5465r");
		assertEquals("No se encontro ninguna mascota con los datos especificados", msg);
	}
	// _________________________________________________________________________________________________________//

	@Test
	void binarySearchByNameCase1() {
		Pet pet = new Pet("AABCDEF", "MascotaA", "16/05/2015", "Male", "DinosaurioA");
		setupScenary1();
		String msg = owner.binarySearchByName("MascotaA");
		assertEquals(pet.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByNameCase2() {
		setupScenary1();
		String msg = owner.binarySearchByName("78dre5465r");
		assertEquals("No se encontro ninguna mascota con los datos especificados", msg);
	}
	// _________________________________________________________________________________________________________//

	@Test
	void binarySearchByDateCase1() {
		Pet pet = new Pet("AABCDEF", "MascotaA", "16/05/2015", "Male", "DinosaurioA");
		setupScenary1();
		String msg = owner.binarySearchByDate("16/05/2015");
		assertEquals(pet.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByDateCase2() {
		setupScenary1();
		String msg = owner.binarySearchByDate("16/06/2015");
		assertEquals("No se encontro ninguna mascota con los datos especificados", msg);
	}
	
	// _________________________________________________________________________________________________________//

	@Test
	void binarySearchByTypeCase1() {
		Pet pet = new Pet("AABCDEF", "MascotaA", "16/05/2015", "Male", "DinosaurioA");
		setupScenary1();
		String msg = owner.binarySearchByPet("DinosaurioA");
		assertEquals(pet.toString(), msg);
	}

	// _________________________________________________________________________________________________________//
	@Test
	void binarySearchByTypeCase2() {
		setupScenary1();
		String msg = owner.binarySearchByPet("asdasdsad");
		assertEquals("No se encontro ninguna mascota con los datos especificados", msg);
	}

}
