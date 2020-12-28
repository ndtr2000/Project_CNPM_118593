package DAO;

import java.io.FileInputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import Core.Person;

public class PersonDAO {
	private  Connection myCon;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public PersonDAO() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("sql/db.properties"));
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String dburl = prop.getProperty("dburl");
		myCon = DriverManager.getConnection(dburl, user, password);
	}
	
	//Get all People from table into a list
	public List<Person> getAllPeople() throws Exception{
		
		List<Person> listAllPerson = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myCon.createStatement();
			myRs = myStmt.executeQuery("Select * FROM person");
			
			while (myRs.next()) {
				Person tempPerson = convertRowToPerson(myRs);
				listAllPerson.add(tempPerson);
			}
			return listAllPerson;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	//Get All Person from table by Name
	public List<Person> getPersonByName(String name) throws Exception{
		List<Person> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			name += "%";
			myStmt = myCon.prepareStatement("SELECT * FROM person WHERE firstName like ? or lastName like ?");
			myStmt.setString(1, name);
			myStmt.setString(2, name);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Person tempPerson = convertRowToPerson(myRs);
				list.add(tempPerson);
			}
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	// Get Person from table by ID
	public Person getPersonByID (String id) throws Exception{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Person person =null;
		
		try {
			myStmt = myCon.prepareStatement("SELECT * FROM person WHERE idPerson = ?");
			myStmt.setString(1, id);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				person = convertRowToPerson(myRs);
			}
			return person;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	//Adding a Person to talbe
	public void addPerson (Person newPerson) throws Exception{
		PreparedStatement myStmt = null;
                
		try {
			String sql = "INSERT INTO person"
					+ "(idPerson, idFamily, lastName, firstName, relationship, birth, gender, address, email,\r\n"
					+ "				phoneNum, identityID, education, job)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			myStmt = myCon.prepareStatement(sql);
			
			String stringDate = formatter.format(newPerson.getBirth());
			
			myStmt.setString(1, newPerson.getIdPerson());
			myStmt.setString(2, newPerson.getIdFamily());
			myStmt.setString(3, newPerson.getLastName());
			myStmt.setString(4, newPerson.getFirstName());
			myStmt.setString(5, newPerson.getRelationship());
			myStmt.setString(6, stringDate);
			myStmt.setString(7, newPerson.getGender());
			myStmt.setString(8, newPerson.getAddress());
			myStmt.setString(9, newPerson.getEmail());
			myStmt.setString(10, newPerson.getPhoneNum());
			myStmt.setString(11, newPerson.getIdentityID());
			myStmt.setString(12, newPerson.getEducation());
			myStmt.setString(13, newPerson.getJob());
			
			myStmt.executeUpdate();
		}
		finally {
			myStmt.close();
		}
	}
	
	//convert result set to Person
	private Person convertRowToPerson(ResultSet myRs) throws SQLException, ParseException {
		String idPerson = myRs.getString("idPerson");
		String idFamily = myRs.getString("idFamily");
		String lastName = myRs.getString("lastName");
		String firstName = myRs.getString("firstName");
		String relationship = myRs.getString("relationship");
		String birth = myRs.getString("birth");
		String address = myRs.getString("address");
		String gender = myRs.getString("gender");
		String email = myRs.getString("email");
		String phoneNum = myRs.getString("phoneNum");
		String job = myRs.getString("job");
		String identityID = myRs.getString("identityID");
		String education = myRs.getString("education");
		
		Date tempBirth = formatter.parse(birth);
		
		Person person = new Person(idPerson, idFamily, lastName, firstName, relationship, tempBirth, gender, address, email,
				phoneNum, identityID, education, job);
		return person;
		
	}
	
	
	//Updating a Person information in table
	public void updatePerson(Person temp) throws SQLException{
		PreparedStatement myStmt = null;
		try {
			String sql = "UPDATE person"
					+" SET lastName = ?, firstName = ?, birth = ?, address = ?, email = ?, phoneNum = ?, job = ?, identityID = ?, education = ?"
					+" WHERE idPerson = ?";
			myStmt = myCon.prepareStatement(sql);
			
			String stringDate = formatter.format(temp.getBirth());
			
			myStmt.setString(1, temp.getLastName());
			myStmt.setString(2, temp.getFirstName());
			myStmt.setString(3, stringDate);
			myStmt.setString(4, temp.getAddress());
			myStmt.setString(5, temp.getEmail());
			myStmt.setString(6, temp.getPhoneNum());
			myStmt.setString(7, temp.getJob());
			myStmt.setString(8, temp.getIdentityID());
			myStmt.setString(9, temp.getEducation());
			myStmt.setString(10, temp.getIdPerson());
			
			myStmt.executeUpdate();
			
		}
		finally {
			myStmt.close();
		}
	}
	
	//Deleting a Person from table
	public void deletePerson(String idPerson) throws SQLException {
		PreparedStatement myStmt = null;
		try {
			String sql = "DELETE FROM person WHERE idPerson = ?";
			myStmt = myCon.prepareStatement(sql);
			
			myStmt.setString(1, idPerson);
			
			myStmt.executeUpdate();
					
		}
		finally {
			myStmt.close();
		}
	}
	
	private static void close(Connection myCon, Statement myStmt, ResultSet myRs) throws SQLException{
		if (myRs != null) {
			myRs.close();
		}
		
		if (myStmt != null) {
			myStmt.close();
		}
		
		if (myCon != null) {
			myCon.close();
		}
	}
	
	private void close(Statement myStmt, ResultSet myRs) throws SQLException{
		close(null, myStmt, myRs);
	}
}
