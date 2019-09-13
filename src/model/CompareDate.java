package model;

import java.util.Comparator;

public class CompareDate implements Comparator<Club>{

	@Override
	public int compare(Club o1, Club o2) {
		return o1.getDateCreation().compareTo(o2.getDateCreation());
	}

}
