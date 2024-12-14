import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Movie class.
 */
public class MovieTest {

    private Movie movie;

    /**
     * Set up the test environment before each test method.
     */
    @BeforeEach
    public void setUp() {
        movie = new Movie("Test Movie", 1, 30);
    }
    
    /**
     * Test the Movie constructor of the Movie class.
     */
    @Test
    public void testConstructor() {
        assertEquals("Test Movie", movie.getTitle());
        assertEquals(1, movie.getDurationHours());
        assertEquals(30, movie.getDurationMinutes());
    }

    /**
     * Test for getting the title of the movie.
     */
    @Test
    public void testGetTitle() {
        assertEquals("Test Movie", movie.getTitle(), "Successfully got movie title");
    }

    /**
     * Test for getting the duration hours of the movie.
     */
    @Test
    public void testGetDurationHours() {
        assertEquals(1, movie.getDurationHours(), "Successfully got movie duration hours");
    }

    /**
     * Test for getting the duration minutes of the movie.
     */
    @Test
    public void testGetDurationMinutes() {
        assertEquals(30, movie.getDurationMinutes(), "Successfully got movie duration minutes");
    }

    /**
     * Test for setting the duration hours of the movie.
     */
    @Test
    public void testSetDurationHours() {
        movie.setDurationHours(2);
        assertEquals(2, movie.getDurationHours(), "Successfully set movie duration hours");
    }

    /**
     * Test for setting the duration minutes of the movie.
     */
    @Test
    public void testSetDurationMinutes() {
        movie.setDurationMinutes(45);
        assertEquals(45, movie.getDurationMinutes(), "Successfully set movie duration minutes");
    }

    /**
     * Test the getShowtimes() method of the Movie class.
     */
    @Test
    public void testGetShowtimes() {
        String[] showtimes = movie.getShowtimes();
        assertEquals(17, showtimes.length);
        assertEquals("11:00 am", showtimes[0]);
        assertEquals("11:30 am", showtimes[1]);
    }

    /**
     * Test the testDisplayMoviesWithShowtimes() method of the Movie class.
     */
    @Test
    public void testDisplayMoviesWithShowtimes() {
        Movie[] movies = new Movie[1];
        movies[0] = new Movie("Test Movie", 1, 30);
        Movie.displayMoviesWithShowtimes(movies, 10, 23); 
        assertTrue(true); 
    }
}
