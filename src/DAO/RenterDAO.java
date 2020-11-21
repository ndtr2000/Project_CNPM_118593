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
import Core.Renter;

public class RenterDAO {
	private  Connection myCon;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public RenterDAO() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("sql/db.properties"));
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String dburl = prop.getProperty("dburl");
		myCon = DriverManager.getConnection(dburl, user, password);
	}
	
	//Get all People from table into a list
	public List<Renter> getAllPeople() throws Exception{
		
		List<Renter> listAllRenter = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myCon.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM person");
			
			while (myRs.next()) {
				Renter tempRenter = convertRowToRenter(myRs);
				listAllRenter.add(tempRenter);
			}
			return listAllRenter;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	//Get All Person from table by Name
	public List<Renter> getRenterByName(String name) throws Exception{
		List<Renter> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			name += "%";
			myStmt = myCon.prepareStatement("SELECT * FROM person INNER JOIN Renter ON person.idPerson = Renter.idPerson WHERE firstName like ? or lastName like ?");
			myStmt.setString(1, name);
			myStmt.setString(2, name);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Renter tempRenter = convertRowToRenter(myRs);
				list.add(tempRenter);
			}
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	// Get Person from table by ID
	public Renter getRenterByID (String id) throws Exception{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Renter Renter =null;
		
		try {
			myStmt = myCon.prepareStatement("SELECT * FROM person INNER JOIN Renter ON person.idPerson = Renter.idPerson WHERE person.idPerson =  ?");
			myStmt.setString(1, id);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				Renter = convertRowToRenter(myRs);
			}
			return Renter;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	//Adding a Person to talbe
	public void addRenter (Renter newRenter) throws Exception{
		PreparedStatement myStmt = null;
		PreparedStatement myStmt1 = null;
		try {
			String sql = "INSERT INTO person"
					+ "(idPerson, idFamily, lastName, firstName, relationship, tempBirth, gender, address, email,\r\n"
					+ "				phoneNum, identityID, education, job)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			myStmt = myCon.prepareStatement(sql);
			
			String stringDate = formatter.format(newRenter.getBirth());
			
			myStmt.setString(1, newRenter.getIdPerson());
			myStmt.setString(2, newRenter.getIdFamily());
			myStmt.setString(3, newRenter.getLastName());
			myStmt.setString(4, newRenter.getFirstName());
			myStmt.setString(5, newRenter.getRelationship());
			myStmt.setString(6, stringDate);
			myStmt.setString(7, newRenter.getGender());
			myStmt.setString(8, newRenter.getAddress());
			myStmt.setString(9, newRenter.getEmail());
			myStmt.setString(10, newRenter.getPhoneNum());
			myStmt.setString(11, newRenter.getIdentityID());
			myStmt.setString(12, newRenter.getEducation());
			myStmt.setString(13, newRenter.getJob());
			
			myStmt.executeUpdate();
			
			sql = "INSERT INTO renter"
				+ "(idPerson, hometown, startLiving)"
				+ "VALUES(?, ?, ?, ?";
			myStmt1 = myCon.prepareStatement(sql);
			
			stringDate = formatter.format(newRenter.getStartLiving());
			
			myStmt1.setString(1, newRenter.getIdPerson());
			myStmt1.setString(2, newRenter.getHomeTown());
			myStmt1.setString(3,  stringDate);
			
			myStmt1.executeUpdate();
		}
		finally {
			myStmt.close();
			myStmt1.close();
		}
	}
	
	//convert result set to Person
	private Renter convertRowToRenter(ResultSet myRs) throws SQLException, ParseException {
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
		String hometown = myRs.getString("hometown");
		String startLiving = myRs.getString("startLiving");
		
		Date tempBirth = formatter.parse(birth);
		Date tempDate = formatter.parse(startLiving);
		
		Renter Renter = new Renter(idPerson, idFamily, lastName, firstName, relationship, tempBirth, gender, address, email,
				phoneNum, identityID, education, job, hometown, tempDate);
		return Renter;
		
	}
	
	
	//Updating a Person information in table
	public void updateRenter(Renter temp) throws SQLException{
		PreparedStatement myStmt = null;
		PreparedStatement myStmt1 = null;
		try {
			String sql = "UPDATE person"
					+"SET lastName = ?, firstName = ?, birth = ?, address = ?, email = ?, phoneNum = ?, job = ?, identityID = ?, education = ?"
					+"WHERE idPerson = ?";
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
			
			 sql = "UPDATE Renter"
						+"SET hometown = ?, startLiving = ?"
						+"WHERE idPerson = ?";
			
			myStmt1 = myCon.prepareStatement(sql);
			
			stringDate = formatter.format(temp.getStartLiving());
			
			
			myStmt1.setString(1, temp.getHomeTown());
			myStmt1.setString(2,  stringDate);
			myStmt1.setString(3, temp.getIdPerson());
			
			myStmt1.executeUpdate();
			
		}
		finally {
			myStmt.close();
			myStmt1.close();
		}
	}
	
	//Deleting a Person from table
	public void deleteRenter(String idPerson) throws SQLException {
		PreparedStatement myStmt = null;
		
		try {
			String sql = "DELETE person WHERE idPerson = ?";
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
