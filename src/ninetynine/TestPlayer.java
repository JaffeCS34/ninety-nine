package ninetynine;

import java.util.Collections;

/**
 * Player object. Students will extend this class
 * and override the getNextMove method
 * 
 * @author Mr. Jaffe
 * @version 1.0
 */
public class TestPlayer extends Player {
  
  /**
   * Player constructor
   */
  public TestPlayer() {
    super();
  }
  
  /**
   * Player constructor with teamName added as instance variable
   * If teamName is not set, then the class name is used when printed
   * during game play
   */
  public TestPlayer(String teamName) {
    super(teamName);
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
      deck.add(this.deck.deal());
      if (Utilities.isLegalMove(deck, total))
        return deck;
    }
    return null;
  };

}
