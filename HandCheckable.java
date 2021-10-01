package chapter2_2;

public interface HandCheckable extends Iterable<Card>{
	
	/**
	 * @param a card to check
	 * @return true if pCard is a card in this hand
	 */
	public boolean contains(Card pCard);
	
	/**
	 * @return true if there are not cards in this hand
	 */
	public boolean isEmpty();
	
	/**
	 * @return the size of the card list in this hand
	 */
	public int size();

	/**
	 * @return true if the hand is full
	 */
	public boolean isFull();


}
