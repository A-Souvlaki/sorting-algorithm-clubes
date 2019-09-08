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

	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}

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
		}
		return date;
	}

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

	public boolean giveOwner( String id ) {
		boolean found = false;
		if(owners != null) {
			for( int i = 0; i < owners.size( ); i++ ){
				if(owners.get(i).getId().equals(id));
					found = true;
			}
		}
	   return found;
	}

	public void registerOwner(String id, String name, String lastName, String birthDate, String favoritePet) throws ElementExistsExcepcion {
		if(giveOwner(id)) {
			throw new ElementExistsExcepcion("Hola");
		}else {
			Owner o = new Owner(id, name, lastName, birthDate, favoritePet);
			owners.add(o);
		}		
	}

	public int numberOwners() {
		return owners.size();
	}

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

	@Override
	public String toString() {
		return "Club" + "| Numero de Due�os =" + numberOwners() + " |id=" + String.format("%1$-8s", id)
				+ "| Nombre del Club =" + String.format("%1$-8s", clubName) + "| Fecha de Creacion del Club ="
				+ String.format("%1$-8s", dateCreation) + "| Tipo de mascotas que recibe el Club ="
				+ String.format("%1$-8s", petType);
	}

	@Override
	public int compareTo(Club o) {
		return id.compareTo(o.getId());
	}

	@Override
	public int compare(Club o1, Club o2) {
		return o1.getClubName().compareTo(o2.getClubName());
	}

	public int compareByDate(Club o) {
		return formatDate(dateCreation).compareTo(formatDate(o.getDateCreation()));
	}

	public int compareByPet(Club o) {
		return petType.compareTo(o.getPetType());
	}

	public int compareByIdBS(String o) {
		return id.compareTo(o);
	}

	public int compareByNameBS(String o) {
		return clubName.compareTo(o);
	}

	public int compareByDateBS(String o) {
		return formatDate(dateCreation).compareTo(formatDate(o));
	}

	public int compareByPetBS(String o) {
		return petType.compareTo(o);
	}

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

	public void orderOwnersByLastName() {
		for (int i = 1; i < owners.size(); i++) {
			for (int j = i; j > 0 && owners.get(j).compareByLastName(owners.get(j - 1)) < 0; j--) {
				Owner temp = owners.get(j);
				owners.set(j, owners.get(j - 1));
				owners.set(j - 1, temp);
			}
		}
	}

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

	public String secuencialSearchById(String id) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getId().equalsIgnoreCase(id)) {
				msg += owners.get(i);
			}
		}
		return msg;
	}

	public String secuencialSearchByName(String name) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getName().equalsIgnoreCase(name)) {
				msg += owners.get(i);
			}
		}
		return msg;

	}

	public String secuencialSearchByLastName(String clubName) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getLastName().equalsIgnoreCase(clubName)) {
				msg += owners.get(i);
			}
		}
		return msg;

	}

	public String secuencialSearchByOwnerDate(String date) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getBirthDate().equalsIgnoreCase(date)) {
				msg += owners.get(i);
			}
		}
		return msg;
	}

	public String secuencialSearchByPet(String pet) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getFavoritePet().equalsIgnoreCase(pet)) {
				msg += owners.get(i);
			}
		}
		return msg;
	}

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
		return msg;
	}

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
		return msg;
	}

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
		return msg;
	}

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
		return msg;
	}

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
		return msg;
	}
	
	public void deleteOwner(String id) {
		boolean close = true;
		for (int i = 0; i < owners.size() && close; i++) {
			if(owners.get(i).getId().equals(id)) {
				owners.remove(i);
				close = false;
			}	
		}
	}

	public String paint() {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg += "\n" + owners.get(i);
		}
		return msg;
	}

}
