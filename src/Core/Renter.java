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
}
