package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

public class ClubAdministration {
	//Atributes
	
	private ArrayList<Club> clubes;

	private String clubFile;
	
	/*
	 * Constructor
	 */
	public ClubAdministration(String clubFile) {
		this.clubFile = clubFile;
		clubes = loadClubes();
	}

	/**
	 * This method allows to load the file with the clubes that were created before.
	 * @return A list with the available clubes or if the program is excecuted by
	 *         first time a empty list.
	 */
	private ArrayList<Club> loadClubes() {
		ArrayList<Club> nClubes = new ArrayList<Club>();
		File file = new File(clubFile);
		if (file.isFile()) { // Verify if it is a file
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));// read the file 
				String lines;
				while ((lines = br.readLine()) != null) {
					String[] write = lines.split(",");
					nClubes.add(new Club(write[0], write[1], write[2], write[3]));// add the clubes
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return nClubes;
	}
	/**
	 * This method allows to save the cubles in a text file.
	 */
	public void saveClubes() {
		File file = new File(clubFile);
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Club club : clubes) { 
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
	 * @param id The club's id. This id must will not repeated between the clubes list
	 * @param clubName The club's name
	 * @param dateCreation The club's creation date
	 * @param petType The club's type
	 */
	public void registerClub(String id, String clubName, String dateCreation, String petType) {
		clubes.add(new Club(id,clubName,dateCreation,petType));
		saveClubes();
	}
	
	/**
	 * This method allows to find a club by its id
	 * @param id the id's club
	 * @return A Club
	 */
	public Club searchClub(String id) {
		Club searched = null;
		boolean close = true;
		for (int i = 0; i < clubes.size() && close; i++) {
			if(clubes.get(i).getId().equals(id)) { 
				searched = clubes.get(i);
				close = false;
			}
				 
		}
		return searched;
	}
	/**
	 * This method allows to order a club's list by bubble sort
	 */
	public void orderClubsById() {
		for (int i = 0; i < clubes.size(); i++) {
			for (int j = 0; j < clubes.size()-1-i; j++) {
				if(clubes.get(j).compareTo(clubes.get(j+1)) > 0) {
					Club temp = clubes.get(j);
					clubes.set(j, clubes.get(j+1));
					clubes.set(j+1, temp);		
				}
			}
		}
	}
	/**
	 * This method allows to order a club's list by selection sort
	 */
	public void orderClubsByClubName() {
		for (int i = 0; i < clubes.size(); i++) {
			Club minor = clubes.get(i);
			int index = i;
			for (int j = i +1; j < clubes.size(); j++) {
				if(clubes.get(j).compare(minor, clubes.get(j)) > 0) {
					minor = clubes.get(j);
					index = j;
				}
			}
			Club temp = clubes.get(i);
			clubes.set(i, minor);
			clubes.set(index, temp);
			
		}
	}
	/**
	 * This method allows to order a club's list by insertion sort
	 */
	public void orderClubsByDate() {
		for (int i = 1; i < clubes.size(); i++) {
			for (int j = i; j > 0 && clubes.get(j).compareByDate(clubes.get(j-1)) < 0 ; j--) {
				Club temp = clubes.get(j);
				clubes.set(j, clubes.get(j-1));
				clubes.set(j-1, temp);
			}
		}
	}
	
	public String paint() {
		String msg = "";
		for (int i = 0; i < clubes.size(); i++) {
			msg += "\n" + clubes.get(i);
		}
		return msg;
	}


}
