package manns2.main.view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import manns2.main.model.SudokuBox;
import manns2.main.model.SudokuTile;

public class BoxController {
	private GridPane box;
	private TextArea[] tiles;
	private BoardController controller;
	private SudokuBox sBox;
	
	public BoxController(BoardController master, GridPane box){
		controller = master;
		this.box = box;
		tiles = new TextArea[9];
	}
	public void initialize(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				box.add(tiles[i], i, j);
			}
		}
	}
	public void update(){
		SudokuTile[] thisBox = getBoard().getMainApp().getSudokuBoard().find(sBox).getContents();
		for(int i = 0; i < tiles.length; i++){
			if(thisBox[i].getValue() > 0 && thisBox[i].getValue() <= 9)
				tiles[i].setText(thisBox[i].toString());
			else tiles[i].clear();
		}
	}

	private BoardController getBoard() {
		return controller;
	}
}
