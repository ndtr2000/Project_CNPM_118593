package Core;

import java.util.Date;

public class Meeting {
	protected String idMeeting;
	protected Date date;
	protected String place;
	protected String topic;
	
	public Meeting(String idMeeting, Date date, String place, String topic) {
		this.idMeeting = idMeeting;
		this.date = date;
		this.place = place;
		this.topic = topic;
	}

	public String getIdMeeting() {
		return idMeeting;
	}

	public void setIdMeeting(String idMeeting) {
		this.idMeeting = idMeeting;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
}
