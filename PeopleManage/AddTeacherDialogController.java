package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

public class AddTeacherDialogController implements Initializable {
	@FXML
	private Button btnSubmit;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField tfName;

	@FXML
    private ChoiceBox<String> choiceCampus;

    @FXML
    private ChoiceBox<String> choiceRoom;
    
    @FXML
    private RadioButton radioFullTime;

    @FXML
    private RadioButton radioPartTime;
	@FXML
	private ListView listSubjects;
	@FXML
	private ListView listTeaching;
	@FXML
	private Button addTeaching;
	@FXML
	private Button removeTeaching;
	
	@FXML
    private DatePicker calEmploymentStart;
	
	@FXML
    private ToggleGroup status;
	
	@FXML
    private ToggleGroup gender;
	
	@FXML
    private RadioButton radioFemale;

    @FXML
    private RadioButton radioMale;
	
	private String campus;
	
	// Event Listener on Button[#btnSubmit].onAction
	@FXML
	public void submitAction(ActionEvent event) throws SQLException {
		
		String name=tfName.getText();

		String employmentDate=calEmploymentStart.getValue().toString();
		
		String campus=choiceCampus.getValue();
		
		String room=choiceRoom.getValue();
		
		String gender=radioFemale.isSelected() ? "Female" : "Male";
		
		String status=radioFullTime.isSelected() ? "Full-Time" : "Part-Time";
		
		String teachingList="";
		for(int i=0;i<listTeaching.getItems().size();i++) {
			if(i<listTeaching.getItems().size()-1)
				teachingList+=listTeaching.getItems().get(i)+",";
			else
				teachingList+=listTeaching.getItems().get(i);
		}
		
		
		//String name, Room room, School campus, String teaching, String startDate, String isFullTime
		Teacher teacher=new Teacher(name, room, gender, campus, teachingList, employmentDate, status);
		
		
		Data.addTeacher(teacher);
		Data.teachers.add(teacher);
		
		Stage stage = (Stage) btnSubmit.getScene().getWindow();
		stage.close();
	}
	// Event Listener on Button[#btnCancel].onAction
	@FXML
	public void cancelAction(ActionEvent event) {
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}
	// Event Listener on Button[#addTeaching].onAction
	@FXML
	public void addTeachingAction(ActionEvent event) {
		int selectedIndex=listSubjects.getSelectionModel().getSelectedIndex();
		if(selectedIndex>-1) {
			//System.out.println(listSubjects.getItems());
			listTeaching.getItems().add(listSubjects.getItems().get(selectedIndex));
			listSubjects.getItems().remove(selectedIndex);
			//System.out.println(listSubjects.getItems());
			//System.out.println(listTeaching.getItems());
			//System.out.println(selectedIndex);
			selectedIndex=-1;
			//System.out.println(selectedIndex);
			listSubjects.getSelectionModel().clearSelection();
		}
		
		
		
	}
	// Event Listener on Button[#removeTeaching].onAction
	@FXML
	public void removeTeachingAction(ActionEvent event) {
		int selectedIndex=listTeaching.getSelectionModel().getSelectedIndex();
		if(selectedIndex>-1) {
			System.out.println(listTeaching.getItems());
			listSubjects.getItems().add(listTeaching.getItems().get(selectedIndex));
			listTeaching.getItems().remove(selectedIndex);
			selectedIndex=-1;
			listTeaching.getSelectionModel().clearSelection();
		}
	}
	
	@FXML
	public void genderAction(ActionEvent event) {
		
	}
	
	@FXML
	public void employmentStartAction(ActionEvent event) {
		
	}
	
	@FXML
    void statusAction(ActionEvent event) {
		//isFullTime=radioFullTime.isSelected();
		
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listSubjects.getItems().addAll(Data.subjectNames);
		choiceCampus.getItems().addAll("Incheon", "Seocho", "Belleville");
		choiceRoom.getItems().addAll("Love", "Holiness");
		
	}

    
}
