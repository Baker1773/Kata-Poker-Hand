package PokerHand.Hands;

import PokerHand.Card;

public class ThreeOfAKind extends HandType {
	public ThreeOfAKind(Card[] cards) {
		super(cards);
		generate();
	}

	/**
	 * Looks to see if three difference cards have the same value, if they do
	 * then there is a three of a kind
	 */
	public void generate() {
		if (originalHand.length >= 3) {
			for (int i = 0; i < originalHand.length - 2; i++) {
				for (int j = i + 1; j < originalHand.length - 1; j++) {
					for (int k = j + 1; k < originalHand.length; k++) {
						if (originalHand[i].getIntegerValue() == originalHand[j]
								.getIntegerValue()
								&& originalHand[i].getIntegerValue() == originalHand[k]
										.getIntegerValue()) {
							valid = true;
							handRank = 4;
							used = new Card[3];
							used[0] = originalHand[i];
							used[1] = originalHand[j];
							used[2] = originalHand[k];
						}
					}
				}
			}
		}
		generateUnusedCards();
	}
}
