package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ClubAdministration implements Serializable {
	
	private ArrayList<Club> clubs;

	public ClubAdministration() {
		clubs = new ArrayList<Club>();
	}

	public void registerClub(String id, String clubName, String dateCreation, String petType) {
		clubs.add(new Club(id, clubName, dateCreation, petType));
	}

	public void saveClubesOnFile() {
		File file = new File("listaClubes.txt");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Club club : clubs) {
				bw.write(club.getId() + ", " + club.getClubName() + ", " + club.getDateCreation() + ", "
						+ club.getPetType());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Ficheros: error en la escritura");
		}
	}

	public void searchClub(String idClub, String id, String name, String lastName, String birthDate,String favoritePet) {
		for (Club club : clubs) {
			if (idClub == club.getId())
				club.registerOwner(id, name, lastName, birthDate, favoritePet);
				club.saveOwnersInFile();
		}
	}

}
