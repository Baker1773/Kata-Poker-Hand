package PokerHand.Hands;

import PokerHand.Card;

public class Straight extends HandType {
	public Straight(Card[] cards) {
		super(cards);
		generate();
	}

	/**
	 * Finds the lowest card and then looks to see if the next card is in the
	 * hand. This is repeated 5 times to find a straight
	 */
	public void generate() {
		if (originalHand.length >= 5) {
			// Get minimum card
			Card min = originalHand[0];
			for (int i = 1; i < originalHand.length; i++) {
				if (min.getIntegerValue() > originalHand[i].getIntegerValue())
					min = originalHand[i];
			}

			boolean foundNextCard = true;
			int i = 0;
			int foundNextCardCount = 1;
			for (; i < originalHand.length - 1 && foundNextCard; i++) {
				foundNextCard = false;
				for (int j = 0; j < originalHand.length & !foundNextCard; j++) {
					if (min.getIntegerValue() + 1 == originalHand[j]
							.getIntegerValue()) {
						min = originalHand[j];
						foundNextCard = true;
						foundNextCardCount++;
					}
				}
			}

			if (foundNextCardCount == originalHand.length) {
				valid = true;
				handRank = 5;
				used = originalHand;
			}
		}
		generateUnusedCards();
	}
}
