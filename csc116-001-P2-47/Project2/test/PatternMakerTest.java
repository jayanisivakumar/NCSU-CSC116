import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test PatternMaker methods
 * @author Suzanne Balik
 * @author Jayani Sivakumar
 */
public class PatternMakerTest {
    
    /** Square - 1 row, 1 column */
    public static final char[][] SQUARE_1_1 = {{' ','_',' '},
                                               {'|','_','|'}};
       
    /** Square - 2 rows, 3 columns */
    public static final char[][] SQUARE_2_3 = {{' ','_',' ','_',' ','_',' '},
                                               {'|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|'}};

    /** Square - 3 rows, 5 columns */
    public static final char[][] SQUARE_3_5 = {{' ','_',' ','_',' ','_',' ','_',' ','_',' '},
                                               {'|','_','|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|','_','|'}};

    /** Square - 4 rows, 2 columns */
    public static final char[][] SQUARE_4_2 = {{' ','_',' ','_',' '},
                                               {'|','_','|','_','|'},
                                               {'|','_','|','_','|'},
                                               {'|','_','|','_','|'},
                                               {'|','_','|','_','|'}};

    /** Square - 5 rows, 5 columns */
    public static final char[][] SQUARE_5_5 = {{' ','_',' ','_',' ','_',' ','_',' ','_',' '},
                                               {'|','_','|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|','_','|'}};


    /** Square - 6 rows, 4 columns */
    public static final char[][] SQUARE_6_4 = {{' ','_',' ','_',' ','_',' ','_',' '},
                                               {'|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|'},
                                               {'|','_','|','_','|','_','|','_','|'}};
                               
    /** Diamond - 1 row */
    public static final char[][] DIAMOND_1 = {{'/','\\'},
                                              {'\\','/'}};
       
                                     
    /** Diamond - 4 rows */
    public static final char[][] DIAMOND_4 = {{' ',' ',' ','/','\\',' ',' ',' '},
                                              {' ',' ','/','\\','/','\\',' ',' '},
                                              {' ','/','\\','/','\\','/','\\',' '},
                                              {'/','\\','/','\\','/','\\','/','\\'},
                                              {'\\','/','\\','/','\\','/','\\','/'}};

    /** Diamond - 2 row */
    public static final char[][] DIAMOND_2 = {{' ','/','\\',' ',},
                                              {'/','\\','/','\\',},
                                              {'\\','/','\\','/',}};
    
    /** Diamond - 5 rows */
    public static final char[][] DIAMOND_5 = {{' ',' ',' ',' ','/','\\',' ',' ',' ',' '},
                                              {' ',' ',' ','/','\\','/','\\',' ',' ',' '},
                                              {' ',' ','/','\\','/','\\','/','\\',' ',' '},
                                              {' ','/','\\','/','\\','/','\\','/','\\',' '},
                                              {'/','\\','/','\\','/','\\','/','\\','/','\\'},
                                              {'\\','/','\\','/','\\','/','\\','/','\\','/'}};

    
    /** Triangle - 1 row */
    public static final char [][] TRIANGLE_1 = {{' ','/','\\',' '},
                                                {'/','_','_','\\'}}; 
    
    /** Triangle - 4 rows */
    public static final char[][] TRIANGLE_4 = {{' ',' ',' ',' ','/','\\',' ',' ',' ',' '},
                                               {' ',' ',' ','/','_','_','\\',' ',' ',' '}, 
                                               {' ',' ','/','_','_','_','_','\\',' ',' '}, 
                                               {' ','/','_','_','_','_','_','_','\\',' '},
                                               {'/','_','_','_','_','_','_','_','_','\\'}};

    /** Triangle - 2 rows */
    public static final char [][] TRIANGLE_2 = {{' ',' ','/','\\',' ',' '},
                                                {' ','/','_','_','\\',' '},
                                                {'/','_','_','_','_','\\'}}; 
    
    /** Triangle - 5 rows */
    public static final char[][] TRIANGLE_5 = {{' ',' ',' ',' ',' ','/','\\',' ',' ',' ',' ',' '},
                                               {' ',' ',' ',' ','/','_','_','\\',' ',' ',' ',' '}, 
                                               {' ',' ',' ','/','_','_','_','_','\\',' ',' ',' '}, 
                                               {' ',' ','/','_','_','_','_','_','_','\\',' ',' '},
                                               {' ','/','_','_','_','_','_','_','_','_','\\',' '},
                                               {'/','_','_','_','_','_','_','_','_','_','_','\\'}};

    /**
    * Tests getSquares method with 1 row and 1 column.
    */
    @Test
    public void testGetSquares1Row1Col() {

        assertArrayEquals(SQUARE_1_1, PatternMaker.getSquares(1,1), "PatternMaker.getSquares(1,1)");

    }

    /**
    * Tests getSquares method with 2 rows and 3 columns.
    */
    @Test
    public void testGetSquares2Row3Col() {

        assertArrayEquals(SQUARE_2_3, PatternMaker.getSquares(2,3), "PatternMaker.getSquares(2,3)");
    }

    /**
    * Tests getSquares method with 3 rows and 5 columns.
    */
    @Test
    public void testGetSquares3Row5Col() {
    
        assertArrayEquals(SQUARE_3_5, PatternMaker.getSquares(3, 5), 
            "PatternMaker.getSquares(3,5)");
    }

    /**
    * Tests getSquares method with 4 rows and 2 columns.
    */
    @Test
    public void testGetSquares4Row2Col() {

        assertArrayEquals(SQUARE_4_2, PatternMaker.getSquares(4, 2), 
            "PatternMaker.getSquares(4,2)");

    }

