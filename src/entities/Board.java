package entities;

import exceptions.PlayInputException;

public class Board {
	
	private Object [][] mboard;
	
	public Board() {
		this.mboard = new Object [][] {
			{" "," "," "},
			{" "," "," "},
			{" "," "," "},
			};
	}
	
	public void setPlay(String play,char character) throws PlayInputException {
		if (play.length()!=2){
			throw new PlayInputException("Invalid Size Coordinates");
		}
		int x = play.charAt(0)-'A';
		int y = play.charAt(1)-'0'-1;
		if (x != 'A' || x!='B' || x!='C' || y>2){
			throw new PlayInputException("Invalid Coordinates");
		}
		if (mboard[x][y]==" ") {
			mboard[x][y]=character;
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
