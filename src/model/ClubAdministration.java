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
	}
	

	public Club searchClub(String id) {
		Club searched = null;
		for (int i = 0; i < clubes.size(); i++) {
			if(clubes.get(i).getId().equals(id))
				searched = clubes.get(i);
		}
		return searched;
	}


}
