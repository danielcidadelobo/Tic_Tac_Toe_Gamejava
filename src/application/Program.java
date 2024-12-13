package application;

import java.util.Scanner;

import entities.Game;
import entities.Board;
import entities.BotPlayer;
import exceptions.PlayInputException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean win=false;
		
		System.out.println("Tic Tac Toe Game!");
		System.out.println("");
		System.out.print("Select your character(0 or X): ");
		char userChar=sc.next().charAt(0);
		while (userChar!='0' && userChar!='X') {
			System.out.print("Try Again: ");
			userChar=sc.next().charAt(0);
		}
		char character=userChar;
		char winner='f';
		
		Board board=new Board();
		Game game=new Game();
		BotPlayer player= new BotPlayer();
		
		System.out.println();
		System.out.println(board.showBoard());
		System.out.println();
		try {
			while (win==false) {
				if (character=='X') {
					System.out.print("Coordinate: ");
					sc.nextLine();
					String play= sc.nextLine();
					board.setUserPlay(play,character);
					System.out.println(board.showBoard());
					character='0';
				}
				else if (character=='0') {
					player.setBotPlay(board,character);
					System.out.println(board.showBoard());
					character='X';
				}
				if (game.end(board)=='X'){
					win = true;
					winner='X';
				}
				else if (game.end(board)=='0'){
					win = true;
					winner='0';
				}
				System.out.println();		
			}
		}	
			
		catch (PlayInputException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			System.out.println();
			if (winner==userChar){
				System.out.println("You Won!");
			}
			else{
				System.out.println("You lost!");
			}
			sc.close();
		}
		

		System.out.println(board.showBoard());
	}

}
