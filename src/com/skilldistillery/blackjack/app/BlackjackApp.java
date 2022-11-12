package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cards.Deck;

public class BlackjackApp {
	
	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Hand aHand = new BlackjackHand();
		BlackjackApp app = new BlackjackApp();
		app.run();
		
	}
	
	public void run() {
		
		// create a new deck
		Deck deck = new Deck();
		// shuffle deck
		deck.shuffle();
		
		// while the deck still has at least 10 cards
		while(deck.checkDeckSize() >= 10) {
			
			// create an instance of blackjackhand for dealer
			BlackjackHand dealerHand = new BlackjackHand();
			// create an instance of blackjackhand for player
			BlackjackHand playerHand = new BlackjackHand();
			// add one card to player hand and announce
			//TODO for loop to print out cards dealt to player/dealer (dealer index starts at 1 to not reveal first card)
			playerHand.addCard(deck.dealCard());
			System.out.println("Player is dealt a card: " + playerHand.getHandValue());
			// add one card to dealer hand and do not announce
			dealerHand.addCard(deck.dealCard());
			System.out.println("Dealer is dealt a card.");
			// add one more to player hand and announce
			playerHand.addCard(deck.dealCard());
			System.out.println("Player is dealt another card: " + playerHand.getHandValue());
			// add one more to dealer hand and announce
			dealerHand.addCard(deck.dealCard());
			System.out.println("Dealer is dealt another card: " + dealerHand.getHandValue());
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
						}
						// compare cards and announce winner
					}
					
				}
			}
		} // while the deck still has at least 10 cards, keep playing
			
	}
	
	public void compareCards(int playerHand, int dealerHand) {
		if(playerHand > dealerHand) {
			System.out.println("Player: I win!");
		} else if(playerHand < dealerHand) {
			System.out.println("Dealer: I win!");
		} else {
			System.out.println("This round ended in a tie!");
		}
		
	}

}
