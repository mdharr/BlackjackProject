package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	 protected List<Card> cards;

	
	public Hand() {
		// classes that extend Hand have access to Hand's constructor
		// see BlackjackHand class
		cards = new ArrayList<Card>();
//		cards = new ArrayList<>();

	}

	
	public Card addCard(Card card) {
		// need logic
		cards.add(card);
		return card;

	}
	
	public void clear() {
//		cards.removeAll(cards);
		cards.clear();
	}
	
	public int getHandValue() {
	// not properly calculating values for cards
	int totalValue = 0;

	return totalValue;
	}


	public List<Card> getCards() {
		return cards;
	}


	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}

	
}
