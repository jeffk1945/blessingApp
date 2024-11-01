package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Blessing {
	
	private SimpleStringProperty id;
	private SimpleStringProperty studentId;
	private SimpleStringProperty teacherId;
	private SimpleStringProperty reason;
	private SimpleStringProperty dateReceived;
	private SimpleIntegerProperty count;
	
	
	public Blessing(String studentId, String teacherId, String reason, String dateReceived, int count) {
		this.id=new SimpleStringProperty(Data.generateId());
		this.studentId = new SimpleStringProperty(studentId);
		this.teacherId = new SimpleStringProperty(teacherId);
		this.reason = new SimpleStringProperty(reason);
		this.dateReceived = new SimpleStringProperty(dateReceived);
		this.count = new SimpleIntegerProperty(count);
	}
	
//	public Blessing(String studentId, String teacherId, String reason, String dateReceived, int count) {
//		this.id=new SimpleStringProperty(Data.generateId());
//		this.studentId = new SimpleStringProperty(studentId);
//		this.teacherId = new SimpleStringProperty(teacherId);
//		this.reason = new SimpleStringProperty(reason);
//		this.dateReceived = new SimpleStringProperty(dateReceived);
//		this.count = new SimpleIntegerProperty(count);
//	}


	public String getStudentId() {
		return studentId.get();
	}


	public void setStudent(String studentId) {
		this.studentId.set(studentId);
	}
	
	public StringProperty studentIdProperty() {
		return this.studentId;
	}


	public String getTeacherId() {
		return teacherId.get();
	}


	public void setTeacherId(String teacherId) {
		this.teacherId.set(teacherId);
	}
	
	public StringProperty teacherIdProperty() {
		return this.teacherId;
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

	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}
	
	public StringProperty idProperty() {
		return this.id;
	}
	
	
	
	
	
	

}
