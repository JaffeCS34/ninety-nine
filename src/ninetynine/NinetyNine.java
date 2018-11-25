/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package ninetynine;

/**
 *
 * @author Roger Jaffe
 */
public class NinetyNine {

  Player[] players;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Player[] players = new Player[]{
      new Player(), 
      new Player(), 
      new Player(), 
      new Player()
    };
    Controller c = new Controller(players);
    c.run();
  }

}
