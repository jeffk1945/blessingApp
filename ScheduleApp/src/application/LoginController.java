package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

public class LoginController {
	
	@FXML
	private Button btnLogin;
	@FXML
	private TextField tfusername;
	@FXML
	private PasswordField tfpassword;

	Connection connectDB;
	Parent root;
	
	
	public void login(ActionEvent e) throws IOException {		
		
		if(tfusername.getText().isBlank()==false && tfpassword.getText().isBlank()==false) {
			if(validateLogin()) {
				//constructAllLists(e, loginUsername.getText().toString());
				mainPage(e);	
			}
				
		} else {
			//loginMessage.setStyle("-fx-text-fill: red;");
			//loginMessage.setText("Please Enter a username and password");
		}
	}
	
	public void constructAllLists(ActionEvent event, String user) {
		//gv.getCategories();
	}
	
	public boolean validateLogin() {

		boolean validated=false;
		DatabaseConnection connectNow=new DatabaseConnection();
		try {
			connectDB=connectNow.getConnection("teachers");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String verifyLogin="SELECT count(1) FROM `teachers` WHERE username='"+tfusername.getText()+"' AND password='"+tfpassword.getText()+"'";
		
		try {
			Statement statement=connectDB.createStatement();
			ResultSet rs=statement.executeQuery(verifyLogin);
			

			while(rs.next()) {
				
				if(rs.getInt(1)==1) {
				
					//loginMessage.setText("Login Successful");
					//Session.sessionUser=tfusername.getText();
					//Session.generateSessionID(tfusername.getText());
					//Student loggedInStudent=new Student(Session.sessionID, loginUsername.getText());
					//setupUser(loggedInStudent);
					validated=true;
				} else {
					System.out.println("no match");
					//loginMessage.setText("Invalid Login, Please Check username and Password again.");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		System.out.println(validated);
		return validated;
	}
	
//	public void setupUser(Student student) {
//		
//
//		String retrieveProfile="SELECT * FROM `student` WHERE username='"+loginUsername.getText()+"'";
//
//		try {
//			Statement statement=connectDB.createStatement();
//			ResultSet rs=statement.executeQuery(retrieveProfile);
//			
//			while(rs.next()) {
//				student.setCountry(rs.getString("country"));
//				student.setSchool(rs.getString("school"));
//				student.setEmail(rs.getString("email"));
//				student.setYear(rs.getString("year"));
//				student.setGraduation(rs.getString("graduation"));
//				student.setPhoto(rs.getString("photo"));
//				student.setContact(rs.getString("contact"));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			e.getCause();
//		}
//		
//		
//		
//	}
	
	
	private Stage stage;
	private Scene scene;
	
	
	public void backToFrontPage(ActionEvent event) throws IOException {
		
		Parent root=FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	public void registerPage(ActionEvent event) throws IOException  {
		Parent root=FXMLLoader.load(getClass().getResource("Registration.fxml"));
		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void forgotPasswordPage(ActionEvent event) throws IOException  {
		Parent root=FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void profilePage(ActionEvent event) throws IOException  {
		
//		String username=loginUsername.getText();
//		
//		FXMLLoader loader=new FXMLLoader(getClass().getResource("Profile.fxml"));
//		root=loader.load();
//		
//		ProfileController profileController=loader.getController();
//		
//		profileController.displayProfile(username);
//		//profileController.displayTable();
//		
//		//profileController.test(loginUsername.getText());
//		
//		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
//		scene=new Scene(root);
//		stage.setScene(scene);
//		stage.show();
	}
	
	public void mainPage(ActionEvent event) throws IOException  {
		
		Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
		scene=new Scene(root, 1200, 800);
		stage.setScene(scene);
		stage.show();

	}
	
	@FXML
	public void loginAction(ActionEvent event) {
		
	}
}
