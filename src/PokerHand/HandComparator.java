package PokerHand;

import javafx.util.Pair;
import PokerHand.Hands.Flush;
import PokerHand.Hands.FourOfAKind;
import PokerHand.Hands.FullHouse;
import PokerHand.Hands.HandType;
import PokerHand.Hands.HighCard;
import PokerHand.Hands.PairCard;
import PokerHand.Hands.Straight;
import PokerHand.Hands.StraightFlush;
import PokerHand.Hands.ThreeOfAKind;
import PokerHand.Hands.TwoPair;

public class HandComparator {
	public static Pair<Player, String> CompareHand(Player one, Player two) {
		HandType handOne;
		HandType handTwo;

		// finds the best hand the the player can make with their cards
		handOne = findHand(one.GetHand());
		handTwo = findHand(two.GetHand());

		// Try to find the winner based of the cards used in both players hands
		Pair<Player, String> winner = findBetter(handOne, handTwo, one, two);

		// In case of tie, look at the remaining cards and
		// attempt to resolve the tie
		// if there is no remaining card, it will remain a tie
		while (winner.getKey() == null && handOne.GetUnusedCards().length > 0) {
			handOne = findHand(handOne.GetUnusedCards());
			handTwo = findHand(handTwo.GetUnusedCards());

			winner = findBetter(handOne, handTwo, one, two);
		}

		return winner;
	}

	// Returns the best hand the cards produce
	private static HandType findHand(Card[] c) {
		HandType hand;

		// high card
		hand = new HighCard(c);

		// pair
		HandType p = new PairCard(c);
		if (p.isValidHand())
			hand = p;

		// two pair
		p = new TwoPair(c);
		if (p.isValidHand())
			hand = p;

		// three of a kind
		p = new ThreeOfAKind(c);
		if (p.isValidHand())
			hand = p;

		// straight
		p = new Straight(c);
		if (p.isValidHand())
			hand = p;

		// flush
		p = new Flush(c);
		if (p.isValidHand())
			hand = p;

		// fullhouse
		p = new FullHouse(c);
		if (p.isValidHand())
			hand = p;

		// four of a kind
		p = new FourOfAKind(c);
		if (p.isValidHand())
			hand = p;

		// straight flush
		p = new StraightFlush(c);
		if (p.isValidHand())
			hand = p;

		return hand;
	}

	// Compares two hand, and returns the player that wins and the reason
	private static Pair<Player, String> findBetter(HandType handOne,
			HandType handTwo, Player one, Player two) {

		// starts off with no winner and no reason
		Player winner = null;
		String reason;

		// if player one has a strong hand based off of rank
		// such as three of a kind being strong then two of a kind
		// then set player one as the winner
		// then set the reason for player one being the winner

		// else see if player two wins based off of hand rank

		// else see which player has a higher card based off of
		// cards used and sets winner the winner and reason based off that

		// if that is still a tie then the reason is set as TIE
		// and the winner remains null
		if (handOne.GetTypeRank() > handTwo.GetTypeRank()) {
			winner = one;
			reason = getReasonBetterType(handOne.GetTypeRank(),
					handOne.GetUsedCards());
		} else if (handOne.GetTypeRank() < handTwo.GetTypeRank()) {
			winner = two;
			reason = getReasonBetterType(handTwo.GetTypeRank(),
					handOne.GetUsedCards());
		} else {
			Card p1HighCard = new HighCard(handOne.GetUsedCards())
					.GetUsedCards()[0];
			Card p2HighCard = new HighCard(handTwo.GetUsedCards())
					.GetUsedCards()[0];
			if (p1HighCard.GetIntegerValue() > p2HighCard.GetIntegerValue()) {
				winner = one;
				reason = getReasonBetterType(handOne.GetTypeRank(),
						handOne.GetUsedCards());
			} else if (p1HighCard.GetIntegerValue() < p2HighCard
					.GetIntegerValue()) {
				winner = two;
				reason = getReasonBetterType(handTwo.GetTypeRank(),
						handTwo.GetUsedCards());
			} else
				reason = "Tie.";
		}
		return new Pair<Player, String>(winner, reason);
	}

	// returns the string meaning for victory
	private static String getReasonBetterType(Integer left, Card[] cards) {
		String reason = "";

		switch (left) {
		case 1:
			reason = "high card: " + cards[0].GetValue();
			break;
		case 2:
			reason = "pair";
			break;
		case 3:
			reason = "two pairs";
			break;
		case 4:
			reason = "three of a kind";
			break;
		case 5:
			reason = "straight";
			break;
		case 6:
			reason = "flush";
			break;
		case 7:
			reason = "full house";
			break;
		case 8:
			reason = "four of a kind";
			break;
		case 9:
			reason = "straight flush";
			break;
		default:
			break;
		}

		return reason;
	}
}
