package DAO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Properties;

import Core.ViceLeader;

public class ViceLeaderDAO {
	private  Connection myCon;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public ViceLeaderDAO() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("sql/db.properties"));
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String dburl = prop.getProperty("dburl");
		myCon = DriverManager.getConnection(dburl, user, password);
	}

	
	// Get Person from table by ID
	public ViceLeader getViceLeader () throws Exception{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		ViceLeader ViceLeader =null;
		
		try {
			myStmt = myCon.prepareStatement("SELECT * FROM person INNER JOIN managerjob ON person.idPerson = managerjob.idPerson WHERE managerjob.idJob = 1");
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				ViceLeader = convertRowToViceLeader(myRs);
			}
			return ViceLeader;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	//Adding a Person to talbe
	public void addViceLeader (ViceLeader newViceLeader) throws Exception{
		PreparedStatement myStmt = null;
		
		try {
			String sql = "INSERT INTO managerjob"
					+ "(idPerson, idJob, startDateTerm, endDateTerm)"
					+ "VALUES(?, ?, ?, ?)";
			myStmt = myCon.prepareStatement(sql);
			
			String stringStartDate = formatter.format(newViceLeader.getStartDateTerm());
			String stringEndDate = formatter.format(newViceLeader.getEndDateTerm());
			
			myStmt.setString(1, newViceLeader.getIdPerson());
			myStmt.setString(2, "1");
			myStmt.setString(3, stringStartDate);
			myStmt.setString(4, stringEndDate);

			myStmt.executeUpdate();
			

		}
		finally {
			myStmt.close();
		}
	}
	
	//convert result set to Person
	private ViceLeader convertRowToViceLeader(ResultSet myRs) throws SQLException, ParseException {
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
		String startDateTerm = myRs.getString("startDateTerm");
		String endDateTerm = myRs.getString("endDateTerm");

		
		Date tempBirth = formatter.parse(birth);
		Date tempStartDate = formatter.parse(startDateTerm);
		Date tempEndDate = formatter.parse(endDateTerm);
		
		ViceLeader ViceLeader = new ViceLeader(idPerson, idFamily, lastName, firstName, relationship, tempBirth, gender, address, email,
				phoneNum, identityID, education, job, tempStartDate, tempEndDate);
		return ViceLeader;
		
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
