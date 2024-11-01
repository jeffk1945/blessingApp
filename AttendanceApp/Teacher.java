package application;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher {
	
	private SimpleStringProperty name;
	private Room room;
	private SimpleStringProperty roomName;
	private SimpleStringProperty id;
	private School campus;
	private SimpleStringProperty campusName;
	private ArrayList<Subject> teaching=new ArrayList<Subject>();
	private String[] subjects;
	private SimpleStringProperty subjectList;
	private SimpleStringProperty startDate;
	private SimpleStringProperty status;
	private SimpleStringProperty gender;
	

	public Teacher() {
		
	}
	
	
	
	public Teacher(String name) {
		this.name=new SimpleStringProperty(name);
	}
	//input data
	public Teacher(String name, String room, String gender, String campus, String teaching, String startDate, String status) {
		this.name = new SimpleStringProperty(name);
		this.room = new Room(room);
		this.roomName=new SimpleStringProperty(room);
		this.campus=new School(campus);
		this.subjectList=new SimpleStringProperty(teaching);
		this.startDate=new SimpleStringProperty(startDate);
		this.status=new SimpleStringProperty(status);
		this.gender=new SimpleStringProperty(gender);
		this.id=new SimpleStringProperty(Data.generateId());
		this.campusName=new SimpleStringProperty(campus);
	}
	
	
	
//	public Teacher(int id, String name, Room room) {
//		this.id = new SimpleStringProperty(id);
//		this.name = new SimpleStringProperty(name);
//		this.room = room;
//	}
	
	//get data
	public Teacher(String id, String name, String campus, String gender, String roomName, String status, String startDate, String subjects) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.campus=new School(campus);
		this.roomName=new SimpleStringProperty(roomName);
		this.subjectList=new SimpleStringProperty(subjects);
		this.startDate=new SimpleStringProperty(startDate);
		this.status=new SimpleStringProperty(status);
		this.gender=new SimpleStringProperty(gender);
		this.campusName=new SimpleStringProperty(campus);
		String[] subjectlist=subjects.split(",");
		for(String s: subjectlist)
			teaching.add(new Subject(s));
	}
	


	public String getStartDate() {
		return startDate.get();
	}

	public void setStartDate(String startDate) {
		this.startDate.set(startDate);
	}
	
	public StringProperty startDateProperty() {
		return this.startDate;
	}

	public String getStatus() {
		return this.status.get();
	}

	public void setStatus(String status) {
		this.status.set(status);
	}
	
	public StringProperty statusProperty() {
		return status;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return name;
	}

	public Room getRoom() {
		return room;
	}
	
	public String getRoomName() {
		return this.roomName.get();
	}

	public void setRoom(Room room) {
		this.room=room;;
	}

	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}
	
	public StringProperty idProperty() {
		return this.id;
	}

	public School getCampus() {
		return campus;
	}

	public void setCampus(School campus) {
		this.campus = campus;
	}

	public ArrayList<Subject> getTeaching() {
		return this.teaching;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void addSubject(Subject subject) {
		this.teaching.add(subject);
	}
	
	public String getGender() {
		return gender.get();
	}

	public void setGender(String gender) {
		this.gender.set(gender);
	}
	
	public StringProperty genderProperty() {
		return this.gender;
	}
	
		
	public String getSubjectList() {
		String subjectlist="";
		for(int i=0;i<teaching.size();i++) {
			if(i<teaching.size()-1)
				subjectlist+=teaching.get(i)+",";
			else 
				subjectlist+=teaching.get(i);
		}
		return subjectList.get();
	}

	public void setSubjectList(String subjectList) {
		this.subjectList.set(subjectList);
	}
	
	public String getCampusName() {
		return campusName.get();
	}

	public void setCampusName(String campusName) {
		this.campusName.set(campusName);
	}
	
	public StringProperty campusNameProperty() {
		return this.campusName;
	}

	public String toString() {
		return this.campus.getCampus()+" "+" "+this.id.get()+" "+this.name.get()+" "+this.gender.get()+" "+this.room.getName()+" "+this.subjectList.get()+" "+this.startDate.get();
	}
	
	

}
