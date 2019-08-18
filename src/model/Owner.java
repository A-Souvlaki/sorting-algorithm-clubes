package model;

public class Owner {
	
	private String id;
	private String name;
	private String lastName;
	private String birthDate;
	private String favoritePet;
	
	public Owner(String id,String name,String lastName,String birthDate,String favoritePet) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.favoritePet = favoritePet; 
	}
}
