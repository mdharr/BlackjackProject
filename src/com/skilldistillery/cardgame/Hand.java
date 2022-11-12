package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	private List<Card> cards;

	
	public Hand() {
		// classes that extend Hand have access to Hand's constructor
		// see BlackjackHand class
		cards = new ArrayList<Card>();

	}

	
	public Card addCard(Card card) {
		// need logic
		cards.add(card);
		return card;

	}
	
	public void clear() {
		cards.clear();
	}
	
	public int getHandValue() {
	// need logic
	int totalValue = 0;
	int numCards = cards.size();
	for (Card card : cards) {
		int c = card.getValue();
		totalValue += card.getValue();	
	}
	return totalValue;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	


}
