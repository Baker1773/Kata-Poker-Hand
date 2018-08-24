package PokerHand.Hands;

import PokerHand.Card;

public class StraightFlush extends HandType {
	public StraightFlush(Card[] cards) {
		super(cards);
		Generate();
	}

	/**
	 * looks for a straight, if it exists it looks for a flush if both exists
	 * then it is a straight flush
	 */
	public void Generate() {
		if (originalHand.length >= 5) {
			Straight s = new Straight(originalHand);
			if (s.isValidHand()) {
				Flush f = new Flush(s.used);
				if (f.isValidHand()) {
					valid = true;
					handRank = 9;
					used = f.used;
				}
			}
		}
		GenerateUnusedCards();
	}
}
