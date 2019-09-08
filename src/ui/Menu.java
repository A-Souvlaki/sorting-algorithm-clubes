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
import model.ElementExistsExcepcion;

public class Menu {

	private ClubAdministration list;
	private Scanner reader;

	public Menu() {
		reader = new Scanner(System.in);
		try {
			list = new ClubAdministration("Clubes.CSV","Serializable.dat","test.CSV","pets.CSV");
		} catch (ElementExistsExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				int valSubMenu = showSubMenu1();
				if(valSubMenu == 1) {
					list.orderClubsById();
					paint();
				}else if(valSubMenu == 2) {
					list.orderClubsByClubName();
					paint();
				}else if(valSubMenu == 3) {
					list.orderClubsByDate();
					paint();
				}else if(valSubMenu == 4) {
					list.orderClubsByPet();
					paint();
				}else if(valSubMenu == 5) {
					list.orderClubsByNumberOwners();
					paint();
				}
				break;
			case 5:
				System.out.println("Ingrese la id del club");
				String idClub = reader.nextLine();
				int valSubMenu2 = showSubMenu2();
				if(valSubMenu2 == 1) {
					list.searchClub(idClub).orderOwnersById();
					paintOwners(idClub);
				}else if(valSubMenu2 == 2) {
					list.searchClub(idClub).orderOwnersByName();
					paintOwners(idClub);
				}else if(valSubMenu2 == 3) {
					list.searchClub(idClub).orderOwnersByLastName();
					paintOwners(idClub);
				}else if(valSubMenu2 == 4) {
					list.searchClub(idClub).orderOwnersByDate();
					paintOwners(idClub);
				}else if(valSubMenu2 == 5) {
					list.searchClub(idClub).orderOwnersByPet();
					paintOwners(idClub);
				}else if(valSubMenu2 == 6) {
					list.searchClub(idClub).orderOwnersByPet();
					paintOwners(idClub);
				}		
				break;
			case 6:
				System.out.println("Ingrese la id del club");
				String idClubn = reader.nextLine();
				System.out.println("Ingrese el id del dueño buscado");
				String idOwner = reader.nextLine();
				int valSubMenu3 = showSubMenu3();
				if(valSubMenu3 == 1) {
					list.searchClub(idClubn).searchOwner(idOwner).orderPetsById();
					paintPets(idClubn, idOwner);
				}else if(valSubMenu3  == 2) {
					list.searchClub(idClubn).searchOwner(idOwner).orderPetsByName();
					paintPets(idClubn, idOwner);
				}else if(valSubMenu3 == 3) {
					list.searchClub(idClubn).searchOwner(idOwner).orderPetsByDate();
					paintPets(idClubn, idOwner);
				}else if(valSubMenu3 == 4) {
					list.searchClub(idClubn).searchOwner(idOwner).orderPetsByType();
					paintPets(idClubn, idOwner);
				}
				break;
			case 7:
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
		System.out.println("4. Mostrar lista ordenada de clubes");
		System.out.println("5. Mostrar lista ordenada de dueños");
		System.out.println("6. Mostrar lista ordenada de mascotas");
		System.out.println("7. Salir ");
		int value = 0;
		//Here I catch the exceptions
		try {
			value = reader.nextInt();
			reader.nextLine();
		}catch(InputMismatchException e) {
			reader.nextLine();
		}
		
		return value;
	}
	
	public void registerClub() {
		System.out.println("Ingrese el id del club");
		String id = reader.nextLine();
		System.out.println("Ingrese el nombre del club");
		String clubName = reader.nextLine();
		System.out.println("Ingrese la fecha de creacion del club");
		String dateCreation = reader.nextLine();
		System.out.println("Ingrese el tipo de mascotas que maneja el club");
		String petType = reader.nextLine();

		list.registerClub(id, clubName, dateCreation, petType);
		list.saveclubs();
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
		try {
			list.searchClub(idClub).registerOwner(id, name, lastName, birthDate, favoritePet);
		} catch (ElementExistsExcepcion e) {
			System.out.println(e.getMessage());
		}
		list.writeOwners("Serializable.dat");
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
		
		try {
			list.searchClub(idClub).searchOwner(idOwner).registerPet(id, petName, petBirthDay, gender, type);
		} catch (ElementExistsExcepcion e) {
			System.out.println(e.getMessage());
		}
		list.writeOwners("Serializable.dat");
	}
	
	public int showSubMenu1() {
		System.out.println("1. Ver listado ordenado por id ");
		System.out.println("2. Ver listado ordenado por nombres de los clubes");
		System.out.println("3. Ver listado ordenado por fecha de creacion");
		System.out.println("4. Ver listado ordenado por tipo de mascota");
		System.out.println("5. Ver listado ordenado por numero de dueños");
		int option = 0;
		try {
			option = reader.nextInt();
			reader.nextLine();
		}catch (Exception e) {
			// TODO: handle exception
		} 
		return option;
	}
	
	public int showSubMenu2() {
		System.out.println("1. Ver listado ordenado por id ");
		System.out.println("2. Ver listado ordenado por nombres de los dueños");
		System.out.println("3. Ver listado ordenado por apellidos de los dueños");
		System.out.println("4. Ver listado ordenado por fecha de nacimiento");
		System.out.println("5. Ver listado ordenado por tipo de mascota");
		System.out.println("6. Ver listado ordenado numero de mascotas");
		int option = 0;
		try {
			option = reader.nextInt();
			reader.nextLine();
		}catch (Exception e) {
			// TODO: handle exception
		} 
		return option;
	}
	
	public int showSubMenu3() {
		System.out.println("1. Ver listado ordenado por id ");
		System.out.println("2. Ver listado ordenado por nombres de las mascotas");
		System.out.println("3. Ver listado ordenado por fecha de nacimiento");
		System.out.println("4. Ver listado ordenado por tipo de mascota");
		int option = 0;
		try {
			option = reader.nextInt();
			reader.nextLine();
		}catch (Exception e) {
			// TODO: handle exception
		} 
		return option;
	}
	
	public void paint() {
		System.out.println(list.paint());
	}
	
	public void paintOwners(String idClub) {
		System.out.println(list.searchClub(idClub).paint());
	}
	
	public void paintPets(String idClubn,String idOwner) {
		System.out.println(list.searchClub(idClubn).searchOwner(idOwner).paint());
	}
	
	public static void main(String[] args) {

		Menu m = new Menu();
	}

}
