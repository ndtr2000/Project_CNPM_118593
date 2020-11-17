package Core;

import java.util.Date;

public class Person {
	protected String idPerson;
	protected String idFamily;
	protected String lastName;
	protected String firstName;
	protected String relationship;
	protected Date birth;
	protected String gender;
	protected String address;
	protected String email;
	protected String phoneNum;
	protected String identityID;
	protected String education;
	protected String job;
	
	
	
	
	
	
	public Person(String idPerson, String idFamily, String lastName, String firstName, String relationship, Date birth, String gender, String address, String email,
			String phoneNum, String identityID, String education, String job) {
		this.idPerson = idPerson;
		this.idFamily = idFamily;
		this.lastName = lastName;
		this.firstName = firstName;
		this.relationship = relationship;
		this.birth = birth;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phoneNum = phoneNum;
		this.identityID = identityID;
		this.education = education;
		this.job = job;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(String idPerson) {
		this.idPerson = idPerson;
	}
	public String getIdFamily() {
		return idFamily;
	}
	public void setIdFamily(String idFamily) {
		this.idFamily = idFamily;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getIdentityID() {
		return identityID;
	}
	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

}
