package manns2.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manns2.main.model.Sudoku;
import manns2.main.view.BoardController;
import manns2.main.view.NumberPickerController;

public class MainApp extends Application{
	private Stage primaryStage;
	
	@FXML
	private BorderPane rootLayout;
	private Sudoku board = new Sudoku();
	private AnchorPane gBoard;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Sudoku");
		initRootLayout();
		
		showBoard();
	}

	public void initRootLayout() {
		try{
			// Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void showBoard() {
		try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Board.fxml"));
            gBoard = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(gBoard);
            
            BoardController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}
	
	public Stage getPrimaryStage(){
		return primaryStage;
	}
	
	public Sudoku getSudokuBoard() {
		return board;
	}
	
	public static void main(String[] args){
		launch(args);
	}

	@FXML
	public void clear(){
		board.clear();
		updateBoard();
	}
	
	@FXML
	public void solve(){
		board.solve();
	}
	
	private void updateBoard(){
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/Board.fxml"));
        try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        BoardController controller = loader.getController();
        controller.setMainApp(this);
		controller.refresh();
	}

	public int showNumberPickerDialog() {
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/NumberPicker.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Select Number");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        NumberPickerController controller = loader.getController();
	        controller.setDialogStage(dialogStage);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.getNumberSelected();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return -1;
	    }		
	}

}
