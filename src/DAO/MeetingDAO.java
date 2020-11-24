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
import Core.Student;

public class MeetingDAO {
	private  Connection myCon;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public MeetingDao() throw Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("sql/db.properties"));
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String dburl = prop.getProperty("dburl");
		myCon = DriverManager.getConnection(dburl, user, password);
	}
	
	//Get all People from table into a list
	public List<Meeting> getAllPeople() throws Exception{
			
		List<Meeting> listAllPerson = new ArrayList<>();
			
		Statement myStmt = null;
		ResultSet myRs = null;
			
		try {
			myStmt = myCon.createStatement();
			myRs = myStmt.executeQuery("Select * FROM person INNER JOIN Meeting ON person.idPerson = Meeting.idPerson WHERE firstName like ? or lastName like ?");
				
			while (myRs.next()) {
				Meeting tempMeeting = convertRowToMeeting(myRs);
				listAllMeeting.add(tempMeeting);
			}
			return listAllMeeting;
		}
		finally {
			close(myStmt, myRs);
		}
	}	
	
	
	//Get all people from table by name
	public List<Meeting> getMeetingByName(String name) throws Exception{
		List<Meeting> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			name += "%";
			myStmt = myCon.prepareStatement("SELECT * FROM person INNER JOIN Meeting ON person.idPerson = Meeting.idPerson WHERE firstName like ? or lastName like ?");
			myStmt.setString(1, name);
			myStmt.setString(2, name);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Meeting tempMeeting = convertRowToMeeting(myRs);
				list.add(tempMeeting);
			}
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	
	//Get Person from table by ID
	public Student getMeetingByID (String id) throws Exception{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Meeting meeting=null;
		
		try {
			myStmt = myCon.prepareStatement("SELECT * FROM person INNER JOIN Meeting ON person.idPerson = Meeting.idPerson WHERE person.idPerson =  ?");
			myStmt.setString(1, id);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				meeting = convertRowToMeeting(myRs);
			}
			return meeting;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	
	//Adding person to table
	public void addMeeting (Meeting newMeeting) throws Exception{
		PreparedStatement myStmt = null;
		PreparedStatement myStmt1 = null;
		try {
			String sql = "INSERT INTO person"
					+ "(idPerson, idFamily, lastName, firstName, relationship, tempBirth, gender, address, email,\r\n"
					+ "				phoneNum, identityID, education, job)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			myStmt = myCon.prepareStatement(sql);
			
			String stringDate = formatter.format(newMeeting.getBirth());
			
			myStmt.setString(1, newMeeting.getIdPerson());
			myStmt.setString(2, newMeeting.getIdFamily());
			myStmt.setString(3, newMeeting.getLastName());
			myStmt.setString(4, newMeeting.getFirstName());
			myStmt.setString(5, newMeeting.getRelationship());
			myStmt.setString(6, stringDate);
			myStmt.setString(7, newMeeting.getGender());
			myStmt.setString(8, newMeeting.getAddress());
			myStmt.setString(9, newMeeting.getEmail());
			myStmt.setString(10, newMeeting.getPhoneNum());
			myStmt.setString(11, newMeeting.getIdentityID());
			myStmt.setString(12, newMeeting.getEducation());
			myStmt.setString(13, newMeeting.getJob());
			
			myStmt.executeUpdate();
			
			sql = "INSERT INTO Meeting"
				+ "(date, place, topic, startLiving)"
				+ "VALUES(?, ?, ?, ?";
			myStmt1 = myCon.prepareStatement(sql);
			
			stringDate = formatter.format(newStudent.getStartLiving());
			
			myStmt1.setString(1, newStudent.getIdPerson());
			myStmt1.setString(2, newStudent.getHomeTown());
			myStmt1.setString(3, newStudent.getUniversity());
			myStmt1.setString(4,  stringDate);
			
			myStmt1.executeUpdate();
		}
		finally {
			myStmt.close();
			myStmt1.close();
		}
	}
	
}
