package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public interface BlackjackDealerControls {
	
	final int CARDS_PER_DEAL = 2;
	
	void shuffle();
	Card dealCard();
	int checkDeckSize();
	String showHand();
	String showHand(boolean needsFirstCardDown);

}
