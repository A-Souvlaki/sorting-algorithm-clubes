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
		if(pets == null) {
			pets = new ArrayList<Pet>();
			serializableCSV();
		}else {
			pets = loadPets();
		}
	}
	
	private void serializableCSV() {
		File file = new File("PetsNoSerializable.CSV");
		if (file.isFile()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String lines;
				while ((lines = br.readLine()) != null) {
					String[] write = lines.split(",");
					pets.add(new Pet(write[0], write[1], write[2], write[3], write[4]));
				}
				br.close();
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
		
		savePetsOnFile();
	}
	
	/**
	 * This method allows to recover the pets data in a list for the program
	 * 
	 * @return
	 */
	private ArrayList<Pet> loadPets() {
		ArrayList<Pet> nPets = new ArrayList<Pet>();
		File file = new File("PetSerializable.CSV");
		if (file.isFile()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				Pet owner = (Pet) ois.readObject();
				nPets.add(owner);
				ois.close();
			} catch (ClassNotFoundException e) {
				e.getCause();
			} catch (IOException e) {
				e.getCause();
			}
		}
		return nPets;
	}
	
	/**
	 * Save the pets like serializable objects
	 */
	public void savePetsOnFile() {
		File file = new File("PetSerializable.CSV");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for (Pet pet : pets) {
				oos.writeObject(pet);
			}
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void registerPet(String id, String petName, String petBirthDay, String gender, String type) {
		pets.add(new Pet(id, petName, petBirthDay, gender, type));
		savePetsOnFile();
	}

	@Override
	public String toString() {
		return "Owner" + "| Numero de mascotas =" + numberPets()+" |id=" + String.format("%1$-9s", id) + "| name=" + String.format("%1$-9s", name) + "| lastName="
				+ String.format("%1$-9s", lastName) + "| birthDate=" + String.format("%1$-9s", birthDate)
				+ "| favoritePet=" + String.format("%1$-9s", favoritePet);
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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

	public String paint() {
		String msg = "";
		for (int i = 0; i < pets.size(); i++) {
			msg += "\n" + pets.get(i);
		}
		return msg;
	}

}
