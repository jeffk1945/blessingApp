package application;

import java.util.ArrayList;

public class Schedule {
	
	private int days;
	private int periods;
	
	private ArrayList<Subject> subjects=new ArrayList<Subject>();
	private ArrayList<Teacher> teachers=new ArrayList<Teacher>();
	private ArrayList<Student> students=new ArrayList<Student>();
	
	public Schedule(int days, int periods) {
		super();
		this.days = days;
		this.periods = periods;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getPeriods() {
		return periods;
	}
	public void setPeriods(int periods) {
		this.periods = periods;
	}
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	public void addSubjects(Subject subject) {
		this.subjects.add(subject);
	}
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}
	public void addTeachers(Teacher teacher) {
		this.teachers.add(teacher);
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public void addStudents(Student student) {
		this.students.add(student);
	}
	
	
	
	

}

