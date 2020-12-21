/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.Meeting;
import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author DELL
 */
public class MeetingTableModel extends AbstractTableModel {
    
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private static final long serialVersionUID = 1L;
    public  static final int OBJECT_COL = -1;
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int DATE_COL = 2;
    private static final int DESCRIPTION_COL = 3;
    private String[] columnNames = {"STT","ID","Date", "Topic"}; 
	private List<Meeting> Meetings;

	public MeetingTableModel(List<Meeting> theMeetings) {
		Meetings = theMeetings;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return Meetings.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Meeting tempMeeting = Meetings.get(row);

		switch (col) {
		case OBJECT_COL:
			return tempMeeting;
		case ID_COL:
			return row+1;
		case NAME_COL:
			return tempMeeting.getIdMeeting();
		case DATE_COL:
			return formatter.format(tempMeeting.getDate());
		case DESCRIPTION_COL:
			return tempMeeting.getTopic();
		default:
			return tempMeeting;
		
		}
	}
	@Override
	public Class<? extends Object> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
