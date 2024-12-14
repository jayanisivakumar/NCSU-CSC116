/**
 * The Player class represents a single player in a game of Hearts.
 * It manages the player's name, overall points, current hand points, and hand of cards.
 * 
 * The class provides methods for accessing and manipulating player information,
 * including adding cards to the hand, getting the player's name, points, and cards,
 * determining the player's move based on game rules, and resetting player's hand and points.
 * 
 * @author Jayani Sivakumar
 */
public class Player {
    
    /**
     * an integer value to represent the number of cards a player holds in their hand at a time.
     */
    public static final int CARDS_IN_HAND = 13;

    /**
     * a String variable that holds this player’s name.
     */
    private String name;

    /**
     * an integer variable that holds the player’s overall score in the game of Hearts.
     */
    private int overallPoints;

    /**
     * an integer variable that holds the player’s points for the current hand.
     */
    private int handPoints;

    /**
     * an array of Card objects that makes up the player’s hand.
     */
    private Card[] hand;

    /**
     * an integer variable that knows the position within the array
     * of Card objects in which the next card dealt to the player should be placed.
     * Constructor
     */
    private int next;

    /**
     * This is the constructor of the Player class. 
     * Constructs a Player with the given name.
     * Initializes the player's hand with an empty array of cards.
     * 
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.overallPoints = 0;
        this.handPoints = 0;
        hand = new Card[CARDS_IN_HAND];
        next = 0;

    }

    /**
     * This is the getter method for the instance field that knows the player’s name.
     * Gets the name of the player.
     * 
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * This method adds a new card that has been dealt to the 
     * player from the deck and places it in the player’s hand.
     * Adds a card to the player's hand.
     * 
     * @param card The card to add to the hand.
     * @throws IllegalStateException if the hand is full.
     */
    public void addCard(Card card) {
        if (next >= CARDS_IN_HAND) {
            throw new IllegalStateException("Full hand");
        }
        hand[next] = card;
        next++;
    
        int currentIndex = next - 1;
        while (currentIndex > 0 && hand[currentIndex - 1].compareTo(hand[currentIndex]) > 0) {
            Card temp = hand[currentIndex];
            hand[currentIndex] = hand[currentIndex - 1];
            hand[currentIndex - 1] = temp;
            currentIndex--;
        }
    }

    /**
     * This is the getter method for the instance field that knows the current
     * number of points the player has obtained in the current hand.
     * 
     * @return The current hand points of the player.
     */
    public int getHandPoints() {
        return handPoints;
    }

    /**
     * This is the getter method for the instance field that knows the current 
     * number of points the player has obtained across all hands played in the Hearts game.
     * 
     * @return The overall points of the player.
     */
    public int getOverallPoints() {
        return overallPoints;
    }

    /**
     * This method updates the current number of points a player has obtained in the current hand.
     * Adds points to the player's hand points and overall points.
     * 
     * @param points The points to add.
     */
    public void addToHandPoints(int points) {
        handPoints += points;
        overallPoints += points;
    }

    /**
     * This method simply returns the card from the player’s
     * hand at the index specified by the parameter
     * 
     * @param index The index of the card in the hand.
     * @return The card at the specified index.
     * @throws IllegalArgumentException if the index is invalid.
     */
    public Card getCard(int index) {
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        return hand[index];
    }

