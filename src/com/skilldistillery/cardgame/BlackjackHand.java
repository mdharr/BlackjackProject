package com.skilldistillery.cardgame;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		
	}
	// BlackjackHand is an extension of Hand, therefore has access to methods within abstract Hand class 
	public int getHandValue() {
		// this needs logic
		return 0;
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
