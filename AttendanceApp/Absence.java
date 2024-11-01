package application;

public class Absence {
	
	private int year;
	private int month;
	private int day;
	private int period;
	private Student student;
	private int grade;
	private String state;
	
	public Absence(int year, int month, int day, int period, int grade, String student, String state) {
		
		this.year = year;
		this.month = month;
		this.day = day;
		this.period = period;
		this.student = new Student(grade, student);
		this.state = state;
	}
	
	

}
