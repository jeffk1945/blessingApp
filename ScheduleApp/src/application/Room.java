package application;


public class Room {

	private int floor;
	private String name;
	private int capacity;
	
	public Room(String name) {
		this.name = name;
	}
	
	public Room(int floor, String name) {
		this.floor = floor;
		this.name = name;
	}
	
	public Room(int floor, String name, int capacity) {
		this.floor = floor;
		this.name = name;
		this.capacity=capacity;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String toString() {
		return this.name;
	}
	
}

