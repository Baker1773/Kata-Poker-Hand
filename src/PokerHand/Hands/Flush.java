package PokerHand.Hands;

import PokerHand.Card;

public class Flush extends HandType {

	public Flush(Card[] cards) {
		super(cards);
		generate();
	}

	// looks to see if all the cards have the same suit
	public void generate() {
		if (originalHand.length >= 5) {
			Card c = originalHand[0];
			boolean equalSuit = true;

			for (int i = 0; i < originalHand.length && equalSuit; i++) {
				if (c.getSuit() != originalHand[i].getSuit())
					equalSuit = false;
			}

			if (equalSuit) {
				valid = true;
				handRank = 6;
				used = originalHand;
				unused = new Card[0];
			}
		}

		generateUnusedCards();
	}

}
