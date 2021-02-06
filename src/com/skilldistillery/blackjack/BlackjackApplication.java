package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.DeckOfCards;

public class BlackjackApplication {
	
	BlackjackDealer dealer;
	BlackjackPlayer player;	
	
	private Scanner input = new Scanner(System.in);

	public BlackjackApplication() {	
		dealer = new BlackjackDealer();
		player = new BlackjackPlayer();
	}

	public static void main(String[] args) {
		BlackjackApplication app = new BlackjackApplication();
		app.run();
	}
	
	private void run() {
		
		boolean run = true;
		
		while(run) {
			
			dealer.shuffle();
			player.addCard(dealer.dealCard());
			dealer.addCard(dealer.dealCard());
			player.addCard(dealer.dealCard());
			dealer.addCard(dealer.dealCard());
			
//			int playerScore = player.getHandValue();
			
			System.out.println(dealer.showHand(true));
			System.out.print(player.showHand());
			System.out.println(" Value: " + player.getHandValue());
			
			String breakString;
			System.out.println("to here?");
			breakString = this.input.next();
		
//		try {
//			
//		} catch (InputMismatchException e) {
//			
		}
	}

}