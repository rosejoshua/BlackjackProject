package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApplication {
	
	BlackjackDealer dealer;
	BlackjackPlayer player;	
	
	private Scanner input = new Scanner(System.in);

	public BlackjackApplication() {	
	}

	public static void main(String[] args) {
		boolean keepGoing = true;
		BlackjackApplication app = new BlackjackApplication();
		while(keepGoing) {
			keepGoing = app.run();
		}
	}
	
	private boolean run() {
		dealer = new BlackjackDealer();
		player = new BlackjackPlayer();

		boolean haveWinner = false;
			while(!haveWinner) {				

				dealer.shuffle();
				player.addCard(dealer.dealCard());
				dealer.addCard(dealer.dealCard());
				player.addCard(dealer.dealCard());
				dealer.addCard(dealer.dealCard());
				
				printBothHandsCardDown(player.getHand(), dealer.getHand());
				
				if(dealer.getHandValue()!=21 && player.getHandValue()==21) {
					checkWinner21(player.getHand(), dealer.getHand());
					break;
				}
				
				hitOrStayPlayer(input, player, dealer);				

				if (player.getHandValue() > 21) {
					System.out.println("You busted.");
					printBothHands(player.getHand(), dealer.getHand());
					System.out.println("Dealer wins.");
					break;
				}

				hitOrStayDealer(player, dealer);
				
				haveWinner = checkWinner21(player.getHand(), dealer.getHand());
				if(haveWinner) {
					break;
				}

				if (dealer.getHandValue() > 21) {
					System.out.println("Dealer busted!");
					printBothHands(player.getHand(), dealer.getHand());
					System.out.println("You win!!!");
					break;
				}

				checkWinner(player.getHand(), dealer.getHand());
				haveWinner = true;
				break;
			
			}
			System.out.println("*** Play Again? ***");
			System.out.println("\'Y\' to play again or \'N\' to quit...");
			
			if (input.next().toUpperCase().equals("Y")) {
				return true;
			}
			else {
				System.out.println("Goodbye!");
				return false;
			}
	}
	
	private boolean checkWinner21(BlackjackHand playerHand, BlackjackHand dealerHand) {
		if (playerHand.isBlackjack()) {
			
			if (playerHand.getSize() == 2 && dealerHand.getSize()==2 ) {
				System.out.println("You have a blackjack!");
			}
			else if (playerHand.getSize()>2) {
				System.out.println("You got 21!");
			}	
			if(dealer.getHandValue()>21) {
					System.out.println("Dealer busted!");
				}
			
			if ((!dealerHand.isBlackjack() && dealerHand.getSize()>2) || (!dealerHand.isBlackjack()  && dealerHand.getHandValue()>16)) {
				printBothHands(playerHand, dealerHand);
				System.out.println("You win!!!");	
				return true;
			}
			if ((!dealerHand.isBlackjack() && playerHand.getSize() == 2)) {
				printBothHands(playerHand, dealerHand);
				System.out.println("You win!!!");	
				return true;
			}
		}
			
		if (dealerHand.isBlackjack()) {
			printBothHands(playerHand, dealerHand);
			
			if (dealerHand.getSize() == 2) {
				System.out.println("Dealer has a blackjack!");
			} else {
				System.out.println("Dealer has 21!");
			}
			if((dealer.getHand().getSize()==2 && player.getHand().getSize()>2) || (dealer.getHand().getSize()==2 && player.getHand().getSize()==2 && !player.getHand().isBlackjack())) {
				System.out.println("Dealer wins!");
			}
			else {
				System.out.println("You tie with the dealer.");
			}
			return true;
		} else {
			return false;
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
			if((dealer.getHandValue()<17 && (player.getHandValue() > dealer.getHandValue())) && player.getHandValue()<22) {
				dealer.addCard(dealer.dealCard());
				System.out.println("[Dealer hits...]");
			}
			
		} while (dealer.getHandValue()<17);	
		if(dealer.getHandValue()>17 && dealer.getHandValue()<22) {
			System.out.println("[Dealer stays...]");
		}
	}	
	
	
	private void hitOrStayPlayer(Scanner input, BlackjackPlayer player, BlackjackDealer dealer) {
		boolean hits = true;
		String temp = "arbitrary";
		while (hits) {
			if(player.getHand().getSize()>2) {
				printBothHandsCardDown(player.getHand(), dealer.getHand());
			}
			if (player.getHandValue() == 21) {
				checkWinner21(player.getHand(), dealer.getHand());
				hits = false;
				break;
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