package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
	private List<Card> deck = new ArrayList<>();

	public DeckOfCards() {
		Suit[] valuesSuit = Suit.values();
		Rank[] valuesRank = Rank.values();
		
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<13; j++) {
				deck.add(new Card(valuesSuit[i], valuesRank[j]));
			}
		}
	}
	
	public int checkDeckSize() {
		return deck.size();
	}
	
	public Card dealCard() {
		return deck.remove(deck.size()-1);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
		System.out.println("[Dealer Shuffles cards]");
	}

}
