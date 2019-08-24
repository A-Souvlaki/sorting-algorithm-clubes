package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Club implements Serializable {

	private String id;
	private String clubName;
	private String dateCreation;
	private String petType;

	private ArrayList<Owner> owners;

	public Club(String id, String clubName, String dateCreation, String petType) {
		this.id = id;
		this.clubName = clubName;
		this.dateCreation = dateCreation;
		this.petType = petType;
		owners = loadOwners();
		
	}

	private ArrayList<Owner> loadOwners() {
		ArrayList<Owner> nOwners = new ArrayList<Owner>();
		File file = new File("OwnersList.txt");
		if (file.isFile()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)); 
				Owner owner = (Owner)ois.readObject();
				nOwners.add(owner);
				ois.close();
			} catch (ClassNotFoundException e) {
				e.getCause();
			}catch (IOException e) { 
				e.getCause();
			}
		}
		return nOwners;
	}

	public void saveOwnersOnFile() {
		File file = new File("OwnersList.txt"); 
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for (Owner owner : owners) {
				oos.writeObject(owner);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public void registerOwner(String id, String name, String lastName, String birthDate, String favoritePet) {
		owners.add(new Owner(id, name, lastName, birthDate, favoritePet));
		saveOwnersOnFile();
	}
	
	public Owner searchOwner(String id) {
		Owner searched = null;
		boolean close = true;
		for (int i = 0; i < owners.size() && close; i++) {
			if(owners.get(i).getId().equals(id)) {
				searched = owners.get(i); 
				close = false;	 
			}
			
		}
		return searched;
	}
	
	

}
