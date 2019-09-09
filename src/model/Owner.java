package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Owner implements Serializable, Comparable<Owner>, Comparator<Owner> {  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String lastName;
	private String birthDate;
	private String favoritePet;

	private ArrayList<Pet> pets;

	public Owner(String id, String name, String lastName, String birthDate, String favoritePet) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.favoritePet = favoritePet;
		pets = new ArrayList<Pet>(); 
		
	}
	

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
	
	public boolean givePet(String pN) {
		boolean found = false;
		if(pets != null) {
			for (Pet pet : pets) {
				String i = pet.getId();
				if(pN.equals(i)) {
					found = true;
				}
			}
		}
		return found;
	}

	public void registerPet(String id, String petName, String petBirthDay, String gender, String type) throws ElementExistsExcepcion {
		
		if(givePet(petName) == false) {
			Pet p = new Pet(id, petName, petBirthDay, gender, type);
			pets.add(p);
		}else {
			throw new ElementExistsExcepcion("Hola2");
		}
		
	}

	@Override
	public String toString() {
		return "Owner" + "| Numero de mascotas =" + numberPets()+" |id=" + String.format("%1$-13s", id) + "| name=" + String.format("%1$-13s", name) + "| lastName="
				+ String.format("%1$-13s", lastName) + "| birthDate=" + String.format("%1$-13s", birthDate)
				+ "| favoritePet=" + String.format("%1$-13s", favoritePet);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getFavoritePet() {
		return favoritePet;
	}
	
	public ArrayList<Pet> getPets() {
		return pets;
	}
	
	public int numberPets() {
		return pets.size();
	}

	@Override
	public int compareTo(Owner o) {
		return id.compareTo(o.getId());
	}

	@Override
	public int compare(Owner o1, Owner o2) {
		return o1.getName().compareTo(o2.getName());
	}

	public int compareByLastName(Owner o) {
		return lastName.compareTo(o.getLastName());
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

	public int compareByDate(Owner o) {
		return formatDate(birthDate).compareTo(formatDate(o.getBirthDate()));
	}

	public int compareByPet(Owner o) {
		return favoritePet.compareTo(o.getFavoritePet());
	}
	
	public int compareByIdBS(String o) {
		return id.compareTo(o);
	}

	public int compareByNameBS(String o) {
		return name.compareTo(o);
	}
	
	public int compareByLastNameBS(String o) {
		return lastName.compareTo(o);
	}

	public int compareByDateBS(String o) {
		return formatDate(birthDate).compareTo(formatDate(o));
	}

	public int compareByPetBS(String o) {
		return favoritePet.compareTo(o);
	}

	public void orderPetsById() {
		for (int i = 0; i < pets.size(); i++) {
			for (int j = 0; j < pets.size() - 1 - i; j++) {
				if (pets.get(j).compareTo(pets.get(j + 1)) > 0) {
					Pet temp = pets.get(j);
					pets.set(j, pets.get(j + 1));
					pets.set(j + 1, temp);
				}
			}
		}
	}

	public void orderPetsByName() {
		for (int i = 0; i < pets.size() - 1; i++) {
			Pet minor = pets.get(i);
			int index = i;

			for (int j = i + 1; j < pets.size(); j++) {
				if (pets.get(j).compare(minor, pets.get(j)) > 0) {
					minor = pets.get(j);
					index = j;
				}
			}

			Pet temp = pets.get(i);
			pets.set(i, minor);
			pets.set(index, temp);
		}
	}

	public void orderPetsByDate() {
		for (int i = 1; i < pets.size(); i++) {
			for (int j = i; j > 0 && pets.get(j).compareByDate(pets.get(j - 1)) < 0; j--) {
				Pet temp = pets.get(j);
				pets.set(j, pets.get(j - 1));
				pets.set(j - 1, temp);
			}
		}
	}

	public void orderPetsByType() {
		for (int i = 0; i < pets.size(); i++) {
			for (int j = 0; j < pets.size() - 1 - i; j++) {
				if (pets.get(j).compareByType(pets.get(j + 1)) > 0) {
					Pet temp = pets.get(j);
					pets.set(j, pets.get(j + 1));
					pets.set(j + 1, temp);
				}
			}
		}
	}
	
	public String secuencialSearchById(String id) {
		String msg = "";
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getId().equalsIgnoreCase(id)) {
				msg += pets.get(i);
			}
		}
		return msg;
	}

	public String secuencialSearchByName(String name) {
		String msg = "";
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getPetName().equalsIgnoreCase(name)) {
				msg += pets.get(i);
			}
		}
		return msg;

	}
	

	public String secuencialSearchByDate(String date) {
		String msg = "";
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getPetBirthDay().equalsIgnoreCase(date)) {
				msg += pets.get(i);
			}
		}
		return msg;
	}

	public String secuencialSearchByPet(String pet) {
		String msg = "";
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getType().equalsIgnoreCase(pet)) {
				msg += pets.get(i);
			}
		}
		return msg;
	}

	public String binarySearchById(String id) {
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = pets.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (pets.get(middle).compareByIdBS(id) == 0) {
				found = true;
				msg += pets.get(middle);
			} else if (pets.get(middle).compareByIdBS(id) > 0) {
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
		int end = pets.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (pets.get(middle).compareByNameBS(name) == 0) {
				found = true;
				msg += pets.get(middle);
			} else if (pets.get(middle).compareByNameBS(name) > 0) {
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
		int end = pets.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (pets.get(middle).compareByDateBS(date) == 0) {
				found = true;
				msg += pets.get(middle);
			} else if (pets.get(middle).compareByDateBS(date) > 0) {
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
		int end = pets.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (pets.get(middle).compareByPetBS(pet) == 0) {
				found = true;
				msg += pets.get(middle);
			} else if (pets.get(middle).compareByPetBS(pet) > 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}
		return msg;
	}
	
	public void deletePetById(String identification) {
		boolean close = true;
		for (int i = 0; i < pets.size() && close; i++) {
			if(pets.get(i).getId().equals(identification)) {
				pets.remove(i);
				close = false;
			}	
		}
	}
	
	public void deletePetByName(String petN) {
		boolean close = true;
		for (int i = 0; i < pets.size() && close; i++) {
			if(pets.get(i).getPetName().equals(petN)) {
				pets.remove(i);
				close = false;
			}	
		}
	}

	public String paint() {
		String msg = "";
		for (int i = 0; i < pets.size(); i++) {
			msg += "\n" + pets.get(i);
		}
		return msg;
	}

}
