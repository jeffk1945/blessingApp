package application;


public class Subject {
	
	private int credits;
	private Teacher teacher;
	private int[] grade;
	private int id;
	private String name;
	
	public Subject(String name) {
		this.name=name;
	}
	
	public Subject(int id, int credits, Teacher teacher, String name) {
		this.id=id;
		this.credits=credits;
		this.teacher=teacher;
		this.name=name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int[] getGrade() {
		return grade;
	}

	public void setGrade(int[] grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}

}