    /**
     * This method determines if the player’s hand contains a 
     * card of the given suit that has not been played yet.
     * 
     * @param suit The suit of the card to check.
     * @return True if the player has an active card of the given suit, false otherwise.
     * @throws IllegalStateException if the hand is not full.
     */
    public boolean hasActiveCardOfSuit(char suit) {
        if (next < CARDS_IN_HAND) {
            throw new IllegalStateException("Hand not full");
        }
        for (Card card : hand) {
            if (card != null && card.getSuit() == suit && !card.hasBeenPlayed()) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method determines if the cards that have not been 
     * played yet in the player’s hand are made up entirely of Heart cards. 
     * Checks if the player's hand contains only hearts.
     * 
     * @return True if the player's hand contains only hearts, false otherwise.
     * @throws IllegalStateException if the hand is not full.
     */
    public boolean onlyHasHearts() {
        if (next < CARDS_IN_HAND) {
            throw new IllegalStateException("Hand not full");
        }
        for (Card card : hand) {
            if (card != null && card.getSuit() != Card.HEARTS) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method creates an array of String objects that has as many elements
     * as the class constant CARDS_IN_HANDS dictates.
     * Gets the names of the cards in the player's hand as an array of strings.
     * 
     * @return The names of the cards in the player's hand.
     * @throws IllegalStateException if the hand is not full.
     */
    public String[] getCardNames() {
        if (next < CARDS_IN_HAND) {
            throw new IllegalStateException("Hand not full");
        }
        String[] cardNames = new String[CARDS_IN_HAND];
        for (int i = 0; i < CARDS_IN_HAND; i++) {
            cardNames[i] = hand[i].toString();
        }
        return cardNames;
    }

    /**
     * This method creates a String that represents the player’s current status
     * in the game and returns it. The players status consists of the player’s
     * name, a colon, a space, and their current points for the given hand.
     * 
     * @return The player's name followed by a colon and space, then the current hand points.
     */
    public String toString() {
        return name + ": " + handPoints;
    }

    /**
     * This method simulates returning a player’s cards back to the deck
     * Resets the player's hand by setting all cards to null and next index to 0.
     */
    public void dumpCards() {
        for (int i = 0; i < hand.length; i++) {
            hand[i] = null;
        }
        next = 0;
    }

     /**
     * This method resets the instance field that knows how many 
     * points the player has obtained in the current hand to 0
     */
    public void resetHandPoints() {
        handPoints = 0;
    }

    /**
     * This method determines the card that a computer player will play in the
     * current round (trick). This method assumes the hand has been sorted and
     * is in order by suits - clubs, diamond, spades, hearts - and the values of
     * the cards in each suit are ordered from lowest to highest value.
     * @param startingCard the card that started the round
     * @param isFirstRound whether or not this is the first round of a hand
     * @param heartsStarted whether or not hearts are in play at this point in the hand
     * @return the card that will be played
     * @throws IllegalStateException If no unplayed card is found in hand.
     */
    public Card getMove(Card startingCard, boolean isFirstRound, boolean heartsStarted) {
        //If this is the first round (trick) and the computer player has the 2 of Clubs, 
        //they must play it. If the player has the 2 of Clubs, it should be the first 
        //card in their (sorted) hand
        if (isFirstRound && startingCard == null && 
            hand[0].getSuit() == Card.CLUBS && hand[0].getValue() == 2) {
            hand[0].setPlayed(true);
            return hand[0];
        } 
        
        //If an initial card was played, the computer player must follow suit
        //and will play the lowest card in that suit
        if (startingCard != null) {
            char currentSuit = startingCard.getSuit(); 
            for (int i = 0; i < CARDS_IN_HAND; i++) {
                if (!hand[i].hasBeenPlayed() && hand[i].getSuit() == currentSuit) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
            }
        }

        //If no card with a matching suit was found and it's not the first round(trick)
        //the computer player will play the Queen of Spades if they have it and it
        //hasn't been played yet
        //If not, they will play their highest valued Heart, if they have one and it
        //hasn't been played yet
        if (startingCard != null && !isFirstRound) {
            //Look for the Queen of Spades
            for (int i = 0; i < CARDS_IN_HAND; i++) {
                if (hand[i].getSuit() == Card.SPADES && hand[i].getValue() == Card.QUEEN_VALUE &&
                    !hand[i].hasBeenPlayed()) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
            }
            for (int i = CARDS_IN_HAND - 1; i >= 0; i--) {
                if (hand[i].getSuit() == Card.HEARTS && !hand[i].hasBeenPlayed()) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
            }
        }

        //If no card has been found yet, the first card that hasn't been played
        //in the sorted hand will be played
        for (int i = 0; i < hand.length; i++) {
            if (!hand[i].hasBeenPlayed()) {
                
                //A club or diamond is always valid
                if (hand[i].getSuit() == Card.CLUBS ||
                    hand[i].getSuit() == Card.DIAMONDS) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
                
                //All spades other than the queen are valid
                //The queen of spades can be played if it's not the
                //first round(trick)
                if (hand[i].getSuit() == Card.SPADES) {
                    if (hand[i].getValue() != Card.QUEEN_VALUE) {
                        hand[i].setPlayed(true);
                        return hand[i];
                    }
                    else if (!isFirstRound) {
                        hand[i].setPlayed(true);
                        return hand[i];
                    }
                }
                
                //A heart is valid if it's not the first round 
                //and either hearts have been played previously or
                //the player only has hearts. NOTE: This case would 
                //occur when the player is playing the initial card
                //in the trick
                if (hand[i].getSuit() == Card.HEARTS && !isFirstRound && 
                    (heartsStarted || onlyHasHearts())) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }    
            }
        }
        //No card found so far - this could happen in the unlikely situation
        //that the player's hand contained only hearts or
        //the Queen of spades with the rest of the cards being hearts
        //Return the first unplayed card        
        for (int i = 0; i < hand.length; i++) {
            if (!hand[i].hasBeenPlayed()) {
                hand[i].setPlayed(true);
                return hand[i];
            }
        }
        //No unplayed card in hand
        throw new IllegalStateException("No unplayed card in hand");

    }
}
