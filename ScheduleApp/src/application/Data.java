package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Data {
	
	public static ArrayList<Teacher>  getTeachers() {
		
		ArrayList<Teacher> teachers=new ArrayList<Teacher>();
		
		DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB;
		Statement statement;
			try {
				String teacherlist="SELECT * from `teachers`";
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				ResultSet rs=statement.executeQuery(teacherlist);
				while(rs.next()) {
					teachers.add(new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("school"), new Room(rs.getString("room")), rs.getString("subjects").split(",")));					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return teachers;
	}
	
	public static void getStudents() {
		
		ArrayList<Student> students=new ArrayList<Student>();
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String studentlist="SELECT * from `students`"; 
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
	
	public void createDatabaseTable() throws SQLException {

		DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("monty");

		String createScoreTable="CREATE TABLE IF NOT EXISTS `wintable` ("+
		 "`id` int(11) NOT NULL primary key AUTO_INCREMENT,"+
		 "`winkeep` int(11) NOT NULL,"+
		 "`winchange` int(11) DEFAULT NULL,"+
		 "`losekeep` int(11) DEFAULT NULL,"+
		 "`losechange` int(11) DEFAULT NULL,"+
		 "`totalgames` int(11) DEFAULT NULL,"+
		");";

		try {
			Statement statement1=connectDB.createStatement();
			statement1.executeUpdate(createScoreTable);

		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}

		}
	
	public static void addStudent(Student student) throws SQLException {
		
		DatabaseConnection connectNow=new DatabaseConnection();
		Connection connectDB=connectNow.getConnection("kics");
				
		String insertFields="INSERT INTO students(name, grade) VALUES ('";
		String insertValues=student.getName()+"','"+student.getGrade()+"')";
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
				
		String insertFields="INSERT INTO teachers(name) VALUES ('";
		String insertValues=teacher.getName()+"')";
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
