package com.skilldistillery.cardgame;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		
	}
	// BlackjackHand is an extension of Hand, therefore has access to methods within abstract Hand class 
	public int getHandValue() {
		// this needs logic
		int totalValue = 0;
		for (Card card : this.cards) {
			totalValue += card.getValue();
		}
		return totalValue;
	}
	
	public boolean isBlackjack() {
		// this needs logic
		boolean result = false;
		if(getHandValue() == 21) {
			result = true;
		}
		return result;
	}
	
	public boolean isBust() {
		// this needs logic
		boolean result = false;
		if(getHandValue() > 21) {
			result = true;
		}
		return result;
	}


}
