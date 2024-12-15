package application;

import java.util.Scanner;

import entities.Game;
import entities.Board;
import entities.BotPlayer;
import exceptions.PlayInputException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean end=false;
		
		System.out.println("Tic Tac Toe Game!");
		System.out.println("");
		System.out.print("Select your character(0 or X): ");
		char userChar=sc.next().charAt(0);
		while (userChar!='0' && userChar!='X') {
			System.out.print("Try Again: ");
			userChar=sc.next().charAt(0);
		}
		int selectPlayer=1;
		char botCharacter='X';
		
		if (userChar == 'X'){
			selectPlayer = 0;
			botCharacter='0';
		}

		char winner='f';

		
		Board board=new Board();
		Game game=new Game();
		BotPlayer player= new BotPlayer();
		
		System.out.println();
		System.out.println(board.showBoard());
		System.out.println();
		try {
			while (end==false) {
				if (selectPlayer==0) {
					System.out.print("Coordinate: ");
					sc.nextLine();
					String play= sc.nextLine();
					board.setUserPlay(play,userChar);
					System.out.println(board.showBoard());
					selectPlayer=1;
				}
				else if (selectPlayer==1) {
					player.setBotPlay(board,userChar,botCharacter);
					System.out.println(board.showBoard());
					selectPlayer=0;
				}
				char endResult = game.end(board);
				
				if (endResult != 'C' && endResult!=' ') {
					end = true; 
					winner = endResult; 
				}
				System.out.println();		
			}
			System.out.println();
			if (winner==userChar){
				System.out.println("You Won!");
			}
			else if (winner==botCharacter){
				System.out.println("You lost!");
			}
			else {
				System.out.println("Tie!");
			}
		}	
			
		catch (PlayInputException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
