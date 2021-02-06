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

		while (run) {

			dealer.shuffle();
			player.addCard(dealer.dealCard());
			dealer.addCard(dealer.dealCard());
			player.addCard(dealer.dealCard());
			dealer.addCard(dealer.dealCard());

			hitOrStayPlayer(input, player, dealer);
			checkWinner21(player.getHand(), dealer.getHand());

			if (player.getHandValue() > 21) {
				System.out.println("You busted.");
				printBothHands(player.getHand(), dealer.getHand());
				System.out.println("Dealer wins.");
				break;
			}

			hitOrStayDealer(player, dealer);
			checkWinner21(player.getHand(), dealer.getHand());

			if (dealer.getHandValue() > 21) {
				System.out.println("Dealer busted!");
				printBothHands(player.getHand(), dealer.getHand());
				System.out.println("You win!!!");
				break;
			}

			checkWinner(player.getHand(), dealer.getHand());

			run = false;

		}
	}
	
	private void checkWinner21(BlackjackHand playerHand, BlackjackHand dealerHand) {
		if (playerHand.isBlackjack()) {
			
			if (playerHand.getSize() == 2) {
				System.out.println("You have a blackjack!");
			} else {
				System.out.println("You got 21!");
			}
			
			if (!dealerHand.isBlackjack()) {
				printBothHands(playerHand, dealerHand);
				System.out.println("You win!!!");
			}
			
		} else if (dealerHand.isBlackjack()) {
			printBothHands(playerHand, dealerHand);
			
			if (dealerHand.getSize() == 2) {
				System.out.println("Dealer has a blackjack!");
			} else {
				System.out.println("Dealer has 21!");
			}
			
			System.out.println("You tie with the dealer.");
		}
	}

	private void checkWinner(BlackjackHand playerHand, BlackjackHand dealerHand) {		
		
		if(dealerHand.getSize()>2) {
			printBothHands(playerHand, dealerHand);
		}
		
		if(playerHand.getHandValue() > dealerHand.getHandValue()) {
			System.out.println("You win!!!");
		}
		else if(playerHand.getHandValue() < dealerHand.getHandValue()) {
			System.out.println("Dealer wins.");
		}
		else {
			System.out.println("You tie with the dealer.");
		}
	}
	
	private void printBothHands(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println("\tDealer: " + dealerHand.toString());
		System.out.println("\tPlayer: " + playerHand.toString());
	}
	private void printBothHandsCardDown(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println("\tDealer: " + dealerHand.toString(true));
		System.out.println("\tPlayer: " + playerHand.toString());
	}	
	
	
	private void hitOrStayDealer (BlackjackPlayer player, BlackjackDealer dealer) {
		do {
			printBothHands(player.getHand(), dealer.getHand());
			if(dealer.getHandValue()<17) {
				dealer.addCard(dealer.dealCard());
				System.out.println("[Dealer hits...]");
			}
			
		} while (dealer.getHandValue()<17);		
	}	
	
	
	private void hitOrStayPlayer(Scanner input, BlackjackPlayer player, BlackjackDealer dealer) {
		boolean hits = true;
		String temp = "arbitrary";
		while (hits) {
			printBothHandsCardDown(player.getHand(), dealer.getHand());
			if (player.getHandValue() == 21) {
				checkWinner21(player.getHand(), dealer.getHand());
			}

			System.out.println("*** Hit or Stay? ***");
			System.out.println("\'H\' to hit or \'S\' to stay ");

			temp = input.next().toUpperCase();

			if (temp.equals("H") && player.getHandValue() < 21) {
				player.addCard(dealer.dealCard());

				if (player.getHandValue() > 20) {
					hits = false;
				}
			}
			if (!temp.equals("H")) {
				hits = false;
			}
		}
		
	}

}