package model;

import java.io.Serializable;

public class Pet implements Serializable {
	
	private String id;
	private String petName;
	private String petBirthDay;
	private String gender;
	private String type;
	
	public Pet(String id, String petName,String petBirthDay,String gender,String type){ 
		this.id = id;
		this.petName = petName;
		this.petBirthDay = petBirthDay;
		this.gender = gender;
		this.type = type;
	}
	
	
	 
}
 