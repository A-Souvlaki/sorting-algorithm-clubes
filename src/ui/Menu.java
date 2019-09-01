/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Soluci�n laboratorio Unidad 2
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
		list = new ClubAdministration("Clubes.CSV");
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
				}
				break;
			case 5:
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
		System.out.println("2. Agregar un due�o a un club ");
		System.out.println("3. Agregar una mascota a un due�o");
		System.out.println("4. Mostrar lista ordenada de clubes");
		System.out.println("3. Eliminar mascota");
		System.out.println("4. Salir ");
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
		System.out.println("Se ha a�adido un club");

	}
	public void registerOwner() {
		System.out.println("Ingrese el id del club");
		String idClub = reader.nextLine();
		System.out.println("Ingrese el id del due�o");
		String id = reader.nextLine();
		System.out.println("Ingrese el nombre del due�o");
		String name = reader.nextLine();
		System.out.println("Ingrese los apellidos del due�o");
		String lastName = reader.nextLine();
		System.out.println("Ingrese su fecha de nacimiento");
		String birthDate= reader.nextLine();
		System.out.println("Ingrese su mascota favorita");
		String favoritePet= reader.nextLine();
		
		list.searchClub(idClub).registerOwner(id, name, lastName, birthDate, favoritePet);
		System.out.println("Se ha agregado un due�o");
	}
	
	public void registerPet() {
		System.out.println("Ingrese el id del club");
		String idClub = reader.nextLine();
		System.out.println("Ingrese el id del due�o buscado");
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
	
	public int showSubMenu1() {
		System.out.println("1. Ver listado ordenado por id ");
		System.out.println("2. Ver listado ordenado por nombres de los clubes");
		System.out.println("3. Ver listado ordenado por fecha de creacion");
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
	public static void main(String[] args) {

		Menu m = new Menu();
	}

}
