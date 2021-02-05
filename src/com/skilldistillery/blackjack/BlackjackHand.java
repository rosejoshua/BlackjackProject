package com.skilldistillery.blackjack;

import java.util.ArrayList;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;

public class BlackjackHand extends Hand {
	
	

	public BlackjackHand() {
		cards = new ArrayList<Card>();
	}
	
	public boolean isBlackjack() {
		if (this.getHandValue()==21) {
			return true;
		}
		else return false;
	}
	
	public boolean isBust() {
		if (this.getHandValue()>21) {
			return true;
		}
		else return false;
	}
	
//	public boolean isHard() {
//		for (Card card : cards) {
//			if (card.getValue()==11) {
//				return true;
//			}
//		}
//		return false;
//	}
//	public boolean isSoft() {
//		for (Card card : cards) {
//			if (card.getValue()==11) {
//				return true;
//			}
//		}
//		return false;
//	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : cards) {
			handValue += card.getValue();
		}
		return handValue;
	}

}
