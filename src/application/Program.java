package application;

import java.util.Scanner;

import entities.Board;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Tic Tac Toe Game!");
		System.out.println("");
		System.out.print("Select your character(0 or X): ");
		char character=sc.next().charAt(0);
		
		
		Board board=new Board();
		System.out.println(board.showBoard());
		board.setPlay("A1","X");
		System.out.println(board.showBoard());

	}

}
