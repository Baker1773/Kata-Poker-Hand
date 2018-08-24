package PokerHand.Hands;

import PokerHand.Card;

public class HighCard extends HandType {
	public HighCard(Card[] cards) {
		super(cards);
		Generate();
	}

	/**
	 * looks for the highest card
	 */
	public void Generate() {
		if (originalHand.length >= 1) {
			used = new Card[1];
			used[0] = originalHand[0];
			valid = true;
			handRank = 1;

			for (int i = 1; i < originalHand.length; i++) {
				if (originalHand[i].GetIntegerValue() > used[0]
						.GetIntegerValue())
					used[0] = originalHand[i];
			}

		}
		GenerateUnusedCards();
	}
}