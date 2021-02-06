package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public interface BlackjackPlayControls {
	
	void addCard(Card card);
	int getHandValue();
	BlackjackHand getHand();
	String showHand();

}
