package chapter2_2;

/**
 * Implementation of a playing card. This class yields immutable objects.
 */
public class Card implements Comparable<Card>
{
	
	private Rank aRank;
	private Suit aSuit;
	
	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	
	@Override
	public int compareTo(Card pCard) {
		
		//If the Ranks are the same, compare the suit
		if(this.getRank().compareTo(pCard.getRank())==0) {
			return this.getSuit().compareTo(pCard.getSuit());
		}
		//If the Ranks are different, we orders them 
		return this.getRank().compareTo(pCard.getRank());
	}
	
	/**
	 * @return The rank of the card.
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	@Override
	public String toString() {
		
		return aRank + " of " + aSuit;
	}

}
