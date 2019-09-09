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
			list = new ClubAdministration("files\\Clubes.CSV","files\\Serializable.dat","files\\test.CSV","files\\pets.CSV");
		} catch (ElementExistsExcepcion e) {
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
				orderClubs();
				break;
			case 5:
				orderOwners();		
				break;
			case 6:
				orderPets();
				break;
			case 7:
				orderByNumberOwners();
				break;
			case 8:
				orderByNumberPets();
				break;
			case 9:
				System.out.println("Ingrese lo que desea buscar: ");
				String data7 = reader.nextLine();
				searchClubs(data7);
				break;
			case 10:
				System.out.println("Ingrese lo que desea buscar: ");
				String data8 = reader.nextLine();
				searchOwners(data8);
				break;
			case 11:
				System.out.println("Ingrese lo que desea buscar: ");
				String data9 = reader.nextLine();
				searchPets(data9);
				break;
			case 12:
				deleteClub();
				list.saveclubs();
				break;
			case 13:
				deleteOwner();
				list.writeOwners("files\\Serializable.dat");
				break;
			case 14:
				deletePet();
				list.writeOwners("files\\Serializable.dat");
				break;
			case 0:
				close = true;
				break;
			default:
				break;
			}

		}

	}

	public int menuSystem() {
		System.out.println("\nElije una opcion :)");
		System.out.println(String.format("%1$-8s","1.  Registrar un club "));
		System.out.println(String.format("%1$-8s","2.  Agregar un dueño a un club "));
		System.out.println(String.format("%1$-8s","3.  Agregar una mascota a un dueño"));
		System.out.println(String.format("%1$-8s","4.  Mostrar lista ordenada de clubes"));
		System.out.println(String.format("%1$-8s","5.  Mostrar lista ordenada de dueños"));
		System.out.println(String.format("%1$-8s","6.  Mostrar lista ordenada de mascotas"));
		System.out.println(String.format("%1$-8s","7.  Mostrar lista ordenada de clubes segun numero de dueños"));
		System.out.println(String.format("%1$-8s","8.  Mostrar lista ordenada de dueños segun numero de mascotas"));
		System.out.println(String.format("%1$-8s","9.  Buscar un club"));
		System.out.println(String.format("%1$-8s","10. Buscar un dueño"));
		System.out.println(String.format("%1$-8s","11. Buscar una mascota"));
		System.out.println(String.format("%1$-8s","12. Eliminar un Club"));
		System.out.println(String.format("%1$-8s","13. Eliminar un Dueño"));
		System.out.println(String.format("%1$-8s","14. Eliminar una Mascota"));
		System.out.println(String.format("%1$-8s","0.  Salir "));
		int value = 0;
		//Here I catch the exceptions
		try {
			value = reader.nextInt();
			reader.nextLine();
			if(value <= -1 || value > 14) {
				throw new OutOfRangeExcepcion("\"Por favor digite una opcion valida :)...O tu windows se cerrara\"");
			}
		}catch(InputMismatchException e) {
			System.out.println("Por favor digite una opcion valida :)...O tu windows se cerrara");
			reader.nextLine();
			
		} catch (OutOfRangeExcepcion e) {
			System.out.println(e.getMessage());
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
			list.writeOwners("files\\Serializable.dat");
			System.out.println("Se ha agregado un dueño");
		} catch(ElementExistsExcepcion e) {
			System.out.println(e.getMessage());
		} catch(NullPointerException e) {
			System.out.println("Ha ingresado un dato que no existe en los registros, por favor revise el registro de error");
			System.out.println("Se anulo el registro");
			System.out.println("Error: NullPointerExcepcion");
		}
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
			list.writeOwners("files\\Serializable.dat");
			System.out.println("Se ha agregado una mascota");
		} catch (ElementExistsExcepcion e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Ha ingresado un dato que no existe en los registros, por favor revise el registro de error");
			System.out.println("Se anulo el registro");
			System.out.println("Error: NullPointerExcepcion");
		}
		
	}
	
	public int showSubMenu1() {
		System.out.println("1. Ver listado ordenado/Buscar por id ");
		System.out.println("2. Ver listado ordenado/Buscar por nombres de los clubes");
		System.out.println("3. Ver listado ordenado/Buscar por fecha de creacion");
		System.out.println("4. Ver listado ordenado/Buscar por tipo de mascota");
		int option = 0;
		try {
			option = reader.nextInt();
			reader.nextLine();
			if(option <= -1 ||option > 4) {
				throw new OutOfRangeExcepcion("Has ingresado un valor que no corresponde a los permitidos por el menu");
			}
		} catch (InputMismatchException e) {
			System.out.println("Has digitado un valor invalido, por favor intenta de nuevo");
		} catch(OutOfRangeExcepcion e) {
			System.out.println(e.getMessage());
		}
		return option;
	}
	
	public int showSubMenu2() {
		System.out.println("1. Ver listado ordenado/Buscar por id ");
		System.out.println("2. Ver listado ordenado/Buscar por nombres de los dueños");
		System.out.println("3. Ver listado ordenado/Buscar por apellidos de los dueños");
		System.out.println("4. Ver listado ordenado/Buscar por fecha de nacimiento");
		System.out.println("5. Ver listado ordenado/Buscar por tipo de mascota");
		int option = 0;
		try {
			option = reader.nextInt();
			reader.nextLine();
			if(option <= -1 ||option > 6) {
				throw new OutOfRangeExcepcion("Has ingresado un valor que no corresponde a los permitidos por el menu");
			}
			
		}catch (InputMismatchException e) {
			System.out.println("Has digitado un valor invalido, por favor intenta de nuevo");
			menuSystem();
			
		}catch(OutOfRangeExcepcion e) {
			System.out.println(e.getMessage());
			menuSystem();
		}
		return option;
	}
	
	public int showSubMenu3() {
		System.out.println("1. Ver listado ordenado por/Buscar id ");
		System.out.println("2. Ver listado ordenado por/Buscar nombres de las mascotas");
		System.out.println("3. Ver listado ordenado por/Buscar fecha de nacimiento");
		System.out.println("4. Ver listado ordenado por/Buscar tipo de mascota");
		int option = 0;
		try {
			option = reader.nextInt();
			reader.nextLine();
			if(option <= -1 || option > 4) {
				throw new OutOfRangeExcepcion("Has ingresado un valor que no corresponde a los permitidos por el menu");
			}
		}catch (InputMismatchException e) {
			System.out.println("Has digitado un valor invalido, por favor intenta de nuevo");
			menuSystem();
			
		}catch(OutOfRangeExcepcion e) {
			System.out.println(e.getMessage());
			menuSystem();
		}
		return option;
	}
	
	public int showSubMenu4() {
		System.out.println("Elija como desea eliminar");
		System.out.println("1. Eliminar por id ");
		System.out.println("2. Eliminar por nombre");
		int option = 0;
		try {
			option = reader.nextInt();
			reader.nextLine();
			if(option <= -1 || option > 2) {
				throw new OutOfRangeExcepcion("Has ingresado un valor que no corresponde a los permitidos por el menu");
			}
		}catch (InputMismatchException e) {
			System.out.println("Has digitado un valor invalido, por favor intenta de nuevo");
			menuSystem();
			
		}catch(OutOfRangeExcepcion e) {
			System.out.println(e.getMessage());
			menuSystem();
		}
		return option;
	}
	
	public void deleteClub() {
		int value = showSubMenu4();
		if(value == 1) {
			System.out.println("Ingrese la identificacion del club que desea eliminar");
			String identification = reader.nextLine();
			System.out.println(list.deleteClubById(identification));
		}else if(value == 2){
			System.out.println("Ingrese el nombre del club que desea eliminar");
			String name = reader.nextLine();
			System.out.println(list.deleteClubByName(name));
		}
	}
	
	public void deleteOwner() {
		int value = showSubMenu4();
		try {
			if(value == 1) {
				System.out.println("Ingrese la identificacion de un club");
				String identification = reader.nextLine();
				System.out.println("Ingrese la identificacion del dueño que contiene la mascota que desea eliminar");
				String idOwner = reader.nextLine();
				System.out.println(list.searchClub(identification).deleteOwnerById(idOwner));
			}else if(value == 2){
				System.out.println("Ingrese la identificacion de un club");
				String identification = reader.nextLine();
				System.out.println("Ingrese el nombre del dueño que desea eliminar");
				String nameOwner = reader.nextLine();
				System.out.println(list.searchClub(identification).deleteOwnerByName(nameOwner));
			}
		} catch (NullPointerException e) {
			System.out.println("Ha ingresado un dato que no existe en los registros, por favor revise el registro de error");
			System.out.println("Se anulo el registro");
			System.out.println("Error: NullPointerExcepcion");
		}
		
	}
	
	public void deletePet() {
		int value = showSubMenu4();
		try {
			if(value == 1) {
				System.out.println("Ingrese la identificacion de un club");
				String identification = reader.nextLine();
				System.out.println("Ingrese la identificacion de un dueño");
				String idOwner = reader.nextLine();
				System.out.println("Ingrese la identificacion de la mascota que desea eliminar");
				String idPet = reader.nextLine();
				System.out.println(list.searchClub(identification).searchOwner(idOwner).deletePetById(idPet));
			}else if(value == 2){
				System.out.println("Ingrese la identificacion de un club");
				String identification = reader.nextLine();
				System.out.println("Ingrese el nombre del dueño que desea eliminar");
				String idOwner = reader.nextLine();
				System.out.println("Ingrese el nombre de la mascota que desea eliminar");
				String namePet = reader.nextLine();
				System.out.println(list.searchClub(identification).searchOwner(idOwner).deletePetByName(namePet));
			}
		} catch (NullPointerException e) {
			System.out.println("Ha ingresado un dato que no existe en los registros, por favor revise el registro de error");
			System.out.println("Se anulo el registro");
			System.out.println("Error: NullPointerExcepcion");
		}
		
	}
	
	public void orderByNumberOwners() {
		list.orderClubsByNumberOwners();
		paint();
	}
	
	public void orderByNumberPets() {
		System.out.println("Ingrese la identificacion del club que desea ordenar");
		String idClub = reader.nextLine();
		try {
			list.searchClub(idClub).orderOwnersByNumberPets();
			paintOwners(idClub);
		} catch (NullPointerException e) {
			System.out.println("Ha ingresado un dato que no existe en los registros, por favor revise el registro de error");
			System.out.println("Se anulo el registro");
			System.out.println("Error: NullPointerExcepcion");
		}
		
		
	}
	
	public void orderClubs() {
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
		}
		
	}
	public void orderOwners() {
		System.out.println("Ingrese la id del club");
		String idClub = reader.nextLine();
		int valSubMenu2 = showSubMenu2();
		try {
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
			}
		} catch (NullPointerException e) {
			System.out.println("Ha ingresado un dato que no existe en los registros, por favor revise el registro de error");
			System.out.println("Se anulo el registro");
			System.out.println("Error: NullPointerExcepcion");
		}
		
	}
	public void orderPets() {
		System.out.println("Ingrese la id del club");
		String idClubn = reader.nextLine();
		System.out.println("Ingrese el id del dueño buscado");
		String idOwner = reader.nextLine();
		int valSubMenu3 = showSubMenu3();
		try {
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
		} catch (NullPointerException e) {
			System.out.println("Ha ingresado un dato que no existe en los registros, por favor revise el registro de error");
			System.out.println("Se anulo el registro");
			System.out.println("Error: NullPointerExcepcion");
		}
	
	}
	
	public void searchClubs(String data) {
		int valSubMenu = showSubMenu1();
		if(valSubMenu == 1) {
			long ts1 = System.nanoTime();
			System.out.println(list.secuencialSearchById(data));
			long ts2 = System.nanoTime();
			System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
			long tb1 = System.nanoTime();
			System.out.println(list.binarySearchById(data));
			long tb2 = System.nanoTime();
			System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
		}else if(valSubMenu == 2) {
			long ts1 = System.nanoTime();
			System.out.println(list.secuencialSearchByClubName(data));
			long ts2 = System.nanoTime();
			System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
			long tb1 = System.nanoTime();
			System.out.println(list.binarySearchByClubName(data));
			long tb2 = System.nanoTime();
			System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
		}else if(valSubMenu == 3) {
			long ts1 = System.nanoTime();
			System.out.println(list.secuencialSearchByClubDate(data));
			long ts2 = System.nanoTime();
			System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
			long tb1 = System.nanoTime();
			System.out.println(list.binarySearchByClubDate(data));
			long tb2 = System.nanoTime();
			System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
		}else if(valSubMenu == 4) {
			long ts1 = System.nanoTime();
			System.out.println(list.secuencialSearchByPet(data));
			long ts2 = System.nanoTime();
			System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
			long tb1 = System.nanoTime();
			System.out.println(list.binarySearchByPet(data));
			long tb2 = System.nanoTime();
			System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
		}
		
	}
	public void searchOwners(String data) {
		System.out.println("Ingrese la id del club");
		String idClub = reader.nextLine();
		int valSubMenu2 = showSubMenu2();
		try {
			if(valSubMenu2 == 1) {
				long ts1 = System.nanoTime();
				System.out.println(list.searchClub(idClub).secuencialSearchById(data));
				long ts2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
				long tb1 = System.nanoTime();
				System.out.println(list.searchClub(idClub).binarySearchById(data));
				long tb2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
			}else if(valSubMenu2 == 2) {
				long ts1 = System.nanoTime();
				System.out.println(list.searchClub(idClub).secuencialSearchByName(data));
				long ts2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
				long tb1 = System.nanoTime();
				System.out.println(list.searchClub(idClub).secuencialSearchByName(data));
				long tb2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
			}else if(valSubMenu2 == 3) {
				long ts1 = System.nanoTime();
				System.out.println(list.searchClub(idClub).secuencialSearchByLastName(data));
				long ts2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
				long tb1 = System.nanoTime();
				System.out.println(list.searchClub(idClub).binarySearchByLastName(data));
				long tb2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
			}else if(valSubMenu2 == 4) {
				long ts1 = System.nanoTime();
				System.out.println(list.searchClub(idClub).secuencialSearchByOwnerDate(data));
				long ts2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
				long tb1 = System.nanoTime();
				System.out.println(list.searchClub(idClub).binarySearchByDate(data));
				long tb2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
			}else if(valSubMenu2 == 5) {
				long ts1 = System.nanoTime();
				System.out.println(list.searchClub(idClub).secuencialSearchByPet(data));
				long ts2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
				long tb1 = System.nanoTime();
				System.out.println(list.searchClub(idClub).binarySearchByPet(data));
				long tb2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
			}
		} catch (NullPointerException e) {
			System.out.println("Ha ingresado un dato que no existe en los registros, por favor revise el registro de error");
			System.out.println("Se anulo el registro");
			System.out.println("Error: NullPointerExcepcion");
		}
	
	}
	public void searchPets(String data) {
		System.out.println("Ingrese la id del club");
		String idClubn = reader.nextLine();
		System.out.println("Ingrese el id del dueño buscado");
		String idOwner = reader.nextLine();
		int valSubMenu3 = showSubMenu3();
		try {
			if(valSubMenu3 == 1) {
				long ts1 = System.nanoTime();
				System.out.println(list.searchClub(idClubn).searchOwner(idOwner).secuencialSearchById(data));
				long ts2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
				long tb1 = System.nanoTime();
				System.out.println(list.searchClub(idClubn).searchOwner(idOwner).binarySearchById(data));
				long tb2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
			}else if(valSubMenu3  == 2) {
				long ts1 = System.nanoTime();
				System.out.println(list.searchClub(idClubn).searchOwner(idOwner).secuencialSearchByName(data));
				long ts2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
				long tb1 = System.nanoTime();
				System.out.println(list.searchClub(idClubn).searchOwner(idOwner).binarySearchByName(data));
				long tb2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
			}else if(valSubMenu3 == 3) {
				long ts1 = System.nanoTime();
				System.out.println(list.searchClub(idClubn).searchOwner(idOwner).secuencialSearchByDate(data));
				long ts2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
				long tb1 = System.nanoTime();
				System.out.println(list.searchClub(idClubn).searchOwner(idOwner).binarySearchByDate(data));
				long tb2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
			}else if(valSubMenu3 == 4) {
				long ts1 = System.nanoTime();
				System.out.println(list.searchClub(idClubn).searchOwner(idOwner).secuencialSearchByPet(data));
				long ts2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda secuencial: " + (ts2-ts1)+" Nanosegundos\n");
				long tb1 = System.nanoTime();
				System.out.println(list.searchClub(idClubn).searchOwner(idOwner).binarySearchByPet(data));
				long tb2 = System.nanoTime();
				System.out.println("Tiempo en ejecutar la busqueda binaria: " + (tb2-tb1)+" Nanosegundos\n");
			}
		}catch (NullPointerException e) {
			System.out.println("Ha ingresado un dato que no existe en los registros, por favor revise el registro de error");
			System.out.println("Se anulo el registro");
			System.out.println("Error: NullPointerExcepcion");
		}
		
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
