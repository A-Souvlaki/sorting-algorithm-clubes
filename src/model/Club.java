package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import org.xml.sax.helpers.ParserFactory;

import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Club implements Serializable, Comparable<Club>, Comparator<Club> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Attributes
	private String id;
	private String clubName;
	private String dateCreation;
	private String petType;

	// Relations
	private ArrayList<Owner> owners;

	// Constructor
	public Club(String id, String clubName, String dateCreation, String petType) {
		this.id = id;
		this.clubName = clubName;
		this.dateCreation = dateCreation;
		this.petType = petType;
		this.owners = new ArrayList<Owner>();
	}
	// _________________________________________________________________________________________________________//

	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}
	// _________________________________________________________________________________________________________//
	/**
	 * This method allows turn a String into a Date
	 * 
	 * @param format A date with the format "dd-mm-yyyy"
	 * @return A Date type object
	 */
	public Date formatDate(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = dateFormat.parse(format);
		} catch (ParseException e) {
			e.getStackTrace();
		} catch (NullPointerException e) {
			e.getStackTrace();
		}
		return date;
	}
	// _________________________________________________________________________________________________________//
	public String getId() {
		return id;
	}

	public String getClubName() {
		return clubName;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public String getPetType() {
		return petType;
	}

	public ArrayList<Owner> getOwners() {
		return owners;
	}
	// _________________________________________________________________________________________________________//
	public boolean giveOwner( String identification ) {
		boolean found = false;
		if(owners != null) {
			for (Owner owner : owners) {
				String i = owner.getId();
				if(i.equals(identification)) {
					found = true;
				}
			}
		}
	   return found;
	}
	// _________________________________________________________________________________________________________//
	public void registerOwner(String id, String name, String lastName, String birthDate, String favoritePet) throws ElementExistsExcepcion {
		if(giveOwner(id) == false) {
			Owner o = new Owner(id, name, lastName, birthDate, favoritePet);
			owners.add(o);
		}else {
			throw new ElementExistsExcepcion("NO JODA");
		}
			
	}

	public int numberOwners() {
		return owners.size();
	}
	// _________________________________________________________________________________________________________//
	public Owner searchOwner(String id) {
		Owner searched = null;
		boolean close = true;
		for (int i = 0; i < owners.size() && close; i++) {
			if (owners.get(i).getId().equals(id)) {
				searched = owners.get(i);
				close = false;
			}

		}
		return searched;
	}
	// _________________________________________________________________________________________________________//
	@Override
	public String toString() {
		return "Club" + "| Numero de Dueños =" + numberOwners() + " |id=" + String.format("%1$-13s", id)
				+ "| Nombre del Club =" + String.format("%1$-13s", clubName) + "| Fecha de Creacion del Club ="
				+ String.format("%1$-13s", dateCreation) + "| Tipo de mascotas que recibe el Club ="
				+ String.format("%1$-13s", petType);
	}
	// _________________________________________________________________________________________________________//
	@Override
	public int compareTo(Club o) {
		return id.compareTo(o.getId());
	}
	// _________________________________________________________________________________________________________//
	@Override
	public int compare(Club o1, Club o2) {
		return o1.getClubName().compareTo(o2.getClubName());
	}
	// _________________________________________________________________________________________________________//
	public int compareByDate(Club o) {
		return formatDate(dateCreation).compareTo(formatDate(o.getDateCreation()));
	}
	// _________________________________________________________________________________________________________//
	public int compareByPet(Club o) {
		return petType.compareTo(o.getPetType());
	}
	// _________________________________________________________________________________________________________//
	public int compareByIdBS(String o) {
		return id.compareTo(o);
	}
	// _________________________________________________________________________________________________________//
	public int compareByNameBS(String o) {
		return clubName.compareTo(o);
	}
	// _________________________________________________________________________________________________________//
	public int compareByDateBS(String o) {
		int date = -1;
		try {
			date = formatDate(dateCreation).compareTo(formatDate(o));
		} catch (NullPointerException e) {
			e.getMessage();
		}
		return date;
	}
	// _________________________________________________________________________________________________________//
	public int compareByPetBS(String o) {
		return petType.compareTo(o);
	}
	// _________________________________________________________________________________________________________//
	public void orderOwnersById() {
		for (int i = 0; i < owners.size(); i++) {
			for (int j = 0; j < owners.size() - 1 - i; j++) {
				if (owners.get(j).compareTo(owners.get(j + 1)) > 0) {
					Owner temp = owners.get(j);
					owners.set(j, owners.get(j + 1));
					owners.set(j + 1, temp);
				}
			}
		}
	}
	// _________________________________________________________________________________________________________//
	public void orderOwnersByName() {
		for (int i = 0; i < owners.size() - 1; i++) {
			Owner minor = owners.get(i);
			int index = i;

			for (int j = i + 1; j < owners.size(); j++) {
				if (owners.get(j).compare(minor, owners.get(j)) > 0) {
					minor = owners.get(j);
					index = j;
				}
			}
			Owner temp = owners.get(i);
			owners.set(i, minor);
			owners.set(index, temp);
		}
	}
	// _________________________________________________________________________________________________________//
	public void orderOwnersByLastName() {
		for (int i = 1; i < owners.size(); i++) {
			for (int j = i; j > 0 && owners.get(j).compareByLastName(owners.get(j - 1)) < 0; j--) {
				Owner temp = owners.get(j);
				owners.set(j, owners.get(j - 1));
				owners.set(j - 1, temp);
			}
		}
	}
	// _________________________________________________________________________________________________________//
	public void orderOwnersByDate() {
		for (int i = 0; i < owners.size(); i++) {
			for (int j = 0; j < owners.size() - 1 - i; j++) {
				if (owners.get(j).compareByDate(owners.get(j + 1)) > 0) {
					Owner temp = owners.get(j);
					owners.set(j, owners.get(j + 1));
					owners.set(j + 1, temp);
				}
			}
		}
	}
	// _________________________________________________________________________________________________________//
	public void orderOwnersByPet() {
		for (int i = 0; i < owners.size() - 1; i++) {
			Owner minor = owners.get(i);
			int index = i;

			for (int j = i + 1; j < owners.size(); j++) {
				if (owners.get(j).compareByPet(minor) < 0) {
					minor = owners.get(j);
					index = j;
				}
			}
			Owner temp = owners.get(i);
			owners.set(i, minor);
			owners.set(index, temp);
		}
	}
	// _________________________________________________________________________________________________________//
	public void orderOwnersByNumberPets() {
		for (int i = 0; i < owners.size(); i++) {
			for (int j = 0; j < owners.size() - 1 - i; j++) {
				if (owners.get(j).numberPets() > owners.get(j + 1).numberPets()) {
					Owner temp = owners.get(j);
					owners.set(j, owners.get(j + 1));
					owners.set(j + 1, temp);
				}
			}
		}
	}
	// _________________________________________________________________________________________________________//
	public String secuencialSearchById(String id) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getId().equalsIgnoreCase(id)) {
				msg += owners.get(i);
			}
		}
		if(msg.equals("")) {
			msg = "No se encontro ningun dueño con los datos especificados";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
	public String secuencialSearchByName(String name) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getName().equalsIgnoreCase(name)) {
				msg += owners.get(i);
			}
		}
		if(msg.equals("")) {
			msg = "No se encontro ningun dueño con los datos especificados";
		}
		return msg;

	}
	// _________________________________________________________________________________________________________//
	public String secuencialSearchByLastName(String clubName) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getLastName().equalsIgnoreCase(clubName)) {
				msg += owners.get(i);
			}
		}
		if(msg.equals("")) {
			msg = "No se encontro ningun dueño con los datos especificados";
		}
		return msg;

	}
	// _________________________________________________________________________________________________________//
	public String secuencialSearchByOwnerDate(String date) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getBirthDate().equalsIgnoreCase(date)) {
				msg += owners.get(i);
			}
		}
		if(msg.equals("")) {
			msg = "No se encontro ningun dueño con los datos especificados";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
	public String secuencialSearchByPet(String pet) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getFavoritePet().equalsIgnoreCase(pet)) {
				msg += owners.get(i);
			}
		}
		if(msg.equals("")) {
			msg = "No se encontro ningun dueño con los datos especificados";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
	public String binarySearchById(String id) {
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = owners.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (owners.get(middle).compareByIdBS(id) == 0) {
				found = true;
				msg += owners.get(middle);
			} else if (owners.get(middle).compareByIdBS(id) > 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}
		if(msg.equals("")) {
			msg = "No se encontro ningun dueño con los datos especificados";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
	public String binarySearchByName(String name) {
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = owners.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (owners.get(middle).compareByNameBS(name) == 0) {
				found = true;
				msg += owners.get(middle);
			} else if (owners.get(middle).compareByNameBS(name) > 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}
		if(msg.equals("")) {
			msg = "No se encontro ningun dueño con los datos especificados";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
	public String binarySearchByLastName(String lastName) {
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = owners.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (owners.get(middle).compareByLastNameBS(lastName) == 0) {
				found = true;
				msg += owners.get(middle);
			} else if (owners.get(middle).compareByLastNameBS(lastName) > 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}
		if(msg.equals("")) {
			msg = "No se encontro ningun dueño con los datos especificados";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
	public String binarySearchByDate(String date) {
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = owners.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (owners.get(middle).compareByDateBS(date) == 0) {
				found = true;
				msg += owners.get(middle);
			} else if (owners.get(middle).compareByDateBS(date) > 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}
		if(msg.equals("")) {
			msg = "No se encontro ningun dueño con los datos especificados";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
	public String binarySearchByPet(String pet) {
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = owners.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (owners.get(middle).compareByPetBS(pet) == 0) {
				found = true;
				msg += owners.get(middle);
			} else if (owners.get(middle).compareByPetBS(pet) > 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}
		if(msg.equals("")) {
			msg = "No se encontro ningun dueño con los datos especificados";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
	public String deleteOwnerById(String identification) {
		String msg = "";
		boolean close = true;
		for (int i = 0; i < owners.size() && close; i++) {
			if(owners.get(i).getId().equals(identification)) {
				owners.remove(i);
				msg += "Se ha eliminado un dueño";
				close = false;
			}	
		}
		if(msg.equals("")) {
			msg = "No se ha eliminado ningun dueño, quiza no exista o te quieres pasar de listo conmigo mushasito :)";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
	public String deleteOwnerByName(String ownerName) {
		boolean close = true;
		String msg = "";
		for (int i = 0; i < owners.size() && close; i++) {
			if(owners.get(i).getName().equals(ownerName)) {
				owners.remove(i);
				msg += "Se ha eliminado un dueño";
				close = false;
			}	
		}
		if(msg.equals("")) {
			msg = "No se ha eliminado ningun dueño, quiza no exista o te quieres pasar de listo conmigo mushasito :)";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
	public String paint() {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg += "\n" + owners.get(i);
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
}
