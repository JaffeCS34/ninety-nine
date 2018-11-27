package ninetynine;

import java.util.Comparator;

/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */

/**
 * Comparator that sorts by card rank only
 */
public class SortByCard implements Comparator<Card> {
  
  @Override
  public int compare(Card a, Card b) {
    return a.getRankInt() - b.getRankInt();
  }

}
