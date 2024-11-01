package application;

import java.util.ArrayList;

public class Teacher {
	
	private String name;
	private Room room;
	private int id;
	private School school;
	private ArrayList<Subject> teaching=new ArrayList<Subject>();
	private String[] subjects;
	
	public Teacher(int id, String name, Room room) {
		this.id = id;
		this.name = name;
		this.room = room;
	}
	
	public Teacher(int id, String name, String school, Room room, String[] subjects) {
		this.id = id;
		this.name = name;
		this.school=new School(school);
		this.room = room;
		for(String s: subjects)
			teaching.add(new Subject(s));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
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
	
	public String toString() {
		return this.school+" "+" "+this.id+" "+this.name+" "+" "+this.room+" "+this.teaching;
	}
	
	

}

