package manns2.main.view;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import manns2.main.MainApp;
import manns2.main.model.SudokuTile;

public class BoardController {
	@FXML
	private GridPane sBoard;
	@FXML
	private TextArea tile;
	// private BoxController[][] boxes = {
	// { new BoxController(this, new GridPane()),
	// new BoxController(this, new GridPane()),
	// new BoxController(this, new GridPane()), },
	// { new BoxController(this, new GridPane()),
	// new BoxController(this, new GridPane()),
	// new BoxController(this, new GridPane()), },
	// { new BoxController(this, new GridPane()),
	// new BoxController(this, new GridPane()),
	// new BoxController(this, new GridPane()), } };
	private MainApp controller;

	public BoardController() {
		// for (int i = 0; i < boxes.length; i++) {
		// for (int j = 0; j < boxes.length; j++) {
		// boxes[i][j].initialize();
		// }
		// }
	}

	public void setMainApp(MainApp main) {
		controller = main;
	}

	public MainApp getMainApp() {
		return controller;
	}
	

	@FXML
	public void selectNumber(MouseEvent e) {
		tile = (TextArea) e.getSource();
		int number = controller.showNumberPickerDialog();
		if (number > 0 && number < 10){
			tile.setText(String.valueOf(number));
			update(tile, number);
		}
	}
	
	public void refresh(){
		ObservableList<Node> boardContents = sBoard.getChildren();
		for(int i = 0; i < 9; i++){
			GridPane g = (GridPane) boardContents.get(i);
			ObservableList<Node> boxContents = g.getChildren();
			for(int j = 0; j < 9; j++){
				TextArea tile = (TextArea) boxContents.get(j);
				int value = controller.getSudokuBoard().get(getBoxIndex(tile)).get(getTileIndexInBox(tile)).getValue();
				if(value == 0)
					tile.clear();
				else if(value >= 1 && value <= 9)
					tile.setText(String.valueOf(value));
			}
		}
	}

	private void update(TextArea tile, int value) {
		controller.getSudokuBoard().get(getBoxIndex(tile)).get(getTileIndexInBox(tile)).setValue(value);
	}
	
	private int getBoxIndex(TextArea tile){
		ObservableList<Node> contents = sBoard.getChildren();
		for(Node b : contents){
			GridPane g = (GridPane) b;
			if(g.getChildren().contains(tile))
				return contents.indexOf(b);
		}
		return -1;
	}
	
	private int getTileIndexInBox(TextArea tile){
		ObservableList<Node> contents = sBoard.getChildren();
		int boxIndex = getBoxIndex(tile);
		GridPane box = (GridPane)contents.get(boxIndex);
		return box.getChildren().indexOf(tile);
	}
}
