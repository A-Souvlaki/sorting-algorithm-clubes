package model;

import java.io.Serializable;
import java.util.Comparator;

public class Personaje implements Comparator<Personaje>, Comparable<Personaje>, Serializable {

	private String nombre;
	private String personalidad;
	private String fechaCreacion;
	private int poder;
	private Tecnica tecnicaBase;
	private Personaje siguiente;
	private Personaje anterior;

	public Personaje(String nombre, String personalidad, String fechaCreacion, int poder, Tecnica tecnicaBase) {
		this.nombre = nombre;
		this.personalidad = personalidad;
		this.fechaCreacion = fechaCreacion;
		this.poder = poder;
		this.tecnicaBase = null;
		this.siguiente = null;
		this.anterior = null;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPersonalidad() {
		return personalidad;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public int getPoder() {
		return poder;
	}

	public Tecnica getTecnicaBase() {
		return tecnicaBase;
	}

	public Personaje getSiguiente() {
		return siguiente;
	}

	public Personaje getAnterior() {
		return anterior;
	}

	public void setSiguiente(Personaje siguiente) {
		this.siguiente = siguiente;
	}

	public void setAnterior(Personaje anterior) {
		this.anterior = anterior;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean repetido(String nombre) {
		boolean repetido = false;
		boolean cerrar = true;
		for (int i = 0; i < contarElementos() && cerrar; i++) {
			if (retornarIndice(i).getNombreTecnica().equals(nombre)) {
				repetido = true;
				cerrar = false;
			}
		}
		return repetido;
	}

	@Override
	public String toString() {
		return "Personaje [nombre: " + String.format("%1$-13s", nombre) + "| personalidad: "
				+ String.format("%1$-70s", personalidad) + "| fechaCreacion: " + String.format("%1$-8s", fechaCreacion)
				+ "| poder: " + String.format("%1$-8s", poder) + "| tecnicaBase: "
				+ String.format("%1$-8s", tecnicaBase) + "]";
	}

	public void insertarAlFinal(String nombreTecnica, int factorDeInfluencia) throws ElementoExisteExcepcion {
		Tecnica tecnica = new Tecnica(nombreTecnica, factorDeInfluencia);
		if (repetido(nombreTecnica)) {
			throw new ElementoExisteExcepcion("YA existe una tecnica con este nombre");
		} else {
			if (tecnicaBase == null) {
				tecnicaBase = tecnica;
			} else {
				Tecnica actual = tecnicaBase;
				while (actual.getSiguiente() != null) {
					actual = actual.getSiguiente();
				}
				actual.setSiguiente(tecnica);
			}
		}

	}

	public void insertarAlInicio(String nombreTecnica, int factorDeInfluencia) throws ElementoExisteExcepcion {
		Tecnica tecnica = new Tecnica(nombreTecnica, factorDeInfluencia);
		if (repetido(nombreTecnica)) {
			throw new ElementoExisteExcepcion("YA existe una tecnica con este nombre");
		} else {
			if (tecnicaBase == null) {
				tecnicaBase = tecnica;
			} else {
				tecnica.setSiguiente(tecnicaBase);
				tecnicaBase = tecnica;
			}
		}

	}

	public void modificarNombre(String nombreActual, String nombreActualizar) throws ElementoExisteExcepcion {
		if (repetido(nombreActualizar) == false) {
			throw new ElementoExisteExcepcion("YA existe una tecnica con este nombre");
		} else {
			Tecnica actual = tecnicaBase;
			boolean cerrar = false;
			while (actual != null && !cerrar) {
				if (actual.getNombreTecnica().equals(nombreActual)) {
					actual.setNombreTecnica(nombreActualizar);
					cerrar = true;
				}
				actual = actual.getSiguiente();
			}
		}
	}

	public void modificarFactor(String nombreActual, int factor) {

		Tecnica actual = tecnicaBase;
		boolean cerrar = false;
		while (actual != null && !cerrar) {
			if (actual.getNombreTecnica().equals(nombreActual)) {
				actual.setFactorDeInfluencia(factor);;
				cerrar = true;
			}
			actual = actual.getSiguiente();
		}

	}

	public void insertarAlInicio(Tecnica t) {
		Tecnica tecnica = t;

		if (tecnicaBase == null) {
			tecnicaBase = tecnica;
		} else {
			tecnica.setSiguiente(tecnicaBase);
			tecnicaBase = tecnica;
		}

	}

	public void insertarDespuesDe(String nombreAnterior, String nombreTecnica, int factorDeInfluencia) {
		Tecnica actual = tecnicaBase, tecnica = new Tecnica(nombreTecnica, factorDeInfluencia), siguiente = null;
		while (actual.getSiguiente() != null) {
			if (actual.getSiguiente().getNombreTecnica().equals(nombreAnterior)) {
				siguiente = actual.getSiguiente();
			}
			actual = actual.getSiguiente();
		}
		Tecnica temp = siguiente.getSiguiente();
		siguiente.setSiguiente(tecnica);
		tecnica.setSiguiente(temp);
	}

	public void insertarAntesDe(String nombreAnterior, String nombreTecnica, int factorDeInfluencia) {
		Tecnica actual = tecnicaBase, tecnica = new Tecnica(nombreTecnica, factorDeInfluencia), anterior = null;
		while (actual.getSiguiente() != null) {
			if (actual.getSiguiente().getNombreTecnica().equals(nombreAnterior)) {
				anterior = actual;
			}
			actual = actual.getSiguiente();
		}
		Tecnica temp = anterior.getSiguiente();
		anterior.setSiguiente(tecnica);
		tecnica.setSiguiente(temp);
	}

	public void eliminarTecnica(String nombreTecnica) {
		Tecnica actual = tecnicaBase, siguiente = null, anterior = null;
		if (actual.getNombreTecnica().equals(nombreTecnica)) {
			siguiente = tecnicaBase.getSiguiente();
			tecnicaBase = siguiente;
		} else {
			while (actual.getSiguiente() != null) {
				if (actual.getSiguiente().getNombreTecnica().equals(nombreTecnica)) {
					anterior = actual;
					siguiente = actual.getSiguiente();
				}
				actual = actual.getSiguiente();
			}
			anterior.setSiguiente(siguiente.getSiguiente());
		}

	}

	public String pintar() {
		String pintar = "";
		Tecnica actual = tecnicaBase;
		while (actual != null) {
			pintar += "\n" + actual;
			actual = actual.getSiguiente();
		}
		return pintar;
	}

	public int contarElementos() {
		int contador = 0;
		Tecnica actual = tecnicaBase;
		while (actual != null) {
			contador++;
			actual = actual.getSiguiente();
		}
		return contador;
	}

	public Tecnica retornarIndice(int pos) {
		Tecnica actual = tecnicaBase;
		if (pos == 0) {
			actual = tecnicaBase;
		} else {
			for (int i = 0; i < pos; i++) {
				actual = actual.getSiguiente();
			}
		}
		return actual;
	}

	public void ordenarPorPoderInsertionSort() {
		Tecnica clave = null;
		int va = 0;
		for (int i = 1; i < contarElementos(); i++) {
			clave = retornarIndice(i);
			va = i - 1;
			while (va > -1 && retornarIndice(va).getFactorDeInfluencia() > clave.getFactorDeInfluencia()) {
				Tecnica aux1 = retornarIndice(va);
				Tecnica aux2 = clave;

				if (aux1 == tecnicaBase) {
					Tecnica temp = aux1;
					Tecnica siguiente = aux2.getSiguiente();
					tecnicaBase = aux2;
					aux2.setSiguiente(temp);
					temp.setSiguiente(siguiente);
				} else {
					Tecnica temp = aux1;
					Tecnica siguiente = aux2.getSiguiente();
					Tecnica anterior = retornarIndice(va - 1);
					anterior.setSiguiente(aux2);
					aux2.setSiguiente(temp);
					temp.setSiguiente(siguiente);
				}
				va--;
			}
			Tecnica centinela = retornarIndice(va + 1);
			centinela = clave;

		}
	}

	public void modificarPorPosicion(int pos, Tecnica temp) {
		Tecnica actual = tecnicaBase;
		if (pos == 0) {
			Tecnica temp1 = actual;
			tecnicaBase = temp;
			temp.setSiguiente(temp1);
		} else {
			Tecnica temp2 = tecnicaBase;
			for (int i = 0; i < pos - 1; i++) {
				temp2 = temp2.getSiguiente();
			}
			Tecnica anterior = temp2;
			temp2 = tecnicaBase;
			for (int i = 0; i < pos + 1; i++) {
				temp2 = temp2.getSiguiente();
			}
			Tecnica siguiente = temp2;
			anterior.setSiguiente(temp);
			temp.setSiguiente(siguiente);
		}
	}

	public void ordenarNombresPorSelectionSort() throws ElementoExisteExcepcion {
		Tecnica menor = null;
		Tecnica mayor = null;
		for (int i = 0; i < contarElementos() - 1; i++) {
			menor = retornarIndice(i);
			int cual = i;
			for (int j = i + 1; j < contarElementos(); j++) {
				mayor = retornarIndice(j);
				if (mayor.compareTo(menor) < 0) {
					menor = mayor;
					cual = j;
				}
			}
			Tecnica menor1 = new Tecnica(menor.getNombreTecnica(), (int) menor.getFactorDeInfluencia());
			Tecnica menor2 = new Tecnica(retornarIndice(i).getNombreTecnica(),
					(int) retornarIndice(i).getFactorDeInfluencia());
			if (retornarIndice(i) != tecnicaBase) {
				if (retornarIndice(i) == tecnicaBase) {
					eliminarTecnica(menor2.getNombreTecnica());
					insertarAlInicio(menor1);
					modificarPorPosicion(cual, menor2);
				} else {
					insertarAntesDe(menor1.getNombreTecnica(), menor2.getNombreTecnica(),
							(int) menor2.getFactorDeInfluencia());
					eliminarTecnica(menor1.getNombreTecnica());
					modificarPorPosicion(i, menor1);
				}
			}
		}
	}
	
	public String buscarSecuencialPorNombre(String nombre) {
		String msj = "";
		boolean cerrar = false;
		Tecnica actual = tecnicaBase;
		while (actual != null && !cerrar) {
			if (actual.getNombreTecnica().equals(nombre)) {
				msj += actual;
				cerrar = true;
			}
			actual = actual.getSiguiente();
		}
		
		if (msj.equals("")) {
			msj = "No se encontro ningun elemento con el nombre indicado";
		}
		return msj;
	}

	@Override
	public int compare(Personaje o1, Personaje o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

	@Override
	public int compareTo(Personaje o) {
		return personalidad.compareTo(o.getPersonalidad());
	}

	public void setPersonalidad(String personalidad) {
		this.personalidad = personalidad;
	}

}
