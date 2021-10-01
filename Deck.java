package chapter2_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a deck of playing cards. In this version, the cards in the 
 * deck are stored in a list and the list of cards in the deck can 
 * be obtained by client code using an immutable wrapper object.
 */
public class Deck implements Iterable<Card>
{
	private List<Card> aCards = new ArrayList<>();
	
	/**
	 * Initialize the deck with an existing deck
	 * @param pDeck
	 */
	public Deck(Deck pDeck) 
	{
		assert pDeck != null;
		for (Card card : pDeck) {
			aCards.add(card);
		}
	}
	
	/**
	 * This method receive a cardValidator as input,
	 * use it to validate every card in the Deck and 
	 * remove the invalid cards
	 * @param cv
	 */
	public Deck( CardValidator cv ) 
	{
		//Add all cards into the deck
		for( Suit suit : Suit.values() )
		{
            for( Rank rank : Rank.values() )
            {
                aCards.add( new Card( rank, suit ));
            }
		}
		
		//Remove invalid cards
		for (Card card : getCards()) {
			if (!cv.isValid(card)) {
				aCards.remove(card);
			}
		}
		
		//Shuffle the cards
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
	public void shuffle()
	{
		Collections.shuffle(aCards);
	}
	
	/**
	 * Because "card" objects are comparable, 
	 * we can sort them in a collection.
	 */
	public void sort()
	{
		Collections.sort(aCards);
	}
	
	
	
	/**
	 * Places pCard on top of the deck.
	 * @param pCard The card to place on top
	 * of the deck.
	 * @pre pCard !=null
	 */
	public void push(Card pCard)
	{
		assert pCard != null;
		aCards.add(pCard);
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card draw()
	{
		assert !isEmpty();
		return aCards.remove(aCards.size() - 1);
	}
	
	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	/**
	 * @return An unmodifiable list of all the cards in the deck.
	 */
	public List<Card> getCards()
	{
		return new ArrayList<Card>(aCards);
	}

	@Override
	/**
	 * Because the array object "aCards" already has 
	 * its own iterator, we can directly return it.
	 */
	public Iterator<Card> iterator() {
		return aCards.iterator();
	}
	
}


