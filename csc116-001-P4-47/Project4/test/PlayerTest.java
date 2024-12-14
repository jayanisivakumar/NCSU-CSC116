import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests Player class
 * 
 * @author Jessica Young Schmidt
 * @author Jayani Sivakumar
 */
public class PlayerTest {

    /** Test player */
    private Player testPlayer;

    /** Three of clubs */
    private Card c3;

    /**
     * Set up fields for tests
     */
    @BeforeEach
    public void setUp() {
        testPlayer = new Player("Human");
        c3 = new Card('c', 3);
    }

    /**
     * Test constructor of Player class.
     */
    @Test
    public void testConstructor() {
        assertEquals("Human", testPlayer.getName(), "Test constructor: getName");
        for (int i = 0; i < 13; i++) {
            assertNull(testPlayer.getCard(i), "Test that card " + i + " is null");
        }
        assertEquals(0, testPlayer.getHandPoints(), "Test constructor: getHandPoints");
        assertEquals(0, testPlayer.getOverallPoints(), "Test constructor: getOverallPoints");
    }

    /**
     * Test adding a single card to the player's hand.
     */
    @Test
    public void testAddCardA() {
        // Test that there are no cards in hand
        String id = "test that first card of hand is null";
        assertNull(testPlayer.getCard(0), id);

        // Add a card to the hand
        testPlayer.addCard(c3);
        id = "test that card is added as first card";
        assertEquals(new Card('c', 3), testPlayer.getCard(0), id);
        for (int i = 1; i < 13; i++) {
            assertNull(testPlayer.getCard(i), "Test that card " + i + " is null");
        }
    }

    /**
     * Test adding multiple cards to the player's hand.
     */
    @Test
    public void testAddCardB() {
        // Test that there are no cards in hand initially
        String id = "test that first card of hand is null";
        assertNull(testPlayer.getCard(0), id);
    
        // Add multiple cards to the hand
        testPlayer.addCard(new Card('c', 3));
        testPlayer.addCard(new Card('d', 5));
        testPlayer.addCard(new Card('s', 8));
        testPlayer.addCard(new Card('h', 11));

    
        id = "test that cards are added correctly";
        assertEquals(new Card('c', 3), testPlayer.getCard(0), id);
        assertEquals(new Card('d', 5), testPlayer.getCard(1), "Test that card 1 is correct");
        assertEquals(new Card('s', 8), testPlayer.getCard(2), "Test that card 2 is correct");
        assertEquals(new Card('h', 11), testPlayer.getCard(3), "Test that card 3 is correct");
    
        // Test that the rest of the hand is still null
        for (int i = 4; i < 13; i++) {
            assertNull(testPlayer.getCard(i), "Test that card " + i + " is null");
        }
        
    }

