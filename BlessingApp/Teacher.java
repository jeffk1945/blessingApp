package application;

import java.util.ArrayList;

public class Teacher {
	
	private String name;
	private int id;
	private School school;
	private String[] subjects;
	
	public Teacher(int id, String name, School school) {
		this.id = id;
		this.name = name;
		this.school=school;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


	public String toString() {
		return this.name;
	}
	
	

}

