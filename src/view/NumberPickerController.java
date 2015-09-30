package manns2.main.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NumberPickerController {
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button3;
	@FXML
	private Button button4;
	@FXML
	private Button button5;
	@FXML
	private Button button6;
	@FXML
	private Button button7;
	@FXML
	private Button button8;
	@FXML
	private Button button9;
	
	private Stage dialogStage;
	private int numberSelected;
	
	@FXML
	private void initialize(){
		
	}
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	public int getNumberSelected(){
		return numberSelected;
	}
	@FXML
	public void numberPicked(ActionEvent e){
		Button b = (Button) e.getSource();
		numberSelected = Integer.parseInt(b.getText());
		dialogStage.close();
	}
}
