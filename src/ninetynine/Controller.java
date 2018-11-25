package ninetynine;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * Game controller
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller
{
  
  Player[] players;
  Deck deck;
  int whoseTurn;
  int total;
  int direction;    // 1 = increasing order; -1 = decreasing order
  ArrayList<Player> finishOrder = new ArrayList<>();
  
  /**
   * Constructor for objects of class Controller
   * @param players
   */
  public Controller(Player[] players)
  {
    this.players = players;
    this.displayMatchup();
    this.init();
  }
  
  /**
   * Initialize game
   */
  private void init() {
    this.whoseTurn = 0;
    this.direction = 1;
    this.deck = new Deck();
    this.deck.newDeck();
    for (int c = 0; c < Constants.INITIAL_CARD_COUNT; c++) 
      for (int i = 0; i < players.length ; i++) 
        this.players[i].draw(this.deck);  
  }

  /**
   * Moves the turn pointer to the next player
   */
  private void getNextTurn() {
    this.whoseTurn = (this.whoseTurn + (this.direction)) % Constants.PLAYER_COUNT;
  }
  
  /**
   * Switches the player order the other way
   */
  private void switchOrder() {
    this.whoseTurn = this.whoseTurn * -1;
  }
  
  /**
   * Displays the match up with the player names
   */
  public void displayMatchup() {
    System.out.println("\n******* MATCHUPS *******");
    for (int i = 0; i < this.players.length; i++) {
      System.out.println("Player "+(i+1)+": "+this.players[i].getName());
    }
  }
  
  private int getPlayersStillAlive() {
    int total = 0;
    for (Player player : this.players) {
      if (player.isNotDead())
        total++;
    }
    return total;
  }
  
  private boolean isValidPlay(Deck play) {
    boolean retValue = false;
    if (play.getCardCount() == 2) {
      if (play.isPair()) {
        retValue = true;
      }
    } else if(play.getCardCount() == 1 && Utilities.isLegalMove(play, this.total)) {
      retValue = true;
    }
    return retValue;
  }
  
  /**
   * Run the game with the four players.  Player 1 always goes first
   */
  public int run() {
    boolean gameOver = false;
    try {
      // Print heading
      System.out.println("\nSTART OF GAME");

      // Delay so we can see the progression in the console
      TimeUnit.MILLISECONDS.sleep(Constants.DELAY);

      while (!gameOver) {
        Player p = this.players[this.whoseTurn];
        p.displayHand();
        Deck play = p.getNextMove(this.total);
        
        // Process the play
        if (play == null) {
          p.setDead();
          this.finishOrder.add(p);
        } else if (this.isValidPlay(play)) {
          this.total = Utilities.getNewTotal(play, this.total);
          p.remove(play);
          p.draw(this.deck);
        } else {
          p.setDead();
          this.finishOrder.add(p);
        }
        
        // Notify players of the cards that were played
        for (Player p1 : this.players) {
          if (p1.isNotDead()) 
            p1.cardsPlayed(play);
        }
        
        // Check to see if game is still going
        gameOver = this.getPlayersStillAlive() == 1;
      }
      
      System.out.println("Player "+(this.whoseTurn+1)+" "+this.players[this.whoseTurn].getName()+" WINS!");
      
    } catch (InterruptedException e) {
      System.out.println("OH NO!!! There was a time exception!\n");
      System.out.println(e.getMessage());
      return 0;
    }
    return 0;
  }
    
}
