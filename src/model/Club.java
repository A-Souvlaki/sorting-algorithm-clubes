package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import org.xml.sax.helpers.ParserFactory;

import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Club implements Serializable,Comparable<Club>,Comparator<Club>{

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
		if(owners == null) {
			owners = new ArrayList<Owner>();
			serializableCSV();
		}else {
			owners = loadOwners();
		}	
	}
	
	private void serializableCSV() {
		File file = new File("OwnersNoSerializable.CSV");
		if (file.isFile()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String lines;
				while((lines = br.readLine())!= null) {
					String[] write = lines.split(",");
					owners.add(new Owner(write[0],write[1],write[2],write[3],write[4]));
				}
				br.close();
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
		saveOwnersOnFile();
	}

	private ArrayList<Owner> loadOwners() {
		ArrayList<Owner> nOwners = new ArrayList<Owner>();
		File file = new File("OwnersSerializable.CSV");
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
		File file = new File("OwnersSerializable.CSV"); 
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for (Owner owner : owners) {
				oos.writeObject(owner);
			}
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Date formatDate(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = dateFormat.parse(format);
		}catch (ParseException e) {
			e.getStackTrace();
		}
		return date;
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

	@Override
	public String toString() {
		return "Club [id=" + id + ", Nombre=" + clubName + ", Fecha de Creacion=" + dateCreation + ", Tipo de mascotas=" + petType
				+ ", owners=" + owners + "]";
	}

	@Override
	public int compareTo(Club o) {
		return id.compareTo(o.getId());
	}

	@Override
	public int compare(Club o1, Club o2) {
		return o1.getClubName().compareTo(o2.getClubName());
	}
	
	public int compareByDate(Club o) {
		return formatDate(dateCreation).compareTo(formatDate(o.getDateCreation()));
	}
	
	
	
	

}
