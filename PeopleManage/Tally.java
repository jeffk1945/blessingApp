package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tally {
	
	private SimpleStringProperty id;
	private Student student;
	private Teacher teacher;
	private SimpleStringProperty reason;
	private SimpleStringProperty dateReceived;
	private SimpleIntegerProperty count;
	
	//create new Tally
	public Tally(Student student, Teacher teacher, String reason, String dateReceived, int count) {
		this.id=new SimpleStringProperty(Data.generateId());
		this.student = student;
		this.teacher = teacher;
		this.reason = new SimpleStringProperty(reason);
		this.dateReceived = new SimpleStringProperty(dateReceived);
		this.count = new SimpleIntegerProperty(count);
	}
	
	//getTallys
	public Tally(String id, Student student, Teacher teacher, String reason, String dateReceived, int count) {
		this.id=new SimpleStringProperty(id);
		this.student = student;
		this.teacher = teacher;
		this.reason = new SimpleStringProperty(reason);
		this.dateReceived = new SimpleStringProperty(dateReceived);
		this.count = new SimpleIntegerProperty(count);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getReason() {
		return reason.get();
	}

	public void setReason(String reason) {
		this.reason.set(reason);
	}
	
	public StringProperty reasonProperty() {
		return this.reason;
	}

	public String getDateReceived() {
		return dateReceived.get();
	}

	public void setDateReceived(String dateReceived) {
		this.dateReceived.set(dateReceived);
	}
	
	public StringProperty dateReceivedProperty() {
		return this.dateReceived;
	}

	public Integer getCount() {
		return count.get();
	}

	public void setCount(int count) {
		this.count.set(count);
	}
	
	public IntegerProperty countProperty() {
		return this.count;
	}

	public SimpleStringProperty getId() {
		return id;
	}

	public void setId(SimpleStringProperty id) {
		this.id = id;
	}
	
	public StringProperty idProperty() {
		return this.id;
	}
	
	

}
