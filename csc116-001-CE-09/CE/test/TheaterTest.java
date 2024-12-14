import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Theater class.
 */
public class TheaterTest {

    private Theater theater;

    /**
     * Set up the test environment before each test method.
     */
    @BeforeEach
    public void setUp() {
        theater = new Theater(1); // Assuming theater number 1
    }

    /**
     * Test for the constructor to ensure theater attributes are set correctly.
     */
    @Test
    public void testConstructor() {
        assertEquals(1, theater.getTheaterNumber());
        assertEquals("SilverScreen Spectacle", theater.getTheaterName());
        assertFalse(theater.isLuxury()); // Assuming non-luxury theater for testing
        assertNotNull(theater.getMovies());
    }

    /**
     * Test for retrieving the theater number.
     */
    @Test
    public void testGetTheaterNumber() {
        assertEquals(1, theater.getTheaterNumber());
    }

    /**
     * Test for retrieving the theater name.
     */
    @Test
    public void testGetTheaterName() {
        assertEquals("SilverScreen Spectacle", theater.getTheaterName());
    }

    /**
     * Test for checking if the theater is luxury.
     */
    @Test
    public void testIsLuxury() {
        assertFalse(theater.isLuxury()); // Assuming non-luxury theater for testing
    }

    /**
     * Test for retrieving the movies in the theater.
     */
    @Test
    public void testGetMovies() {
        assertNotNull(theater.getMovies());
    }

}
