package PokerHand.Hands;

import PokerHand.Card;

public class Straight extends HandType {
	public Straight(Card[] cards) {
		super(cards);
		Generate();
	}

	/**
	 * Finds the lowest card and then looks to see if the next card is in the
	 * hand. This is repeated 5 times to find a straight
	 */
	public void Generate() {
		if (originalHand.length >= 5) {
			// Get minimum card
			Card min = originalHand[0];
			for (int i = 1; i < originalHand.length; i++) {
				if (min.GetIntegerValue() > originalHand[i].GetIntegerValue())
					min = originalHand[i];
			}

			boolean foundNextCard = true;
			int i = 0;
			int foundNextCardCount = 1;
			for (; i < originalHand.length - 1 && foundNextCard; i++) {
				foundNextCard = false;
				for (int j = 0; j < originalHand.length & !foundNextCard; j++) {
					if (min.GetIntegerValue() + 1 == originalHand[j]
							.GetIntegerValue()) {
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
		GenerateUnusedCards();
	}
}
