package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Konoha implements Serializable {

	private ArrayList<Clan> clanes;
	private String fileClan;

	public Konoha(String fileClan) {
		this.fileClan = fileClan;
		clanes = loadClanes();
	}

	public void saveClanes() {
		ObjectOutputStream oos;
		File file = new File(fileClan);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(clanes);
			oos.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	private ArrayList<Clan> loadClanes() {
		File file = new File(fileClan);
		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				ArrayList<Clan> c = (ArrayList<Clan>) ois.readObject();
				clanes = c;
				ois.close();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			clanes = new ArrayList<Clan>();
		}
		return clanes;
	}

	public ArrayList<Clan> getClanes() {
		return clanes;
	}

	public boolean buscarClanRepetido(String nombreClan) {
		boolean detener = true, repetido = false;
		if (clanes != null) {
			for (int i = 0; i < clanes.size() && detener; i++) {
				if (clanes.get(i).getNombreClan().equals(nombreClan)) {
					detener = false;
					repetido = true;
				}
			}
		}
		return repetido;
	}

	public void crearClan(String nombreClan) throws ElementoExisteExcepcion {
		if (buscarClanRepetido(nombreClan) == false) {
			Clan c = new Clan(nombreClan);
			clanes.add(c);
		} else {
			throw new ElementoExisteExcepcion("Ya existe un clan con este nombre");
			
		}
	}

	public void eliminarClan(String nombreClan) {
		boolean detener = true;
		for (int i = 0; i < clanes.size() && detener; i++) {
			if (clanes.get(i).getNombreClan().equals(nombreClan)) {
				detener = false;
				clanes.remove(i);
			}
		}
	}

	public void ordenarPorNombreSeleccionSort() {
		for (int i = 0; i < clanes.size() - 1; i++) {
			Clan menor = clanes.get(i);
			int cual = i;
			for (int j = i + 1; j < clanes.size(); j++) {
				if (clanes.get(j).compareTo(menor) < 0) {
					menor = clanes.get(j);
					cual = j;
				}
			}

			Clan temp = clanes.get(i);
			clanes.set(i, menor);
			clanes.set(cual, temp);
		}
	}

	public Clan retornarObjetoClan(String nombreClan) {
		Clan clan = null;
		boolean cerrar = true;
		for (int i = 0; i < clanes.size() && cerrar; i++) {
			if (clanes.get(i).getNombreClan().equals(nombreClan)) {
				clan = clanes.get(i);
				cerrar = false;
			}
		}
		return clan;
	}

	public String buscarClan(String nombreClan) {
		String msj = "";
		for (int i = 0; i < clanes.size(); i++) {
			if (clanes.get(i).getNombreClan().equals(nombreClan)) {
				msj += clanes.get(i);
			}
		}
		if (msj.equals("")) {
			msj += "No existe ningun clan con el nombre ingresado";
		}
		return msj;
	}

	public String pintar() {
		String msj = "";
		for (int i = 0; i < clanes.size(); i++) {
			msj += "\n" + clanes.get(i);
		}
		return msj;
	}

}
