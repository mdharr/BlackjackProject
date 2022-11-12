package com.skilldistillery.cards;

import java.util.Objects;

public class Card {
	
	private Rank rank;
	private Suit suit;

	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getValue() {
		// this.getValue() or this.rank.getValue()?
		return this.rank.getValue();
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}
// how can I reach this toString?
	@Override
	public String toString() {
		return rank + " of " + suit;
	}

}
