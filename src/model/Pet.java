package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Pet implements Serializable, Comparable<Pet>,Comparator<Pet> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	

	public String getId() {
		return id;
	}

	public String getPetName() {
		return petName;
	}

	public String getPetBirthDay() {
		return petBirthDay;
	}

	public String getGender() {
		return gender;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Pet"+" |id=" + id + "| petName=" + String.format("%1$-13s",petName) + "| petBirthDay=" + String.format("%1$-13s",petBirthDay) + "| gender=" + String.format("%1$-13s",gender)
				+ "| type=" + String.format("%1$-13s",type);
	}
	@Override
	public int compareTo(Pet o) {
		return id.compareTo(o.getId());
	}
	
	@Override
	public int compare(Pet o1, Pet o2) {
		return o1.getPetName().compareTo(o2.getPetName());
	}
	
	/**
	 * This method allows turn a String into a Date
	 * 
	 * @param format A date with the format "dd-mm-yyyy"
	 * @return A Date type object
	 */
	public Date formatDate(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = dateFormat.parse(format);
		} catch (ParseException e) {
			e.getStackTrace();
		}
		return date;
	}
	
	public int compareByDate(Pet o) {
		return petBirthDay.compareTo(o.getPetBirthDay());
	}
	
	public int compareByType(Pet o) {
		return type.compareTo(o.getType());
	}
	
	public int compareByIdBS(String o) {
		return id.compareTo(o);
	}

	public int compareByNameBS(String o) {
		return petName.compareTo(o);
	}
	

	public int compareByDateBS(String o) {
		return formatDate(petBirthDay).compareTo(formatDate(o));
	}

	public int compareByPetBS(String o) {
		return type.compareTo(o);
	}
	

	
	
	
	
	
	 
}
 