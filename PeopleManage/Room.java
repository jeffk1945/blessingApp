package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Room {
	
	private SimpleStringProperty id;
	private SimpleIntegerProperty floor;
	private SimpleStringProperty name;
	private SimpleIntegerProperty capacity;
	private School campus;
	private SimpleStringProperty campusName;
	
	
	public Room(String name) {
		this.name = new SimpleStringProperty(name);
		
	}
	
	public Room(int floor, String name) {
		this.floor = new SimpleIntegerProperty(floor);
		this.name = new SimpleStringProperty(name);
	}
	
	//import
	public Room(String id, String campus, int floor, String name, int capacity) {
		this.id=new SimpleStringProperty(id);
		this.campus=new School(campus);
		this.floor = new SimpleIntegerProperty(floor);
		this.name = new SimpleStringProperty(name);
		this.capacity=new SimpleIntegerProperty(capacity);
		this.campusName=new SimpleStringProperty(campus);
	}
	
	//write
	public Room(String campus, int floor, String name, int capacity) {
		this.campus=new School(campus);
		this.floor = new SimpleIntegerProperty(floor);
		this.name = new SimpleStringProperty(name);
		this.capacity=new SimpleIntegerProperty(capacity);
		this.id=new SimpleStringProperty(Data.generateId());
		this.campusName=new SimpleStringProperty(campus);
	}

	public Integer getFloor() {
		return floor.get();
	}

	public void setFloor(int floor) {
		this.floor.set(floor);;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);;
	}
	
	public StringProperty nameProperty() {
		return this.name;
	}

	public Integer getCapacity() {
		return capacity.get();
	}

	public void setCapacity(int capacity) {
		this.capacity.set(capacity);
	}
	
	public IntegerProperty capacityProperty() {
		return this.capacity;
	}
	
	public IntegerProperty floorProperty() {
		return this.floor;
	}
	
	public String getId() {
		return this.id.get();
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
		return this.id.get()+this.campus.getCampus().toString()+this.name.get()+this.floor.get()+this.capacity.get();
	}
	
	

}
