import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The CinemagicClientTest class contains unit tests for the CinemagicClient class methods.
 * It tests various functionalities such as menu selections, showtime calculations, and price calculations.
 * 
 * @author Essence Hill, Shreeya Wadodkar, Anthony Ma, Jayani Sivakumar
 */
public class CinemagicClientTest {
    
    private Theater theater;
    private Movie movie;
    private Scanner console;

    /**
     * Sets up the test environment before each test method.
     */
    @BeforeEach
    public void setUp() {
        theater = new Theater(1);
        movie = new Movie("Test Movie", 1, 30);
    }

    /**
     * Tests the constructor of CinemagicClient by checking theater and movie properties.
     */
    @Test
    public void testConstructor() {
        assertEquals("SilverScreen Spectacle", theater.getTheaterName());
        assertFalse(theater.isLuxury()); // Assuming the default theater is not luxury
        assertEquals("Test Movie", movie.getTitle());
        assertEquals(1, movie.getDurationHours());
        assertEquals(30, movie.getDurationMinutes());
    }

    /**
     * Tests the theaterMenu method of CinemagicClient by simulating user input and checking the selected theater name.
     */
    @Test
    public void testTheaterMenu() {
        Scanner input = new Scanner("1\n"); // Input "1" for theater number 1
        Theater theater = CinemagicClient.theaterMenu(input);
        assertEquals("SilverScreen Spectacle", theater.getTheaterName());
    }

    /**
     * Tests the movieMenu method of CinemagicClient by simulating user input and checking the selected movie title.
     */
    @Test
    public void testMovieMenu() {
        Scanner input = new Scanner("1\n"); // Input "1" to select the first movie
        Theater theater = new Theater(1);
        Movie movie = CinemagicClient.movieMenu(input, theater);
        assertEquals("Barbie (PG - 13) ", movie.getTitle());
    }

    /**
     * Tests the showtimeMenu method of CinemagicClient by simulating user input and checking the selected showtime.
     */
    @Test
    public void testShowtimeMenu() {
        int selectedShowtime = CinemagicClient.showtimeMenu(new Scanner(System.in), movie);
        assertEquals(1, selectedShowtime);
    }

    /**
     * Tests the getShowtimes method of CinemagicClient by simulating user input and checking the returned showtime.
     */
    @Test
    public void testGetShowtimes() {
        Scanner input = new Scanner("1\n");
        int showtime = CinemagicClient.showtimeMenu(input, movie);
        assertEquals(1, showtime);
    }

    /**
     * Tests the isMatinee method of CinemagicClient by checking matinee conditions.
     */
    @Test
    public void testIsMatinee() {
        assertTrue(CinemagicClient.isMatinee(9));
        assertFalse(CinemagicClient.isMatinee(12));
    }

    /**
     * Tests the calculatePrice method of CinemagicClient by simulating user input and checking the calculated price.
     */
    @Test
    public void testCalculatePrice() { 
        Scanner input = new Scanner("1\n1\n1"); 
        int showtime = 1;
        int price = CinemagicClient.calculatePrice(input, showtime, theater);
        assertEquals(18, price);
    }
}
