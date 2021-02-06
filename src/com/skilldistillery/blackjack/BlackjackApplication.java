package com.skilldistillery.blackjack;

import java.util.Scanner;

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
			
			while (run) {
				System.out.println(" Dealer hand: " + dealer.showHand(true));
				System.out.println(" Player hand: " + player.showHand());
				checkWinnerOneRound(player.getHand(), dealer.getHand());
				
				
				String breakString;
				System.out.println("to here?");
				breakString = this.input.next();
			}
			
			
			
		
//		try {
//			
//		} catch (InputMismatchException e) {
//			
		}
	}
	
	public void checkWinnerOneRound(BlackjackHand playerHand, BlackjackHand dealerHand) {
		if (playerHand.isBlackjack()) {
			System.out.println("You have a blackjack!");
			if(!dealerHand.isBlackjack()) {
				printBothHands(playerHand, dealerHand);
				System.out.println("You win!!!");
			}
			else if (dealerHand.isBlackjack()) {
				printBothHands(playerHand, dealerHand);
				System.out.println("Dealer has a blackjack!");
				System.out.println("You tie with the dealer.");
			}
		}
	}
	public void checkWinnerTwoOrMoreRounds(BlackjackHand playerHand, BlackjackHand dealerHand) {
		if (playerHand.isBlackjack()) {
			System.out.println("You got 21!");
			printBothHands(playerHand, dealerHand);			
			if(!dealerHand.isBlackjack()) {
				if(dealerHand.isBust()) {
					System.out.println("Dealer busts.");
				}
				System.out.println("You win!!!");
			}
			//else if ()
		}
	}
	public void checkWinner3(BlackjackHand playerHand, BlackjackHand dealerHand) {
		
	}
	
	public void printBothHands(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println(dealerHand.toString());
		System.out.println(playerHand.toString());
	}

}