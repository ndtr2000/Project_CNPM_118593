package Core;

import java.util.Date;

public class ViceLeader extends Person{
	protected Date startDateTerm;
	protected Date endDateTerm;
	public ViceLeader(String idPerson, String idFamily, String lastName, String firstName, String relationship, Date birth, String gender, String address, String email,
			String phoneNum, String identityID, String education, String job, Date startDateTerm, Date endDateTerm) {
		super(idPerson, idFamily, lastName, firstName, relationship, birth, gender, address, email, phoneNum, identityID, education, job);
		this.startDateTerm = startDateTerm;
		this.endDateTerm = endDateTerm;
	}
}
