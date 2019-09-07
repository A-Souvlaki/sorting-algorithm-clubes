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
	//Atributes
	
	private ArrayList<Club> clubs;

	private String clubFile;
	
	/*
	 * Constructor
	 */
	public ClubAdministration(String clubFile) throws ElementExistsExcepcion {
		this.clubFile = clubFile;
		clubs = loadclubs();
		loadOwners();
		verifyInvariantOwners();
		verifyInvariantPets();
	}
	

/**
	 * This method allows add random owners to the clubs that have been added to the Management
	 * @throws ElementExistsExcepcion 
	 */
	private void dataDefaultOwners() throws ElementExistsExcepcion {
		File file = new File("test.CSV");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			for (int i = 0; i < clubs.size(); i++) {
				int iterator = 0;
				do {
					String lines = br.readLine();
					String[] write = lines.split(",");
					clubs.get(i).getOwners().add(new Owner(write[0], write[1], write[2], write[3], write[4]));
					writeOwners();
					iterator++;
				}
				while(iterator < 2);
			}
			br.close();
		}catch (IOException e) {
			e.getStackTrace();
		}
	}
	

	private void dataDefaultPets() {
		BufferedReader br = null;
		File file = new File("pets.CSV");
		try {
			br = new BufferedReader(new FileReader(file)); 
			for (int i = 0; i < clubs.size(); i++) {
				for (int j = 0; j < clubs.get(i).getOwners().size(); j++) {
					int iterator = 0;
					do {
						String lines = br.readLine();
						String[] write = lines.split(",");
						clubs.get(i).getOwners().get(j).registerPet(write[0], write[1], write[2], write[3], write[4]);
						writeOwners();
						iterator++;
					}
					while(iterator < 1);
				}
			}
			br.close();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
		}
	}
	
	private void verifyInvariantOwners() throws ElementExistsExcepcion{
		for (Club club : clubs) {
			if(club.getOwners().isEmpty()) { 
				dataDefaultOwners();
			}
		}
	}
	
	private void verifyInvariantPets() {
		for (Club club : clubs) {
			for (Owner owner : club.getOwners()) {
				if(owner.getPets().isEmpty()) {
					dataDefaultPets();
				}
			}
		}
	}
	
	/**
	 * 	This method allows to recover an owner like a serializable object 
	 */
	public void writeOwners() {
		ObjectOutputStream oos;
		File file = new File("Prueba.dat");
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
		
			for (int i = 0; i < clubs.size(); i++) {
				oos.write(i);
				oos.writeObject(clubs.get(i).getOwners());
			}
			oos.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * This method allows to save an owmer like a serializable object
	 */
	public void loadOwners() {
		File file = new File("Prueba.dat");
		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				for (int i = 0; i < clubs.size(); i++) {
					int pos = ois.read();
					ArrayList<Owner> o = (ArrayList<Owner>)ois.readObject();
					clubs.get(pos).setOwners(o);
				}
				ois.close();
			}catch (Exception e) { 
				// TODO: handle exception
			}
		}
		
	}
	/**
	 * This method allows to load the file with the clubs that were created before.
	 * @return A list with the available clubs or if the program is executed by
	 *         first time a empty list.
	 */
	private ArrayList<Club> loadclubs() {
		ArrayList<Club> nclubs = new ArrayList<Club>(); 
		File file = new File(clubFile);
		if (file.isFile()) { // Verify if it is a file
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
		}
		
		return nclubs;
	}
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
	/**
	 * This method allows to create a club
	 * @param id The club's id. This id must will not repeated between the clubs list
	 * @param clubName The club's name
	 * @param dateCreation The club's creation date
	 * @param petType The club's type
	 */
	public void registerClub(String id, String clubName, String dateCreation, String petType) {
		clubs.add(new Club(id,clubName,dateCreation,petType));
		saveclubs();
	}
	
	/**
	 * This method allows to find a club by its id
	 * @param id the id's club
	 * @return A Club
	 */
	public Club searchClub(String id) {
		Club searched = null;
		boolean close = true;
		for (int i = 0; i < clubs.size() && close; i++) {
			if(clubs.get(i).getId().equals(id)) { 
				searched = clubs.get(i);
				close = false;
			}
				 
		}
		return searched;
	}
	/**
	 * This method allows to order a club's list by bubble sort
	 */
	public void orderClubsById() {
		for (int i = 0; i < clubs.size(); i++) {
			for (int j = 0; j < clubs.size()-1-i; j++) {
				if(clubs.get(j).compareTo(clubs.get(j+1)) > 0) {
					Club temp = clubs.get(j);
					clubs.set(j, clubs.get(j+1));
					clubs.set(j+1, temp);		
				}
			}
		}
	}
	/**
	 * This method allows to order a club's list by selection sort
	 */
	public void orderClubsByClubName() {
		for (int i = 0; i < clubs.size(); i++) {
			Club minor = clubs.get(i);
			int index = i;
			for (int j = i +1; j < clubs.size(); j++) {
				if(clubs.get(j).compare(minor, clubs.get(j)) > 0) {
					minor = clubs.get(j);
					index = j;
				}
			}
			Club temp = clubs.get(i);
			clubs.set(i, minor);
			clubs.set(index, temp);
		}
	}
	/**
	 * This method allows to order a club's list by insertion sort
	 */
	public void orderClubsByDate() {
		for (int i = 1; i < clubs.size(); i++) {
			for (int j = i; j > 0 && clubs.get(j).compareByDate(clubs.get(j-1)) < 0 ; j--) {
				Club temp = clubs.get(j);
				clubs.set(j, clubs.get(j-1));
				clubs.set(j-1, temp);
			}
		}
	}
	
	public void orderClubsByPet() {
		for (int i = 0; i < clubs.size(); i++) {
			for (int j = 0; j < clubs.size()-1-i; j++) {
				if(clubs.get(j).compareByPet(clubs.get(j+1))>0) {
					Club temp = clubs.get(j);
					clubs.set(j, clubs.get(j+1));
					clubs.set(j+1, temp);	
				}
			}
		}
	}
	
	public void orderClubsByNumberOwners() {
		for (int i = 0; i < clubs.size(); i++) {
			for (int j = 0; j < clubs.size()-1-i; j++) {
				if(clubs.get(j).numberOwners() > clubs.get(j+1).numberOwners()) {
					Club temp = clubs.get(j);
					clubs.set(j, clubs.get(j+1));
					clubs.set(j+1, temp);	
				}
			}
		}
	}
	
	public String secuencialSearchById(String id) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getId().equalsIgnoreCase(id)) {
				msg += clubs.get(i);
			}
		}
		return msg;
	}
	
	public String secuencialSearchByClubName(String clubName) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getClubName().equalsIgnoreCase(clubName)) {
				msg += clubs.get(i);
			}
		}
		return msg;
			
	}
	public String secuencialSearchByClubDate(String date) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getDateCreation().equalsIgnoreCase(date)) {
				msg += clubs.get(i);
			}
		}
		return msg;
	}
	public String secuencialSearchByPet(String pet) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getPetType().equalsIgnoreCase(pet)) {
				msg += clubs.get(i);
			}
		}
		return msg;
	}
	
	public String binarySearchById(String id) {
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = clubs.size()-1;
		while (start <= end && !found) {
			int middle = (start+end)/2;
			if(clubs.get(middle).compareByIdBS(id)==0) {
				found = true;
				msg += clubs.get(middle);		
			}else if(clubs.get(middle).compareByIdBS(id)>0) {
				end = middle -1;
			}else {
				start = middle+1;
			}
			
		}
		return msg;
	}
	
	public String binarySearchByClubName(String name) {
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = clubs.size()-1;
		while (start <= end && !found) {
			int middle = (start+end)/2;
			if(clubs.get(middle).compareByNameBS(name)==0) {
				found = true;
				msg += clubs.get(middle);		
			}else if(clubs.get(middle).compareByNameBS(name)>0) {
				end = middle -1;
			}else {
				start = middle+1;
			}
			
		}
		return msg;	
	}
	public String binarySearchByClubDate(String date) {
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = clubs.size()-1;
		while (start <= end && !found) {
			int middle = (start+end)/2;
			if(clubs.get(middle).compareByDateBS(date)==0) {
				found = true;
				msg += clubs.get(middle);		
			}else if(clubs.get(middle).compareByDateBS(date)>0) {
				end = middle -1;
			}else {
				start = middle+1;
			}
			
		}
		return msg;	
	}
	public String binarySearchByPet(String pet) {
		String msg = "";
		boolean found = false;
		int start = 0;
		int end = clubs.size()-1;
		while (start <= end && !found) {
			int middle = (start+end)/2;
			if(clubs.get(middle).compareByPetBS(pet)==0) {
				found = true;
				msg += clubs.get(middle);		
			}else if(clubs.get(middle).compareByPetBS(pet)>0) {
				end = middle -1;
			}else {
				start = middle+1;
			}
			
		}
		return msg;	
	}
	
		
	public String paint() {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			msg += "\n" + clubs.get(i);
		}
		return msg;
	}


}
