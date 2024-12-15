package entities;

import exceptions.PlayInputException;

public class Board {
	
	private char [][] mboard;
	
	public Board() {
		this.mboard = new char[][] {
			{' ', ' ', ' '},
			{' ', ' ', ' '},
			{' ', ' ', ' '}
		};
	}	
	public char getElement(int line,int collum) {
		return mboard[line][collum];
	}
	
	public void setElement(int line,int collumn,char character) {
		mboard[line][collumn]=character;
	}
	
	public boolean isFree(int line,int collumn) {
		return mboard[line][collumn]==' ';
	}

	public void setUserPlay(String play,char character) throws PlayInputException {
		if (play.length()!=2){
			throw new PlayInputException("Invalid Size Coordinates");
		}
		int x = play.charAt(0)-'A';
		int y = play.charAt(1)-'0'-1;
		if ((x <0 || x>=3 || x=='C') && y>0 && y<3){
			throw new PlayInputException("Invalid Coordinates");
		}
		if (isFree(x,y)){
			setElement(x,y,character);
		}
		else {
			throw new PlayInputException("Coordinates already used");
		}
	}
	
	public String showBoard() {
		StringBuilder sb= new StringBuilder();
		for (int i=0;i<mboard.length;i++) {
			if (i==0) {
				sb.append("    1   2   3\n");
			}
			sb.append((char)((int)('A'+i))+"  ");
			for (int j=0;j<mboard[0].length;j++) {
				sb.append(" " + mboard[i][j] + " ");
				if (j<mboard[0].length-1) {
					sb.append("|");
				}
			}
			if (i<mboard.length-1) {
				sb.append("\n");
				sb.append("   ---+---+---");
				sb.append("\n");
			}
		}
	return sb.toString();
	}
	
}
