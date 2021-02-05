package com.skilldistillery.cards;

import java.util.List;

public abstract class Hand {
	
	protected List<Card> cards;

	public Hand() {
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		//clears table?
	}
	
	public abstract int getHandValue();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Card card : cards) {
			sb.append(card.toString());
		}
		return sb.toString();
	}

}
