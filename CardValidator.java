package chapter2_2;

public interface CardValidator {

	/**
	 * Return whether a card is to be accepted by the client code
	 * 
	 * @param pCard
	 * @return true if the card is to be accepted
	 * @pre pCard != null
	 */
	public boolean isValid(Card pCard);
}
