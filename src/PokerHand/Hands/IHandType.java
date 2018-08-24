package PokerHand.Hands;

import PokerHand.Card;

public interface IHandType {

	// returns true if that hand type can be made with
	// the original hand given to it.
	public boolean isValidHand();

	// returns the cards used to make that hand type
	// if it cannot make that hand type it returns an
	// empty array
	// Note it will have the cards used to make the hand
	// that are used to compare to other hands of the same
	// type, such as in a full house it only compares the
	// three of a kind so it saves the three of a kind
	// as the cards used
	public Card[] GetUsedCards();

	// returns the cars not used
	public Card[] GetUnusedCards();

	// gets the rank of the card
	// high card being the lowest at 1
	// straight flush being the highest at 9
	public int GetTypeRank();
}
