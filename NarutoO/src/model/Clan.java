package model;

import java.io.Serializable;

public class Clan implements Comparable<Clan>,Serializable {

	private String nombreClan;
	private Personaje primero;
	private Personaje ultimo;

	public Clan(String nombreClan) {
		this.nombreClan = nombreClan;
		primero = null;
		ultimo = null;
	}

	public String getNombreClan() {
		return nombreClan;
	}
	
	@Override
	public String toString() {
		return "Clan [nombre del clan: " + nombreClan + "]";
	}
	
	public void ingresarPersonajeAlFinal(String nombre, String personalidad, String fechaCreacion, int poder,
			Tecnica tecnicaBase) throws ElementoExisteExcepcion {
		Personaje personaje = new Personaje(nombre, personalidad, fechaCreacion, poder, tecnicaBase);
		if (repetido(nombre)) {
			throw new ElementoExisteExcepcion("Ya existe un personaje con el nombre ingresado");
		} else {
			if (primero == null) {
				primero = personaje;
				primero.setAnterior(null);
				ultimo = primero;
			} else {
				ultimo.setSiguiente(personaje);
				personaje.setAnterior(ultimo);
				personaje.setSiguiente(null);
				ultimo = personaje;
			}
		}
	}

	public void ingresarPersonajeAlInicio(String nombre, String personalidad, String fechaCreacion, int poder,
			Tecnica tecnicaBase) throws ElementoExisteExcepcion {
		Personaje personaje = new Personaje(nombre, personalidad, fechaCreacion, poder, tecnicaBase);
		if (repetido(nombre)) {
			throw new ElementoExisteExcepcion("Ya existe un personaje con el nombre ingresado");
		} else {
			if (primero != null) {
				Personaje temp = primero;
				primero = personaje;
				temp.setAnterior(personaje);
				personaje.setSiguiente(temp);
				personaje.setAnterior(null);
			}
		}
		
	}
	public boolean repetido(String nombre) {
		boolean repetido = false;
		boolean cerrar = true;
		for (int i = 0; i < contarElementos() && cerrar; i++) {
			if (retornarIndice(i).getNombre().equals(nombre)) {
				repetido = true;
				cerrar = false;
			}
		}
		return repetido;
	}

	public void eliminarPersonaje(String nombre) {
		Personaje actual = primero, anterior = null, siguiente = null;
		boolean cerrar = false;
		if (nombre.equals(primero.getNombre())) {
			siguiente = primero.getSiguiente();
			primero = primero.getSiguiente();
			siguiente.setAnterior(null);

		} else {
			while (actual != null && !cerrar) {
				if (actual.getNombre().equals(nombre) && actual.getSiguiente() != null) {
					anterior = actual.getAnterior();
					siguiente = actual.getSiguiente();
					anterior.setSiguiente(siguiente);
					siguiente.setAnterior(anterior);
					cerrar = true;
				} else if (actual.getNombre().equals(nombre) && actual.getSiguiente() == null) {
					anterior = actual.getAnterior();
					anterior.setSiguiente(null);
					cerrar = true;
				}
				actual = actual.getSiguiente();
			}

		}

	}

	public void modificarNombrePersonaje(String nombreActual, String nombreActualizar) {
		Personaje actual = primero;
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if (actual.getNombre().equals(nombreActual)) {
				actual.setNombre(nombreActualizar);
				cerrar = true;
			}
			actual = actual.getSiguiente();
		}
	}
	
	public void modificarPersonalidadPersonaje(String nombreActual, String nuevaPersonalidad) {
		Personaje actual = primero;
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if (actual.getNombre().equals(nombreActual)) {
				actual.setPersonalidad(nuevaPersonalidad);;
				cerrar = true;
			}
			actual = actual.getSiguiente();
		}
	}

	public int contarElementos() {
		int contador = 0;
		Personaje actual = primero;
		while (actual != null) {
			contador++;
			actual = actual.getSiguiente();
		}
		return contador;
	}

	public Personaje retornarIndice(int pos) {
		Personaje actual = primero;
		if (pos == 0) {
			actual = primero;
		} else {
			for (int i = 0; i < pos; i++) {
				actual = actual.getSiguiente();
			}
		}
		return actual;
	}

	public void ordenarPorNombreBubbleSort() {
		Personaje actual = primero;

		while (actual != null) {

			int va = 0;
			while (va < contarElementos() - 1) {
				if (retornarIndice(va).compare(retornarIndice(va), retornarIndice(va + 1)) > 0) {
					Personaje aux1 = retornarIndice(va);
					Personaje aux2 = retornarIndice(va + 1);
					//
					if (aux1.getAnterior() == null) {

						Personaje temp = aux1;
						Personaje anterior = aux1.getAnterior();
						Personaje next = aux2.getSiguiente();
						primero = aux2;
						temp.setAnterior(aux2);
						temp.setSiguiente(next);
						next.setAnterior(temp);
						aux2.setSiguiente(temp);
						aux2.setAnterior(anterior);

					} else if (aux2.getSiguiente() == null) {

						Personaje temp = aux1;
						Personaje anterior = aux1.getAnterior();
						temp.setSiguiente(aux2.getSiguiente());
						temp.setAnterior(aux2);
						anterior.setSiguiente(aux2);
						aux2.setAnterior(anterior);
						aux2.setSiguiente(temp);

					} else if (aux1.getAnterior() != null & aux2.getSiguiente() != null) {

						Personaje temp1 = aux1;
						Personaje temp2 = aux2;
						Personaje previous = aux1.getAnterior();
						Personaje next = aux2.getSiguiente();
						temp2.setAnterior(previous);
						previous.setSiguiente(temp2);
						temp2.setSiguiente(temp1);
						temp1.setAnterior(temp2);
						temp1.setSiguiente(next);
						next.setAnterior(temp1);
					}
					//
				}
				va++;
			}
			actual = actual.getSiguiente();
		}
	}
	
	public Personaje retornarObjeto(String nombre) {
		Personaje personaje = null;
		Personaje actual = primero;
		if(primero.getNombre().equals(nombre)) {
			personaje = primero;
		}else {
			while(actual!=null) {
				if(actual.getNombre().equals(nombre)) {
					personaje = actual;
				}
			}
		}
		return personaje;
	}

	public String buscarSecuencialPorNombre(String nombre) {
		Personaje actual = primero;
		String msj = "";
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if (actual.getNombre().equals(nombre)) {
				msj += actual;
				cerrar = true;
			}
			actual = actual.getSiguiente();
		}
		
		if (msj.equals("")) {
			msj = "No se encontro o no existe el personaje buscado";
		}
		return msj;
	}

	public String pintar() {
		String pintar = "";
		Personaje actual = primero;
		while (actual != null) {
			pintar += "\n" + actual;
			actual = actual.getSiguiente();
		}
		return pintar;
	}

	@Override
	public int compareTo(Clan o) {
		return nombreClan.compareTo(o.getNombreClan());
	}

}
