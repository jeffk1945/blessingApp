package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.ListView;

import javafx.scene.control.RadioButton;

import javafx.scene.control.DatePicker;

import javafx.scene.control.ChoiceBox;

public class EditTeacherDialogController implements Initializable {
	@FXML
	private Button btnApplyChanges;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField tfName;
	@FXML
	private ListView listSubjects;
	@FXML
	private ListView listTeaching;
	@FXML
	private Button addTeaching;
	@FXML
	private Button removeTeaching;
	@FXML
	private RadioButton radioPartTime;
	@FXML
	private RadioButton radioFullTime;
	@FXML
	private ToggleGroup statusGroup;
	@FXML
	private ChoiceBox<String> choiceCampus;
	@FXML
	private ChoiceBox<String> choiceRoom;
	@FXML
	private DatePicker calEmploymentStart;
	@FXML
	private ToggleGroup genderGroup;
	@FXML
	private RadioButton radioMale;
	@FXML
	private RadioButton radioFemale;
	
	private String id;
//	private String gender;
//	private String status;

	public void loadData(Teacher teacher) {
		
		id=teacher.getId();
		choiceCampus.setValue(teacher.getCampus().getCampus());
		choiceRoom.setValue(teacher.getRoomName());
		tfName.setText(teacher.getName());
		if(teacher.getGender().equals("Female")) {
			radioFemale.setSelected(true);
		}
		
		if(teacher.getStatus().equals("Full-Time")) {
			radioFullTime.setSelected(true);
		}
		
		String[] dob=teacher.getStartDate().split("-");
		LocalDate date=LocalDate.of(Integer.valueOf(dob[0]), Integer.valueOf(dob[1]), Integer.valueOf(dob[2]));
		calEmploymentStart.setValue(date);
		
		String[] teachinglist=teacher.getSubjectList().split(",");
		
		for(int i=0;i<teachinglist.length;i++) {
			listTeaching.getItems().add(teachinglist[i]);
		}
		
		for(int i=0;i<listSubjects.getItems().size();i++) {
			for(int j=0;j<teachinglist.length;j++) {
				//System.out.println(listSubjects.getItems().get(i)+" ");
				if(listSubjects.getItems().get(i).equals(teachinglist[j])) {
					//System.out.println(listSubjects.getItems().get(i)+" "+teachinglist[j]);
					listSubjects.getItems().remove(i);
					i--;
				}
			}
		}
	}
		
	// Event Listener on Button[#btnApplyChanges].onAction
	@FXML
	public void applyChangesAction(ActionEvent event) throws SQLException {
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
		//public Teacher(String id, String name, String campus, String gender, String roomName, String status, String startDate, String subjects) {
		
		//String name, Room room, School campus, String teaching, String startDate, String isFullTime
		Teacher teacher=new Teacher(id, name, campus, gender, room, status, employmentDate, teachingList);
		
		
		Data.updateTeacher(teacher);
		
		for(int i=0;i<Data.teachers.size();i++) {
			if(Data.teachers.get(i).getId()==id) {
				Data.teachers.get(i).setCampus(new School(campus));
				Data.teachers.get(i).setRoom(new Room(room));
				Data.teachers.get(i).setGender(gender);
				Data.teachers.get(i).setSubjectList(teachingList);
				Data.teachers.get(i).setStartDate(employmentDate);
				Data.teachers.get(i).setStatus(status);
				Data.teachers.get(i).setCampusName(campus);
			}
		}
		
		Stage stage = (Stage) btnApplyChanges.getScene().getWindow();
		stage.close();
	}
	// Event Listener on Button[#btnCancel].onAction
	@FXML
	public void cancelAction(ActionEvent event) {
		// TODO Autogenerated
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
	// Event Listener on RadioButton[#radioPartTime].onAction
	@FXML
	public void statusAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on RadioButton[#radioFullTime].onAction

	// Event Listener on DatePicker[#calEmploymentStart].onAction
	@FXML
	public void employmentStartAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on RadioButton[#radioMale].onAction
	@FXML
	public void genderAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on RadioButton[#radioFemale].onAction
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listSubjects.getItems().addAll(Data.subjectNames);
		choiceCampus.getItems().addAll("Incheon", "Seocho", "Belleville");
		choiceRoom.getItems().addAll(Data.roomNames);
		
	}
}
