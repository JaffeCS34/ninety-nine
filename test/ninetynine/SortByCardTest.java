/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package ninetynine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roger Jaffe
 */
public class SortByCardTest {
  
  public SortByCardTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of compare method, of class SortByCard.
   */
  @Test
  public void testCompare() {
    System.out.println("compare");
    Card a = new Card(Constants.FIVE, Constants.DIAMONDS);
    Card b = new Card(Constants.FOUR, Constants.SPADES);
    Card c = new Card(Constants.FOUR, Constants.HEARTS);
    SortByCard sbc = new SortByCard();
    assertEquals(1, sbc.compare(a, b));
    assertEquals(-1, sbc.compare(b, a));
    assertEquals(0, sbc.compare(b, b));
  }
  
}
