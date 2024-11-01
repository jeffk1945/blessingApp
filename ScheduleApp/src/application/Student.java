package application;

import java.util.ArrayList;

public class Student {
	
	private int grade;
	private String name;
	private boolean honors;
	
	private int id;
	ArrayList<Subject> classes=new ArrayList<Subject>();
	
	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}
	
	public Student(int id, int grade, String name, boolean honors, String[] classes1) {
		super();
		this.grade = grade;
		this.name = name;
		this.honors = honors;
		this.id = id;
		//this.matchClasses(classes1);
	}
	
	public void mathClasses(String[] classes1) {
		
		
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

	public boolean isHonors() {
		return this.honors;
	}

	public void setHonors(boolean honors) {
		this.honors = honors;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}

