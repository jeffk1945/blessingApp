package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class ManageController implements Initializable {
	@FXML
	private BorderPane borderPane;
	@FXML
	private TabPane tabPane;
	@FXML
	private Button btnAddStudent;
	@FXML
	private Button btnAddTeacher;
	@FXML
	private Button btnAddSubject;
	@FXML
	private Button btnAddRoom;
	@FXML
	private TableView<Student> tableViewStudents;
	@FXML
    private TableView<Room> tableViewRooms;
    @FXML
    private TableView<Subject> tableViewSubjects;
	@FXML
    private TableView<Teacher> tableViewTeachers;
	@FXML
	private TableColumn<Student, Integer> colStudentsGrade;
	@FXML
	private TableColumn<Student, String>colStudentsNameEnglish;
	@FXML
	private TableColumn<Student, String>colStudentsNameKorean;
	@FXML
	private TableColumn<Student, String>colStudentsGender;
	@FXML
	private TableColumn<Student, String> colStudentsHonors;
	@FXML
	private TableColumn<Student, String> colStudentsDoB;
	@FXML
	private TableColumn<Student, String> colStudentsDorm;
//	@FXML
//	private TableColumn<Student, Integer> colStudentsBlessings;
//	@FXML
//	private TableColumn<Student, Integer> colStudentsTallies;
	@FXML
	private TableColumn<Student, String> colStudentsEnrolled;
	@FXML
    private TableColumn<Student, String> colStudentsSubjects;
	
	@FXML
    private TableColumn<Student, Void> colStudentsEdit;
	@FXML
    private TableColumn<Student, Void> colStudentsDelete;
	
	@FXML
	private ComboBox comboGrade;
	@FXML
	private Button btnViewStudents;
	
	@FXML
    private Button btnViewRooms;

    @FXML
    private Button btnViewSubjects;
	
	@FXML
	private Button btnViewTeachers;
	
	@FXML
	private Button btnRefreshRooms;

	@FXML
	private Button btnRefreshStudents;

	@FXML
	private Button btnRefreshSubjects;
    @FXML
    
    private Button btnRefreshTeachers;
    @FXML
    private TableColumn<Room, String> colRoomsCampus;
    @FXML
    private TableColumn<Room, Integer> colRoomsCapacity;
    @FXML
    private TableColumn<Room, Integer> colRoomsFloor;
    @FXML
    private TableColumn<Room, String> colRoomsRoomName;
    @FXML
    private TableColumn<Room, Void> colRoomsDelete;
    @FXML
    private TableColumn<Room, Void> colRoomsEdit;
    
    
	@FXML
	private TableColumn<Teacher, String> colTeachersName;
	@FXML
	private TableColumn<Teacher, String> colTeachersStatus;
	@FXML
	private TableColumn<Teacher, String> colTeachersRoom;
	@FXML
    private TableColumn<Teacher, String> colTeachersEmploymentDate;
	@FXML
	private TableColumn<Teacher, String> colTeachersSubjects;
	@FXML
    private TableColumn<Teacher, Void> colTeachersDelete;
    @FXML
    private TableColumn<Teacher, Void> colTeachersEdit;
    @FXML
    private TableColumn<Teacher, String> colTeachersCampus;
    
	
	@FXML
    private TableColumn<Subject, String> colSubjectCampus;
    @FXML
    private TableColumn<Subject, Integer> colSubjectCredits;
    @FXML
    private TableColumn<Subject, String> colSubjectGrade;
    @FXML
    private TableColumn<Subject, String> colSubjectName;
    @FXML
    private TableColumn<Subject, String> colSubjectTeacher;
    @FXML
    private TableColumn<Subject, Void> colSubjectsDelete;
    @FXML
    private TableColumn<Subject, Void> colSubjectsEdit;
	
	School incheon;
	School seocho;
	
	

	// Event Listener on Button[#btnAddStudent].onAction
	@FXML
	public void addStudentAction(ActionEvent event) throws IOException {
		Stage stage=new Stage();
		
		Parent root=FXMLLoader.load(getClass().getResource("AddStudentDialog.fxml"));
		
		Scene scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	@FXML
    void addRoomAction(ActionEvent event) throws IOException {
		Stage stage=new Stage();
		
		Parent root=FXMLLoader.load(getClass().getResource("AddRoomDialog.fxml"));
		
		Scene scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void addSubjectAction(ActionEvent event) throws IOException {
    	Stage stage=new Stage();
		
		Parent root=FXMLLoader.load(getClass().getResource("AddSubjectDialog.fxml"));
		
		Scene scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    
	// Event Listener on ComboBox[#comboGrade].onAction
	@FXML
	public void gradeAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnViewStudents].onAction

	// Event Listener on Button[#btnAddTeacher].onAction
	@FXML
	public void addTeacherAction(ActionEvent event) throws IOException {
		Stage stage=new Stage();
		
		Parent root=FXMLLoader.load(getClass().getResource("AddTeacherDialog.fxml"));
		Scene scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	// Event Listener on Button[#btnViewTeachers].onAction
	
	@FXML
	public void refreshStudentsAction(ActionEvent event) {
		
	}
	
	@FXML
	public void refreshTeachersAction(ActionEvent event) {
		
	}
	
	@FXML
	public void refreshRoomsAction(ActionEvent event) {
		
	}
	
	@FXML
	public void refreshSubjectsAction(ActionEvent event) {
		
	}
	
	@FXML
	public void viewStudentsAction(ActionEvent event) {
		
	}
	
	@FXML
	public void viewTeachersAction(ActionEvent event) {
		
	}
	
	@FXML
	public void viewRoomsAction(ActionEvent event) {
		
	}
	
	@FXML
	public void viewSubjectsAction(ActionEvent event) {
		
	}
	
	@FXML
	public void roomCampusAction(ActionEvent event) {
		
	}
	
	@FXML
	public void roomFloorAction(ActionEvent event) {
		
	}
	
	
	
	public ObservableList<Student> getAllStudents(){
		return Data.getAllStudents();
	}
	
	public ObservableList<Teacher> getAllTeachers(){
		return null;
	}

	public ObservableList<Subject> getAllSubjects(){
		return null;
	}
	
	@FXML
	public void logoutAction(ActionEvent event) {
		
	}
	
	 private void editStudent(String btnName, TableColumn<Student, Void> col) {
		 Callback<TableColumn<Student, Void>, TableCell<Student, Void>> cellFactory=new Callback<TableColumn<Student, Void>, TableCell<Student, Void>>(){
			 @Override 
			 public TableCell<Student, Void> call(final TableColumn<Student, Void> param){
				 final TableCell<Student, Void> cell=new TableCell<Student, Void>(){
				 private final Button btn=new Button(btnName);
				 {
					 btn.setOnAction((ActionEvent event) -> {
						 Student row=getTableView().getItems().get(getIndex());
						 //System.out.println(row.getId());
						 
						 Stage stage=new Stage();
						 							
						 FXMLLoader loader;
						try {
							loader = new FXMLLoader(getClass().getResource("EditStudentDialog.fxml"));
							Parent root=loader.load();
							 EditStudentDialogController editStudentDialogController=loader.getController();
							 editStudentDialogController.loadData(row);
							 //loader.setController(editRoomDialogController);
							 
							 Scene scene=new Scene(root);
							 stage.setScene(scene);
							 stage.show();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					 });
				 }
				 @Override 
				 public void updateItem(Void item, boolean empty) {
					 super.updateItem(item, empty);
					 if(empty) {
						 setGraphic(null);
					 } else {
						 setGraphic(btn);
					 }
				 }
			 };
			 return cell;
		 	}
		 };
		 col.setCellFactory(cellFactory);
		 //tableStudents.getColumns().add(colEdit); //already added in scenebuilder
		 
	 }
	
	 private void deleteStudent(String btnName, TableColumn<Student, Void> col) {
		 Callback<TableColumn<Student, Void>, TableCell<Student, Void>> cellFactory=new Callback<TableColumn<Student, Void>, TableCell<Student, Void>>(){
			 @Override 
			 public TableCell<Student, Void> call(final TableColumn<Student, Void> param){
				 final TableCell<Student, Void> cell=new TableCell<Student, Void>(){
				 private final Button btn=new Button(btnName);
				 {
					 btn.setOnAction((ActionEvent event) -> {
						 Alert alert=new Alert(AlertType.CONFIRMATION);
						 alert.setTitle("Delete Student");
						 alert.setContentText("Are you sure you want to delete the student?");
						 
						 Optional<ButtonType> result=alert.showAndWait();
						 if(result.get()==ButtonType.OK) {
							 System.out.println(getIndex());
							 tableViewStudents.getItems().remove(getIndex());
						 }
					 });
				 }
				 @Override 
				 public void updateItem(Void item, boolean empty) {
					 super.updateItem(item, empty);
					 if(empty) {
						 setGraphic(null);
					 } else {
						 setGraphic(btn);
					 }
				 }
			 };
			 return cell;
		 	}
		 };
		 col.setCellFactory(cellFactory);
		 //tableStudents.getColumns().add(colEdit); //already added in scenebuilder
		 
	 }
	 

	 
	 private void editTeacher(String btnName, TableColumn<Teacher, Void> col) {
		 Callback<TableColumn<Teacher, Void>, TableCell<Teacher, Void>> cellFactory=new Callback<TableColumn<Teacher, Void>, TableCell<Teacher, Void>>(){
			 @Override 
			 public TableCell<Teacher, Void> call(final TableColumn<Teacher, Void> param){
				 final TableCell<Teacher, Void> cell=new TableCell<Teacher, Void>(){
				 private final Button btn=new Button(btnName);
				 {
					 btn.setOnAction((ActionEvent event) -> {
						 Teacher row=getTableView().getItems().get(getIndex());
						 //System.out.println(row.getId());
						 
						 Stage stage=new Stage();
						 							
						 FXMLLoader loader;
						try {
							loader = new FXMLLoader(getClass().getResource("EditTeacherDialog.fxml"));
							Parent root=loader.load();
							 EditTeacherDialogController editTeacherDialogController=loader.getController();
							 editTeacherDialogController.loadData(row);
							 //loader.setController(editRoomDialogController);
							 
							 Scene scene=new Scene(root);
							 stage.setScene(scene);
							 stage.show();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
						 
					 });
				 }
				 @Override 
				 public void updateItem(Void item, boolean empty) {
					 super.updateItem(item, empty);
					 if(empty) {
						 setGraphic(null);
					 } else {
						 setGraphic(btn);
					 }
				 }
			 };
			 return cell;
		 	}
		 };
		 col.setCellFactory(cellFactory);
		 //tableStudents.getColumns().add(colEdit); //already added in scenebuilder
		 
	 }
	 
	 private void deleteTeacher(String btnName, TableColumn<Teacher, Void> col) {
		 Callback<TableColumn<Teacher, Void>, TableCell<Teacher, Void>> cellFactory=new Callback<TableColumn<Teacher, Void>, TableCell<Teacher, Void>>(){
			 @Override 
			 public TableCell<Teacher, Void> call(final TableColumn<Teacher, Void> param){
				 final TableCell<Teacher, Void> cell=new TableCell<Teacher, Void>(){
				 private final Button btn=new Button(btnName);
				 {
					 btn.setOnAction((ActionEvent event) -> {
						 Alert alert=new Alert(AlertType.CONFIRMATION);
						 alert.setTitle("Delete Teacher");
						 alert.setContentText("Are you sure you want to delete the teacher?");
						 
						 Optional<ButtonType> result=alert.showAndWait();
						 if(result.get()==ButtonType.OK) {
							 //System.out.println(getIndex());
							 tableViewTeachers.getItems().remove(getIndex());
						 }
						 
						 
					 });
				 }
				 @Override 
				 public void updateItem(Void item, boolean empty) {
					 super.updateItem(item, empty);
					 if(empty) {
						 setGraphic(null);
					 } else {
						 setGraphic(btn);
					 }
				 }
			 };
			 return cell;
		 	}
		 };
		 col.setCellFactory(cellFactory);
		 //tableStudents.getColumns().add(colEdit); //already added in scenebuilder
		 
	 }
	 
	 private void editSubject(String btnName, TableColumn<Subject, Void> col) {
		 Callback<TableColumn<Subject, Void>, TableCell<Subject, Void>> cellFactory=new Callback<TableColumn<Subject, Void>, TableCell<Subject, Void>>(){
			 @Override 
			 public TableCell<Subject, Void> call(final TableColumn<Subject, Void> param){
				 final TableCell<Subject, Void> cell=new TableCell<Subject, Void>(){
				 private final Button btn=new Button(btnName);
				 {
					 btn.setOnAction((ActionEvent event) -> {
						 Subject row=getTableView().getItems().get(getIndex());
						 //System.out.println(row.getId());
						 
						 Stage stage=new Stage();
						 							
						 FXMLLoader loader;
						try {
							loader = new FXMLLoader(getClass().getResource("EditSubjectDialog.fxml"));
							Parent root=loader.load();
							 EditSubjectDialogController editSubjectDialogController=loader.getController();
							 editSubjectDialogController.loadData(row);
							 //loader.setController(editRoomDialogController);
							 
							 Scene scene=new Scene(root);
							 stage.setScene(scene);
							 stage.show();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
						 
					 });
				 }
				 @Override 
				 public void updateItem(Void item, boolean empty) {
					 super.updateItem(item, empty);
					 if(empty) {
						 setGraphic(null);
					 } else {
						 setGraphic(btn);
					 }
				 }
			 };
			 return cell;
		 	}
		 };
		 col.setCellFactory(cellFactory);
		 //tableStudents.getColumns().add(colEdit); //already added in scenebuilder
		 
	 }
	 
	 private void deleteSubject(String btnName, TableColumn<Subject, Void> col) {
		 Callback<TableColumn<Subject, Void>, TableCell<Subject, Void>> cellFactory=new Callback<TableColumn<Subject, Void>, TableCell<Subject, Void>>(){
			 @Override 
			 public TableCell<Subject, Void> call(final TableColumn<Subject, Void> param){
				 final TableCell<Subject, Void> cell=new TableCell<Subject, Void>(){
				 private final Button btn=new Button(btnName);
				 {
					 btn.setOnAction((ActionEvent event) -> {
						 Alert alert=new Alert(AlertType.CONFIRMATION);
						 alert.setTitle("Delete Subject");
						 alert.setContentText("Are you sure you want to delete the subject?");
						 
						 Optional<ButtonType> result=alert.showAndWait();
						 if(result.get()==ButtonType.OK) {
							 System.out.println(getIndex());
							 //tableViewSubjects.getItems().remove(getIndex());
						 } 
					 });
				 }
				 @Override 
				 public void updateItem(Void item, boolean empty) {
					 super.updateItem(item, empty);
					 if(empty) {
						 setGraphic(null);
					 } else {
						 setGraphic(btn);
					 }
				 }
			 };
			 return cell;
		 	}
		 };
		 col.setCellFactory(cellFactory);
		 //tableStudents.getColumns().add(colEdit); //already added in scenebuilder
		 
	 }
	 
	 
	 private void editRoom(String btnName, TableColumn<Room, Void> col) {
		 Callback<TableColumn<Room, Void>, TableCell<Room, Void>> cellFactory=new Callback<TableColumn<Room, Void>, TableCell<Room, Void>>(){
			 @Override 
			 public TableCell<Room, Void> call(final TableColumn<Room, Void> param){
				 final TableCell<Room, Void> cell=new TableCell<Room, Void>(){
				 private final Button btn=new Button(btnName);
				 {
					 
					 
					 btn.setOnAction((ActionEvent event) -> {
						 Room row=getTableView().getItems().get(getIndex());
						 System.out.println(row.getId());
						 
						 Stage stage=new Stage();
						 							
						 FXMLLoader loader;
						try {
							loader = new FXMLLoader(getClass().getResource("EditRoomDialog.fxml"));
							Parent root=loader.load();
							 EditRoomDialogController editRoomDialogController=loader.getController();
							 editRoomDialogController.loadData(row);
							 //loader.setController(editRoomDialogController);
							 
							 Scene scene=new Scene(root);
							 stage.setScene(scene);
							 stage.show();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
//						 Alert alert=new Alert(AlertType.CONFIRMATION);
//						 alert.setTitle("Edit Room");
//						 alert.setContentText("Are you sure you want to save changes?");
//						 
//						 Optional<ButtonType> result=alert.showAndWait();
//						 if(result.get()==ButtonType.OK) {
//							 System.out.println(getIndex());
//							 //tableStudents.getItems().remove(getIndex());
//						 }
						 
						 
					 });
				 }
				 @Override 
				 public void updateItem(Void item, boolean empty) {
					 super.updateItem(item, empty);
					 if(empty) {
						 setGraphic(null);
					 } else {
						 setGraphic(btn);
					 }
				 }
			 };
			 return cell;
		 	}
		 };
		 col.setCellFactory(cellFactory);
		 //tableStudents.getColumns().add(colEdit); //already added in scenebuilder
		 
	 }
	 
	 private void deleteRoom(String btnName, TableColumn<Room, Void> col) {
		 Callback<TableColumn<Room, Void>, TableCell<Room, Void>> cellFactory=new Callback<TableColumn<Room, Void>, TableCell<Room, Void>>(){
			 @Override 
			 public TableCell<Room, Void> call(final TableColumn<Room, Void> param){
				 final TableCell<Room, Void> cell=new TableCell<Room, Void>(){
				 private final Button btn=new Button(btnName);
				 {
					 btn.setOnAction((ActionEvent event) -> {
						 Alert alert=new Alert(AlertType.CONFIRMATION);
						 alert.setTitle("Delete Room");
						 alert.setContentText("Are you sure you want to delete the room?");
						 
						 Optional<ButtonType> result=alert.showAndWait();
						 if(result.get()==ButtonType.OK) {
							 //System.out.println(getIndex());
							 tableViewRooms.getItems().remove(getIndex());
						 } 
					 });
				 }
				 @Override 
				 public void updateItem(Void item, boolean empty) {
					 super.updateItem(item, empty);
					 if(empty) {
						 setGraphic(null);
					 } else {
						 setGraphic(btn);
					 }
				 }
			 };
			 return cell;
		 	}
		 };
		 col.setCellFactory(cellFactory);
		 //tableStudents.getColumns().add(colEdit); //already added in scenebuilder
		 
	 }
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

				
		colStudentsGrade.setCellValueFactory(new PropertyValueFactory<Student, Integer>("grade"));
		colStudentsNameEnglish.setCellValueFactory(new PropertyValueFactory<Student, String>("nameEnglish"));
		colStudentsNameKorean.setCellValueFactory(new PropertyValueFactory<Student, String>("nameKorean"));
		colStudentsHonors.setCellValueFactory(new PropertyValueFactory<Student, String>("honors"));
		colStudentsDoB.setCellValueFactory(new PropertyValueFactory<Student, String>("doB"));
		colStudentsDorm.setCellValueFactory(new PropertyValueFactory<Student, String>("honors"));
//		colStudentsBlessings.setCellValueFactory(new PropertyValueFactory<Student, Integer>("blessingTotal"));
//		colStudentsTallies.setCellValueFactory(new PropertyValueFactory<Student, Integer>("tallyTotal"));
		colStudentsEnrolled.setCellValueFactory(new PropertyValueFactory<Student, String>("enrollmentDate"));
		colStudentsSubjects.setCellValueFactory(new PropertyValueFactory<Student, String>("subjectList"));
		colStudentsGender.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
		Data.students=Data.getAllStudents();
		tableViewStudents.setItems(Data.students);
			
		colTeachersName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
		colTeachersCampus.setCellValueFactory(new PropertyValueFactory<Teacher, String>("campusName"));
		colTeachersStatus.setCellValueFactory(new PropertyValueFactory<Teacher, String>("status"));
		colTeachersRoom.setCellValueFactory(new PropertyValueFactory<Teacher, String>("roomName"));
		colTeachersEmploymentDate.setCellValueFactory(new PropertyValueFactory<Teacher, String>("startDate"));
		colTeachersSubjects.setCellValueFactory(new PropertyValueFactory<Teacher, String>("subjectList"));
		Data.teachers=Data.getAllTeachers();
		tableViewTeachers.setItems(Data.teachers);
		
		
		colRoomsCampus.setCellValueFactory(new PropertyValueFactory<Room, String>("campusName"));
		colRoomsCapacity.setCellValueFactory(new PropertyValueFactory<Room, Integer>("capacity"));
		colRoomsFloor.setCellValueFactory(new PropertyValueFactory<Room, Integer>("floor"));
		colRoomsRoomName.setCellValueFactory(new PropertyValueFactory<Room, String>("name"));
		Data.rooms=Data.getAllRooms();
		tableViewRooms.setItems(Data.rooms);
		
		colSubjectCampus.setCellValueFactory(new PropertyValueFactory<Subject, String>("campusName"));
		colSubjectCredits.setCellValueFactory(new PropertyValueFactory<Subject, Integer>("credits"));
		colSubjectGrade.setCellValueFactory(new PropertyValueFactory<Subject, String>("gradesList"));
		colSubjectName.setCellValueFactory(new PropertyValueFactory<Subject, String>("name"));
		colSubjectTeacher.setCellValueFactory(new PropertyValueFactory<Subject, String>("teacherName"));
		Data.subjects=Data.getAllSubjects();
		tableViewSubjects.setItems(Data.subjects);
		
		editStudent("Edit", colStudentsEdit);
		deleteStudent("Delete", colStudentsDelete);
		
		editTeacher("Edit", colTeachersEdit);
		deleteTeacher("Delete", colTeachersDelete);
		
		editSubject("Edit", colSubjectsEdit);
		deleteSubject("Delete", colSubjectsDelete);
		
		editRoom("Edit", colRoomsEdit);
		deleteRoom("Delete", colRoomsDelete);
		
		
		
		
		
		
	}
}
