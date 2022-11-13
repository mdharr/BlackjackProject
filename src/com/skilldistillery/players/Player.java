package com.skilldistillery.players;

import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Card;

public class Player {
	
	protected Hand hand;
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(Hand hand) {
		super();
		this.hand = hand;
	}

		public void printHandAndValue() {
			int value = 0;
			for(Card card : this.hand.getCards()) {
				System.out.println(card);
				value += card.getValue();
			}
			System.out.println("Total value: " + value);
		}

		public Hand getHand() {
			return hand;
		}

}
