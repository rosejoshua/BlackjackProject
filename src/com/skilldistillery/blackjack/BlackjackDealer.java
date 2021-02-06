package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.DeckOfCards;

public class BlackjackDealer implements BlackjackDealerControls, BlackjackPlayControls {
	
	private DeckOfCards deck;	
	private BlackjackHand hand;

	public BlackjackDealer() {
		deck = new DeckOfCards();
		hand = new BlackjackHand();
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
		deck.shuffle();
	}

	@Override
	public int checkDeckSize() {
		return deck.checkDeckSize();
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
	public Card dealCard() {
		return deck.dealCard();
	}

	@Override
	public String showHand(boolean needsFirstCardDown) {
		return hand.toString(needsFirstCardDown);
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
