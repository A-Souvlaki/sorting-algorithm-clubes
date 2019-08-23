package model;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
		owners = new ArrayList<Owner>();
	}
	private ArrayList<Owner> loadOwners(){
		ArrayList<Owner> nOwners = new ArrayList<Owner>();
		return nOwners;
	}
	
	public void saveOwnersOnFile() {
		File file = new File("OwnersList.txt");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for (Owner owner: owners) {
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
	
	public void registerOwner(String id,String name,String lastName,String birthDate,String favoritePet) {
		owners.add(new Owner(id,name,lastName,birthDate,favoritePet));
		saveOwnersOnFile();
	}
	
	



	
	

	
}
