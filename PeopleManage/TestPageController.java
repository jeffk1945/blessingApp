package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;

import java.net.URL;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ListView;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;

import javafx.scene.control.DatePicker;

import javafx.scene.control.ChoiceBox;

public class TestPageController implements Initializable {
	@FXML
	private DatePicker datePicker;
	@FXML
	private CheckBox checkBox;
	@FXML
	private ColorPicker colorPicker;
	@FXML
	private ChoiceBox cbChoice;
	@FXML
	private ComboBox cbCombo;
	@FXML
	private RadioButton radioMale;
	@FXML
	private RadioButton radioFemale;
	@FXML
	private ListView lvListView;
	
	@FXML
    private ToggleGroup gender;
	
	@FXML
    private ToggleButton toggleHonors;
	@FXML
	private Label label;
	
	@FXML
    private Button btnReason;
	
	@FXML
    private Button btnAdd;
	
	@FXML
    private Button btnDelete;
	
	@FXML
    private TextArea taReason;
	
	@FXML
    private TableColumn<Student, Integer> colGrade;

    @FXML
    private TableColumn<Student, String> colName;
    
    @FXML
    private TableColumn<Student, Void> colEdit;
    
    @FXML
    private TableColumn<Student, Void> colDelete;
    
    @FXML
    private TableView<Student> tableStudents;
    
    private boolean loaded=false;
    
    ArrayList<Student> students=new ArrayList<Student>();

	// Event Listener on DatePicker[#datePicker].onAction
	@FXML
	public void dateAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on CheckBox[#checkBox].onAction
	@FXML
	public void checkBoxAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on ColorPicker[#colorPicker].onAction
	@FXML
	public void colorAction(ActionEvent event) {
		System.out.println(colorPicker.getValue());
	}
	// Event Listener on ChoiceBox[#cbChoice].onDragDetected
	@FXML
	public void choiceAction(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on ComboBox[#cbCombo].onAction
	@FXML
	public void comboAction(ActionEvent event) {
		// TODO Autogenerated
	}
	
	@FXML
    void btnReasonAction(ActionEvent event) {
		System.out.println(taReason.getText());
    }
	
	@FXML
    void reasonAction(MouseEvent event) {
		
    }
	@FXML
    public void genderAction(ActionEvent event) {
		String gen = radioMale.isSelected() ? "Male" : "Female";
		System.out.println(gen);
    }
	
	@FXML
    public void toggleHonorsAction(ActionEvent event) {
		if(toggleHonors.isSelected())
			System.out.println("Honors");
		else
			System.out.println("Regular");
    }
	
	 @FXML
	 void addAction(ActionEvent event) {
		 students.add(new Student(10, "tony"));
		 tableStudents.setItems(FXCollections.observableArrayList(students));
	 }
	 
	 @FXML
	 void deleteAction(ActionEvent event) {
		 TableView.TableViewSelectionModel<Student> selectionModel= tableStudents.getSelectionModel();
		 if(selectionModel.isEmpty()) {
			 System.out.println("choose");
		 }
		 
		 ObservableList<Integer> list=selectionModel.getSelectedIndices();
		 Integer[] selectedIndices=new Integer[list.size()];
		 selectedIndices=list.toArray(selectedIndices);
		 
		 Arrays.sort(selectedIndices);
		 for(int i=selectedIndices.length-1;i>=0;i--) {
			 selectionModel.clearSelection(selectedIndices[i].intValue());
			 tableStudents.getItems().remove(selectedIndices[i].intValue());
		 }
	 }
	 
	 final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
	     public DateCell call(final DatePicker datePicker) {
	         return new DateCell() {
	             @Override public void updateItem(LocalDate item, boolean empty) {
	                 super.updateItem(item, empty);

	                 if (MonthDay.from(item).equals(MonthDay.of(9, 25))) {
	                     //setTooltip(new Tooltip("Happy Birthday!"));
	                     setStyle("-fx-background-color: #ff4444;");
	                 }
	                 if (item.equals(LocalDate.now().plusDays(1))) {
	                     // Tomorrow is too soon.
	                     setDisable(true);
	                 }
	             }
	         };
	     }
	 };
	
	 private void addbuttonToTable(String btnName, TableColumn<Student, Void> col) {
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
							 tableStudents.getItems().remove(getIndex());
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

	ObservableList<Student> loadStudents(){
		
		students.add(new Student(11, "john"));
		students.add(new Student(12, "bob"));
		return FXCollections.observableArrayList(students);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		LocalDate date=LocalDate.of(2024,02,11);
		datePicker.setValue(date);
		System.out.println(LocalDate.now());
		colName.setCellValueFactory(new PropertyValueFactory<Student, String>("nameEnglish"));
		colGrade.setCellValueFactory(new PropertyValueFactory<Student, Integer>("grade"));
		tableStudents.setItems(loadStudents());
		
//		colName.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
//		colName.setOnEditCommit(event -> {
//			Student student=event.getTableView().getItems().get(event.getTablePosition().getRow());
//			student.setNameEnglish(event.getNewValue());
//		});
		
		addbuttonToTable("Edit", colEdit);
		addbuttonToTable("Delete", colDelete);
		
			
		
	}
}
