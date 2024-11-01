package application;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Subject {
	
	private SimpleStringProperty id;
	private School campus;
	private SimpleIntegerProperty year;
	private SimpleStringProperty semester;
	private SimpleStringProperty name;
	private SimpleIntegerProperty credits;
	private Teacher teacher;
	private SimpleStringProperty teacherName;
	private int[] grades;
	private SimpleStringProperty gradesList;
	private SimpleStringProperty campusName;
	private ArrayList<Student> roster=new ArrayList<Student>();
	
	
	public Subject(String name) {
		this.name=new SimpleStringProperty(name);
	}
	
	public Subject(String id, int credits, Teacher teacher, String name) {
		this.id=new SimpleStringProperty(id);
		this.credits=new SimpleIntegerProperty(credits);
		this.teacher=teacher;
		this.name=new SimpleStringProperty(name);
		this.teacherName=new SimpleStringProperty(teacher.getName());
	}
	
	//getall students
	public Subject(String id, String campus, int year, String semester, String name, int credits, String teacher, String grades) {
		this.id=new SimpleStringProperty(id);
		this.campus=new School(campus);
		this.campusName=new SimpleStringProperty(campus);
		this.year=new SimpleIntegerProperty(year);
		this.semester=new SimpleStringProperty(semester);
		this.name=new SimpleStringProperty(name);
		this.credits=new SimpleIntegerProperty(credits);
		this.gradesList=new SimpleStringProperty(grades);
		this.teacherName=new SimpleStringProperty(teacher);
		this.teacher=new Teacher(teacher);
		String[] gradelist=grades.split(",");
		this.grades=new int[gradelist.length];
		for(int i=0;i<this.grades.length;i++) {
			this.grades[i]=Integer.valueOf(gradelist[i]);
		}
	}
	
	//create new student
	public Subject(String campus, int year, String semester, String name, int credits, String teacher, String grades) {
		this.id=new SimpleStringProperty(Data.generateId());
		this.campus=new School(campus);
		this.campusName=new SimpleStringProperty(campus);
		this.year=new SimpleIntegerProperty(year);
		this.semester=new SimpleStringProperty(semester);
		this.name=new SimpleStringProperty(name);
		this.credits=new SimpleIntegerProperty(credits);
		this.gradesList=new SimpleStringProperty(grades);
		this.teacherName=new SimpleStringProperty(teacher);
		this.teacher=new Teacher(teacher);
		String[] gradelist=grades.split(",");
		this.grades=new int[gradelist.length];
		for(int i=0;i<this.grades.length;i++) {
			this.grades[i]=Integer.valueOf(gradelist[i]);
		}
	}
	
	

	//(campus, year, semester, name, credits, teacher, grades) 
	
	
	public School getCampus() {
		return campus;
	}

	public String getGradesList() {
		return gradesList.get();
	}

	public void setGradesList(String gradesList) {
		this.gradesList.set(gradesList);
	}
	
	public StringProperty gradesListProperty() {
		return gradesList;
	}

	public void setCampus(School campus) {
		this.campus = campus;
	}

	public Integer getYear() {
		return year.get();
	}

	public void setYear(int year) {
		this.year.set(year);
	}
	
	public IntegerProperty yearProperty() {
		return this.year;
	}

	public String getSemester() {
		return semester.get();
	}

	public void setSemester(String semester) {
		this.semester.set(semester);
	}
		
	public StringProperty semesterProperty() {
		return semester;
	}

	public int[] getGrades() {
		return grades;
	}

	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	public Integer getCredits() {
		return credits.get();
	}

	public void setCredits(int credits) {
		this.credits.set(credits);
	}
	
	public IntegerProperty creditsProperty() {
		return this.credits;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return this.name;
	}
	
	
	public String getTeacherName() {
		return teacherName.get();
	}

	public void setTeacherName(String teacherName) {
		this.teacherName.set(teacherName);
	}
	
	public StringProperty teacherNameProperty() {
		return teacherName;
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
	
//	public String toString() {
//		return this.id.get()+" " +this.name.get()+" "+this.campus.getCampus()+" "+this.year.get()+" "+this.semester.get()+" "+this.credits.get()+" "+this.teacherName.get()+" "+this.gradesList.get();
//	}
}
