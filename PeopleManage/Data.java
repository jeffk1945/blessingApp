package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Data {
	
	public static ObservableList<Student> students;
	public static ObservableList<Teacher> teachers;
	public static ObservableList<String> teacherNames=FXCollections.observableArrayList();
	public static ObservableList<Room> rooms;
	public static ObservableList<String> roomNames=FXCollections.observableArrayList();
	public static ObservableList<Subject> subjects;
	public static ObservableList<String> subjectNames=FXCollections.observableArrayList();
	
	
	public static String generateId() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	   return generatedString;
	}
	public static ObservableList<Teacher> getAllTeachers() {
		
		
		ObservableList<Teacher> teachers=FXCollections.observableArrayList();
		
		DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB;
		Statement statement;
			try {
				String teacherlist="SELECT * from `teachers`";
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				ResultSet rs=statement.executeQuery(teacherlist);
				while(rs.next()) {
					String name=rs.getString("name");
					teacherNames.add(name);
					teachers.add(new Teacher(rs.getString("id"), name, rs.getString("campus"), rs.getString("gender"), rs.getString("room"), rs.getString("status"), rs.getString("employmentStart"), rs.getString("subjects")));					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return teachers;
	}
	
	public static ObservableList<Room> getAllRooms() {
		
		ObservableList<Room> rooms=FXCollections.observableArrayList();
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String studentlist="SELECT * from `rooms`"; 
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				ResultSet rs=statement.executeQuery(studentlist);
				while(rs.next()) {
					String name=rs.getString("name");
					roomNames.add(name);
					rooms.add(new Room(rs.getString("id"), rs.getString("campus"),rs.getInt("floor"), name, rs.getInt("capacity")));	
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		return rooms;
	}

	
	public static ObservableList<Student> getAllStudents() {
		
		ObservableList<Student> students=FXCollections.observableArrayList();
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String studentlist="SELECT * from `students`"; 
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				ResultSet rs=statement.executeQuery(studentlist);
				while(rs.next()) {
					//int id, int grade, String nameEnglish, String nameKorean, String campus, String isHonors, String isLivingDorm, String gender, String doB, int blessings, int tallies, String enrollmentDate, String[] subjects) {
					students.add(new Student(rs.getString("id"), rs.getInt("grade"),rs.getString("nameEnglish"), rs.getString("nameKorean"), rs.getString("campus"), rs.getString("honors"), rs.getString("dorm"), rs.getString("gender"), rs.getString("doB"), rs.getInt("blessings"), rs.getInt("tallies"), rs.getString("enrolled"), rs.getString("subjects")));
					
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		return students;
	}
	
	
	
	public static ObservableList<Subject> getAllSubjects() {
		
		ObservableList<Subject> subjects=FXCollections.observableArrayList();
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String subjectlist="SELECT * from `subjects`"; 
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				ResultSet rs=statement.executeQuery(subjectlist);
				while(rs.next()) {
					String name=rs.getString("name");
					subjects.add(new Subject(rs.getString("id"), rs.getString("campus"),rs.getInt("year"), rs.getString("semester"), name, rs.getInt("credits"), rs.getString("teacher"), rs.getString("grades")));
					subjectNames.add(name);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		return subjects;
	}
	
    public static void getStudents(int grade) {
		
		ArrayList<Student> students=new ArrayList<Student>();
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String studentlist="SELECT * from `students` WHERE grade='"+grade+"'"; 
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				ResultSet rs=statement.executeQuery(studentlist);
				while(rs.next()) {
					students.add(new Student(rs.getInt("grade"),rs.getString("name")));
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
    
    public static void updateRoom2(Room room) {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String updateRoom="UPDATE `rooms` SET campus='"+room.getCampus().getCampus()+"', floor='"+room.getFloor()+"', name='"+room.getCapacity()+"'WHERE id='"+room.getId()+"')"; 
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				statement.executeUpdate(updateRoom);				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
    
    public static void updateRoom(Room room) throws SQLException {
	
    	System.out.println(room.getCampus().getCampus());
    	System.out.println(room.getName());
    	System.out.println(room.getFloor());
    	System.out.println(room.getCapacity());
    	System.out.println("id: "+room.getId());


    	DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
						
		String sql = ("UPDATE `rooms` SET campus=?,name=?,floor=?,capacity=? WHERE id=?");
		PreparedStatement statement = null;
		try {
			statement = connectDB.prepareStatement(sql);
			statement.setString(5, room.getId());
		    statement.setString(1, room.getCampus().getCampus());
		    statement.setString(2, room.getName());
		    statement.setInt(3, room.getFloor());
		    statement.setInt(4, room.getCapacity());
		    
		    statement.executeUpdate();
		    statement.close();
						
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}
 
 
    public static void updateSubject2(Subject subject) {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String updatesubject="UPDATE `subjects` SET campus='"+subject.getCampus().getCampus()+"', year='"+subject.getYear()+"', semester='"+subject.getSemester()+"', name='"+subject.getName()+"', credits='"+subject.getCredits()+"', teacher='"+subject.getTeacher()+"'grades='"+subject.getGrades()+"'WHERE id='"+subject.getId()+"')"; 
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				statement.executeUpdate(updatesubject);				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
    
    public static void updateSubject(Subject subject) throws SQLException {
    	

    	DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
						
		String sql = ("UPDATE `subjects` SET campus=?,year=?, semester=?,name=?,credits=?,teacher=?,grades=? WHERE id=?");
		PreparedStatement statement = null;
		try {
			statement = connectDB.prepareStatement(sql);
			statement.setString(8, subject.getId());
		    statement.setString(1, subject.getCampus().getCampus());
		    statement.setInt(2, subject.getYear());
		    statement.setString(3, subject.getSemester());
		    statement.setString(4, subject.getName());
		    statement.setInt(5, subject.getCredits());
		    statement.setString(6, subject.getTeacherName());
		    statement.setString(7, subject.getGradesList());
		    
		    statement.executeUpdate();
		    statement.close();
						
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
    }

    public static void updateStudent2(Student student) {
	
//	DatabaseConnection connectNow=new DatabaseConnection();
//	  Connection connectDB;
//	  Statement statement;
//		try {
//			String updatestudent="UPDATE `students` SET campus='"+student.getCampus().getCampus()+"', floor='"+student.getFloor()+"', name='"+student.getCapacity()+"'WHERE id='"+student.getId()+"')"; 
//			connectDB=connectNow.getConnection("kics");
//			statement=connectDB.createStatement();
//			statement.executeUpdate(updatestudent);				
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
    }
    
    public static void updateStudent(Student student) throws SQLException {
    	
    	DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
		String sql = ("UPDATE `students` SET grade=?,nameEnglish=?, nameKorean=?,campus=?,gender=?,dob=?,enrolled=?,honors=?,dorm=? WHERE id=?");
		PreparedStatement statement = null;
		try {
			statement = connectDB.prepareStatement(sql);
			statement.setString(10, student.getId());
		    statement.setInt(1, student.getGrade());
		    statement.setString(2, student.getNameEnglish());
		    statement.setString(3, student.getNameKorean());
		    statement.setString(4, student.getCampus().getCampus());
		    statement.setString(5, student.getGender());
		    statement.setString(6, student.getDoB());
		    statement.setString(7, student.getEnrollmentDate());
		    statement.setString(8, student.getHonors());
		    statement.setString(9, student.getDorm());
		    
		    statement.executeUpdate();
		    statement.close();
						
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
    }

    public static void updateTeacher2(Teacher teacher) {
	
//	DatabaseConnection connectNow=new DatabaseConnection();
//	  Connection connectDB;
//	  Statement statement;
//		try {
//			String updateteacher="UPDATE `teachers` SET campus='"+teacher.getCampus().getCampus()+"', floor='"+teacher.getFloor()+"', name='"+teacher.getCapacity()+"'WHERE id='"+teacher.getId()+"')"; 
//			connectDB=connectNow.getConnection("kics");
//			statement=connectDB.createStatement();
//			statement.executeUpdate(updateteacher);				
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
    }
    
    public static void updateTeacher(Teacher teacher) throws SQLException {
    	
    	DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
		//int id, String name, String campus, String gender, String roomName, String status, String startDate, String subjects) {
		String sql = ("UPDATE `teachers` SET name=?,campus=?, gender=?,room=?,status=?,employmentStart=? WHERE id=?");
		
		PreparedStatement statement = null;
		try {
			statement = connectDB.prepareStatement(sql);
			statement.setString(7, teacher.getId());
		    statement.setString(1, teacher.getName());
		    statement.setString(2, teacher.getCampus().getCampus());
		    statement.setString(3, teacher.getGender());
		    statement.setString(4, teacher.getRoomName());
		    statement.setString(5, teacher.getStatus());
		    statement.setString(6, teacher.getStartDate());
		    
		    statement.executeUpdate();
		    statement.close();
						
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
    }
	
	public static void deleteStudent(int grade, String name) {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String deleteStudent="DELETE FROM `students` WHERE (grade='"+grade+"' AND name='"+name+"')"; 
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				statement.executeUpdate(deleteStudent);				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	public static void deleteTeacher(String name) {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String deleteStudent="DELETE FROM `teachers` WHERE (name='"+name+"')"; 
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				statement.executeUpdate(deleteStudent);				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	public static void addStudent(Student student) throws SQLException {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
				
		String insertFields="INSERT INTO students(grade, nameEnglish, nameKorean, campus, gender, dob, honors, dorm) VALUES ('";
		String insertValues=student.getGrade()+"','"+student.getNameEnglish()+"','"+student.getNameKorean()+"','"+student.getCampus()+"','"+student.getGender()+"','"+student.getDoB()+"','"+student.isHonors()+"','"+student.isLivingDorm()+"')";
		String insertToRegister=insertFields+insertValues;
		
		try {
			Statement statement=connectDB.createStatement();
			statement.executeUpdate(insertToRegister);
						
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}
	
	public static void addRoom(Room room) throws SQLException {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
				
		String insertFields="INSERT INTO rooms(campus, name, floor, capacity) VALUES ('";
		String insertValues=room.getCampus()+"','"+room.getName()+"','"+room.getFloor()+"','"+room.getCapacity()+"')";
		String insertToRegister=insertFields+insertValues;
		
		try {
			Statement statement=connectDB.createStatement();
			statement.executeUpdate(insertToRegister);
						
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}
	
	public static void addRoom2(Room room) throws SQLException {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
						
		String sql = "INSERT INTO rooms (campus, name, floor, capacity)"
			     + " VALUES (?, ?, ?, ?)";
		PreparedStatement statement = null;
		
		try {
			statement = connectDB.prepareStatement(sql);
		    statement.setString(1, room.getCampus().getCampus());
		    statement.setString(2, room.getName());
		    statement.setInt(3, room.getFloor());
		    statement.setInt(4, room.getCapacity());
		    statement.executeUpdate();
						
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}
	
	public static void addSubject(Subject subject) throws SQLException {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
				
		String insertFields="INSERT INTO subjects(campus, year, semester, name, credits, teacher, grades) VALUES ('";
		String insertValues=subject.getCampus()+"','"+subject.getYear()+"','"+subject.getSemester()+"','"+subject.getName()+"','"+subject.getCredits()+"','"+subject.getTeacherName()+"','"+subject.getGradesList()+"')";
		String insertToRegister=insertFields+insertValues;
		
		try {
			Statement statement=connectDB.createStatement();
			statement.executeUpdate(insertToRegister);
						
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}
	
	public static void addSubject2(Subject subject) throws SQLException {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
				
		String insertFields="INSERT INTO subjects(campus, year, semester, name, credits, teacher, grades) VALUES ('";
		String insertValues=subject.getCampus()+"','"+subject.getYear()+"','"+subject.getSemester()+"','"+subject.getName()+"','"+subject.getCredits()+"','"+subject.getTeacherName()+"','"+subject.getGradesList()+"')";
		String insertToRegister=insertFields+insertValues;
		
		try {
			Statement statement=connectDB.createStatement();
			statement.executeUpdate(insertToRegister);
						
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}
	
	public static void addTeacher(Teacher teacher) throws SQLException {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
		//String name, Room room, School campus, String teaching, String startDate, String isFullTime
		String insertFields="INSERT INTO teachers(id, name, room, status, gender, employmentStart, subjects, campus) VALUES ('";
		String insertValues=teacher.getId()+"','"+teacher.getName()+"','"+teacher.getRoom().getName()+"','"+teacher.getStatus()+"','"+teacher.getGender()+"','"+teacher.getStartDate()+"','"+teacher.getSubjectList()+"','"+teacher.getCampus().getCampus()+"')";
		String insertToRegister=insertFields+insertValues;
		
		try {
			Statement statement=connectDB.createStatement();
			statement.executeUpdate(insertToRegister);
						
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}

}
