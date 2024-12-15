package entities;

import java.util.Random;

public class BotPlayer {

	public void setBotPlay(Board board,char userCharacter,char botCharacter) {
		int [] Userposition =canWinLoose(board,userCharacter);
		int [] Botposition =canWinLoose(board,botCharacter);
		int line;
		int collumn;
		if (Userposition!=null){
			line = Userposition[0];
			collumn = Userposition[1];
		}
		else if (Botposition!=null){
			line = Botposition[0];
			collumn = Botposition[1];
		}
		else{
			Random rand=new Random();
			line = rand.nextInt(3);
			collumn = rand.nextInt(3);
			while (!board.isFree(line,collumn)) {
				line = rand.nextInt(3);
				collumn = rand.nextInt(3);
			}
		}
		board.setElement(line,collumn,botCharacter);
	}

	public int[] canWinLoose(Board board,char character){
		for (int i = 0; i < 3; i++) {
			int counter = 0;
			int emptySpot = -1;
			for (int j = 0; j < 3; j++) {
				if (character == board.getElement(i, j)) {
					counter++;
				} else if (board.isFree(i, j)) {
					emptySpot = j;
				}
			}
			if (counter == 2 && emptySpot != -1) {
				return new int[]{i, emptySpot};
			}
		}
		for (int j = 0; j < 3; j++) {
			int counter = 0;
			int emptySpot = -1;
			for (int i = 0; i < 3; i++) {
				if (character == board.getElement(i, j)) {
					counter++;
				} else if (board.isFree(i, j)) {
					emptySpot = i;
				}
			}
			if (counter == 2 && emptySpot != -1) {
				return new int[]{emptySpot, j};
			}
		}
		int counter = 0;
		int[] emptySpot = null;
		for (int i = 0; i < 3; i++) {
			if (character == board.getElement(i, i)) {
				counter++;
			} else if (board.isFree(i, i)) {
				emptySpot = new int[]{i, i};
			}
		}
		if (counter == 2 && emptySpot != null) {
			return emptySpot;
		}
		counter = 0;
		emptySpot = null;
		for (int i = 0; i < 3; i++) {
			if (character == board.getElement(i, 2 - i)) {
				counter++;
			} else if (board.isFree(i, 2 - i)) {
				emptySpot = new int[]{i, 2 - i};
			}
		}
		if (counter == 2 && emptySpot != null) {
			return emptySpot;
		}
		return null;
		}
}
