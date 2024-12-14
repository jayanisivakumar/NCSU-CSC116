/**
 * The Theater class represents a theater in The Cinemagic Theater Complex.
 * It contains information about the theater number, name, luxury status, and movies playing in the theater.
 * This class provides methods to add and remove movies from the theater's movie list.
 *
 * @author Shreeya Wadodkar
 * @author Anthony Ma
 * @author Jayani Sivakumar
 * @author Essence
 */
public class Theater {

    private int theaterNumber;
    private String theaterName;
    private boolean isLuxury;
    private Movie[] movies;


    /**
     * Constructs a new Theater object with the specified parameters.
     *
     * @param theaterNumber The number of the theater
     * @param theaterName The name of the theater
     * @param isLuxury Indicates if the theater is a luxury theater
     */
    public Theater(int theaterNumber) {
        this.theaterNumber = theaterNumber;

        
        String theaterName;
        switch (theaterNumber) {
            case 1:
                theaterName = "SilverScreen Spectacle";
                isLuxury = false;
                break;
            case 2:
                theaterName = "CineVerse Luxury";
                isLuxury = true;
                break;
            case 3:
                theaterName = "RetroReel Theaters";
                isLuxury = true;
                break;
            case 4:
                theaterName = "Popcorn Palace";
                isLuxury = false;
                break;
            case 5:
                theaterName = "Blockbuster Bliss";
                isLuxury = false;
                break;
            default:
                System.out.println("Invalid theater selection. Defaulting to SilverScreen Spectacle.");
                theaterName = "SilverScreen Spectacle";
                isLuxury = false;
                break;
        }

        this.theaterName = theaterName;


        this.movies = new Movie[5]; // Assuming each theater can have 5 movies


        if (theaterNumber ==  1 || theaterNumber ==  2 ){
            movies[0] = new Movie("Barbie (PG - 13) ", 1, 54);
            movies[1] = new Movie("Kung Fu Panda 4 (PG)", 1, 30);
            movies[2] = new Movie("Mean Girls (PG - 13)", 1, 52);
            movies[3] = new Movie("Dune: Part 2 (PG - 13)", 2, 46);
            movies[4] = new Movie("Red White & Royal Blue (R)", 1, 58 );
        }
        if (theaterNumber == 3){
            movies[0] = new Movie("Breakfast at Tiffany's (G) ", 1, 54);
            movies[1] = new Movie("The Wizard of Oz (G))", 1, 30);
            movies[2] = new Movie("Singin' In the Rain (G) )", 1, 52);
            movies[3] = new Movie("The Sound of Music (G)", 2, 46);
            movies[4] = new Movie("Back to the Future (PG) )", 1, 58 );

        }
        if (theaterNumber == 4){
            movies[0] = new Movie("Inside Out (PG) ", 1, 54);
            movies[1] = new Movie("Coco (PG) ", 1, 30);
            movies[2] = new Movie("Elemental (PG) ", 1, 52);
            movies[3] = new Movie("Luca (PG) ", 2, 46);
            movies[4] = new Movie("Finding Dory (PG) ", 1, 58 );

        }
        if (theaterNumber == 5){
            movies[0] = new Movie("Avatar (PG-13) ", 1, 54);
            movies[1] = new Movie("Avengers: Endgame (PG-13) ", 1, 30);
            movies[2] = new Movie("Avatar: The Way of Water (PG-13) ", 1, 52);
            movies[3] = new Movie("Titanic (PG-13) ", 2, 46);
            movies[4] = new Movie("Star-Wars: Episode VII - The Force Awakens (PG-13) ", 1, 58 );

        }
    }


    // Getters and setters


    /**
     * Retrieves the theater number.
     *
     * @return The theater number
     */
    public int getTheaterNumber() {
        return theaterNumber;
    }


    /**
     * Retrieves the theater name.
     *
     * @return The theater name
     */
    public String getTheaterName() {
        return theaterName;
    }


    /**
     * Checks if the theater is a luxury theater.
     *
     * @return true if the theater is luxury, false otherwise
     */
    public boolean isLuxury() {
        return isLuxury;
    }


     /**
     * Retrieves the array of movies playing in the theater.
     *
     * @return An array of Movie objects representing the movies in the theater
     */
    public Movie[] getMovies() {
        return movies;
    }
}