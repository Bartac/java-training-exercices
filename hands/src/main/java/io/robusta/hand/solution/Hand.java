package io.robusta.hand.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import io.robusta.hand.Card;
import io.robusta.hand.CardColor;
import io.robusta.hand.HandClassifier;
import io.robusta.hand.HandValue;
import io.robusta.hand.interfaces.IDeck;
import io.robusta.hand.interfaces.IHand;
import io.robusta.hand.interfaces.IHandResolver;

public class Hand extends TreeSet<Card> implements IHand{

	
	private static final long serialVersionUID = 7824823998655881611L;

	@Override
	public Set<Card> changeCards(IDeck deck, Set<Card> cards) {
		// For exemple remove three cards from this hand
        // , and get 3 new ones from the Deck
        // returns the new given cards
		return null;
	}


	@Override
	public boolean beats(IHand villain) {
		return false;
	}

	@Override
	public IHand getHand() {
		return this;
	}

	@Override
	public HandClassifier getClassifier() {
		
		return this.getValue().getClassifier();
	}

	@Override
	public boolean isStraight() {

		return false;
	}

	@Override
	public boolean isFlush() {

		return true;
	}


    /**
     * Returns number of identical cards
     * 5s5cAd2s3s  has two cardValue of 5
     */
	@Override
	public int number(int cardValue) {
		int result = 0;
		for (Card current : this){
			if (current.getValue() == cardValue){
				result++;
			}
		}
		return result;
	}


    /**
     * The fundamental map
     * Check the tests and README to understand
     */
	@Override
	public HashMap<Integer, List<Card>> group() {
		HashMap<Integer, List<Card> > map = new HashMap<>();

        // fill the map

		return map;
	}


    // different states of the hand
	int mainValue;
	int tripsValue;
	int pairValue;
	int secondValue;
	TreeSet<Card> remainings;


    /**
     * return all single cards not used to build the classifier
     * @param map
     * @return
     */
    TreeSet<Card>getGroupRemainingsCard(Map<Integer, List<Card>> map){
        TreeSet<Card> groupRemaining = new TreeSet<>();
        // May be adapted at the end of project:
        // if straight or flush : return empty
        // If High card, return 4 cards

        for (List<Card> group :map.values()){
            if (group.size() ==1){
                groupRemaining.add(group.get(0));
            }
        }
        return groupRemaining;
    }


	@Override
	public boolean isPair() {

			return false;	

		
	}


	@Override
	public boolean isDoublePair() {
		return false;
	}


	@Override
	public boolean isHighCard() {

		return true;
	}


	@Override
	public boolean isTrips() {

		return false;
	}



	@Override
	public boolean isFourOfAKind() {

			return false;	

		
		
	}


	
	@Override
	public boolean isFull() {
		return false;
	}


	@Override
	public boolean isStraightFlush() {
		return false;
	}


	@Override
	public HandValue getValue() {
		HandValue handValue = new HandValue();

		// Exemple for FourOfAKind ; // do for all classifiers
		if(this.isFourOfAKind()){
			handValue.setClassifier(HandClassifier.FOUR_OF_A_KIND);
			handValue.setLevelValue(this.mainValue);
			handValue.setOtherCards(this.remainings); // or this.getRemainings()
			return handValue;
		}

		return handValue;
	}


	@Override
	public boolean hasCardValue(int level) {

		return false;
	}


	@Override
	public boolean hasAce() {
		return false;
	}


	@Override
	public int highestValue() {
        // ace might be the highest value
		return 0;
	}


	@Override
	public int compareTo(IHandResolver o) {
		return 0;
	}

	
}
