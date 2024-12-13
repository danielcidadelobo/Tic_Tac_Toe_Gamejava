package entities;

import java.util.Random;

public class BotPlayer {

	public void setBotPlay(Board board,char character) {
		Random rand=new Random();
		int randomLine = rand.nextInt(3);
		int randomCollumn = rand.nextInt(3);
		
		while (!board.isFree(randomLine,randomCollumn)) {
			randomLine = rand.nextInt(3);
			randomCollumn = rand.nextInt(3);
		}
		board.setElement(randomLine,randomCollumn,character);
	}
}
