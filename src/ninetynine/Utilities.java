package ninetynine;

import java.util.ArrayList;

/**
 * Write a description of class Utilities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utilities
{

  /**
   * Gets the new score when playing this card given the old score
   * @param deck Deck to check
   * @param total Current total
   * @return The new score
   */
  public static int getNewTotal(Deck deck, int total) {
    int retValue = total;
    ArrayList<Card> cards = deck.getCards();
    if (cards.size() == 1) {
      switch(cards.get(0).getRank()) {
        case Constants.ACE: retValue = total + 1;
        case Constants.TWO:
        case Constants.THREE: 
        case Constants.FOUR: 
        case Constants.FIVE: 
        case Constants.SIX: 
        case Constants.SEVEN:
        case Constants.EIGHT: 
        case Constants.NINE: 
        case Constants.TEN: 
          retValue = total + (new Integer(cards.get(0).getRank()));
        case Constants.QUEEN: retValue = total - 10;
        case Constants.KING: retValue = Constants.NINETY_NINE;
      }      
    }
    return retValue;
  }
  
  public static boolean isLegalMove(Deck deck, int total) {
    boolean retValue = false;
    ArrayList<Card> cards = deck.getCards();
    if (cards.size() == 2) {
      return (cards.get(0).getRank().equals(cards.get(1).getRank()));
    } else if (cards.size() == 1) {
      switch(cards.get(0).getRank()) {
        case Constants.JACK:
        case Constants.QUEEN:
        case Constants.KING:
          retValue = true;
        case Constants.ACE:
        case Constants.TWO:
        case Constants.THREE: 
        case Constants.FOUR: 
        case Constants.FIVE: 
        case Constants.SIX: 
        case Constants.SEVEN:
        case Constants.EIGHT: 
        case Constants.NINE: 
        case Constants.TEN: {
          retValue = total + (new Integer(cards.get(0).getRank())) <= Constants.NINETY_NINE;
        }        
      }
    }
    return retValue;
  }
}
