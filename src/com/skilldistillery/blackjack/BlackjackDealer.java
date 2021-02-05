package com.skilldistillery.blackjack;

import com.skilldistillery.cards.DeckOfCards;

public class BlackjackDealer implements BlackjackDealerControls, BlackjackPlayControls {
	
	private DeckOfCards deck = new DeckOfCards();	
	private BlackjackHand hand;

	public BlackjackDealer() {
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dealDealer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dealPlayer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkDeckSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String showHandCardDown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showHand() {
		// TODO Auto-generated method stub
		return null;
	}

}
