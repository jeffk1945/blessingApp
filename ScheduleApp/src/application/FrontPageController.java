package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class FrontPageController {
	@FXML
	private Button admins;
	@FXML
	private Button btnteachers;
	@FXML
	private Button btnstudents;
	
	private Stage stage;
	private Scene scene;
	
	// Event Listener on Button[#admins].onAction
	@FXML
	public void adminsAction(ActionEvent event) throws IOException {
		System.out.println("admins");
		Parent root=FXMLLoader.load(getClass().getResource("AdminStartPage.fxml"));
		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	// Event Listener on Button[#btnteachers].onAction
	@FXML
	public void teachersAction(ActionEvent event) throws IOException {
		System.out.println("teachers");
		Parent root=FXMLLoader.load(getClass().getResource("TeacherStartPage.fxml"));
		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	// Event Listener on Button[#btnstudents].onAction
	@FXML
	public void studentsAction(ActionEvent event) throws IOException {
		System.out.println("start");
		Parent root=FXMLLoader.load(getClass().getResource("StudentStartPage.fxml"));
		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
