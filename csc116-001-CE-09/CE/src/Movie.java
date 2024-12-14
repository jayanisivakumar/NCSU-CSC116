import java.util.*;


/**
 * The Movie class represents a movie available in The Cinemagic Theater Complex.
 * It contains information about the movie title, duration, and methods to calculate showtimes and ticket prices.
 * This class also provides methods to display movies with their showtimes and calculate ticket prices based on timing.
 *
 * @author Shreeya Wadodkar
 * @author Anthony Ma
 * @author Jayani Sivakumar
 * @author Essence
 */
public class Movie {
    // displays the menu


    // Constants for showtime pricing
    public static final int MATINEE_PRICE = 5;
    public static final int NIGHT_PRICE = 10;
    public static final int CHILD_MATINEE = 5;
    public static final int ADULT_MATINEE = 10;
    public static final int SENIOR_MATINEE = 5;
    public static final int ADULT_NIGHT = 15;
    public static final int CHILD_NIGHT = 10;
    public static final int SENIOR_NIGHT = 10;
    public static final int CHILD_LUXURY = 7;
    public static final int MATINEE_START = 11; // 11 am
    public static final int MATINEE_END = 17;   // 5 pm
    public static final int CLOSE = 23;


    private String title;
    private int durationHours;
    private int durationMinutes;
    private String[] showtimes;


    /**
     * Constructs a new Movie object with the specified title and duration.
     *
     * @param title The title of the movie
     * @param duration The duration of the movie in hours
     */
    public Movie(String title, int durationHours, int durationMinutes) {
        this.title = title;
        this.durationHours = durationHours;
        this.durationMinutes = durationMinutes;
       
        showtimes = new String[17];

        showtimes[0] = "11:00 am";
        showtimes[1] = "11:30 am";
        showtimes[2] = "12:00 pm";
        showtimes[3] = "1:00 pm";
        showtimes[4] = "2:00 pm";
        showtimes[5] = "3:00 pm";
        showtimes[6] = "3:30 pm";
        showtimes[7] = "4:00 pm";
        showtimes[8] = "5:00 pm";
        showtimes[9] = "6:00 pm";
        showtimes[10] = "7:00 pm";
        showtimes[11] = "8:00 pm";
        showtimes[12] = "8:30 pm";
        showtimes[13] = "9:00 pm";
        showtimes[14] = "10:00 pm";
        showtimes[15] = "10:30 pm";
        showtimes[16] = "11:00 pm";
        


    }


    /**
     * Retrieves the title of the movie.
     *
     * @return The title of the movie
     */
    public String getTitle() {
        return title;
    }


    /**
     * Retrieves the duration hour of the movie.
     *
     * @return The duration hour of the movie in hours
     */
    public int getDurationHours() {
        return durationHours;
    }

    /**
     * Retrieves the duration minutes of the movie.
     *
     * @return The duration minutes of the movie in hours
     */
    public int getDurationMinutes() {
        return durationMinutes;
    }


    /**
     * Sets the duration of the movie.
     *
     * @param duration The duration of the movie in hours
     */
    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    /**
     * Sets the duration of the movie.
     *
     * @param duration The duration of the movie in hours
     */
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }


    /**
     * Generates and returns the showtimes of the movie based on its duration.
     * Showtimes are formatted as hours in 24-hour format.
     *
     * @return A string containing the showtimes of the movie
     */
    public String[] getShowtimes() {
        return showtimes;

    }





    /**
     * Displays the list of movies with their respective showtimes within the specified time range.
     *
     * @param movies The list of movies to display
     * @param startTime The start time for showtimes display in 24-hour format
     * @param endTime The end time for showtimes display in 24-hour format
     */
    public static void displayMoviesWithShowtimes(Movie[] movies, int startTime, int endTime) {
        for (Movie movie : movies) {
            System.out.println("Movie: " + movie.getTitle());
            System.out.println("Showtimes:");
            String[] showtimes = movie.getShowtimes();
            for (String time : showtimes) {
                System.out.println(time);
            }
            System.out.println("Duration: " + movie.getDurationHours() + "h " + movie.getDurationMinutes());
            System.out.println(); 
            }
        }  


        /**
         * The main method creates a list of movies, displays their showtimes, and calculates ticket prices.
         *
         * @param args The command-line arguments (not used in this context)
         */
        public static void main(String[] args) {
            // Create movies
            Movie[] movies = new Movie[5];
            movies[0] = new Movie("Barbie (PG - 13)", 1, 54);
            movies[1] = new Movie("Kung Fu Panda 4 (PG)", 1, 30);
            movies[2] = new Movie("Mean Girls (PG - 13)", 1, 52);
            movies[3] = new Movie("Dune: Part 2 (PG - 13)", 2, 46);
            movies[4] = new Movie("Red White & Royal Blue (R)", 1, 58);
        
            // Display movies with showtimes
            displayMoviesWithShowtimes(movies, 10, 23);


            // add another array for price of movies and duration that displays with the movie time
            //if matinee --> child price = 5, adult price = +2, senior price = +1
            // if matinee --> child price = 7, adult price = +2, senior price = +1
        }
    }


   


   

