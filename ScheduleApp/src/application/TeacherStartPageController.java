package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TeacherStartPageController {
	
	@FXML
	private Button btnLogout;
	
	private Stage stage;
	private Scene scene;
	
	@FXML
    private Button btnBack;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private TextField tfUsername;

    @FXML
    void LoginAction(ActionEvent event) throws IOException {
    	System.out.println("logout");
		Parent root=FXMLLoader.load(getClass().getResource("Teachers.fxml"));
		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
    	System.out.println("logout");
		Parent root=FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
		stage=(Stage) ((Node) (event.getSource())).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void passwordAction(ActionEvent event) {

    }

    @FXML
    void usernameAction(ActionEvent event) {

    }


}
