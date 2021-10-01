package chapter2_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Hand implements Comparable<Hand>, HandCheckable{
	
	//The max number of cards that can be stored in the hand
	private final int aMaxNum;
	
	//The list of cards in this hand
	private final List<Card> aCards = new ArrayList<>();

	//The way to compare the cards (that is used to keep the cards sorted)
	private final Comparator<Card> aCardComparator;
	
	/**
	 * Crate a new, empty hand, which can hold a maximum
	 * of pMaxNum cards. 
	 * 
	 * The second parameter specifies how the cards in the hand 
	 * should be sorted. 
	 * 
	 * @param pMaxNum the max number of cards allowed in this hand
	 * @pre pMaxNum>0
	 */
	public Hand(int pMaxNum, Comparator<Card> pCardComparator) {
		assert pMaxNum>0;
		aMaxNum = pMaxNum;
		
		aCardComparator = pCardComparator;
		Collections.sort(aCards, aCardComparator);
	}
	
	
	/**
	 * Add a card into the hand. Still keep it sorted.
	 * @param pCard
	 */
	public void add(Card pCard) {
		assert pCard != null;
		//The Hand should not be full
		assert !isFull();
		/*
		 * Since the "card" objects are immutable
		 * (They can not be modified once created),
		 * we can directly add it into our list
		 * (Problem with storing an external reference doesn't happen)
		 */
		aCards.add(pCard);
		
		aCards.sort(aCardComparator);
	};
	
	/**
	 * Remove pCard if it is in the hand. If it 
	 * is not in the hand, do nothing.
	 * 
	 * @param pCard The card to remove
	 */
	public void remove(Card pCard) {
		assert pCard != null;
		
		aCards.remove(pCard);
		//Always keep the hand sorted
		aCards.sort(aCardComparator);
	};
	
	/**
	 * @param pCard
	 * @return true if pCard is a card in this hand
	 */
	public boolean contains(Card pCard) {
		assert pCard != null;
		return aCards.contains(pCard);
	};
	
	/**
	 * @return true if there are not cards in this hand
	 */
	public boolean isEmpty() {
		return size()==0;
	};
	
	/**
	 * Get the size of the Hand (How many cards are there right now?)
	 */
	public int size() {
		return aCards.size();
	};
	

	/**
	 * @return true if the size of the card list 
	 * exceeds the max number allow 
	 */
	public boolean isFull() {
		return aCards.size()>=aMaxNum;
	};


	/**
	 * Compare the two "Hand"s by increasing
	 * number of cards in the hand
	 */
	public int compareTo(Hand pHand) {
		assert pHand != null;
		return this.size() - pHand.size();
	}
	
	/**
	 * Count the number of cards in the Hand
	 * that have the particular rank.
	 * @param pRank
	 * @return number of cards
	 */
	private int countOneRank(Rank pRank) {
		int count = 0;
		for( Card card : this) {
			if(card.getRank().equals(pRank)) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * @param pRank
	 * @return The sum of the ordinal of the cards in a hand
	 */
	private int sumRank() {
		int sum = 0;
		for( Card card : aCards) {
			sum += card.getRank().ordinal();
		}
		return sum;
	}
	
	
	//A factory method that generates a comparator
	public static Comparator<Hand> byIncreasingSize(){
		return new Comparator<Hand>() {
			@Override
			public int compare(Hand h1, Hand h2) 
			{
				return h1.size() - h2.size();
			}
		};
	}
	
	//A factory method that generates a comparator
	public static Comparator<Hand> byDecreasingSize(){
		return new Comparator<Hand>() {
			@Override
			public int compare(Hand h1, Hand h2) 
			{
				return h2.size() - h1.size();
			}
		};
	}
	
	/**
	 * A factory method that generates a comparator
	 * to compare the number of cards with a user-specified rank
	 * in the hand
	 * @param pRank
	 * @return
	 */
	public static Comparator<Hand> byNumOfOneRank(Rank pRank){
		
		return new Comparator<Hand>() {
			@Override
			public int compare(Hand h1, Hand h2) 
			{
				return h1.countOneRank(pRank) - h2.countOneRank(pRank);
			}
		};
	}
	
	/**
	 * Compare two hands according to poker hands rules.
	 * (The sum of their ranks)
	 * @return the comparator
	 */
	public static Comparator<Hand> byPokerStrength(){
		return new Comparator<Hand>() {
			@Override
			public int compare(Hand h1, Hand h2) 
			{
				assert h1.size() == 5 && h2.size()==5;
				
				return h1.sumRank() - h2.sumRank();
			}
		};
	}


	@Override
	/**
	 * return the iterator to iterate over all the cards in the hand
	 */
	public Iterator<Card> iterator() {
		return aCards.iterator();
	}

}
