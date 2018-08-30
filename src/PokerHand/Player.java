package PokerHand;


public class Player {
	private String name;
	private Card[] hand;

	// Player Constructor
	// Stores the name and hand
	Player(String name, Card[] hand) {
		assert hand.length == 5 : " Invalid hand size, Expected hand size is 5";

		this.name = name;
		this.hand = hand;
	}

	// returns players name
	public String getName() {
		return name;
	}

	// returns players hand
	public Card[] getHand() {
		return hand;
	}
}
