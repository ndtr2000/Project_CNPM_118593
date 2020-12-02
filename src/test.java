/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khangt1k25
 */

import java.util.Date;

public class test{
	protected Date startDateTerm;
	protected Date endDateTerm;
	
	public Leader(String idPerson, String idFamily, String lastName, String firstName, String relationship, Date birth, String gender, String address, String email,
			String phoneNum, String identityID, String education, String job, Date startDateTerm, Date endDateTerm) {
		super(idPerson, idFamily, lastName, firstName, relationship, birth, gender, address, email, phoneNum, identityID, education, job);
		this.startDateTerm = startDateTerm;
		this.endDateTerm = endDateTerm;
	}

	public Date getStartDateTerm() {
		return startDateTerm;
	}

	public void setStartDateTerm(Date startDateTerm) {
		this.startDateTerm = startDateTerm;
	}

	public Date getEndDateTerm() {
		return endDateTerm;
	}

	public void setEndDateTerm(Date endDateTerm) {
		this.endDateTerm = endDateTerm;
	}

	@Override
	public String toString() {
		return "Leader [startDateTerm=" + startDateTerm + ", endDateTerm=" + endDateTerm + ", lastName=" + lastName
				+ ", firstName=" + firstName + "]";
	}
	
	
}
