package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public interface BlackjackPlayControls {
	
	void hit();
	void stay();
	void addCard(Card card);
	int getHandValue();
	String showHand();

}
