package application;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MonthController implements Initializable {
	@FXML
	private GridPane month;
	String[] days= {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	
	
	public int startMonth(DayOfWeek dayOfWeek) {
		
		switch(dayOfWeek) {
		case SUNDAY:
			return 0;
		case MONDAY:
			return 1;
		case TUESDAY:
			return 2;
		case WEDNESDAY:
			return 3;
		case THURSDAY:
			return 4;
		case FRIDAY:
			return 5;
		case SATURDAY:
			return 6;
		default:
			return -1;
			
		}
		
		
	}
	public void generateMonth(int y, int m) {
		
		int firstday=startMonth(LocalDate.of(y, m, 1).getDayOfWeek());
		int daysinMonth=LocalDate.of(y, m, 1).lengthOfMonth();
		
		
		
		for(int j=0;j<7;j++) {
			month.add(new Label(days[j]), j, 0);
		}
		
		int days=1;
		int rows=6;
		for(int j=1;j<rows;j++) {
		
			for(int i=0;i<7;i++) {
			
				if(days<=daysinMonth) {
					if(j==1) {
						if(i==0) {
							i=i+firstday;
							month.add(new Label(String.valueOf(days)), i, j);
							days++;
							Pane pane=new Pane();
							pane.setStyle("-fx-background-color: #FF5733");
							month.add(pane, j, i);
						} else {
							month.add(new Label(String.valueOf(days)), i, j);
							days++;
						}

					} else {
						month.add(new Label(String.valueOf(days)), i, j);
						days++;
					}
						
				}
				if(days<=daysinMonth && j==rows-1) {
					month.addRow(1);
					rows++;
				}
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		generateMonth(2024, 3);
		
	}
	
	
	

}
