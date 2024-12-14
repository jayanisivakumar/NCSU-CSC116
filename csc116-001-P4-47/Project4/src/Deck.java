import java.util.Random;

/**
 * The Deck class represents a deck of 52 playing cards used in the Hearts Game.
 * It manages an array of Card objects to represent the cards in the deck.
 * 
 * This class provides methods to initialize the deck, shuffle the cards, deal cards,
 * reset the deck for a new hand, and retrieve information about the deck.
 * 
 * @author Jayani Sivakumar
 */
public class Deck {

    /** 
     * The number of cards in a standard deck. 
     */
    public static final int CARDS_IN_DECK = 52;

    /** 
     * The range of cards with clubs as suit in a standard deck. 
     */
    public static final int CLUB_SUIT_CARDS = 12;

    /** 
     * The range of cards with diamonds as suit in a standard deck. 
     */
    public static final int DIAMOND_SUIT_CARDS = 25;

    /** 
     * The range of cards with spades as suit in a standard deck. 
     */
    public static final int SPADE_SUIT_CARDS = 38;

    /** 
     * The lowest value of a card in a standard deck. 
     */
    public static final int LOWEST_VALUE = 2;

    /** 
     * The highest value of card in a standard deck. 
     */
    public static final int HIGHEST_VALUE = 14;

    /**
     * an array of Card objects that will be used to manage the
     * CARDS_IN_DECK cards in the deck. Each element in the array is a single Card object.
     */
    private Card[] cards;

    /**
     * an integer that holds the index of the next card to be dealt from the array of Cards. 
     */
    private int next;

    /**
     * This is the constructor of the Deck class.
     * Constructs a new Deck object.
     */
    public Deck() {
        cards = new Card[CARDS_IN_DECK];
        int count = Card.LOWEST_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (i <= CLUB_SUIT_CARDS){
                cards[i] = new Card(Card.CLUBS, count);
                count++;
            }
            else if (i <= DIAMOND_SUIT_CARDS) {
                cards[i] = new Card(Card.DIAMONDS, count);
                count ++;
            }
            else if (i <= SPADE_SUIT_CARDS) {
                cards[i] = new Card(Card.SPADES, count);
                count ++;
            }     
            else if (i <= CARDS_IN_DECK) {
                cards[i] = new Card(Card.HEARTS, count);
                count ++;
            }

            if (count == Card.HIGHEST_VALUE + 1) {
                count = Card.LOWEST_VALUE;
            }
        }
    }

    /**
     * This is the getter method for the next instance field.
     * Gets the index of the next card to be dealt.
     *
     * @return the index of the next card
     */
    public int getNext() {
        return next;
    }

    /**
     * This is the getter method for the cards array.
     * Gets the array of Card objects representing the deck.
     *
     * @return the array of Card objects
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * This method shuffles the deck by using the Random 
     * class to generate random numbers.
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = CARDS_IN_DECK - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    /**
     * This method handles resetting the deck for a new hand to be played.
     * The first thing this method must do is reset each card so that it has not been played yet. 
     * Resets the deck for a new hand.
     * Marks all cards as not played and resets the next card index to 0.
     */
    public void initialize() {
        for (int i = 0; i < cards.length; i++) {
            cards[i].setPlayed(false);
        }
        
        next = 0;
    }


    /**
     * This method returns the next card in the deck based on the instance
     * field next that knows the position within the array where 
     * the next card to be dealt is located. 
     * Deals the next card from the deck.
     *
     * @return the next card to be dealt
     * @throws IllegalStateException if there are no more cards to be dealt
     */
    public Card nextCard() {
        if (next >= CARDS_IN_DECK) {
            throw new IllegalStateException("No more cards");
        }
        return cards[next++];
    }

     /**
      * This method returns whether this Deck and o are equal.
      * If o is not a Deck, the method should return false. 
      * Decks are considered equal if their card arrays and next card index are equal.
      *
      * @param o the object to compare to
      * @return true if the decks are equal, false otherwise
      */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }
    
        if (!(o instanceof Deck)) {
            return false;
        }
    
        Deck otherDeck = (Deck) o;
    
        if (next != otherDeck.next) {
            return false;
        }
    
        for (int i = 0; i < CARDS_IN_DECK; i++) {
            if (!cards[i].equals(otherDeck.cards[i])) {
                return false;
            }
        }
        return true;

    }

    /**
     * This method generates a String representation of the deck.
     * Returns a String containing each card in the deck.
     *
     * @return the String representation of the deck
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CARDS_IN_DECK; i++) {
            sb.append("card ");
            sb.append(i);
            sb.append(": ");
            sb.append(cards[i]);
            sb.append("\n");
        }
        return sb.toString();
    }
}
