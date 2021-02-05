package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.DeckOfCards;

public class BlackjackApplication {
	
	
	private Scanner input = new Scanner(System.in);

	public BlackjackApplication() {		
	}

	public static void main(String[] args) {
		BlackjackApplication app = new BlackjackApplication();
		app.run();
	}
	
	private void run() {
		List<Card> userDeck = new ArrayList<>();
		
		try {
			numCardsToDraw = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Restart Program.");
			return;
		}
		
		if(numCardsToDraw==0 && this.deck.checkDeckSize()!=0) {
			System.out.println("Invalid input 0");
			return;
		}
		if(numCardsToDraw > this.deck.checkDeckSize()) {
			System.out.println("Invalid input, not enought cards in deck.");
			return;
		}
		
		
		for (int i=0; i<numCardsToDraw; i++) {
			userDeck.add(this.deck.dealCard());
		}
		
		for (Card card : userDeck) {
			totalCardValue+=card.getValue();
		}
		
		for (Card card : userDeck) {
			System.out.println(card);
		}
		
		System.out.println("Total card value: " + totalCardValue);
	}

}