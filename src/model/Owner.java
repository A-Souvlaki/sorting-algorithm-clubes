package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Owner implements Serializable{
	
	private String id;
	private String name;
	private String lastName;
	private String birthDate;
	private String favoritePet;
	
	private ArrayList<Pet> pets;
	
	public Owner(String id,String name,String lastName,String birthDate,String favoritePet) { 
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.favoritePet = favoritePet; 
		pets = new ArrayList<Pet>(); 
	}
	
	public void registerPet(String id, String petName,String petBirthDay,String gender,String type) {
		pets.add(new Pet(id,petName,petBirthDay,gender,type));
	}

	public String getId() {
		return id;
	}

	
	


}
