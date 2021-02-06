package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public class BlackjackPlayer implements BlackjackPlayControls {
	
	private BlackjackHand hand;

	public BlackjackPlayer() {
		hand = new BlackjackHand();
	}

	@Override
	public void hit() {
		

	}

	@Override
	public void stay() {
		// TODO Auto-generated method stub

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

}
