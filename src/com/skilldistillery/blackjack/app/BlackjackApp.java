package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackjackApp {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BlackjackApp app = new BlackjackApp();
		app.run(scanner);
	}
	
	public void run(Scanner scanner) {
		System.out.println("Welcome to Blackjack.");
		while(true) {
			
			// instantiate a dealer, then instantiate a new deck and dealer hand through Dealer ctor args
			Dealer dealer = new Dealer(new Deck(), new BlackjackHand());
			Deck deck = dealer.getDeck();
			// instantiate a player, then 
			Player player = new Player(new BlackjackHand());
			noCardsBreakPoint:
			// while the deck still has at least 10 cards
			while(deck.checkDeckSize() >= 10) {
				// empty dealer and player hands at start of each round
				dealer.getHand().clear();
				player.getHand().clear();
				// have dealer shuffle deck
				dealer.shuffle(deck);
				// add one card to player hand and announce
				System.out.println("Player is dealt: " + player.getHand().addCard(dealer.dealCard()).toString());
				System.out.println("Player hand total: " + player.getHand().getHandValue());
				System.out.println();
				// add one card to dealer hand and do not announce
				dealer.getHand().addCard(dealer.dealCard()).toString();
				System.out.println("Dealer is dealt: a card face down.");
				System.out.println("Dealer hand total: unknown");
				System.out.println();
				// add one more to player hand and announce
				System.out.println("Player is dealt: " + player.getHand().addCard(dealer.dealCard()).toString());
				System.out.println("Player hand total: " + player.getHand().getHandValue());
				System.out.println();
				// add one more to dealer hand and announce
				System.out.println("Dealer is dealt: " + dealer.getHand().addCard(dealer.dealCard()).toString());
				// how to access index[1] of dealer hand?
				System.out.println("Dealer hand total: " + dealer.printNonHiddenDealerHandAndValue() + " plus unknown value of face down card.");
				System.out.println();
				// if either player or dealer have blackjack, the game ends and winner is announced
				if(dealer.getHand().getHandValue() == 21) {
					System.out.println("Dealer has a score of: " + dealer.getHand().getHandValue());
					System.out.println("Dealer: Blackjack! Dealer Wins!");
					System.out.println();
				} else if (player.getHand().getHandValue() == 21) {
					System.out.println("Player: Blackjack! Player Wins!");
					System.out.println();
				} else {
					while(true) {
						// ask player hit or stand
						System.out.println();
						System.out.println("Hit or Stand: ");
						System.out.println();
						String userInput = scanner.nextLine();
						// if user hits, add card to user hand and announce
						if(userInput.equalsIgnoreCase("Hit")) {
							System.out.println("Player: 'Hit me!'");
							System.out.println();
							System.out.println("Player is dealt: " + player.getHand().addCard(dealer.dealCard()).toString());
							System.out.println();
							System.out.println("Player score is now: " + player.getHand().getHandValue());
							System.out.println();
							// if player score exceeds 21, player loses
							if(player.getHand().getHandValue() > 21) {
								System.out.println("Player: Bust! Player lost this round.");
								System.out.println();
								System.out.println("Dealer wins!");
								System.out.println();
								System.out.print("Would you like to play another round? (y/n): ");
								userInput = scanner.nextLine();
									if(userInput.equals("y")) {
										System.out.println();
										break;
									} else if (userInput.equals("n")){
										System.out.println();
										exitProgram();
									}
									
							} else {
								continue;
							}
							
							// if player stands, count score and announce winner
						} else if(userInput.equalsIgnoreCase("Stand")) {
							System.out.println("Player: 'Stand'");
							System.out.println();
							// how to access index of dealerHand?
							System.out.println("Dealer reveals face down card: " + dealer.printHiddenDealerHandAndValue());
							System.out.println("Dealer score is now: " + dealer.getHand().getHandValue());
							System.out.println();
							while(true) {
								// continue giving card to dealer until hand reaches 17 or bust
								if(dealer.getHand().getHandValue() >= 17 && dealer.getHand().getHandValue() <= 21) {
									System.out.println("Dealer score is now: " + dealer.getHand().getHandValue());
									compareCards(player.getHand().getHandValue(), dealer.getHand().getHandValue());
									System.out.println();
									break;
								} else if(dealer.getHand().getHandValue() < 17) {
								
									while(dealer.getHand().getHandValue() < 17) {
										// fixed break point in case cards run out mid game
										if(!(deck.checkDeckSize() >= 10)) {
											break noCardsBreakPoint;
										}
										System.out.println("Dealer is dealt: " + dealer.getHand().addCard(dealer.dealCard()).toString());
										System.out.println("Dealer score is now: " + dealer.getHand().getHandValue());
										System.out.println();
										if(dealer.getHand().getHandValue() > 21) {
											System.out.println("Dealer: Bust!");
											System.out.println("Dealer loses this round.");
											System.out.println();
											System.out.println("Player wins!");
											System.out.println();
											break;
											
										}
										
									} // end of loop that continues to deal cards to dealer until they either get at least 17 cards or bust
									compareCards(player.getHand().getHandValue(), dealer.getHand().getHandValue());
									System.out.println();
								}
								
							} // hit or stand for dealer loop, then compare cards and announce winner
														
						} // stand
						playAnother(scanner);
						break;
					} // player 'hit' or 'stand' loop end
					
				} //  else ---> enter player 'hit' or 'stand' loop end
				
			} // while the deck still has at least 10 cards, keep playing
			System.out.println("Not enough cards in deck to play another round. Start a new game? (y/n)");
			String userInput = scanner.nextLine();
			if(userInput.equals("y")) {
				continue;
			} else {
				break;
			}
		} // creates new deck if deck has less than 10 cards
		exitProgram();
	} // end of program
	
	public void compareCards(int playerHand, int dealerHand) {
		if(playerHand > dealerHand) {
			System.out.println("Player: I win!");
			System.out.println();
		} else if(playerHand < dealerHand) {
			System.out.println("Dealer: I win!");
			System.out.println();
		} else if (playerHand == dealerHand){
			System.out.println("This round ended in a tie!");
			System.out.println();
		}
		
	}
	
	public void exitProgram() {
		System.out.println("Thanks for playing!");	
		System.out.println("Application closed.");
		System.exit(0);
	}
	
	public void playAnother(Scanner scanner) {
		String userInput = "";
		System.out.print("Would you like to play another round? (y/n): ");
		userInput = scanner.nextLine();
		while(true) {
			if(userInput.equals("y")) {
				System.out.println();
				break;
			} else if (userInput.equals("n")){
				System.out.println();
				exitProgram();
			} // else if --> end of program
			
		} // loop for user input to play again
		
	}
	
}
