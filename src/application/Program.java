package application;

import java.util.Scanner;

import entities.Board;
import exceptions.PlayInputException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean win=false;
		
		System.out.println("Tic Tac Toe Game!");
		System.out.println("");
		System.out.print("Select your character(0 or X): ");
		char character=sc.next().charAt(0);
		Board board=new Board();
		System.out.println();
		System.out.println(board.showBoard());
		System.out.println();
		try {
			if (character=='X') {
				System.out.print("Coordinate: ");
				sc.nextLine();
				String play= sc.nextLine();
				board.setPlay(play,character);
			}
			while (win==false) {
				
			}
		catch (PlayInputException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		

		System.out.println(board.showBoard());

	}

}
