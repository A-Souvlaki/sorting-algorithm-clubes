package model;

public class Pet {
	
	private String id;
	private String petName;
	private String petBirthDay;
	private char gender;
	private String type;
	
	public Pet(String id, String petName,String petBirthDay,char gender,String type){
		this.id = id;
		this.petName = petName;
		this.petBirthDay = petBirthDay;
		this.gender = gender;
		this.type = type;
	}
	
}
