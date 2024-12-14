import java.util.Scanner;


/**
 * The CinemagicClient class represents the client interface for The Cinemagic Theater Complex.
 * It allows users to select theaters, movies, showtimes, and ticket types to calculate the 
 * ticket price.This class interacts with Theater, Movie, and Scanner classes to facilitate 
 * the ticketing process.
 *
 * @author Shreeya Wadodkar
 * @author Anthony Ma
 * @author Jayani Sivakumar
 * @author Essence Hill
 */
public class CinemagicClient {

    /** class constants */
    public static final int CHILD_PRICE = 6;
    public static final int ADULT_PRICE = 8;
    public static final int SENIOR_PRICE = 7;


    
    


    /**
     * Main method that starts the CinemagicClient application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);


        System.out.println();
        System.out.println("Welcome to The Cinemagic Theater Complex!");
        System.out.println("-----------------------------------------");
        System.out.println();


        Theater theater = theaterMenu(console);
        Movie movie = movieMenu(console, theater);
        int showtime = showtimeMenu(console, movie);
       //int ticketPrice = calculatePrice(console, showtime, theater);

       System.out.println(" ");


        System.out.println("        Your ticket price is: $" + calculatePrice(console, showtime, theater) );


        console.close();
    }


    /**
     * Displays the theater menu and allows the user to select a theater.
     *
     * @param console Scanner object for user input
     * @return Theater object representing the chosen theater
     */
    public static Theater theaterMenu(Scanner console) {
        System.out.println("Theater Menu:");
        System.out.println("-------------");
        System.out.println(" ");
        System.out.println("1. SilverScreen Spectacle");
        System.out.println("2. CineVerse Luxury");
        System.out.println("3. RetroReel Theaters");
        System.out.println("4. Popcorn Palace");
        System.out.println("5. Blockbuster Bliss");

        System.out.println(" ");
        System.out.print("      Select your theater (#): ");
        

        int theaterNumber = console.nextInt();
        console.nextLine();

        System.out.println(" ");
//calculatePrice(console, showtime, theater)

        String theaterName;
        

        System.out.println(" ");


        return new Theater(theaterNumber);
    }


    /**
     * Displays the movie menu for a specific theater and allows the user to select a movie.
     *
     * @param console Scanner object for user input
     * @param theater Theater object representing the chosen theater
     * @return Movie object representing the chosen movie
     */
    public static Movie movieMenu(Scanner console, Theater theater) {
        System.out.println("Movie Menu for " + theater.getTheaterName() + ":");
        System.out.println("------------------------------");
        System.out.println(" ");


        Movie[] movies = theater.getMovies();
        for (int i = 0; i < movies.length; i++) {
            if (movies[i] != null) {
                System.out.println((i + 1) + ". " + movies[i].getTitle());
            }
        }

        System.out.println(" ");
        System.out.print("      Select the movie (#): ");
        int movieNumber = console.nextInt();
        console.nextLine();

         System.out.println(" ");


        return movies[movieNumber - 1];
    }


    /**
     * Displays the showtimes for a specific movie and allows the user to select a showtime.
     *
     * @param console Scanner object for user input
     * @param movie Movie object representing the chosen movie
     * @return int representing the chosen showtime
     */
    public static int showtimeMenu(Scanner console, Movie movie) {
        System.out.println("Showtimes for " + movie.getTitle() + ":");
        System.out.println("-------------------------");
        System.out.println(" ");


        String[] showtimes = movie.getShowtimes();
        for (int i = 0; i < showtimes.length; i++) {
            System.out.println((i + 1) + ". " + showtimes[i]);
        }

        System.out.println(" ");
        System.out.print("      Select a showtime (#): ");
        int showtimeNumber = console.nextInt();

        System.out.println(" ");

        return showtimeNumber;

                

    }


    /**
     * Calculates the ticket price based on the selected showtime and ticket type.
     *
     * @param console Scanner object for user input
     * @param showtime int representing the chosen showtime
     * @return int representing the calculated ticket price
     */
    public static int calculatePrice(Scanner console, int showtime, Theater theater) {
        System.out.println("Ticket Types:");
        System.out.println("1. Adult");
        System.out.println("2. Child");
        System.out.println("3. Senior");

/** 
    System.out.print("Select your ticket type (#): ");
    int ticketType = console.nextInt();
    console.nextLine(); // Consume the newline character

*/

        System.out.print("How many adult tickets? (#): ");
        int adultTickets = console.nextInt();

        System.out.print("How many child tickets? (#): ");
        int childTickets = console.nextInt();

        System.out.print("How many senior tickets? (#): ");
        int seniorTickets = console.nextInt();

        int totalTickets = childTickets + adultTickets + seniorTickets;
        int ticketPrice = 0;

        if (theater.isLuxury() == true && isMatinee(showtime) == true){
            ticketPrice = (childTickets * CHILD_PRICE) + (adultTickets * ADULT_PRICE) + (seniorTickets * SENIOR_PRICE);
            ticketPrice = ticketPrice + (totalTickets * 3); // extra cost of $3 per tik for luxury
            ticketPrice = ticketPrice - (totalTickets * 1); // discount of $1 per ticket for matinee
        }
        if (theater.isLuxury() == true && isMatinee(showtime) == false){
            ticketPrice = (childTickets * CHILD_PRICE) + (adultTickets * ADULT_PRICE) + (seniorTickets * SENIOR_PRICE);
            ticketPrice = ticketPrice + (totalTickets * 3); // extra cost of $3 per tik for luxury

        }
        if (theater.isLuxury() == false && isMatinee(showtime) == true){
            ticketPrice = (childTickets * CHILD_PRICE) + (adultTickets * ADULT_PRICE) + (seniorTickets * SENIOR_PRICE);
            ticketPrice = ticketPrice - (totalTickets * 1); // discount of $1 per ticket for matinee
        }
        if (theater.isLuxury() == false && isMatinee(showtime) == false){
            ticketPrice = (childTickets * CHILD_PRICE) + (adultTickets * ADULT_PRICE) + (seniorTickets * SENIOR_PRICE);
            
        }

        return ticketPrice;

        }


/**

    int ticketPrice;
        switch (ticketType) {
            case 1:
                ticketPrice = showtime <= Movie.MATINEE_END ? Movie.ADULT_MATINEE : Movie.ADULT_NIGHT;
                break;
            case 2:
                ticketPrice = showtime <= Movie.MATINEE_END ? Movie.CHILD_MATINEE : Movie.CHILD_NIGHT;
                break;
            case 3:
                ticketPrice = showtime <= Movie.MATINEE_END ? Movie.SENIOR_MATINEE : Movie.SENIOR_NIGHT;
                break;
            default:
                System.out.println("Invalid ticket type selected. Defaulting to Adult ticket price.");
                ticketPrice = showtime <= Movie.MATINEE_END ? Movie.ADULT_MATINEE : Movie.ADULT_NIGHT;
                break;
        }

         */


    
    

    /**
     * Checks if a given time is within the matinee hours.
     * Matinee hours are defined as starting from 11 AM (1) to 5 PM (9).
     *
     * @param time The time to check in 24-hour format
     * @return true if the time is during matinee hours, false otherwise
     */
    public static boolean isMatinee(int showtime) {
        if (showtime <= 9){
            return true;
        }
        else {
            return false;
        }
    }


   
}