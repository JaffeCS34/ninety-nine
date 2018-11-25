package ninetynine;

import java.util.Collections;

/**
 * Player object. Students will extend this class
 * and override the getNextMove method
 * 
 * @author Mr. Jaffe
 * @version 1.0
 */
public class TestPlayer
{
  private Deck deck;
  private boolean dead;
  
  /**
   * Gets the player name
   * @return        Player name
   */
  public String getName() {
    return this.getClass().getSimpleName();
  }
  
  /**
   * The player must override getNextMove
   * @param board Game board
   * @return A position coordinate pair of his/her next move. Returns null
   *          if no move is available
   */
  Deck getNextMove(int total) {
    int i = 0;
    while (i < this.deck.getCardCount()) {
      Deck deck = new Deck();
      deck.add(this.deck.getCards().get(i));
      if (Utilities.isLegalMove(deck, total))
    }
    return null;
  };

}
