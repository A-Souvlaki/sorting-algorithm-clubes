package model;

import java.io.BufferedReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;;

public class ClubAdministration {
	// Atributes

	private ArrayList<Club> clubs;

	private String clubFile;
	private String serializableFile;
	private String loadOwners;
	private String loadPets;

	/*
	 * Constructor
	 */
	public ClubAdministration(String clubFile, String serilizableFile, String loadOwners, String loadPets)
			throws ElementExistsExcepcion {
		this.clubFile = clubFile;
		this.serializableFile = serilizableFile;
		this.loadOwners = loadOwners;
		this.loadPets = loadPets;
		// Method by the persistence
		clubs = loadclubs();
		loadOwners(serilizableFile);
		verifyInvariantOwners(loadOwners,loadPets);
		
	}

	// _________________________________________________________________________________________________________//
	public ArrayList<Club> getClubs() {
		return clubs;
	}

	// _________________________________________________________________________________________________________//
	/*
	 * The next methods allows the I/O from files and works if you don't touch them,
	 * so be careful
	 */
	// _________________________________________________________________________________________________________//
	/**
	 * This method allows add random owners to the clubs that have been added to the
	 * Management
	 * 
	 * @throws ElementExistsExcepcion
	 */
	private void dataDefaultOwners(String data) throws ElementExistsExcepcion {
		File file = new File(data);
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				for (int i = 0; i < clubs.size(); i++) {
					int iterator = 0;
					do {
						String lines = br.readLine();
						String[] write = lines.split(",");
						clubs.get(i).getOwners().add(new Owner(write[0], write[1], write[2], write[3], write[4]));
						writeOwners(serializableFile);
						iterator++;
					} while (iterator < 20);
				}
				br.close();
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to add random pets to the owners in the clubs
	 * 
	 * @param data
	 */
	private void dataDefaultPets(String data) {
		BufferedReader br = null;
		File file = new File(data);
		if (file.exists()) {
			try {
				br = new BufferedReader(new FileReader(file));
				for (int i = 0; i < clubs.size(); i++) {
					for (int j = 0; j < clubs.get(i).getOwners().size(); j++) {
						int iterator = 0;
						do {
							String lines = br.readLine();
							String[] write = lines.split(",");
							clubs.get(i).getOwners().get(j).registerPet(write[0], write[1], write[2], write[3],
									write[4]);
							writeOwners(serializableFile);
							iterator++;
						} while (iterator < 1);
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ElementExistsExcepcion e) {
				e.printStackTrace();
			}
		}

	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to load a default owner's list one time
	 * 
	 * @param data The file from the data will be load
	 * @throws ElementExistsExcepcion
	 */
	private void verifyInvariantOwners(String dataO, String dataP) throws ElementExistsExcepcion {
		for (Club club : clubs) {
			if (club.getOwners().isEmpty()) { 
				dataDefaultOwners(dataO);
				dataDefaultPets(dataP);
			}
		}
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to recover an owner like a serializable object
	 */
	public void writeOwners(String f) {
		ObjectOutputStream oos;
		File file = new File(f);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));

			for (int i = 0; i < clubs.size(); i++) {
				oos.write(i);
				oos.writeObject(clubs.get(i).getOwners());
			}
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to save an owmer like a serializable object
	 */
	public void loadOwners(String f) {
		File file = new File(f);
		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				for (int i = 0; i < clubs.size(); i++) {
					int pos = ois.read();
					ArrayList<Owner> o = (ArrayList<Owner>) ois.readObject();
					clubs.get(pos).setOwners(o);
				}
				ois.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to load the file with the clubs that were created before.
	 * 
	 * @return A list with the available clubs or if the program is executed by
	 *         first time a empty list.
	 */
	private ArrayList<Club> loadclubs() {
		ArrayList<Club> nclubs = new ArrayList<Club>();
		File file = new File(clubFile);
		if (file.exists()) { // Verify if it is a file
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));// read the file
				String lines;
				while ((lines = br.readLine()) != null) {
					String[] write = lines.split(",");
					nclubs.add(new Club(write[0], write[1], write[2], write[3]));// add the clubs
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			nclubs = new ArrayList<Club>();
		}

		return nclubs;
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to save the clubs in a text file.
	 */
	public void saveclubs() {
		File file = new File(clubFile);
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Club club : clubs) {
				bw.write(club.getId() + "," + club.getClubName() + "," + club.getDateCreation() + ","
						+ club.getPetType());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// _________________________________________________________________________________________________________//
	/*
	 * Please read the pre-conditions of every method.
	 */
	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to create a club Pre: The club's list must be not null
	 * 
	 * @param id The club's id. This id must will not repeated between the clubs list
	 * @param clubName The club's name
	 * @param dateCreation The club's creation date
	 * @param petTypeThe club's type
	 */
	public void registerClub(String id, String clubName, String dateCreation, String petType) {
		clubs.add(new Club(id, clubName, dateCreation, petType));
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to find a club by means of its "id" Pre: The club's list
	 * must be not null
	 * @param id the id's club
	 * @return A Club
	 */
	public Club searchClub(String id) {
		Club searched = null;
		boolean close = true;
		for (int i = 0; i < clubs.size() && close; i++) {
			if (clubs.get(i).getId().equals(id)) {
				searched = clubs.get(i);
				close = false;
			}
		}
		return searched;
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to order a club's list by bubble sort
	 */
	public void orderClubsById() {
		for (int i = 0; i < clubs.size(); i++) {
			for (int j = 0; j < clubs.size() - 1 - i; j++) {
				if (clubs.get(j).compareTo(clubs.get(j + 1)) > 0) {
					Club temp = clubs.get(j);
					clubs.set(j, clubs.get(j + 1));
					clubs.set(j + 1, temp);
				}
			}
		}
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to order a club's list by selection sort
	 */
	public void orderClubsByClubName() {
		for (int i = 0; i < clubs.size(); i++) {
			Club minor = clubs.get(i);
			int index = i;
			for (int j = i + 1; j < clubs.size(); j++) {
				if (clubs.get(j).compare(minor, clubs.get(j)) > 0) {
					minor = clubs.get(j);
					index = j;
				}
			}
			Club temp = clubs.get(i);
			clubs.set(i, minor);
			clubs.set(index, temp);
		}
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to order a club's list by insertion sort
	 */
	public void orderClubsByDate() {
		for (int i = 1; i < clubs.size(); i++) {
			for (int j = i; j > 0 && clubs.get(j).compareByDate(clubs.get(j - 1)) < 0; j--) {
				Club temp = clubs.get(j);
				clubs.set(j, clubs.get(j - 1));
				clubs.set(j - 1, temp);
			}
		}
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to order a club's list by bubble sort
	 */
	public void orderClubsByPet() {
		for (int i = 0; i < clubs.size(); i++) {
			for (int j = 0; j < clubs.size() - 1 - i; j++) {
				if (clubs.get(j).compareByPet(clubs.get(j + 1)) > 0) {
					Club temp = clubs.get(j);
					clubs.set(j, clubs.get(j + 1));
					clubs.set(j + 1, temp);
				}
			}
		}
	}

	// _________________________________________________________________________________________________________//
	/**
	 * This method allows to order a club's list by bubble sort
	 */
	public void orderClubsByNumberOwners() {
		for (int i = 0; i < clubs.size(); i++) {
			for (int j = 0; j < clubs.size() - 1 - i; j++) {
				if (clubs.get(j).numberOwners() > clubs.get(j + 1).numberOwners()) {
					Club temp = clubs.get(j);
					clubs.set(j, clubs.get(j + 1));
					clubs.set(j + 1, temp);
				}
			}
		}
	}

	// _________________________________________________________________________________________________________//
	public String secuencialSearchById(String identification) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if (identification.equals(clubs.get(i).getId())) {
				msg += clubs.get(i);
			}
		}
		if(msg.equals("")) {
			msg = "No se encontro ningun club con los datos especificados";
		}
		return msg;
	}

	// _________________________________________________________________________________________________________//
	public String secuencialSearchByClubName(String clubName) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).getClubName().equalsIgnoreCase(clubName)) {
				msg += clubs.get(i);
			}
		}
		if(msg.equals("")) {
			msg = "No se encontro ningun club con los datos especificados";
		}
		return msg;
	}

	// _________________________________________________________________________________________________________//
	public String secuencialSearchByClubDate(String date) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).getDateCreation().equalsIgnoreCase(date)) {
				msg += clubs.get(i);
			}
		}
		if(msg.equals("")) {
			msg = "No se encontro ningun club con los datos especificados";
		}
		return msg;
	}

	// _________________________________________________________________________________________________________//
	public String secuencialSearchByPet(String pet) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).getPetType().equalsIgnoreCase(pet)) {
				msg += clubs.get(i);
			}
		}
		if(msg.equals("")) {
			msg = "No se encontro ningun club con los datos especificados";
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//

	public String binarySearchById(String id) {
		orderClubsById();
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = clubs.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (clubs.get(middle).compareByIdBS(id) == 0) {
				found = true;
				msg += clubs.get(middle);
			} else if (clubs.get(middle).compareByIdBS(id) > 0) { 
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}
		if(msg.equals("")) {
			msg = "No se encontro ningun club con los datos especificados";
		}
		return msg;
	}

	// _________________________________________________________________________________________________________//
	public String binarySearchByClubName(String name) {
		orderClubsById();
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = clubs.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (clubs.get(middle).compareByNameBS(name) == 0) {
				found = true;
				msg += clubs.get(middle);
			} else if (clubs.get(middle).compareByNameBS(name) > 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}
		if(msg.equals("")) {
			msg = "No se encontro ningun club con los datos especificados";
		}
		return msg;
	}

	// _________________________________________________________________________________________________________//
	public String binarySearchByClubDate(String date) {
		orderClubsById();
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = clubs.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (clubs.get(middle).compareByDateBS(date) == 0) {
				found = true;
				msg += clubs.get(middle);
			} else if (clubs.get(middle).compareByDateBS(date) > 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}
		if(msg.equals("")) {
			msg = "No se encontro ningun club con los datos especificados";
		}
		return msg;
	}

	// _________________________________________________________________________________________________________//
	public String binarySearchByPet(String pet) {
		orderClubsById();
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = clubs.size() - 1;
		while (start <= end && !found) {
			int middle = (start + end) / 2;
			if (clubs.get(middle).compareByPetBS(pet) == 0) {
				found = true;
				msg += clubs.get(middle);
			} else if (clubs.get(middle).compareByPetBS(pet) > 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}
		if(msg.equals("")) {
			msg = "No se encontro ningun club con los datos especificados";
		}
		return msg;
	}

	// _________________________________________________________________________________________________________//
	public String deleteClubById(String identification) {
		String msg = "";
		boolean close = true;
		for (int i = 0; i < clubs.size() && close; i++) {
			if (clubs.get(i).getId().equals(identification)) {
				clubs.remove(i);
				msg = "Se ha eliminado un club";
				close = false;
			}
		}
		if(msg.equals("")) {
			msg = "No se ha eliminado ningun club, quiza no exista o te quieres pasar de listo conmigo mushasito :)";
		}
		return msg;
	}

	// _________________________________________________________________________________________________________//
	public String deleteClubByName(String n) {
		String msg = "";
		boolean close = true;
		for (int i = 0; i < clubs.size() && close; i++) {
			if (clubs.get(i).getClubName().equals(n)) {
				clubs.remove(i);
				msg = "Se ha eliminado un club";
				close = false;
			}
		}
		if(msg.equals("")) {
			msg = "No se ha eliminado ningun club, quiza no exista o te quieres pasar de listo conmigo mushasito :)";
		}
		return msg;
	}

	// _________________________________________________________________________________________________________//
	public String paint() {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			msg += "\n" + clubs.get(i);
		}
		return msg;
	}
	// _________________________________________________________________________________________________________//
}
