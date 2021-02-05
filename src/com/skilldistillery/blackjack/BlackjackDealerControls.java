package com.skilldistillery.blackjack;

public interface BlackjackDealerControls {
	
	final int CARDS_PER_DEAL = 2;
	
	void shuffle();
	void dealDealer();
	void dealPlayer();
	int checkDeckSize();
	String showHandCardDown();
	String showHand();

}
