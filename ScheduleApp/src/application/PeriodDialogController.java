package application;

import javafx.fxml.FXML;

import javafx.scene.control.Label;

public class PeriodDialogController {
	@FXML
	private Label labelDay;
	@FXML
	private Label labelPeriod;
	
	public void loadData(int day, int period) {
		labelDay.setText(day+" ");
		labelPeriod.setText(period+" ");
		
	}

}
