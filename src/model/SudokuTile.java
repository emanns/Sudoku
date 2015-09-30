package manns2.main.model;

import java.util.ArrayList;

public class SudokuTile {
	private int value;
	private SudokuBox box;
	
	public SudokuTile(SudokuBox container){
		box = container;
		value = 0;
	}
	public SudokuTile(int value, SudokuBox container){
		this.value = value;
		box = container;
	}
	public int getValue() {
		return value;
	}
	public int getY(){
		for(int i = 0; i < box.getContents().length; i++){
			if(box.getContents()[i].getValue() == value){
				if(i == 0 || i == 3 || i == 6)
					return 0;
				else if(i == 1 || i == 4 || i == 7)
					return 1;
				else return 2;
			}
		}
		return -1;
	}
	
	public int getX(){
		for(int i = 0; i < box.getContents().length; i++){
			if(box.getContents()[i].getValue() == value){
				if(i >=0 && i <=2)
					return 0;
				else if(i >= 3 && i <= 5)
					return 3;
				else return 6;
			}
				
		}
		return -1;
	}
	public SudokuBox getBox() {
		return box;
	}
	public void setValue(int number) {
		value = number;
	}

	public ArrayList<Integer> getPossibleSolutions() {
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		for(int i = 1; i < 10; i++)
			solutions.add(i);
		for(Integer value : solutions){
			if(getBox().getBoard().getPeers(this).contains(value))
				solutions.remove(value);
		}
		return solutions;
	}
	
	public String toString(){
		return "" + value;
	}

	
}
