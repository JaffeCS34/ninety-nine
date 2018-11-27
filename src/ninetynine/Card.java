package ninetynine;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Write a description of class Card here.
 * 
 * @author Roger Jaffe
 */
public class Card
{
  // instance variables - replace the example below with your own
  private String rank;
  private String suit;

  /**
   * Constructor for objects of class Card
   */
  public Card(String rank, String suit)
  {
    this.rank = rank;
    this.suit = suit;
  }
  
  /**
   * Get the card rank
   * @returns Card rank
   */
  public String getRank() {
    return this.rank;
  }
  
  public int getRankInt() {
    switch (this.rank) {
      case Constants.ACE:
        return 1;
      case Constants.TWO:
      case Constants.THREE:
      case Constants.FOUR:
      case Constants.FIVE:
      case Constants.SIX:
      case Constants.SEVEN:
      case Constants.EIGHT:
      case Constants.NINE:
      case Constants.TEN:
        return new Integer(this.rank);
      case Constants.JACK:
        return 11;
      case Constants.QUEEN:
        return 12;
      case Constants.KING:
        return 13;
      default:
        {
          try {
            throw new Exception("Invalid card rank");
          } catch (Exception ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }
    return 0;
  }
  
  public int getPointValue() {
    switch (this.rank) {
      case Constants.ACE:
        return 1;
      case Constants.TWO:
      case Constants.THREE:
      case Constants.FOUR:
      case Constants.FIVE:
      case Constants.SIX:
      case Constants.SEVEN:
      case Constants.EIGHT:
      case Constants.NINE:
      case Constants.TEN:
        return new Integer(this.rank);
      case Constants.JACK:
        return 0;
      case Constants.QUEEN:
        return -10;
      case Constants.KING:
        return Constants.NINETY_NINE;
      default:
        {
          try {
            throw new Exception("Invalid card rank");
          } catch (Exception ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }
    return 0;
  }
  
  /**
   * Get the card suit
   * @returns Card suit
   */
  public String getSuit() {
    return this.suit.toUpperCase();
  }
  
  public String toString() {
    return this.getRank()+" of "+this.getSuit();
  }
  
}
