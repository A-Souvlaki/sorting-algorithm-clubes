/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Solución laboratorio Unidad 2
 * @author Cristian Rivadeneira - josepthcamilo@gmail.com
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

import java.io.*;
import java.text.SimpleDateFormat;

import model.ClubAdministration;

public class Menu {

	private ClubAdministration list;
	private Scanner reader;

	public Menu() {
		reader = new Scanner(System.in);
		list = new ClubAdministration("Clubes.txt");
		systemOperation();
	}

	public void systemOperation() {
		boolean close = false;

		while (!close) {
			int userValue = menuSystem();
			switch (userValue) {
			case 1:
				registerClub();
				break;
			case 2:
				registerOwner();
				break;
			case 3:
				registerPet();
				break;
			case 4:
				close = true;
				break;
			default:
				break;
			}

		}

	}

	public int menuSystem() {
		System.out.println("Elije una opcion :)");
		System.out.println("1. Registrar un club ");
		System.out.println("2. Agregar un dueño a un club ");
		System.out.println("3. Agregar una mascota a un dueño");
		System.out.println("3. Eliminar dueño");
		System.out.println("3. Eliminar mascota");
		System.out.println("4. Salir ");
		int value = 0;
		//En caso de que se ingrese un valor no valido, estas declaraciones permiten atrapar la excepcion...
		try {
			value = reader.nextInt();
			reader.nextLine();
		}catch(InputMismatchException e) {
			reader.nextLine();
		}
		
		return value;
	}

	public String petType() {
		System.out.println("1. Perros");
		System.out.println("2. Gatos");
		System.out.println("3. Reptiles y Dinosaurios");
		System.out.println("4. Otro");

		String type = reader.nextLine();

		return type;
	}

	public void registerClub() {
		System.out.println("Ingrese el id del club");
		String id = reader.nextLine();
		System.out.println("Ingrese el nombre del club");
		String clubName = reader.nextLine();
		System.out.println("Ingrese la fecha de creacion del club");
		String dateCreation = reader.nextLine();
		System.out.println("Ingrese el tipo de mascotas que maneja el club");
		String petType = petType();

		list.registerClub(id, clubName, dateCreation, petType);
		System.out.println("Se ha añadido un club");

	}
	public void registerOwner() {
		System.out.println("Ingrese el id del club");
		String idClub = reader.nextLine();
		System.out.println("Ingrese el id del dueño");
		String id = reader.nextLine();
		System.out.println("Ingrese el nombre del dueño");
		String name = reader.nextLine();
		System.out.println("Ingrese los apellidos del dueño");
		String lastName = reader.nextLine();
		System.out.println("Ingrese su fecha de nacimiento");
		String birthDate= reader.nextLine();
		System.out.println("Ingrese su mascota favorita");
		String favoritePet= reader.nextLine();
		
		list.searchClub(idClub).registerOwner(id, name, lastName, birthDate, favoritePet);
		System.out.println("Se ha agregado un dueño");
	}
	
	public void registerPet() {
		System.out.println("Ingrese el id del club");
		String idClub = reader.nextLine();
		System.out.println("Ingrese el id del dueño buscado");
		String idOwner = reader.nextLine();
		System.out.println("Ingrese el id de la mascota");
		String id = reader.nextLine();
		System.out.println("Ingrese el nombre de la mascota");
		String petName = reader.nextLine();
		System.out.println("Ingrese la fecha de nacimiento");
		String petBirthDay = reader.nextLine();
		System.out.println("Ingrese el genero de la mascota");
		String gender = reader.nextLine();
		System.out.println("Ingrese el tipo de mascota");
		String type = reader.nextLine(); 
		
		list.searchClub(idClub).searchOwner(idOwner).registerPet(id, petName, petBirthDay, gender, type);
		
		
	}
	public static void main(String[] args) {

		Menu m = new Menu();
	}

}
