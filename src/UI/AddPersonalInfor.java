/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.Family;
import Core.Person;
import DAO.PersonDAO;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class AddPersonalInfor extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel thisPanel;
    private PersonDAO personDAO;
    private Person prevPerson;
    private boolean updateMode;
	
	
    private final JPanel contentPanel = new JPanel();
    private JTextField first_nameField;
    private JTextField last_nameField;
    private JTextField relationshipField;
    private JTextField addressField;
    private JTextField contactField;
    private JTextField jobField;
    private JTextField idField;
    private JTextField educationField;
    private JRadioButton birthField;
    private JRadioButton genderField;
    public AddPersonalInfor( PersonDAO thePersonDAO) throws Exception {
		super();		
		personDAO = thePersonDAO;
	}
    protected void savePerson() throws Exception {
		
    String firstName = first_nameField.getText();
    String lastName = last_nameField.getText();
    String relationship = relationshipField.getText();
    String address = addressField.getText();
    String contact = contactField.getText();
    String job = jobField.getText();
    String id = idField.getText();
    String education = educationField.getText();
    Date birth = new Date();
    String gender = genderField.getText();
		
		Person temp = null;
		temp = new Person("1","1",lastName, firstName, relationship, birth, gender, address, contact, contact, id, education, job);
		try {
                        personDAO.addPerson(temp);
                        JOptionPane.showMessageDialog(thisPanel, "Added successfully", "Added successfully ", JOptionPane.INFORMATION_MESSAGE);			
			setVisible(false);
			dispose();	
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(thisPanel,"Error saving: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			
		}		
	}

    
}
