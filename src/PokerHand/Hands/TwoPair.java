package PokerHand.Hands;

import PokerHand.Card;

public class TwoPair extends HandType {

	public TwoPair(Card[] cards) {
		super(cards);
		Generate();
	}

	/**
	 * looks for 1 pair with the original hand then looks for another pair with
	 * the remaining cards. If both pairs are valid then there two pair exists
	 */
	public void Generate() {
		if (originalHand.length >= 4) {
			PairCard one = new PairCard(originalHand);
			if (one.isValidHand()) {
				PairCard two = new PairCard(one.unused);
				if (two.isValidHand()) {
					valid = true;
					handRank = 3;
					used = one.used;
				}

			}
		}
		GenerateUnusedCards();
	}

}
