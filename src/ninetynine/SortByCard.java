package ninetynine;

import java.util.Comparator;

/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */

/**
 *
 */
public class SortByCard implements Comparator<Card> {
  
  public int compare(Card a, Card b) {
    return a.getRankInt() - b.getRankInt();
  }

}
