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

	@Override
	public int getSize() {
		return cards.size();
	}

	@Override
	public String toString() {
		return super.toString();
	}
	public String toString(boolean needsFirstCardDown) {
		if(needsFirstCardDown) {
			StringBuilder sb = new StringBuilder();
			sb.append(" [Hidden Card]");
			for(int i=1; i<cards.size(); i++) {
				sb.append(" [" + cards.get(i).toString() + "]");
			}
			return sb.toString();
		}
		else return super.toString();
	}
	
	

}
