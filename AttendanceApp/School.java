package application;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class School {
	
	private SimpleStringProperty campus=new SimpleStringProperty();
	private ObservableList<Teacher> teachers=FXCollections.observableArrayList();
	private ObservableList<Student> students=FXCollections.observableArrayList();
	private ObservableList<Subject> subjects=FXCollections.observableArrayList();
	
	
	public School(String campus) {
		this.campus=new SimpleStringProperty(campus);
		
	}
			
	public String getCampus() {
		return campus.get();
	}

	public void setCampus(String campus) {
		this.campus.set(campus);
	}
	
	public StringProperty campusProperty() {
		return this.campus;
	}
	
	public String toString() {
		return this.campus.get();
	}

	public ObservableList<Teacher> getTeachers() {
		return teachers;
	}


	public ObservableList<Student> getStudents() {
		return students;
	}


	public ObservableList<Subject> getSubjects() {
		return subjects;
	}


	

}
