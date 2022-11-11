package com.skilldistillery.cardgame;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	
	public Hand() {
		// classes that extend Hand have access to Hand's constructor
		// see BlackjackHand class
	}
	
	public void addCard(Card card) {
		// need logic
	}
	
	public void clear() {
		// need logic
	}
	
	public int getHandValue() {
	// need logic
	int result = 0;
	return result;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	


}
