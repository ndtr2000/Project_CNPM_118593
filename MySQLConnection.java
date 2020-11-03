package CNPM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnection {
	public static int NumOfDataBook=4;
	private static String url = "jdbc:mysql://localhost:3306/practivemysql_db";
	private static String username = "root";
	private static String password = "danghuynhduc";
	
  public static List<String> GetMasterOfFamily() {
	  Connection con=null;
	  System.out.println("Network Connect!");
	  ResultSet rs = null;
	  List<String> list= new ArrayList<String>(); 
	    try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(url, username, password);

	      System.out.println("Connected OK!");
	      Statement stmt=con.createStatement();
	      rs=stmt.executeQuery("SELECT family.idFamily,lastName,firstName from family,person"
	      		+ "	WHERE person.idPerson=family.idFamilyMaster;");
	       
	      while (rs.next()) {              
	    	   int i = 1;
	    	   while(i <= NumOfDataBook) {
	    	        list.add(rs.getString(i++));
	    	   }
	    	}
	    } catch (SQLException ex) {
	        throw new Error("Error ", ex);
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	    finally {
		      try {
		        if (con != null) {
		            con.close();
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		     }
	    return list;
  }
  public static void AddNewPerson(String idPerson,String idFamily, String LastName, String firstName, String relationship,String birth,
		  					String adress,String gender, String email, String job, String identityID,String education ) {
	  Connection con=null;
	  System.out.println("DataBase Connect!");
		try {
			con = DriverManager.getConnection(url, username, password);
          Statement stmt = con.createStatement();
          stmt.executeUpdate("INSERT INTO person "
          		+ "VALUE("
          		+ idPerson+','
          		+ idFamily+','
          		+ LastName+','
          		+ firstName+','
          		+ relationship+','
          		+ birth+','
          		+ adress+','
          		+ gender+','
          		+ email+','
          		+ job+','
          		+ identityID+','
          		+ education
          		+ ");");
      } catch (Exception ex) {
          ex.printStackTrace();
      }
	}
  public static void UpdatePersonInfor(String idPerson,String idFamily, String LastName, String firstName, String relationship,String birth,
			String adress,String gender, String email, String job, String identityID,String education ) {
				Connection con=null;
				System.out.println("DataBase Connect!");
				try {
				con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE person"
						+ "SET"
				+"idFamily="+ idFamily+','
				+"LastName="+ LastName+','
				+"firstName="+firstName+','
				+"relationship ="+ relationship+','
				+"birth="+ birth+','
				+"adress="+ adress+','
				+"gender="+ gender+','
				+"email="+ email+','
				+"job="+ job+','
				+"identityID="+ identityID+','
				+"education="+ education
				+ "WHERE idPerson="+idPerson+";");
				} catch (Exception ex) {
				ex.printStackTrace();
				}
				}
 
 public static void AddNewStudent(String idStudent,String idPerson, String hometown, String university, String startLiving ) {
	  Connection con=null;
	  System.out.println("DataBase Connect!");
		try {
			con = DriverManager.getConnection(url, username, password);
          Statement stmt = con.createStatement();
          stmt.executeUpdate("INSERT INTO student VALUE("+idStudent+","+idPerson+","+hometown+","+university+","+startLiving+");");
      } catch (Exception ex) {
          ex.printStackTrace();
      }
	}
  public static void UpdateStudentInfor(String idStudent,String idPerson, String hometown, String university, String startLiving ) {
				Connection con=null;
				System.out.println("DataBase Connect!");
				try {
				con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE student"
						+ "SET"
						+ "idStudent="+idStudent+","
						+ "idPerson="+idPerson+","
						+ "hometown="+hometown+","
						+ "university="+university+","
						+ "startLiving="+startLiving+""
						+ "WHERE idStudent="+idStudent+";");
				} catch (Exception ex) {
				ex.printStackTrace();
				}
				}
 
  public static void AddNewRender(String idrenter,String idPerson, String hometown, String startLiving ) {
	  Connection con=null;
	  System.out.println("DataBase Connect!");
		try {
			con = DriverManager.getConnection(url, username, password);
          Statement stmt = con.createStatement();
          stmt.executeUpdate("INSERT INTO render VALUE("+idrenter+","+idPerson+","+hometown+","+startLiving+");");
      } catch (Exception ex) {
          ex.printStackTrace();
      }
	}
  public static void UpdateRenderInfor(String idrenter,String idPerson, String hometown, String startLiving ) {
				Connection con=null;
				System.out.println("DataBase Connect!");
				try {
				con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE renter"
						+"SET"
						+"idPerson="+idPerson+","
						+ "hometown="+hometown+","
						+ "startLiving="+startLiving+""
						+ "WHERE idrenter="+idrenter+";");
				} catch (Exception ex) {
				ex.printStackTrace();
				}
				}
 
  public static void AddNewFamily(String idFamily,String idFamilyMaster) {
	  Connection con=null;
	  System.out.println("DataBase Connect!");
		try {
			con = DriverManager.getConnection(url, username, password);
          Statement stmt = con.createStatement();
          stmt.executeUpdate("INSERT INTO family VALUE("+idFamily+","+idFamilyMaster+");");
      } catch (Exception ex) {
          ex.printStackTrace();
      }
	}
  public static void UpdateFamilyInfor(String idFamily,String idFamilyMaster) {
				Connection con=null;
				System.out.println("DataBase Connect!");
				try {
				con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE family"
						+"SET"
						+ "idFamilyMaster="+idFamilyMaster+","
						+ "WHERE idFamily="+idFamily+";");
				} catch (Exception ex) {
				ex.printStackTrace();
				}
				}
 
  public static void AddNewMeeting(String idMeeting,String date,String place, String topic) {
	  Connection con=null;
	  System.out.println("DataBase Connect!");
		try {
			con = DriverManager.getConnection(url, username, password);
          Statement stmt = con.createStatement();
          stmt.executeUpdate("INSERT INTO renter VALUE("+idMeeting+","+date+","+place+","+topic+");");
      } catch (Exception ex) {
          ex.printStackTrace();
      }
	}
  public static void UpdateMeetingInfor(String idMeeting,String date,String place, String topic) {
				Connection con=null;
				System.out.println("DataBase Connect!");
				try {
				con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE renter"
						+ "SET"
						+ "date="+date+","
						+ "place="+place+","
						+ "topic="+topic+","
						+ "WHERE idMeeting="+idMeeting+";");
				} catch (Exception ex) {
				ex.printStackTrace();
				}
				}
 
}
