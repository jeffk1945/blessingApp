package application;

import java.util.ArrayList;

public class School {
	
	private String campus;
	private ArrayList<Teacher> teachers=new ArrayList<Teacher>();
	private ArrayList<Student> students=new ArrayList<Student>();
	
	public School(String campus) {
		this.campus=campus;
	}
	
	
	
	public String getSchool() {
		return campus;
	}



	public void setSchool(String campus) {
		this.campus = campus;
	}
	
	public String toString() {
		return this.campus;
	}



	public void load() {
		//load the teachers and students arrays
		
//		String[] jeffsubjects= {"math10", "math11", "math12", "science9", "science11", "science12"};
//		String[] jamessubjects= {"math6", "math7", "math8", "math9", "science6", "science7", "science8"};
//		String[] jennifersubjects= {"writing10", "writing11", "writing12"};
//		String[] thomassubjects= {"History9", "History10", "History11"};
//		String[] yaerimsubjects= {"bible9", "bible10", "bible11"};
//		String[] juliasubjects= {"cs9", "cs10", "cs11"};
//		String[] rebekahsubjects= {"english9", "english10", "english11", "english12"};
//		String[] boramsubjects= {"music9","music10", "music11", "music12"};
//		String[] olivesubjects= {"econ10", "finance11", "banking12"};
//		String[] karisubjects= {"reading9", "reading10", "reading11", "reading12"};
		
		
//		teachers.add(new Teacher("Jeff", new Room(2, "Confidence"), 0, jeffsubjects));
//		teachers.add(new Teacher("James", new Room(2, "Obedience"), 1, jamessubjects));
//		teachers.add(new Teacher("Jennifer", new Room(2, "Humility"), 2, jennifersubjects));
//		teachers.add(new Teacher("Thomas", new Room(2, "Mercy"), 3, thomassubjects));
//		teachers.add(new Teacher("Yaerim", new Room(3, "Love"), 4, yaerimsubjects));
//		teachers.add(new Teacher("Julia", new Room(3, "Faith"), 5, juliasubjects));
//		teachers.add(new Teacher("Rebekah", new Room(2, "Holiness"), 6, rebekahsubjects));
//		teachers.add(new Teacher("Olive", new Room(2, "Truth"), 7, olivesubjects));
//		teachers.add(new Teacher("Boram", new Room(2, "Salvation"), 8, boramsubjects));
//		teachers.add(new Teacher("Kari", new Room(2, "Eden"), 9, karisubjects));
		
		//jeff
//		subjects.add(new Subject(0, 4,  teachers.get(0), "Math9"));
//		subjects.add(new Subject(1, 4,  teachers.get(0), "Math10"));
//		subjects.add(new Subject(2, 4,  teachers.get(0), "Math11"));
//		subjects.add(new Subject(3, 4,  teachers.get(0), "Math12"));
//		subjects.add(new Subject(4, 3,  teachers.get(0), "Science9"));
//		subjects.add(new Subject(6, 3,  teachers.get(0), "Science11"));
//		subjects.add(new Subject(7, 3,  teachers.get(0), "Science12"));
//		
//		//james
//		subjects.add(new Subject(4, 3,  teachers.get(1), "Science6"));
//		subjects.add(new Subject(5, 3,  teachers.get(1), "Science7"));
//		subjects.add(new Subject(6, 3,  teachers.get(1), "Science8"));
//		subjects.add(new Subject(7, 3,  teachers.get(1), "Science10"));
//		subjects.add(new Subject(0, 4,  teachers.get(1), "Math6"));
//		subjects.add(new Subject(1, 4,  teachers.get(1), "Math7"));
//		subjects.add(new Subject(2, 4,  teachers.get(1), "Math8"));
//		subjects.add(new Subject(2, 4,  teachers.get(1), "Math9"));
//		
//		//jennifer
//		subjects.add(new Subject(8, 3,  teachers.get(2), "Psychology9"));
//		subjects.add(new Subject(9, 3,  teachers.get(2), "Psychology10"));
//		subjects.add(new Subject(10, 3,  teachers.get(2), "Psychology11"));
//		subjects.add(new Subject(11, 3,  teachers.get(2), "Psychology12"));
//		subjects.add(new Subject(11, 3,  teachers.get(2), "Grammar9"));
//		subjects.add(new Subject(11, 3,  teachers.get(2), "Grammar10"));
//				
//		//thomas
//		subjects.add(new Subject(8, 4,  teachers.get(3), "History9"));
//		subjects.add(new Subject(9, 4,  teachers.get(3), "History10"));
//		subjects.add(new Subject(10, 4,  teachers.get(3), "History11"));
//		subjects.add(new Subject(11, 4,  teachers.get(3), "History12"));
//		subjects.add(new Subject(11, 4,  teachers.get(3), "SocialStudies6"));
//		subjects.add(new Subject(11, 4,  teachers.get(3), "SocialStudies7"));
//		subjects.add(new Subject(11, 4,  teachers.get(3), "SocialStudies8"));
//		subjects.add(new Subject(11, 4,  teachers.get(3), "SocialStudies9"));
//		
//		//Kari
//		subjects.add(new Subject(12, 4,  teachers.get(7), "Reading9"));
//		subjects.add(new Subject(13, 4,  teachers.get(7), "Reading10"));
//		subjects.add(new Subject(14, 4,  teachers.get(7), "Reading11"));
//		subjects.add(new Subject(15, 4,  teachers.get(7), "Reading12"));
//				
//		//rebekah
//		subjects.add(new Subject(12, 4,  teachers.get(6), "English9"));
//		subjects.add(new Subject(13, 4,  teachers.get(6), "English10"));
//		subjects.add(new Subject(14, 4,  teachers.get(6), "English11"));
//		subjects.add(new Subject(15, 4,  teachers.get(6), "English12"));
//		
//		//yaerim
//		subjects.add(new Subject(16, 3,  teachers.get(4), "Bible9"));
//		subjects.add(new Subject(17, 3,  teachers.get(4), "Bible10"));
//		subjects.add(new Subject(18, 3,  teachers.get(4), "Bible11"));
//		subjects.add(new Subject(19, 3,  teachers.get(4), "Bible12"));
//		
//		//boram
//		subjects.add(new Subject(16, 2,  teachers.get(8), "music9"));
//		subjects.add(new Subject(17, 2,  teachers.get(8), "music10"));
//		subjects.add(new Subject(18, 2,  teachers.get(8), "music11"));
//		subjects.add(new Subject(19, 2,  teachers.get(8), "music12"));
//		
//		//olive
//		subjects.add(new Subject(16, 2,  teachers.get(8), "music9"));
//		subjects.add(new Subject(17, 2,  teachers.get(8), "music10"));
//		subjects.add(new Subject(18, 2,  teachers.get(8), "music11"));
//		subjects.add(new Subject(19, 2,  teachers.get(8), "music12"));
		
		
		
	}

}
