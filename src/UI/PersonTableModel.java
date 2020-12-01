/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.Person;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ndtr
 */
public class PersonTableModel extends AbstractTableModel{
    public static final int OBJECT_COL = -1;
    public static final int STT_COL = 0;
    public static final int FIRST_NAME_COL = 1;
    public static final int LAST_NAME_COL = 2;
    public static final int IDENTITY_COL = 3;
    public static final int BIRTHDAY_COL = 4;
    public static final int ADDRESS_COL = 5;
    public static final int GENDER_COL = 6;
    public static final int HOMETOWN_COL = 7;
    public static final int START_LIVING_COL = 8;
    public static final int PHONE_NUM = 9;
    public static final int JOB_COL = 10;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    private String[] columnNames ={"STT", "First Name", "Last Name", "Identity ID", "Birthday", "Address", "Gender", "Hometown", "Start Living", "Phone Num", "Job"};
    private List<Person> people;
    
    public PersonTableModel(List<Person> people){
        this.people = people;
    }
    @Override
    public int getRowCount() {
        return columnNames.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return people.size(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int col) {
	return columnNames[col];
    }
    @Override
    public Object getValueAt(int row, int col) {
        Person tempPer = people.get(row);
        switch(col){
            case OBJECT_COL:
                return tempPer;
            case STT_COL:
                return row +1;
            case FIRST_NAME_COL:
                return tempPer.getFirstName();
            case LAST_NAME_COL:
                return tempPer.getLastName();
            case IDENTITY_COL:
                return tempPer.getIdPerson();
            case BIRTHDAY_COL:
                Date tempBirth =tempPer.getBirth();
                String tempDateString = formatter.format(tempBirth);
                return tempDateString;
            case ADDRESS_COL:
                return tempPer.getAddress();
            case GENDER_COL:
                return tempPer.getGender();
            case HOMETOWN_COL:
                return "";
            case START_LIVING_COL:
                return "";
            case PHONE_NUM:
                return tempPer.getPhoneNum();
            case JOB_COL:
                return "";
            default:
                return tempPer.getIdPerson();
        }
    }
    
}
