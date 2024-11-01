package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class AttendanceController implements Initializable {
	
	@FXML
    private AnchorPane anchorPane;
	
	@FXML
    private AnchorPane anchor;
	
	@FXML
    private ScrollPane scrollPane;
	
	@FXML
    private ToggleGroup group1;

	@FXML
    private RadioButton radioAbsent;

    @FXML
    private RadioButton radioLate;

    @FXML
    private RadioButton radioOnline;

    @FXML
    private RadioButton radioPresent;
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnPeriod1;

    @FXML
    private Button btnPeriod2;

    @FXML
    private Button btnPeriod3;

    @FXML
    private Button btnPeriod4;

    @FXML
    private Button btnPeriod5;

    @FXML
    private Button btnPeriod6;

    @FXML
    private Button btnPeriod7;

    @FXML
    private Button btnPeriod8;
    
    @FXML
    private ComboBox<Integer> comboGrade;
    @FXML
    private ComboBox<String> comboClass;
    
    @FXML
    private ToggleGroup search;
    
    @FXML
    private RadioButton radioClass;

    @FXML
    private RadioButton radioGrade;
    
    private int grade;
    private int period;
    private int year;
    private int month;
    private int day;
    
    private ObservableList<RadioButton> buttons=FXCollections.observableArrayList();
    
    private String[] labels= {"Present", "Late", "Online", "Absent"};
    private String[] students= {"bob", "tony", "mary", "luke", "jeff", "peter", "judah", "jeremiah", "bob", "tony", "mary", "luke", "jeff", "peter", "judah", "jeremiah", "tony", "mary", "luke", "jeff", "peter", "judah", "jeremiah"};
    private ArrayList<ToggleGroup> groups=new ArrayList<ToggleGroup>();

    private String teacher;
    
    void getData(String username) {
    	teacher=username;
    	System.out.println("entered attendence: "+username);
    }
    @FXML
    void absentAction(ActionEvent event) {
    	if(radioAbsent.isSelected()) {
    		for(int i=3;i<buttons.size();i=i+4) {
    			buttons.get(i).setSelected(true);
    		}
    	}
    }

    @FXML
    void lateAction(ActionEvent event) {
    	if(radioLate.isSelected()) {
    		for(int i=2;i<buttons.size();i=i+4) {
    			buttons.get(i).setSelected(true);
    		}
    	}
    }

    @FXML
    void onlineAction(ActionEvent event) {
    	if(radioOnline.isSelected()) {
    		for(int i=1;i<buttons.size();i=i+4) {
    			buttons.get(i).setSelected(true);
    		}
    	}
    }

    @FXML
    void presentAction(ActionEvent event) {
    	
    	if(radioPresent.isSelected()) {
    		for(int i=0;i<buttons.size();i=i+4) {
    			buttons.get(i).setSelected(true);
    		}
    	}

    }
    
    @FXML
    void submitAction(ActionEvent event) {
    	
    	for(int i=0;i<students.length;i++) {
    		for(int j=i*4;j<4*(i+1);j++) {
    			if(buttons.get(j).isSelected()) {
    				
    				System.out.println(students[i]+" "+buttons.get(j).getText());
        			
        		}
    		}
    		
    	}
    	

    }
    
    @FXML
    void period1Action(ActionEvent event) {
    	
    	btnPeriod1.setStyle("-fx-background-color: blue");
    	btnPeriod1.setTextFill(Color.color(1, 1, 1));
    	btnPeriod2.setStyle("-fx-background-color: grey");
    	btnPeriod3.setStyle("-fx-background-color: grey");
    	btnPeriod4.setStyle("-fx-background-color: grey");
    	btnPeriod5.setStyle("-fx-background-color: grey");
    	btnPeriod6.setStyle("-fx-background-color: grey");
    	btnPeriod7.setStyle("-fx-background-color: grey");
    	btnPeriod8.setStyle("-fx-background-color: grey");
    	loadPeriod(6, teacher);

    }

    @FXML
    void period2Action(ActionEvent event) {
    	btnPeriod1.setStyle("-fx-background-color: grey");
    	btnPeriod2.setStyle("-fx-background-color: blue");
    	btnPeriod2.setTextFill(Color.color(1, 1, 1));
    	btnPeriod3.setStyle("-fx-background-color: grey");
    	btnPeriod4.setStyle("-fx-background-color: grey");
    	btnPeriod5.setStyle("-fx-background-color: grey");
    	btnPeriod6.setStyle("-fx-background-color: grey");
    	btnPeriod7.setStyle("-fx-background-color: grey");
    	btnPeriod8.setStyle("-fx-background-color: grey");
    }

    @FXML
    void period3Action(ActionEvent event) {
    	btnPeriod1.setStyle("-fx-background-color: grey");
    	btnPeriod2.setStyle("-fx-background-color: grey");
    	btnPeriod3.setStyle("-fx-background-color: blue");
    	btnPeriod3.setTextFill(Color.color(1, 1, 1));
    	btnPeriod4.setStyle("-fx-background-color: grey");
    	btnPeriod5.setStyle("-fx-background-color: grey");
    	btnPeriod6.setStyle("-fx-background-color: grey");
    	btnPeriod7.setStyle("-fx-background-color: grey");
    	btnPeriod8.setStyle("-fx-background-color: grey");

    }

    @FXML
    void period4Action(ActionEvent event) {
    	btnPeriod1.setStyle("-fx-background-color: grey");
    	btnPeriod2.setStyle("-fx-background-color: grey");
    	btnPeriod3.setStyle("-fx-background-color: grey");
    	btnPeriod4.setStyle("-fx-background-color: blue");
    	btnPeriod4.setTextFill(Color.color(1, 1, 1));
    	btnPeriod5.setStyle("-fx-background-color: grey");
    	btnPeriod6.setStyle("-fx-background-color: grey");
    	btnPeriod7.setStyle("-fx-background-color: grey");
    	btnPeriod8.setStyle("-fx-background-color: grey");
    	

    }

    @FXML
    void period5Action(ActionEvent event) {
    	btnPeriod1.setStyle("-fx-background-color: grey");
    	btnPeriod2.setStyle("-fx-background-color: grey");
    	btnPeriod3.setStyle("-fx-background-color: grey");
    	btnPeriod4.setStyle("-fx-background-color: grey");
    	btnPeriod5.setStyle("-fx-background-color: blue");
    	btnPeriod5.setTextFill(Color.color(1, 1, 1));
    	btnPeriod6.setStyle("-fx-background-color: grey");
    	btnPeriod7.setStyle("-fx-background-color: grey");
    	btnPeriod8.setStyle("-fx-background-color: grey");

    }

    @FXML
    void period6Action(ActionEvent event) {
    	btnPeriod1.setStyle("-fx-background-color: grey");
    	btnPeriod2.setStyle("-fx-background-color: grey");	
    	btnPeriod3.setStyle("-fx-background-color: grey");
    	btnPeriod4.setStyle("-fx-background-color: grey");
    	btnPeriod5.setStyle("-fx-background-color: grey");
    	btnPeriod6.setStyle("-fx-background-color: blue");
    	btnPeriod6.setTextFill(Color.color(1, 1, 1));
    	btnPeriod7.setStyle("-fx-background-color: grey");
    	btnPeriod8.setStyle("-fx-background-color: grey");

    }

    @FXML
    void period7Action(ActionEvent event) {
    	btnPeriod1.setStyle("-fx-background-color: grey");
    	btnPeriod2.setStyle("-fx-background-color: grey");
    	btnPeriod3.setStyle("-fx-background-color: grey");
    	btnPeriod4.setStyle("-fx-background-color: grey");
    	btnPeriod5.setStyle("-fx-background-color: grey");
    	btnPeriod6.setStyle("-fx-background-color: grey");
    	btnPeriod7.setStyle("-fx-background-color: blue");
    	btnPeriod7.setTextFill(Color.color(1, 1, 1));
    	btnPeriod8.setStyle("-fx-background-color: grey");

    }

    @FXML
    void period8Action(ActionEvent event) {
    	btnPeriod1.setStyle("-fx-background-color: grey");
    	btnPeriod2.setStyle("-fx-background-color: grey");
    	
    	btnPeriod3.setStyle("-fx-background-color: grey");
    	btnPeriod4.setStyle("-fx-background-color: grey");
    	btnPeriod5.setStyle("-fx-background-color: grey");
    	btnPeriod6.setStyle("-fx-background-color: grey");
    	btnPeriod7.setStyle("-fx-background-color: grey");
    	btnPeriod8.setStyle("-fx-background-color: blue");
    	btnPeriod8.setTextFill(Color.color(1, 1, 1));

    }
    
    @FXML
    void radioClassAction(ActionEvent event) {
    	
    	comboGrade.setDisable(true);
    	comboClass.setDisable(false);
    	comboClass.getItems().addAll("Math1", "Math11", "English11", "Bible12");
    }

    @FXML
    void radioGradeAction(ActionEvent event) {
    	comboClass.setDisable(true);
    	comboGrade.setDisable(false);
    }
    
    @FXML
    void gradeAction(ActionEvent event) {

    }
    
    @FXML
    void comboClassAction(ActionEvent event) {
    	comboClass.setDisable(false);
    	comboGrade.setDisable(true);
    	
    	
    }
    //get students in a period of a teacher.
    public static void loadPeriod(int period, String teacher) {
    	
    	ArrayList<Student> students=new ArrayList<Student>();
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String studentlist="SELECT * from `students` WHERE grade='"+10+"'"; 
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				ResultSet rs=statement.executeQuery(studentlist);
				while(rs.next()) {
					students.add(new Student(rs.getInt("grade"),rs.getString("name")));
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
    	
    	
    }
    
  //get students in a period of a teacher.
    public static void loadSubject(String subject) {
    	
    	ArrayList<Student> students=new ArrayList<Student>();
		
		DatabaseConnection connectNow=new DatabaseConnection();
		  Connection connectDB;
		  Statement statement;
			try {
				String studentlist="SELECT * from `students` WHERE grade='"+12+"'"; 
				connectDB=connectNow.getConnection("kics");
				statement=connectDB.createStatement();
				ResultSet rs=statement.executeQuery(studentlist);
				while(rs.next()) {
					students.add(new Student(rs.getInt("grade"),rs.getString("name")));
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
    	
    	
    }


   
    
    @FXML
    void dateAction(ActionEvent event) {

    	System.out.println(datePicker.getValue().getYear());
    	System.out.println(datePicker.getValue().getMonth());
    	System.out.println(datePicker.getValue().getDayOfYear());
    }
    
    void periodChooser() {
    	
    	int hour=LocalTime.now().getHour();
    	
    	switch(hour) {
    	case 9:
    		btnPeriod1.fire();
    		break;
    	case 10:
    		btnPeriod2.fire();
    		break;
    	case 11:
    		btnPeriod3.fire();
    		break;
    	case 12:
    		btnPeriod4.fire();
    		break;
    	case 13:
    		btnPeriod4.fire();
    		break;
    	case 14:
    		btnPeriod5.fire();
    		break;
    	case 15:
    		btnPeriod6.fire();
    		break;
    	case 16:
    		btnPeriod7.fire();
    		break;
    	case 17:
    		btnPeriod8.fire();
    		break;
    	default:
    		btnPeriod1.fire();
    		break;	
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		periodChooser();
		comboClass.setDisable(true);
		comboGrade.getItems().addAll(12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		datePicker.setValue(LocalDate.now());
		
    	for(int i=0;i<students.length;i++) {
    		ToggleGroup newGroup=new ToggleGroup();
    		groups.add(newGroup);
    	}
    	
    	int shift=100;
		
		for(int j=0;j<students.length;j++) {
			for(int i=0;i<labels.length;i++) {
				RadioButton b=new RadioButton(labels[i]);
				Label nameLabel=new Label(students[j]);
				nameLabel.setText(students[j]);
				nameLabel.setPrefWidth(shift);
				nameLabel.setLayoutY(j*25+5);
				
				b.setLayoutX(i*100+shift);
				b.setLayoutY(j*25+5);
				b.setPrefWidth(80);
				b.setToggleGroup(groups.get(j));
				if(i==3)
					b.setSelected(true);
				anchor.getChildren().add(b);
				anchor.getChildren().add(nameLabel);
				buttons.add(b);
				
			}
		}
		
		
	}



}