    /**
     * Test getting a card at an invalid index.
     */
    @Test
    public void testGetCardException() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> testPlayer.getCard(-1), "Invalid index");
        assertEquals("Invalid index", exception.getMessage(), "Invalid index - exception message");
    }

    /**
     * Test hasActiveCardOfSuit method when the player's hand is not full.
     * Expects an IllegalStateException to be thrown.
     */
    @Test
    public void testHasActiveCardOfSuitException() {
        Exception exception = assertThrows(IllegalStateException.class,
            () -> testPlayer.hasActiveCardOfSuit('c'), "Hand not full");
        assertEquals("Hand not full", exception.getMessage(), "Hand not full - exception message");
    }

    /**
     * Test onlyHasHearts method when the player's hand is not full.
     * Expects an IllegalStateException to be thrown.
     */
    @Test
    public void testOnlyHasHeartsException() {
        Exception exception = assertThrows(IllegalStateException.class,
            () -> testPlayer.onlyHasHearts(), "Hand not full");
        assertEquals("Hand not full", exception.getMessage(), "Hand not full - exception message");
    }

    /**
     * Test getCardNames method when the player's hand is not full.
     * Expects an IllegalStateException to be thrown.
     */
    @Test
    public void testGetCardNamesException() {
        Exception exception = assertThrows(IllegalStateException.class,
            () -> testPlayer.getCardNames(), "Hand not full");
        assertEquals("Hand not full", exception.getMessage(), "Hand not full - exception message");
    }


    /**
     * test hasActiveCardOfSuit for hand with all cards of suit already played
     */     
    @Test
    public void testHasActiveCardOfSuitA() {
        // hand has to be full
        testPlayer.addCard(c3);
        for (int i = 2; i < 14; i++) {
            testPlayer.addCard(new Card (Card.HEARTS, i));
        }
        Card card = testPlayer.getCard(0);
        card.setPlayed(true);
        assertFalse(testPlayer.hasActiveCardOfSuit('c'));
    }

    /**
     * Test hasActiveCardOfSuit method when the player's hand contains all clubs 
     * except one card that has been played.
     * Expects the method to return true.
     */
    @Test
    public void testHasActiveCardOfSuitB() {
        // hand has to be full
        testPlayer.addCard(c3);
        for (int i = 2; i < 14; i++) {
            testPlayer.addCard(new Card (Card.CLUBS, i));
        }
        Card card = testPlayer.getCard(0);
        card.setPlayed(true);
        assertTrue(testPlayer.hasActiveCardOfSuit('c'));
    }

    /**
     * Test hasActiveCardOfSuit method when the player's hand contains all 
     * diamonds except one card that has been played.
     * Expects the method to return false.
     */
    @Test
    public void testHasActiveCardOfSuitC() {
        // hand has to be full
        testPlayer.addCard(c3);
        for (int i = 2; i < 14; i++) {
            testPlayer.addCard(new Card (Card.DIAMONDS, i));
        }
        Card card = testPlayer.getCard(0);
        card.setPlayed(true);
        assertFalse(testPlayer.hasActiveCardOfSuit('c'));
    }

    /**
     * Test onlyHasHearts method when the player's hand contains only hearts.
     * Expects the method to return true.
     */
    @Test
    public void testOnlyHasHeartsA() {
        for (int i = 2; i <= 14; i++) {
            testPlayer.addCard(new Card (Card.HEARTS, i));
        }
        assertTrue(testPlayer.onlyHasHearts(), "player has only hearts");
    }

    /**
     * Test onlyHasHearts method when the player's hand contains cards other than hearts.
     * Expects the method to return false.
     */
    @Test
    public void testOnlyHasHeartsB() {
        for (int i = 2; i <= 14; i++) {
            testPlayer.addCard(new Card(Card.CLUBS, i));
        }
        assertFalse(testPlayer.onlyHasHearts(), "Player does not have hearts");
    }
    
    /**
     * Test onlyHasHearts method when the player's hand contains both hearts and non-heart cards.
     * Expects the method to return false.
     */
    @Test
    public void testOnlyHasHeartsC() {
        // Add hearts to the player's hand
        for (int i = 2; i <= Player.CARDS_IN_HAND; i++) {
            testPlayer.addCard(new Card(Card.HEARTS, i));
        }
        
        // Add a non-heart card to the player's hand
        testPlayer.addCard(new Card(Card.SPADES, 9));
        assertFalse(testPlayer.onlyHasHearts(), "Player has both hearts and non-hearts");
    }
    
    /**
     * Test getCardNames method to ensure it returns the correct 
     * card names for all clubs in the player's hand.
     */
    @Test
    public void testGetCardNames() {
        String[] names = new String[13];
        for (int i = 2; i <= 14; i++) {
            testPlayer.addCard(new Card (Card.CLUBS, i));
            names[i - 2] = "" + Card.CLUBS + i;
        }
        assertArrayEquals(names, testPlayer.getCardNames(), "test getCardNames() for all clubs");  
    }

    /**
     * Test addToHandPoints method to ensure it correctly adds 
     * points to the player's hand and overall points.
     */
    @Test
    public void testAddToHandPoints() {
        // Add points to hand and test getHandPoints and getOverallPoints
        testPlayer.addToHandPoints(5);
        assertEquals(5, testPlayer.getHandPoints(), "Test addToHandPoints: getHandPoints");
        assertEquals(5, testPlayer.getOverallPoints(), "Test addToHandPoints: getOverallPoints");

        // Add more points to hand and test getHandPoints and getOverallPoints
        testPlayer.addToHandPoints(10);
        assertEquals(15, testPlayer.getHandPoints(), "Test addToHandPoints: getHandPoints");
        assertEquals(15, testPlayer.getOverallPoints(), "Test addToHandPoints: getOverallPoints");
    }

    /**
     * Test resetHandPoints method to ensure it 
     * correctly resets the hand points to zero.
     */
    @Test
    public void testResetHandPoints() {
        // Add points to hand
        testPlayer.addToHandPoints(5);
        assertEquals(5, testPlayer.getHandPoints(), "Test resetHandPoints:"
            + "getHandPoints before reset");

        // Reset hand points and test getHandPoints
        testPlayer.resetHandPoints();
        assertEquals(0, testPlayer.getHandPoints(), "Test resetHandPoints:"
            + "getHandPoints after reset");
    }

    /**
     * Test dumpCards method to ensure it correctly 
     * resets the player's hand by setting all cards to null.
     */
    @Test
    public void testDumpCards() {
        
        testPlayer.addCard(c3);
        String id = "test dump Cards(): cards [0] not null before dump";
        assertEquals(new Card('c', 3), testPlayer.getCard(0), id);
        testPlayer.dumpCards();
        id = "test dumpCards: cards[0] = null after dump";
        assertEquals(null, testPlayer.getCard(0), id);
        testPlayer.addCard(c3);
        id = "test dump Cards(): next was reset to 0";
        assertEquals(new Card('c', 3), testPlayer.getCard(0), id);       
    }
    
    /**
     * Tests toString
     */
    @Test
    public void testToString() {
        assertEquals("Human: 0", testPlayer.toString(), "Test toString");
    }

    /**
     * Tests toString method to ensure it returns the correct 
     * string representation of the player with non-zero points.
     */
    @Test
    public void testToStringNonZeroPoints() {
        testPlayer.addToHandPoints(15);
        assertEquals("Human: 15", testPlayer.toString(), "Test toString for non-zero points");
    }

    /**
     * Test getMove method
     */
    @Test
    public void testGetMove() {

        Card c2 = new Card('c', 2);
        Card c12 = new Card('c', 12);
        Card d4 = new Card('d', 4);
        Card d5 = new Card('d', 5);
        Card d7 = new Card('d', 7);
        Card d12 = new Card('d', 12);
        Card s5 = new Card('s', 5);
        Card s11 = new Card('s', 11);
        Card s12 = new Card('s', 12);
        Card h2 = new Card('h', 2);
        Card h3 = new Card('h', 3);
        Card h5 = new Card('h', 5);

        testPlayer.addCard(c3);
        testPlayer.addCard(h5);
        testPlayer.addCard(d7);
        testPlayer.addCard(s12);
        testPlayer.addCard(c12);
        testPlayer.addCard(c2);
        testPlayer.addCard(d4);
        testPlayer.addCard(h2);
        testPlayer.addCard(s5);
        testPlayer.addCard(s11);
        testPlayer.addCard(d5);
        testPlayer.addCard(h3);
        testPlayer.addCard(d12);

        // Test first round (trick) and the computer player has the 2 of Clubs
        Card c2Copy = new Card('c', 2);
        c2Copy.setPlayed(true);
        assertEquals(c2Copy, testPlayer.getMove(null, true, false), "Has 2 of clubs");
        Card c3copy = new Card('c', 3);
        c3copy.setPlayed(true);
        assertEquals(c3copy, testPlayer.getMove(new Card('c', 4), true, false), "Lowest clubs");
    }
}