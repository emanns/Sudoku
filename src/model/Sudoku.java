package manns2.main.model;

import java.util.ArrayList;

public class Sudoku {
	private SudokuBox[] board = {
			new SudokuBox(this), new SudokuBox(this), new SudokuBox(this),
			new SudokuBox(this), new SudokuBox(this), new SudokuBox(this),
			new SudokuBox(this), new SudokuBox(this), new SudokuBox(this)};
	
	public Sudoku(){}
	
	public Sudoku(SudokuBox[] board){
		this.board = board;
	}
	
	
	public void clear(){
		for(int i = 0; i < board.length; i++)
			board[i].clear();
		System.out.println("Board cleared");
	}
	
	public ArrayList<Integer> getRow(SudokuTile tile){
		ArrayList<Integer> rowContents = new ArrayList<Integer>();
		int boxIndex = getBoxX(tile);
		for(int i = 0; i < 3; i++){
			rowContents.add(board[boxIndex].getContents()[i].getValue());
			rowContents.add(board[boxIndex +1].getContents()[i].getValue());
			rowContents.add(board[boxIndex +2].getContents()[i].getValue());
		}
		return rowContents;
	}
	
	private int getBoxX(SudokuTile tile) {
		int boxIndex = -1;
		for(int i = 0; i < board.length; i++){
			if(tile.getBox() == board[i]){
				if(i>=0 && i <= 2)
					boxIndex = 0;
				else if(i >= 3 && i <= 5)
					boxIndex = 3;
				else boxIndex = 6;
			}
		}
		return boxIndex;
	}

	public ArrayList<Integer> getCol(SudokuTile tile){
		ArrayList<Integer> colContents = new ArrayList<Integer>();
		int boxIndex = getBoxY(tile);
		for(int i = 0; i < 3; i++){
			colContents.add(board[boxIndex].getContents()[i].getValue());
		}
		return colContents;
	}
	
	private int getBoxY(SudokuTile tile) {
		int boxIndex = -1;
		for(int i = 0; i < board.length; i++){
			if(tile.getBox() == board[i]){
				if(i == 0 || i == 3 || i == 6)
					boxIndex = 0;
				else if(i == 1 || i == 4 || i == 7)
					boxIndex = 1;
				else boxIndex = 2;
			}
		}
		return boxIndex;
	}

	public ArrayList<Integer> getBox(SudokuTile tile){
		ArrayList<Integer> boxContents = new ArrayList<Integer>();
		for(int i = 0; i < board.length; i++){
			if(board[i] == tile.getBox()){
				for(SudokuTile t : board[i].getContents())
					boxContents.add(t.getValue());
			}
		}
		return boxContents;
	}
	public ArrayList<Integer> getPeers(SudokuTile tile){
		ArrayList<Integer> peers = new ArrayList<Integer>();
		peers.addAll(getCol(tile));
		peers.addAll(getRow(tile));
		peers.addAll(getBox(tile));
		return peers;
	}
	public void solve(){
		for(SudokuBox s : board){
			for(SudokuTile t : s.getContents()){
				ArrayList<Integer> replacements = t.getPossibleSolutions();
				if(replacements.size() == 1)
					t.setValue(replacements.get(0));
					}
				}
			}
		

	public SudokuBox find(SudokuBox box) {
		for(int i = 0; i < board.length; i++){
			if(board[i] == box)
				return board[i];
		}
		return null;
	}

	public SudokuBox get(int index) {
		return board[index];
	}
}
