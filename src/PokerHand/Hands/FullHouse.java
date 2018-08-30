package PokerHand.Hands;

import PokerHand.Card;

public class FullHouse extends HandType {
	public FullHouse(Card[] cards) {
		super(cards);
		generate();
	}

	/**
	 * Looks for a 3 of a kind in the original hand if it exists look for a pair
	 * in the remaining cards if the pair also exits then there a full house
	 */
	public void generate() {
		if (originalHand.length >= 5) {
			ThreeOfAKind three = new ThreeOfAKind(originalHand);
			if (three.isValidHand()) {
				PairCard pair = new PairCard(three.unused);
				if (pair.isValidHand()) {
					valid = true;
					handRank = 7;
					used = three.used;
				}
			}
		}

		generateUnusedCards();
	}
}
