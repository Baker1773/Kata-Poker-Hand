package PokerHand.Hands;

import PokerHand.Card;

public abstract class HandType implements IHandType {
	// If the hand can make the hand type or not
	boolean valid;
	// Cards used if any
	Card[] used;
	// Cards unused
	Card[] unused;
	// Hand to start with
	Card[] originalHand;
	// Int value to compare against other hand types
	int handRank;

	public HandType(Card[] cards) {
		valid = false;
		used = new Card[0];
		unused = cards;
		originalHand = cards;
		handRank = 0;
	}

	// Generates the hand type
	// Sets valid, used, handRank
	protected abstract void Generate();

	public boolean isValidHand() {
		return valid;
	}

	public Card[] GetUsedCards() {
		return used;
	}

	public Card[] GetUnusedCards() {
		return unused;
	}

	// To be called after Generate
	// This will find the cards used in the hand
	// but not in the original hand
	// and generate an array of unused cards
	protected void GenerateUnusedCards() {
		int indexUnused = 0;
		unused = new Card[originalHand.length - used.length];
		for (int i = 0; i < originalHand.length; i++) {
			boolean usedCardAtI = false;
			for (int j = 0; j < used.length && !usedCardAtI; j++) {
				if (originalHand[i] == used[j])
					usedCardAtI = true;
			}

			if (!usedCardAtI) {
				unused[indexUnused] = originalHand[i];
				indexUnused++;
			}
		}
	}

	public int GetTypeRank() {
		return handRank;
	}
}
