import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.prefs.Preferences;

public class person {
	public List<Preferences> myPrefs = new ArrayList<Preferences>();
	private String building;
	private String gender;
	private int academicYear;
	private int numRoommates;
	private boolean isAthlete = false;
	private int age;
	private boolean drinksAlcohol;
	private String hometown;
	private boolean hasPets = false;
	private boolean hasDisability = false;


	/*
	* Default Setup
	*/
	public person() {
	}

	/*
	* Full setup without preferences
	*/
	public person(String building, String gender, int academicYear, int numRoommates, boolean isAthlete, int age,
		boolean drinksAlcohol, String hometown, boolean hasPets, boolean hasDisability) {
		this.building = building;
		this.gender = gender;
		this.academicYear = academicYear;
		this.numRoommates = numRoommates;
		this.isAthlete = isAthlete;
		this.age = age;
		this.drinksAlcohol = drinksAlcohol;
		this.hometown = hometown;
		this.hasPets = hasPets;
		this.hasDisability = hasDisability;
	}
	
	public void survey() {
	}

	public boolean updatePreferences(preferences myPreference, boolean flag) {


		//compare with enum value
		if(preferences.values().equals(myPreference)){
			//do something
			System.out.println("here...");
		}


		// needs meat to search for particular preference and update boolean with new 'flag' value
		for (preferences pref : preferences.values()) {

			if (pref == myPreference) {
				pref.change(flag);
				return true; // exit when value is found
			}
		}

		return false;
	}
	public preferences getPreference( preferences myPreference  ) {

		if ( EnumSet.allOf(preferences.class).contains(myPreference) ) {

			//  update boolean with new 'flag' value
			for (preferences pref : preferences.values()) {

				if (pref == myPreference) {

					return pref; // exit when value is found
				}
			}

		}

		return null;

	}


}
