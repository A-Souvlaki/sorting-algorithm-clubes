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

import model.ElementoExisteExcepcion;
import model.Konoha;

public class Menu {

	private Konoha aldeas;
	private Scanner reader;

	public Menu() {
		reader = new Scanner(System.in);
		aldeas = new Konoha("files//Serializable.dat");
		systemOperation();
	}

	public void systemOperation() {
		boolean close = false;

		while (!close) {
			int userValue = menuSystem();
			switch (userValue) {
			case 0:
				close = true;
				break;
			case 1:
				registrarClan();
				aldeas.saveClanes();
				break;
			case 2:
				registrarPersonaje();
				aldeas.saveClanes();
				break;
			case 3:
				registrarTecnica();
				aldeas.saveClanes();
				break;
			case 4:
				eliminarClan();
				aldeas.saveClanes();
				break;
			case 5:
				eliminarPersonaje();
				aldeas.saveClanes();
				break;
			case 6:
				eliminarTecnica();
				aldeas.saveClanes();
				break;
			case 7:
				mostrarClanesOrdenados();
				break;
			case 8:
				mostrarPersonajesOrdenados();
				break;
			case 9:
				mostrarTecnicasOrdenadas();
				break;
			case 10:
				mostrarTecnicasOrdenadasSeleccion();
				break;
			case 11:
				modificarPersonalidadPersonaje();
				aldeas.saveClanes();
				break;
			case 12:
				modificarNombrePersonaje();
				aldeas.saveClanes();
				break;
			case 13:
				modificarNombreTecnica();
				aldeas.saveClanes();
				break;
			case 14:
				modificarFactorTecnica();
				aldeas.saveClanes();
				break;
			case 15:
				buscarPersonajeNombre();
				break;
			case 16:
				buscarTecnicaNombre();
				break;
			default:
				break;
			}

		}

	}

