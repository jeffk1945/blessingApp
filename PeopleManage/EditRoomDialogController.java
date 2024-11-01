package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

public class EditRoomDialogController implements Initializable {
	
	@FXML
	private ComboBox<String> comboRoomCampus;

    @FXML
    private ChoiceBox<Integer> choiceRoomFloor;
	@FXML
	private TextField labelRoomName;
	@FXML
	private Spinner<Integer> roomCapacity;
	@FXML
    private Button btnApplyChanges;
	@FXML
    private Button btnCancelEditRoom;
	
	SpinnerValueFactory<Integer> valueFactory;
	private String id;


	public void loadData(Room room) {
		
		comboRoomCampus.setValue(room.getCampus().getCampus());
		choiceRoomFloor.setValue(room.getFloor());
		labelRoomName.setText(room.getName());
		roomCapacity.getValueFactory().setValue(room.getCapacity());
		id=room.getId();
		
	}
	
	@FXML
    void roomCampusAction(ActionEvent event) {

    }
	
	
	@FXML
    void applyChangesAction(ActionEvent event) throws SQLException {
		
		String campus=comboRoomCampus.getSelectionModel().getSelectedItem().toString();
		int floor=choiceRoomFloor.getSelectionModel().getSelectedItem();
		String name=labelRoomName.getText();
		int capacity=roomCapacity.getValue();
	
		
		System.out.println(campus);
		System.out.println(floor);
		System.out.println(name);
		System.out.println(capacity);


		Room room=new Room(id, campus, floor, name, capacity);
	
		
		Data.updateRoom(room);
		
		for(int i=0;i<Data.rooms.size();i++) {
			if(Data.rooms.get(i).getId()==id) {
				Data.rooms.get(i).getCampus().setCampus(campus);
				Data.rooms.get(i).setCampusName(campus);
				Data.rooms.get(i).setFloor(floor);
				Data.rooms.get(i).setCapacity(capacity);
				Data.rooms.get(i).setName(name);
			}
		}
		
//		for(Room r: Data.rooms) {
//			System.out.println(r);
//		}
		
		Stage stage = (Stage) btnApplyChanges.getScene().getWindow();
		stage.close();
    }

	@FXML
    void cancelEditRoomAction(ActionEvent event) {

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30);
		roomCapacity.setValueFactory(valueFactory);
		Integer[] floors= {2, 3, 4};
		choiceRoomFloor.getItems().addAll(floors);
		comboRoomCampus.getItems().addAll("Incheon", "Seocho", "Belleville");
		
	}
}
