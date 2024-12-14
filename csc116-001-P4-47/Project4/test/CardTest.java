import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests Card class
 * 
 * @author Jessica Young Schmidt
 * @author Jayani Sivakumar
 */
public class CardTest {

    /** three of clubs */
    private Card c3;

    /** five of diamonds */
    private Card d5;

    /** eight of hearts */
    private Card h8;

    /** six of clubs */
    private Card c6;

    /** queen of spades */
    private Card qs;

    /** seven of spades */
    private Card s7;


    /**
     * The value of a queen.
     */
    public static final int QUEEN_VALUE = 12;

    /**
     * Sets up field for testing
     */
    @BeforeEach
    public void setUp() {
        c3 = new Card('c', 3);
        d5 = new Card('d', 5);
        h8 = new Card('h', 8);
        c6 = new Card('c', 6);
        qs = new Card('s', QUEEN_VALUE);
        s7 = new Card('s', 7);
    }

    /**
     * Test invalid constructor parameters
     */
    @Test
    public void testInvalidConstructorParameters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Card('a', 33),
                "invalid suit");
        assertEquals("Invalid suit", exception.getMessage(), "invalid suit - exception message");

        exception = assertThrows(IllegalArgumentException.class, () -> new Card('c', 1),
                "invalid value (1)");
        assertEquals("Invalid value", exception.getMessage(),
                "invalid value (1) - exception message");
    }
    

    /**
     * Test getSuit for three of clubs
     */
    @Test
    public void testGetSuitA() {
        assertEquals('c', c3.getSuit(), "Test getSuit for three of clubs");
    }

    /**
     * Test getSuit for five of diamonds
     */
    @Test
    public void testGetSuitB() {
        assertEquals('d', d5.getSuit(), "Test getSuit for five of diamonds");     
    }

    /**
     * Test getValue for three of clubs
     */
    @Test
    public void testGetValueA() {
        assertEquals(3, c3.getValue(), "Test getValue for three of clubs");
    }

    /**
     * Test getValue for five of diamonds
     */
    @Test
    public void testGetValueB() {
        assertEquals(5, d5.getValue(), "Test getValue for five of diamonds");
    }

    /**
     * Test hasBeenPlayed
     */
    @Test
    public void testHasBeenPlayed() {
        assertFalse(c3.hasBeenPlayed(), "Test hasBeenPlayed for three of clubs before played");
        c3.setPlayed(true);
        assertTrue(c3.hasBeenPlayed(), "Test hasBeenPlayed for three of clubs after played");
    }
    
    /**
     * Test setPlayed method with true and false for three of clubs
     */
    @Test
    public void testSetPlayed() {
        c3.setPlayed(true);
        assertTrue(c3.hasBeenPlayed(), "Test setPlayed method for three of clubs with true");
        c3.setPlayed(false);
        assertFalse(c3.hasBeenPlayed(), "Test setPlayed method for three of clubs with false");   
    }
       

    /**
     * Test isHeart for three of clubs
     */
    @Test
    public void testIsHeartA() {
        assertFalse(c3.isHeart(), "Test isHeart for three of clubs");
    }

    /**
     * Test isHeart for eight of hearts
     */
    @Test
    public void testIsHeartB() {
        assertTrue(h8.isHeart(), "Test isHeart for eight of hearts");
    }

    /**
     * Test toString for three of clubs
     */
    @Test
    public void testToStringA() {
        assertEquals("c3", c3.toString(), "Test toString for three of clubs");
    }

    /**
     * Test toString for five of diamonds
     */
    @Test
    public void testToStringB() {
        assertEquals("d5", d5.toString(), "Test toString for five of diamonds");
    }    

    /**
     * Test equals for three of clubs
     */
    @Test
    public void testEqualsA() {
        assertTrue(c3.equals(c3), "Test equals for three of clubs");
    }

    /**
     * Test equals for three of clubs and five of diamonds
     */
    @Test
    public void testEqualsB() {
        assertFalse(c3.equals(d5), "Test equals for three of clubs and five of diamonds");
    }

    /**
     * Test equals for three of clubs and six of diamonds.
     */
    @Test
    public void testEqualsC() {
        assertFalse(c3.equals(c6), "Test equals for two cards with same suit but" 
            + "different numbers");     
    }

    /**
     * Test equals for same three of clubs but different hasBeenPlayed status.
     */
    @Test
    public void testEqualsD() {
        Card card1 = new Card('c', 3);
        Card card2 = new Card('c', 3);
    
        card1.setPlayed(true);
        card2.setPlayed(false);
        assertFalse(card1.equals(card2), "Test equals for cards with same suit"
            + "and same value but different hasBeenPlayed");
    }

    /**
     * Test compareTo for three of clubs and three of spades
     */
    @Test
    public void testCompareToA() {
        Card s3 = new Card('s', 3);
        assertTrue(c3.compareTo(s3) < 0, "Test compareTo for three of clubs and three of spades");
    }

    /**
     * Test compareTo for three of clubs and two of clubs
     */
    @Test
    public void testCompareToB() {
        Card c2 = new Card('c', 2);
        assertTrue(c3.compareTo(c2) > 0,"Test compareTo for three of clubs and two of clubs");
    }

    /**
     * Test compareTo for three of clubs and two of hearts
     */
    @Test
    public void testCompareToC() {
        Card h2 = new Card('h', 2);
        assertTrue(h2.compareTo(c3) > 0, "Test compareTo for two of hearts and three of clubs");
    }

    /**
     * Test compareTo for three of clubs and four of clubs
     */
    @Test
    public void testCompareToD() {
        Card c4 = new Card('c', 4);
        assertTrue(c3.compareTo(c4) < 0, "Test compareTo for three of clubs and four of clubs");
    }

    /**
     * Test compareTo for three of clubs and three of clubs
     */
    @Test
    public void testCompareToE() {
        Card c3Two = new Card('c', 3);
        assertEquals(0, c3.compareTo(c3Two), 
                     "Test compareTo for three of clubs and three of clubs");
    }

    /**
     * Test isQueenOfSpades for three of clubs
     */
    @Test
    public void testIsQueenOfSpadesA() {
        assertFalse(c3.isQueenOfSpades(), "Test isQueenOfSpades for three of clubs");
    }

    /**
     * Test isQueenOfSpades for queen of spades
     */
    @Test
    public void testIsQueenOfSpadesB() {
        assertTrue(qs.isQueenOfSpades(), "Test isQueenOfSpades for Queen of Spades");
    }

    /**
     * Test isQueenOfSpades for seven of spades
     */
    @Test
    public void testIsQueenOfSpadesC() {
        assertFalse(s7.isQueenOfSpades(), "Test isQueenOfSpades for seven of spades");
    }

    /**
     * Test isHigherThan for four of clubs and three of clubs
     */
    @Test
    public void testIsHigherA() {
        Card c4 = new Card('c', 4);
        assertTrue(c4.isHigherThan(c3), "Test isHigherThan for four of clubs and three of clubs");
    }

    /**
     * Test isHigherThan for two of diamonds and three of clubs
     */
    @Test
    public void testIsHigherB() {
        Card d2 = new Card('d', 2);
        assertFalse(d2.isHigherThan(c3), "Test isHigherThan for two of diamonds"
            + "and three of clubs");
    }

    /**
     * Test isHigherThan for two of clubs and three of clubs
     */
    @Test
    public void testIsHigherC() {
        Card c2 = new Card('c', 2);
        assertFalse(c2.isHigherThan(c3), "Test isHigherThan for two of clubs and three of clubs");
    }

    /**
     * Tests values for public constants
     */
    @Test
    public void testClassConstants() {
        assertEquals('c', Card.CLUBS, "Test CLUBS constant");
        assertEquals('d', Card.DIAMONDS, "Test DIAMONDS constant");
        assertEquals('s', Card.SPADES, "Test SPADES constant");
        assertEquals('h', Card.HEARTS, "Test HEARTS constant");
        assertEquals(2, Card.LOWEST_VALUE, "Test LOWEST_VALUE constant");
        assertEquals(14, Card.HIGHEST_VALUE, "Test HIGHEST_VALUE constant");
        assertEquals(12, Card.QUEEN_VALUE, "Test QUEEN_VALUE constant");
    }

}
