package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	private Button btnClose;
	@FXML
	private PasswordField tfPassword;
	@FXML
	private TextField tfUsername;
	
	@FXML
    private Label passwordError;

    @FXML
    private Label usernameError;
	
	private Stage stage;
	private Scene scene;
	
	Connection connectDB;
	

	// Event Listener on Button[#btnLogin].onAction
	@FXML
	public void loginAction(ActionEvent event) throws IOException {
		
		String un=tfUsername.getText();
		String pw=tfPassword.getText();
		
		if(validate(un, pw)) {
			Parent root=FXMLLoader.load(getClass().getResource("Manage.fxml"));
			stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		} 	
		
	}
	
	public boolean validateLogin(String un, String pw) { 

		boolean validated=false;
		DatabaseConnection connectNow=new DatabaseConnection();
		try {
			connectDB=connectNow.getConnection("kics");
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}

			String verifyLogin="SELECT count(1) FROM `admin` WHERE username='"+un+"' AND password='"+pw+"'";

		try {
			Statement statement=connectDB.createStatement();
			ResultSet rs=statement.executeQuery(verifyLogin);


		while(rs.next()) {

			if(rs.getInt(1)==1) {

//			loginMessage.setText("Login Successful");
//			Session.sessionUser=loginUsername.getText();
//			Session.generateSessionID(loginUsername.getText());
//			Student loggedInStudent=new Student(Session.sessionID, loginUsername.getText());
//			setupUser(loggedInStudent);
			validated=true;
		} else {
			
			passwordError.setText("Invalid Login, Please Check username and Password again.");
		}
		}

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
			System.out.println(validated);
			return validated;
		}
	
	private boolean validate(String un, String pw) {
		
		return true;
	}
	// Event Listener on Button[#btnClose].onAction
	@FXML
	public void closeAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on PasswordField[#tfPassword].onAction
	@FXML
	public void passwordAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on TextField[#tfUsername].onAction
	@FXML
	public void usernameAction(ActionEvent event) {
		// TODO Autogenerated
	}
}
