package PokerHand.Hands;

import PokerHand.Card;

public class PairCard extends HandType {
	public PairCard(Card[] cards) {
		super(cards);
		Generate();
	}

	/**
	 * looks for a pair, if it exists then it will set valid to true if it finds
	 * another pair and valid is true it will see if the new pair has higher
	 * value and go with the pair with higher value
	 */
	public void Generate() {
		if (originalHand.length >= 2) {
			for (int i = 0; i < originalHand.length - 1; i++) {
				for (int j = i + 1; j < originalHand.length; j++) {
					if (originalHand[i].GetIntegerValue() == originalHand[j]
							.GetIntegerValue()) {
						if (valid) {
							if (used[0].GetIntegerValue() < originalHand[i]
									.GetIntegerValue()) {
								used[0] = originalHand[i];
								used[1] = originalHand[j];
							}
						} else {
							valid = true;
							handRank = 2;
							used = new Card[2];
							used[0] = originalHand[i];
							used[1] = originalHand[j];
						}
					}
				}
			}
		}
		GenerateUnusedCards();
	}
}
