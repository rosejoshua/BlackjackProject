package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public class BlackjackPlayer implements BlackjackPlayControls {
	
	private BlackjackHand hand;

	public BlackjackPlayer() {
		hand = new BlackjackHand();
	}

	@Override
	public String showHand() {
		return hand.toString();
	}

	@Override
	public void addCard(Card card) {
		hand.addCard(card);
		
	}

	@Override
	public int getHandValue() {
		return hand.getHandValue();
	}

	@Override
	public BlackjackHand getHand() {
		BlackjackHand newHand = hand;
		return newHand;
	}

}
