package Core;

import java.util.Date;

public class Renter extends Person{
	protected String homeTown;
	protected Date startLiving;
	
	public Renter(String idPerson, String idFamily, String lastName, String firstName, String relationship, Date birth, String gender, String address, String email,
			String phoneNum, String identityID, String education, String job, String homeTown, Date startLiving) {
		super(idPerson, idFamily, lastName, firstName, relationship, birth, gender, address, email, phoneNum, identityID, education, job);
		this.homeTown = homeTown;
		this.startLiving = startLiving;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public Date getStartLiving() {
		return startLiving;
	}

	public void setStartLiving(Date startLiving) {
		this.startLiving = startLiving;
	}

	@Override
	public String toString() {
		return "Renter [lastName=" + lastName + ", firstName=" + firstName + "]";
	}
	
}
