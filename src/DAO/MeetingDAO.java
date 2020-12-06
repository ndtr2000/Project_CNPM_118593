package DAO;

import java.io.FileInputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import Core.Meeting;

public class MeetingDAO {
	private  Connection myCon;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public MeetingDAO() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("sql/db.properties"));
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String dburl = prop.getProperty("dburl");
		myCon = DriverManager.getConnection(dburl, user, password);
	}
	
	//Get all People from table into a list
	public List<Meeting> getAllMeeting() throws Exception{
		
		List<Meeting> listAllMeeting = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myCon.createStatement();
			myRs = myStmt.executeQuery("Select * FROM meeting");
			
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
	
	//Get All Person from table by Name
	public List<Meeting> getMeetingByTopic(String topic) throws Exception{
		List<Meeting> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			topic += "%";
			myStmt = myCon.prepareStatement("SELECT * FROM meeting WHERE topic like ?");
			myStmt.setString(1, topic);
			
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
	
	// Get Person from table by ID
	public Meeting getMeetingByID (String id) throws Exception{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Meeting meeting =null;
		
		try {
			myStmt = myCon.prepareStatement("SELECT * FROM meeting WHERE idMeeting = ?");
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
	
	//Adding a Meeting to table
	public void addMeeting (Meeting newMeeting) throws Exception{
		PreparedStatement myStmt = null;
		try {
			String sql = "INSERT INTO meeting"
					+ "(idMeeting, date, place, topic)"
					+ "VALUES(?, ?, ?, ?)";
			myStmt = myCon.prepareStatement(sql);
			
			String stringDate = formatter.format(newMeeting.getDate());
			
			myStmt.setString(1, newMeeting.getIdMeeting());
			myStmt.setString(2, stringDate);
			myStmt.setString(3, newMeeting.getPlace());
			myStmt.setString(4, newMeeting.getTopic());
			
			myStmt.executeUpdate();
		}
		finally {
			myStmt.close();
		}
	}
	
	//convert result set to Meeting
	private Meeting convertRowToMeeting(ResultSet myRs) throws SQLException, ParseException {
		String idMeeting = myRs.getString("idMeeting");
		String place = myRs.getString("place");
		String topic = myRs.getString("topic");
		String date = myRs.getString("date");
		
		Date tempDate = formatter.parse(date);
		
		Meeting meeting = new Meeting(idMeeting, tempDate, place, topic);
		return meeting;
		
	}
	
	
	//Updating a Person information in table
	public void updateMeeting(Meeting temp) throws SQLException{
		PreparedStatement myStmt = null;
		try {
			String sql = "UPDATE meeting"
					+"SET date = ?, place = ?, topic = ?"
					+"WHERE idMeeting = ?";
			myStmt = myCon.prepareStatement(sql);
			
			String stringDate = formatter.format(temp.getDate());
			
			
			myStmt.setString(1, stringDate);
			myStmt.setString(2, temp.getPlace());
			myStmt.setString(3, temp.getTopic());
			myStmt.setString(4, temp.getIdMeeting());
			
			myStmt.executeUpdate();
			
		}
		finally {
			myStmt.close();
		}
	}
	
	//Deleting a Person from table
	public void deleteMeeting(String idMeeting) throws SQLException {
		PreparedStatement myStmt = null;
		try {
			String sql = "DELETE Meeting WHERE idMeeting = ?";
			myStmt = myCon.prepareStatement(sql);
			
			myStmt.setString(1, idMeeting);
			
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
