package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ChoiceBox;

public class AddRoomDialogController implements Initializable {
	
	@FXML
	private ChoiceBox<String> comboRoomCampus;
	@FXML
	private ChoiceBox<Integer> comboRoomFloor;
	@FXML
	private TextField labelRoomName;
	@FXML
	private Spinner<Integer> roomCapacity;
	@FXML
	private Button btnAddRoomSubmit;
	@FXML
	private Button btnCancelAddRoom;
	
	SpinnerValueFactory<Integer> valueFactory;

	// Event Listener on Button[#btnAddRoomSubmit].onAction
	@FXML
	public void addRoomSubmitAction(ActionEvent event) throws SQLException {
		
		String campus=comboRoomCampus.getSelectionModel().getSelectedItem().toString();
		int floor=comboRoomFloor.getSelectionModel().getSelectedItem();
		String name=labelRoomName.getText();
		int capacity=roomCapacity.getValue();
	
		
		System.out.println(campus);
		System.out.println(floor);
		System.out.println(name);
		System.out.println(capacity);


		Room room=new Room(campus, floor, name, capacity);
	
		
		Data.addRoom2(room);
		Data.rooms.add(room);
		Stage stage = (Stage) btnAddRoomSubmit.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void cancelAddRoomAction(ActionEvent event) {
		Stage stage = (Stage) btnCancelAddRoom.getScene().getWindow();
		stage.close();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30);
		roomCapacity.setValueFactory(valueFactory);
		Integer[] floors= {2, 3, 4};
		comboRoomFloor.getItems().addAll(floors);
		comboRoomCampus.getItems().addAll("Incheon", "Seocho", "Belleville");
		
	}

	
}