	public int menuSystem() {
		System.out.println("\nElije una opcion :)");
		System.out.println("1.   Registrar un clan ");
		System.out.println("2.   Registrar un personaje ");
		System.out.println("3.   Registrar una tecnica a un personaje");
		System.out.println(" ");
		System.out.println("4.   Eliminar un clan");
		System.out.println("5.   Eliminar un personaje");
		System.out.println("6.   Eliminar una tecnica");
		System.out.println(" ");
		System.out.println("7.   Mostrar clanes ordenados ( seleccion )");
		System.out.println("8.   Mostrar personajes ordenados por nombre ( burbuja )");
		System.out.println("9.   Mostrar tecnicas ordenadas por poder ( insercion )");
		System.out.println("10.  Mostrar tecnicas ordenadas por nombre ( seleccion )");
		System.out.println(" ");
		System.out.println("11.  Modificar personalidad de personaje");
		System.out.println("12.  Modificar nombre de personaje ");
		System.out.println("13.  Modificar nombre tecnica ");
		System.out.println("14.  Modificar factor tecnica ");
		System.out.println(" ");
		System.out.println("15.  Buscar personaje por nombre ");
		System.out.println("16.  Buscar tecnica por nombre");

		System.out.println(String.format("0.  Salir "));
		int value = 0;
		// Here I catch the exceptions
		try {
			value = reader.nextInt();
			reader.nextLine();
			if (value <= -1 || value > 16) {
				throw new OutOfRangeExcepcion("\"Por favor digite una opcion valida :)...O tu windows se cerrara\"");
			}
		} catch (InputMismatchException e) {
			System.out.println("Por favor digite una opcion valida :)...O tu windows se cerrara");
			reader.nextLine();
			systemOperation();

		} catch (OutOfRangeExcepcion e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public void registrarClan() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		try {
			aldeas.crearClan(nombreClan);
			System.out.println("Se ha añadido un clan. ");
		} catch (ElementoExisteExcepcion e) {
			System.out.println(e.getMessage());
		}
	}

	public void registrarPersonaje() {

		System.out.println("Ingrese el nombre del Personaje: ");
		String nombre = reader.nextLine();
		System.out.println("Ingrese la personalidad del Personaje: ");
		String personalidad = reader.nextLine();
		System.out.println("Ingrese la fecha de creacion:  ");
		String fechaCreacion = reader.nextLine();
		int poder = 0;
		boolean cerrar = false;
		do {
			try {
				System.out.println("Ingrese el poder del personaje: ");
				poder = reader.nextInt();
				reader.nextLine();
				cerrar = true;

			} catch (InputMismatchException e) {
				System.out.println("Has ingresado un valor no valido en alguna de las opciones del registro ");
				System.out.println("No te pases de listo dude,no me obligues a decirle a shrek que te busque");
				System.out.println("                            Intenta de nuevo                                 ");
				reader.nextLine();
			}
		}while(!cerrar);
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		try {
			aldeas.retornarObjetoClan(nombreClan).ingresarPersonajeAlFinal(nombre, personalidad, fechaCreacion, poder,
					null);
			System.out.println("Se ha creado un personaje. ");
		} catch (ElementoExisteExcepcion e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un clan que no existe, un gatito muere :(");
		}
	}

	public void registrarTecnica() {

		System.out.println("Ingrese el nombre de la tecnica: ");
		String nombreTecnica = reader.nextLine();
		int factorDeInfluencia = 0;
		boolean cerrar = false;
		do {
			try {
				System.out.println("Ingrese el factor de influencia: ");
				factorDeInfluencia = reader.nextInt();
				reader.nextLine();
				cerrar = true;

			} catch (InputMismatchException e) {
				System.out.println("Has ingresado un valor no valido en alguna de las opciones del registro ");
				System.out.println("No te pases de listo dude,no me obligues a decirle a shrek que te busque");
				System.out.println("                            Intenta de nuevo                                 ");
				reader.nextLine();
			}
		}while(!cerrar);

		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();

		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();

		try {
			aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).insertarAlFinal(nombreTecnica,
					factorDeInfluencia);
			System.out.println("Se ha agregado una tecnica. ");
		} catch (ElementoExisteExcepcion e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un clan o un personaje que no existe, un gatito muere :(");
		}
	}

	public void eliminarClan() {
		System.out.println("Ingrese el nombre del clan que desea eliminar: ");
		String nombreClan = reader.nextLine();

		aldeas.eliminarClan(nombreClan);
		System.out.println("Verifique en su lista de clanes");
	}

	public void eliminarPersonaje() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();

		System.out.println("Ingrese el nombre del personaje que desea eliminar: ");
		String nombre = reader.nextLine();
		try {
			aldeas.retornarObjetoClan(nombreClan).eliminarPersonaje(nombre);
			System.out.println("Verifique en su lista de personajes");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un clan que no existe, un gatito muere :(");
		}
		
	}

	public void eliminarTecnica() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();

		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();

		System.out.println("Ingrese el nombre de la tecnica que desea eliminar: ");
		String nombreTecnica = reader.nextLine();
		try {
			aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).eliminarTecnica(nombreTecnica);
			System.out.println("Verifique en su lista de tecnicas");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un personaje que no existe, un gatito muere :(");
		}
	}

	public void mostrarClanesOrdenados() {
		aldeas.ordenarPorNombreSeleccionSort();
		System.out.println(aldeas.pintar());
	}

	public void mostrarPersonajesOrdenados() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		try {
			long t1 = System.nanoTime();
			aldeas.retornarObjetoClan(nombreClan).ordenarPorNombreBubbleSort();
			long t2 = System.nanoTime();
			System.out.println(aldeas.retornarObjetoClan(nombreClan).pintar());
			System.out.println("\nTiempo en ejecutar el ordenamiento: " + (t2 - t1) + " Nanosegundos\n");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un clan que no existe, un gatito muere :(");
		}
		
	}

	public void mostrarTecnicasOrdenadas() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();

		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();
		try {
			long t1 = System.nanoTime();
			aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).ordenarPorPoderInsertionSort();
			long t2 = System.nanoTime();
			System.out.println(aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).pintar());
			System.out.println("\nTiempo en ejecutar el ordenamiento: " + (t2 - t1) + " Nanosegundos\n");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un personaje que no existe, un gatito muere :(");
		}

	}
	
	public void mostrarTecnicasOrdenadasSeleccion() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();

		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();
		try {
			long t1 = System.nanoTime();
			aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).ordenarNombresPorSelectionSort();
			long t2 = System.nanoTime();
			System.out.println(aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).pintar());
			System.out.println("\nTiempo en ejecutar el ordenamiento: " + (t2 - t1) + " Nanosegundos\n");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un personaje que no existe, un gatito muere :(");
		} catch (ElementoExisteExcepcion e) {
			System.out.println("Si estas leyendo esto, es porque lograste hackiar la NASA XD");
		}
		
	}
	
	public void modificarPersonalidadPersonaje() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		
		System.out.println("Ingrese el nombre del personaje al que desea actualizarle su personalidad: ");
		String nombreActual = reader.nextLine();
		
		System.out.println("Ingrese la nueva personalidad: ");
		String nuevaPersonalidad = reader.nextLine();
		
		try {
			long t1 = System.nanoTime();
			aldeas.retornarObjetoClan(nombreClan).modificarPersonalidadPersonaje(nombreActual, nuevaPersonalidad);
			long t2 = System.nanoTime();
			System.out.println("Se ha actualizado la personalidad, por favor verifique las listas");
			System.out.println("\nTiempo en ejecutar la busqueda: " + (t2 - t1) + " Nanosegundos\n");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un personaje que no existe, un gatito muere :(");
		}
	}
	
	public void modificarNombrePersonaje() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();
		
		System.out.println("Ingrese el nombre del personaje al que desea actualizarle su nombre ");
		String nombreActual = reader.nextLine();
		
		System.out.println("Ingrese el nuevoNombre: ");
		String nombreActualizar = reader.nextLine();
		
		try {
			long t1 = System.nanoTime();
			aldeas.retornarObjetoClan(nombreClan).modificarNombrePersonaje(nombreActual, nombreActualizar);
			long t2 = System.nanoTime();
			System.out.println("Se ha actualizado el nombre, por favor verifique las listas");
			System.out.println("\nTiempo en ejecutar la busqueda: " + (t2 - t1) + " Nanosegundos\n");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un personaje que no existe, un gatito muere :(");
		}
	}
	
	public void modificarNombreTecnica() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();

		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();
		
		System.out.println("Ingrese el nombre de la tecnica para actualizarle el nombre: ");
		String nombreTecnica = reader.nextLine();
		
		System.out.println("Ingrese el nuevo nombre de la tecnica: ");
		String nombreActualizar = reader.nextLine();
		
		try {
			long t1 = System.nanoTime();
			aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).modificarNombre(nombreTecnica, nombreActualizar);;
			long t2 = System.nanoTime();
			System.out.println("Se ha actualizado el nombre, por favor verifique las listas");
			System.out.println("\nTiempo en ejecutar la busqueda: " + (t2 - t1) + " Nanosegundos\n");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un personaje que no existe, un gatito muere :(");
		} catch (ElementoExisteExcepcion e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void modificarFactorTecnica() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();

		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();
		
		System.out.println("Ingrese el nombre de la tecnica para actualizarle el factor de poder: ");
		String nombreTecnica = reader.nextLine();
		
	
		int factor = 0;
		boolean cerrar = false;
		do {
			try {
				System.out.println("Ingrese el nuevo factor: ");
				factor = reader.nextInt();
				reader.nextLine();
				cerrar = true;

			} catch (InputMismatchException e) {
				System.out.println("Has ingresado un valor no valido en alguna de las opciones del registro ");
				System.out.println("No te pases de listo dude,no me obligues a decirle a shrek que te busque");
				System.out.println("                            Intenta de nuevo                                 ");
				reader.nextLine();
			}
		}while(!cerrar);
		
		try {
			long t1 = System.nanoTime();
			aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).modificarFactor(nombreTecnica, factor);;
			long t2 = System.nanoTime();
			System.out.println("Se ha actualizado el factor, por favor verifique las listas");
			System.out.println("\nTiempo en ejecutar la busqueda: " + (t2 - t1) + " Nanosegundos\n");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un personaje que no existe, un gatito muere :(");
		} 
		
	}
	
	public void buscarPersonajeNombre() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();

		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();
		try {
			long t1 = System.nanoTime();
			System.out.println(aldeas.retornarObjetoClan(nombreClan).buscarSecuencialPorNombre(nombre));
			long t2 = System.nanoTime();
			System.out.println("\nTiempo en ejecutar la busqueda: " + (t2 - t1) + " Nanosegundos\n");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un clan que no existe, un gatito muere :(");
		}
	
		
		
	}
	
	public void buscarTecnicaNombre() {
		System.out.println("Ingrese el nombre del clan: ");
		String nombreClan = reader.nextLine();

		System.out.println("Ingrese el nombre del personaje: ");
		String nombre = reader.nextLine();
		
		System.out.println("Ingrese el nombre de la tecnica: ");
		String nombreTecnica = reader.nextLine();
		try {
			long t1 = System.nanoTime();
			System.out.println(aldeas.retornarObjetoClan(nombreClan).retornarObjeto(nombre).buscarSecuencialPorNombre(nombreTecnica));
			long t2 = System.nanoTime();
			System.out.println("\nTiempo en ejecutar la busqueda: " + (t2 - t1) + " Nanosegundos\n");
		} catch (NullPointerException e) {
			System.out.println("Cada vez que intentas ingresar un personaje que no existe, un gatito muere :(");
		}
	
		
		
	}

	public static void main(String[] args) {

		Menu m = new Menu();
	}
}
