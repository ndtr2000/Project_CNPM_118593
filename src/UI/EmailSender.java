/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author DELL
 */
import Core.Meeting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EmailSender {
    private String sender ;
    private String password; 
    private String host;
    private Session session;
    Properties properties = System.getProperties();
    private List<String> emailToday;
    private List<String> emailTomorrow;
    private String messToday;
    private String messTomorrow;
    private String messEvent;
    private String header;
    public EmailSender() throws FileNotFoundException, IOException, MessagingException {
        Properties prop = new Properties();
	prop.load(new FileInputStream("sql/email.properties"));
        sender = prop.getProperty("sender");
	password = prop.getProperty("password");
	host = prop.getProperty("host");

        String recepient = "hp20183500@gmail.com";        
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    	session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(sender, password);

            }

        });
        Message message = prepareMessage(session, sender, recepient);
        Transport.send(message);
        System.out.println("Send Success");
    }
    public void MailSender(String recepient) throws Exception {
        Properties prop = new Properties();
	prop.load(new FileInputStream("sql/email.properties"));
	sender = prop.getProperty("sender");
	password = prop.getProperty("password");
	host = prop.getProperty("host");
        
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    	session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(sender, password);

            }

        });
        Message message = prepareMessage(session, sender, recepient);
        Transport.send(message);
        System.out.println("Send Success");
    }
     private Message prepareMessage(Session session, String sender,String recepient) {
         try {
             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress(sender));
             message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
             message.setSubject("Email for Meeting");
             message.setText("Meeting email");
             return message;
         } catch (Exception ex) {
             Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null,ex);
         }
         return null;
    }
     public EmailSender(List<String> thelisttoday) throws FileNotFoundException, IOException, MessagingException {
    	this();
    	emailToday = thelisttoday;
    }
/*    public void sendToday() {
    	JOptionPane.showMessageDialog(null,"Sending today ...");
    	for (String receiver : emailToday) {
    		try {
    	        // Create a default MimeMessage object.
    	        MimeMessage message = new MimeMessage(session);
    	        // Set From: header field of the header.
    	        message.setFrom(new InternetAddress(sender));
    	        // Set To: header field of the header.
    	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
    	        // Set Subject: header field
    	        message.setSubject(header);

    	        // Now set the actual message 
    	        message.setContent(messToday,"text/html");
    	      
    	       
    	        // Send message
    	        Transport.send(message);
    	     
    	    } catch (MessagingException mex) {
    	        mex.printStackTrace();
    	    }
    		
    	}
    	JOptionPane.showMessageDialog(null,"Sent email successfully");
    }
    public void sendEvent(Meeting meeting, List<String> emails) {
    	messEvent = " Hi friends, Our center is going to hold an meeting. The Meeting ID: " + meeting.getIdMeeting() + 
    			", Date: "+ meeting.getDate() + ", Description: "+ meeting.getTopic()+ 
    			". Contact with us to get more details. Have a nice day !"; 
    	int i=0;
    	JOptionPane.showMessageDialog(null,"Sending...");
    	for (String receiver : emails) {
    		i++;
    		if(i == 2) break;
    		try {
    	        // Create a default MimeMessage object.
    	        MimeMessage message = new MimeMessage(session);
    	        // Set From: header field of the header.
    	        message.setFrom(new InternetAddress(sender));
    	        // Set To: header field of the header.
    	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
    	        // Set Subject: header field
    	        message.setSubject(header);

    	        // Now set the actual message 
    	        message.setContent(messEvent,"text/html");
    	        
    	        // Send message
    	        Transport.send(message);
    	    } catch (MessagingException mex) {
    	        mex.printStackTrace();
    	        JOptionPane.showMessageDialog(null, "Error");
    	    }
    		
    	}
    	JOptionPane.showMessageDialog(null," Sent email successfully");	
    }
*/

}
