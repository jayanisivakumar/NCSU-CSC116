/**
 * The Card class represents a single playing card used in the
 * Hearts Game. A card consists of a suit and a value. Card values
 * range from 2 to 14, with the value 11 used for the Jack, 12 for 
 * the Queen, 13 for the King, and 14 for the Ace. 
 * 
 * This class provides methods to interact with cards, including
 * retrieving the suit and value, checking if a card has been played, 
 * setting the played status of a card, checking if a card is a Heart
 * or the Queen of Spades, comparing cards, and generating
 * a String representation of a card.
 * 
 * @author Jayani Sivakumar
 */
public class Card implements Comparable<Card> {

    /**
     * Clubs is represented by character 'c'.
     */
    public static final char CLUBS = 'c';

    /**
     * Diamonds is represented by character 'd'.
     */
    public static final char DIAMONDS = 'd';

    /**
     * Hearts is represented by character 'h'.
     */
    public static final char HEARTS = 'h';

    /**
     * Spades is represented by character 's'.
     */
    public static final char SPADES = 's';

    /**
     * The lowest numeric value for a card.
     */
    public static final int LOWEST_VALUE = 2;

    /**
     * The highest numeric value for a card.
     */
    public static final int HIGHEST_VALUE = 14;

    /**
     * The value of a jack.
     */
    public static final int JACK_VALUE = 11;
    
    /**
     * The value of a queen.
     */
    public static final int QUEEN_VALUE = 12;

    /**
     * The value of a king.
     */
    public static final int KING_VALUE = 13;

    /**
     * The value of an ace.
     */
    public static final int ACE_VALUE = 14;

    /**
     * a char that represents the suit shown on the card,
     * based on the values seen in the class constants, 
     * which are lowercase letters.
     */
    private char suit;

    /**
     * an integer that represents the value shown on the card (a Jack
     * would be 11, a Queen would be 12, a King would be 13, and an 
     * Ace would be 14)
     */
    private int value;

    /**
     * a boolean that knows whether or not the card has been played.
     */
    private boolean hasBeenPlayed;

    /**
     * This is the constructor of the class. 
     * It accepts a suit and a value to assign to the instance fields. 
     * Constructs a new Card with the given suit and value.
     *
     * @param suit  the suit of the card
     * @param value the value of the card
     * @throws IllegalArgumentException if the suit or value is invalid
     */
    public Card(char suit, int value) {
        if (suit != CLUBS && suit != DIAMONDS && suit != HEARTS && suit != SPADES) {
            throw new IllegalArgumentException("Invalid suit");
        }
        if (value < LOWEST_VALUE || value > HIGHEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.suit = suit;
        this.value = value;
        this.hasBeenPlayed = false;

    }

    /**
     * This is the getter method for the instance field that knows 
     * the suit of the card.
     *
     * @return the suit of the card
     */
    public char getSuit() {
        return suit;
    }

    /**
     * This is the getter method for the instance field 
     * that knows the value of the card. 
     *
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * This is the getter method for the instance field that
     * knows whether or not this card has been played yet.
     *
     * @return true if the card has been played, false otherwise
     */
    public boolean hasBeenPlayed() {
        return hasBeenPlayed;
    }

    /**
     * This is the setter method for the instance field that
     * knows whether this card has been played yet.
     *
     * @param played true if the card has been played, false otherwise
     */
    public void setPlayed(boolean played) {
        hasBeenPlayed = played;
    }

    /**
     * This method returns true if the card is of the suit Hearts. 
     * Otherwise, the method returns false.
     * Checks if the card has the suit Hearts.
     *
     * @return true if the card is of the suit Hearts, false otherwise
     */
    public boolean isHeart() {
        return suit == HEARTS;
    }

    /**
     * This method returns true if this card is the Queen 
     * of Spades. Otherwise, the method returns false.
     * Checks if the card is the Queen of Spades.
     *
     * @return true if the card is the Queen of Spades, false otherwise
     */
    public boolean isQueenOfSpades() {
        return suit == SPADES && value == QUEEN_VALUE;
    }

    /**
     * If this card is higher than the Card given as a 
     * parameter, this method returns true. Otherwise, the method returns false.
     * Checks if this card is higher than another card.
     *
     * @param other the other card to compare to
     * @return true if this card is higher than the other card, false otherwise
     */
    public boolean isHigherThan(Card other) {
        return suit == other.suit && value > other.value;
    }

    /**
     * This method returns whether this Card and o are equal.
     * If o is not a Card, the method should return false
     * Checks if this card is equal to another object.
     *
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return suit == card.suit && value == card.value && hasBeenPlayed == card.hasBeenPlayed;
    }

    /**
     * This method returns the the first letter of the suit (lowercase) 
     * followed by the numeric value of the card.
     * Generates a String representation of the card.
     *
     * @return the String representation of the card
     */
    public String toString() {
        String valueString;
        switch (value) {
            case JACK_VALUE:
                valueString = "11";
                break;
            case QUEEN_VALUE:
                valueString = "12";
                break;
            case KING_VALUE:
                valueString = "13";
                break;
            case ACE_VALUE:
                valueString = "14";
                break;
            default:
                valueString = String.valueOf(value);
        }
        return suit + valueString;
    }

    /**
     * This method is used for sorting cards.
     * It orders the cards by suit (Clubs, Diamonds, Spades, Hearts) and then by
     * value within the suit
     * @param other The Card object to which this Card is being compared.
     * @return  negative value if this Card should be before the other Card,
     *          positive value if this Card should be after the other Card,
     *          0 if this Card has the same suit and value as the other Card.
     */
    public int compareTo(Card other) {
        if (other == null) {
            return 1; 
        }

        if (getSuit() == other.getSuit()) {
            if (getValue() < other.getValue()) {
                return -1;
            } else if (getValue() > other.getValue()) {
                return 1;
            }
            else {
                return 0;
            }
        } 
        else {
            switch(getSuit()) {
                case HEARTS:
                    return 1;
                case SPADES:
                    if (other.getSuit() == HEARTS) {
                        return -1;
                    } 
                    else {
                        return 1;
                    }
                case DIAMONDS:
                    if (other.getSuit() == HEARTS || other.getSuit() == SPADES) {
                        return -1;
                    } 
                    else {
                        return 1;
                    }
                //CLUBS
                default:
                    return -1;
            }
        }
    }
}
