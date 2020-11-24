package DAO;

import java.io.FileInputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import Core.Student;

public class StudentDAO {
	private  Connection myCon;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public StudentDAO() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("sql/db.properties"));
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String dburl = prop.getProperty("dburl");
		myCon = DriverManager.getConnection(dburl, user, password);
	}
	
	//Get all People from table into a list
	public List<Student> getAllStudent() throws Exception{
		
		List<Student> listAllStudent = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myCon.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM person INNER JOIN student ON person.idPerson = student.idPerson");
			
			while (myRs.next()) {
				Student tempStudent = convertRowToStudent(myRs);
				listAllStudent.add(tempStudent);
			}
			return listAllStudent;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	//Get All Person from table by Name
	public List<Student> getStudentByName(String name) throws Exception{
		List<Student> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			name += "%";
			myStmt = myCon.prepareStatement("SELECT * FROM person INNER JOIN student ON person.idPerson = student.idPerson WHERE firstName like ? or lastName like ?");
			myStmt.setString(1, name);
			myStmt.setString(2, name);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Student tempStudent = convertRowToStudent(myRs);
				list.add(tempStudent);
			}
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	// Get Person from table by ID
	public Student getStudentByID (String id) throws Exception{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Student student =null;
		
		try {
			myStmt = myCon.prepareStatement("SELECT * FROM person INNER JOIN student ON person.idPerson = student.idPerson WHERE person.idPerson =  ?");
			myStmt.setString(1, id);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				student = convertRowToStudent(myRs);
			}
			return student;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	//Adding a Person to talbe
	public void addStudent (Student newStudent) throws Exception{
		PreparedStatement myStmt = null;
		PreparedStatement myStmt1 = null;
		try {
			String sql = "INSERT INTO person"
					+ "(idPerson, idFamily, lastName, firstName, relationship, tempBirth, gender, address, email,\r\n"
					+ "				phoneNum, identityID, education, job)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			myStmt = myCon.prepareStatement(sql);
			
			String stringDate = formatter.format(newStudent.getBirth());
			
			myStmt.setString(1, newStudent.getIdPerson());
			myStmt.setString(2, newStudent.getIdFamily());
			myStmt.setString(3, newStudent.getLastName());
			myStmt.setString(4, newStudent.getFirstName());
			myStmt.setString(5, newStudent.getRelationship());
			myStmt.setString(6, stringDate);
			myStmt.setString(7, newStudent.getGender());
			myStmt.setString(8, newStudent.getAddress());
			myStmt.setString(9, newStudent.getEmail());
			myStmt.setString(10, newStudent.getPhoneNum());
			myStmt.setString(11, newStudent.getIdentityID());
			myStmt.setString(12, newStudent.getEducation());
			myStmt.setString(13, newStudent.getJob());
			
			myStmt.executeUpdate();
			
			sql = "INSERT INTO student"
				+ "(idPerson, hometown, university, startLiving)"
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
	
	//convert result set to Person
	private Student convertRowToStudent(ResultSet myRs) throws SQLException, ParseException {
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
		String university = myRs.getString("university");
		String startLiving = myRs.getString("startLiving");
		
		Date tempBirth = formatter.parse(birth);
		Date tempDate = formatter.parse(startLiving);
		
		Student student = new Student(idPerson, idFamily, lastName, firstName, relationship, tempBirth, gender, address, email,
				phoneNum, identityID, education, job, hometown, tempDate, university);
		return student;
		
	}
	
	
	//Updating a Person information in table
	public void updateStudent(Student temp) throws SQLException{
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
			
			 sql = "UPDATE student"
						+"SET hometown = ?, university = ?, startLiving = ?"
						+"WHERE idPerson = ?";
			
			myStmt1 = myCon.prepareStatement(sql);
			
			stringDate = formatter.format(temp.getStartLiving());
			
			
			myStmt1.setString(1, temp.getHomeTown());
			myStmt1.setString(2, temp.getUniversity());
			myStmt1.setString(3,  stringDate);
			myStmt1.setString(4, temp.getIdPerson());
			
			myStmt1.executeUpdate();
			
		}
		finally {
			myStmt.close();
			myStmt1.close();
		}
	}
	
	//Deleting a Person from table
	public void deleteStudent(String idPerson) throws SQLException {
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