    /**
    * Tests getSquares method with 5 rows and 5 columns.
    */
    @Test
    public void testGetSquares5Row5Col() {

        assertArrayEquals(SQUARE_5_5, PatternMaker.getSquares(5, 5), 
            "PatternMaker.getSquares(5,5)");

    }

    /**
    * Tests getSquares method with 6 rows and 4 columns.
    */
    @Test
    public void testGetSquares6Row4Col() {
    
        assertArrayEquals(SQUARE_6_4, PatternMaker.getSquares(6, 4), 
            "PatternMaker.getSquares(6,4)");

    }


    /**
    * Tests getDiamonds method with 1 row.
    */
    @Test
    public void testGetDiamonds1Row() {
        
        assertArrayEquals(DIAMOND_1, PatternMaker.getDiamonds(1), "PatternMaker.getDiamonds(1)");

    }
    
    /**
    * Tests getDiamonds method with 4 rows.
    */
    @Test
    public void testGetDiamonds4Rows() {

        assertArrayEquals(DIAMOND_4, PatternMaker.getDiamonds(4), "PatternMaker.getDiamonds(4)");

    }

    /**
    * Tests getDiamonds method with 2 rows.
    */
    @Test
    public void testGetDiamonds2Rows() {

        assertArrayEquals(DIAMOND_2, PatternMaker.getDiamonds(2), "PatternMaker.getDiamonds(2)");

    }

    /**
    * Tests getDiamonds method with 5 rows.
    */
    @Test
    public void testGetDiamonds5Rows() {
    
        assertArrayEquals(DIAMOND_5, PatternMaker.getDiamonds(5), "PatternMaker.getDiamonds(5)");

    }
   
    /**
    * Tests getTriangles method with 1 row.
    */
    @Test
    public void testGetTriangles1Row() {

        assertArrayEquals(TRIANGLE_1, PatternMaker.getTriangles(1), "PatternMaker.getTriangles(1)");

    }
    
    /**
    * Tests getTriangles method with 4 rows.
    */
    @Test
    public void testGetTriangles4Rows() {

        assertArrayEquals(TRIANGLE_4, PatternMaker.getTriangles(4), "PatternMaker.getTriangles(4)");

    }

    /**
    * Tests getTriangles method with 2 rows.
    */
    @Test
    public void testGetTriangles2Rows() {

        assertArrayEquals(TRIANGLE_2, PatternMaker.getTriangles(2), "PatternMaker.getTriangles(2)");

    }
    
    /**
    * Tests getTriangles method with 5 rows.
    */
    @Test
    public void testGetTriangles5Rows() {

        assertArrayEquals(TRIANGLE_5, PatternMaker.getTriangles(5), "PatternMaker.getTriangles(5)");

    }
    
    /**
    * Tests toString method with 1 row array.
    */
    @Test
    public void testToStringOneRow() {
        char[][] hello = {{'H','e','l','l','o'}};
        String expected = "Hello\n";
        assertEquals(expected, PatternMaker.toString(hello), "PatternMaker.toString(hello)");

    }

    /**
    * Tests toString method with 1 row and 1 column of square pattern.
    */
    @Test
    public void testToStringSquares1Row1Col() {
        String expected = " _ \n" + 
                          "|_|\n";
        assertEquals(expected, PatternMaker.toString(SQUARE_1_1), 
                     "PatternMaker.toString(SQUARE_1_1)");
    }

    /**
    * Tests toString method with 4 rows of diamond pattern.
    */
    @Test
    public void testToStringDiamonds4Rows() {   
        String expected = "   /\\   \n" +
                          "  /\\/\\  \n" +
                          " /\\/\\/\\ \n" +
                          "/\\/\\/\\/\\\n" +
                          "\\/\\/\\/\\/\n";
        assertEquals(expected, PatternMaker.toString(DIAMOND_4), 
                     "PatternMaker.toString(DIAMOND_4)");
    }                  

    /**
     * Test the PatternMaker methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getSquares(0,-1), "PatternMaker.getSquares(0,-1)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getSquares(0,-1) - exception message");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getSquares(2,-1), "PatternMaker.getSquares(2,-1)");
        assertEquals("Invalid columns", exception.getMessage(),
                     "Testing PatternMaker.getSquares(2,-1) - exception message");
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getSquares(11, 11), "PatternMaker.getSquares(11,11)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getSquares(11,11) - exception message");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getSquares(10,11), "PatternMaker.getSquares(10,11)");
        assertEquals("Invalid columns", exception.getMessage(),
                     "Testing PatternMaker.getSquares(10,11) - exception message");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getTriangles(0), "PatternMaker.getTriangles(0)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getTriangles(0) - exception message");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getTriangles(11), "PatternMaker.getTriangles(11)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getTriangles(11) - exception message");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getDiamonds(0), "PatternMaker.getDiamonds(0)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getDiamonds(0) - exception message");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.getDiamonds(11), "PatternMaker.getDiamonds(11)");
        assertEquals("Invalid rows", exception.getMessage(),
                     "Testing PatternMaker.getDiamonds(11) - exception message");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.toString(null), "PatternMaker.toString(null)");
        assertEquals("Null array", exception.getMessage(),
                     "Testing PatternMaker.toString(null) - exception message");
                     
        char[][] empty = new char[0][0];
        exception = assertThrows(IllegalArgumentException.class,
            () -> PatternMaker.toString(empty), "PatternMaker.toString(empty)");
        assertEquals("Empty array", exception.getMessage(),
                     "Testing PatternMaker.toString(null) - exception message");

    }
}