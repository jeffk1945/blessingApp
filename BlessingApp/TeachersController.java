package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class TeachersController {
	
	private Stage stage;
	private Scene scene;
	private int grade;
	ObservableList<Integer> gradeList=FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
	@FXML
	private ComboBox<Integer> comboGrade;
	@FXML
	private Button btnLogout;

	// Event Listener on ChoiceBox[#choiceGrade].onDragDetected
	@FXML
	public void gradeAction(ActionEvent event) {
		grade=comboGrade.getValue();
		
		
	}
	// Event Listener on Button[#btnLogout].onAction
	@FXML
	public void logoutAction(ActionEvent event) throws IOException {
		Parent root=FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void initialize() {
		
		comboGrade.setItems(gradeList);
		
	}
}
