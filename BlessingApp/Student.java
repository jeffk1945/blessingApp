package application;

import java.util.ArrayList;

public class Student {
	
	private int grade;
	private String name;
	private boolean honors;
	private School campus;
	
	private int id;
	
	public Student(int grade, String name, School campus) {
		this.grade = grade;
		this.name = name;
		this.campus=campus;
	}
	
	public Student(int id, int grade, String name, boolean honors, String[] classes1) {
		super();
		this.grade = grade;
		this.name = name;
		this.id = id;
	}
	

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}

