package com.skilldistillery.blackjack.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackjackApp {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BlackjackApp app = new BlackjackApp();
		app.run(scanner);
	}
	
	public void run(Scanner scanner) {
		System.out.println("Welcome to Blackjack.");
		while(true) {
			
			// create a new deck
			Deck deck = new Deck();
			// shuffle deck
			deck.shuffle();
			// create an instance of black jack hand for dealer
			Hand dealerHand = new BlackjackHand();
			// create an instance of black jack hand for player
			Hand playerHand = new BlackjackHand();
			
			// while the deck still has at least 10 cards
			while(deck.checkDeckSize() >= 10) {
				dealerHand.clear();
				playerHand.clear();
				// add one card to player hand and announce
				System.out.println("Player is dealt: " + playerHand.addCard(deck.dealCard()).toString());
				System.out.println(playerHand.getHandValue());
				// add one card to dealer hand and do not announce
				System.out.println("Dealer is dealt: a card face down.");
				System.out.println(dealerHand.getHandValue());
				// add one more to player hand and announce
				System.out.println("Player is dealt: " + playerHand.addCard(deck.dealCard()).toString());
				System.out.println(playerHand.getHandValue());
				// add one more to dealer hand and announce
				System.out.println("Dealer is dealt: " + dealerHand.addCard(deck.dealCard()).toString());
				System.out.println(dealerHand.getHandValue());
				// if either player or dealer have blackjack, the game ends and winner is announced
				if(dealerHand.getHandValue() == 21) {
					System.out.println("Dealer has a score of: " + dealerHand.getHandValue());
					System.out.println("Dealer: Blackjack! Dealer Wins!");
				} else if (playerHand.getHandValue() == 21) {
					System.out.println("Player: Blackjack! Player Wins!");
				} else {
					while(true) {
						// ask player hit or stand
						System.out.println("Hit or Stand: ");
						String userInput = scanner.nextLine();
						// if user hits, add card to user hand and announce
						if(userInput.equalsIgnoreCase("Hit")) {
							System.out.println("Player: 'Hit me!'");
							playerHand.addCard(deck.dealCard());
							System.out.println("Player score is now: " + playerHand.getHandValue());
							// if player score exceeds 21, player loses
							if(playerHand.getHandValue() > 21) {
								System.out.println("Player: Bust! Player lost this round.");
							} else {
								continue;
							}
							
							// if player stands, count score and announce winner
						} else if(userInput.equalsIgnoreCase("Stand!")) {
							System.out.println("Player: 'Stand'");
							while(true) {
								// continue giving card to dealer until hand reaches 17 or bust
								if(dealerHand.getHandValue() >= 17 && dealerHand.getHandValue() <= 21) {
									compareCards(playerHand.getHandValue(), dealerHand.getHandValue());
								} else if(dealerHand.getHandValue() < 17) {
									dealerHand.addCard(deck.dealCard());
									compareCards(playerHand.getHandValue(), dealerHand.getHandValue());
									
								}
							} // hit or stand for dealer loop, then compare cards and announce winner
														
						} // stand
						
					} // hit or stand loop
					
				} //  else ---> hit or stand loop
				
			} // while the deck still has at least 10 cards, keep playing
			
		} // creates new deck if deck has less than 10 cards
			
	} // end of program
	
	public void compareCards(int playerHand, int dealerHand) {
		if(playerHand > dealerHand) {
			System.out.println("Player: I win!");
		} else if(playerHand < dealerHand) {
			System.out.println("Dealer: I win!");
		} else {
			System.out.println("This round ended in a tie!");
		}
		
	}
	// not sure if I can actually use this
	private void printHandAndValue(List<Card> hand, int value) {
		for(Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Total value: " + value);
	}

}
