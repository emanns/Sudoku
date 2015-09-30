package manns2.main.model;

public class SudokuBox {
	private SudokuTile[] box = {
			new SudokuTile(this),new SudokuTile(this),new SudokuTile(this),
			new SudokuTile(this),new SudokuTile(this),new SudokuTile(this),
			new SudokuTile(this),new SudokuTile(this),new SudokuTile(this)};
	private Sudoku board;

	public SudokuBox(Sudoku master){
		for(int i = 0; i < box.length; i++){
				box[i].setValue(0);
			}
		board = master;
	}
	
	public SudokuBox(SudokuTile[] tiles, Sudoku master){
		for(int i = 0; i < box.length; i++){
			box[i].setValue(tiles[i].getValue());
		}
		board = master;
	}
	public SudokuTile[] getContents() {
		return box;
	}
	
	public Sudoku getBoard(){
		return board;
	}
	public void clear(){
		for(int i = 0; i < box.length; i++){
			box[i].setValue(0);
			System.out.println("Clearing...");
		}
	}

	public boolean contains(Integer value) {
		for(int i = 0; i < box.length; i++){
			if(box[i].getValue() == value)
				return true;
		}
		return false;
	}

	public SudokuTile get(int index) {
		return box[index];
	}
}
