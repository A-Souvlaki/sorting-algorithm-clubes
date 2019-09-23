package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Tecnica;

class TecnicaTest {
	private Tecnica t;
	
	private void setupScenary1() {
		t = new Tecnica("Uzugan", 9);
	}
	@Test
	void testCompareToCase1() {
		setupScenary1();
		Tecnica t1 = new Tecnica("Valdio",5);
		assertTrue(t.compareTo(t1)<0);
	}
	
	@Test
	void testCompareToCase2() {
		setupScenary1();
		Tecnica t1 = new Tecnica("Alma",5);
		assertTrue(t.compareTo(t1)>0);
	}
	@Test
	void testCompareToCase3() {
		setupScenary1();
		Tecnica t1 = new Tecnica("Uzugan",5);
		assertTrue(t.compareTo(t1)==0);
	}

}
