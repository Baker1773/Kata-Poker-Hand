package PokerHand.Hands;

import PokerHand.Card;

public class FourOfAKind extends HandType {

	public FourOfAKind(Card[] cards) {
		super(cards);
		generate();
	}

	/**
	 * Looks for a pair with the original hand If there is pair it will then use
	 * the remaining cards to look for a second pair if it finds a second pair
	 * it see if they are the same card value if they are then there is a four
	 * of a kind
	 */
	public void generate() {
		if (originalHand.length >= 4) {
			PairCard one = new PairCard(originalHand);
			if (one.isValidHand()) {
				PairCard two = new PairCard(one.unused);
				if (two.isValidHand()) {
					Card oneC = one.used[0];
					Card twoC = two.used[0];
					if (oneC.getIntegerValue() == twoC.getIntegerValue()) {
						valid = true;
						handRank = 8;
						unused = two.unused;
						used = one.used;
					}
				}

			}
		}

		if (!valid) {
			generateUnusedCards();
		}
	}
}
