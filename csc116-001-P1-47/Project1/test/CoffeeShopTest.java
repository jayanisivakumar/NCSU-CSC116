import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test CoffeeShop methods
 * @author Suzanne Balik
 * @author Michelle Glatz
 * @author Jayani Sivakumar
 */
public class CoffeeShopTest {

    /**
    * Tests the isValidTime method with valid input in morning time.
    */
    @Test
    public void testIsValidTimeValidInMorning() {

        assertTrue(CoffeeShop.isValidTime(8, 20), "CoffeeShop.isValidTime(8, 20)");

    }

    /**
    * Tests the isValidTime method with invalid hour and minute values
    */
    @Test
    public void testIsValidTimeHourSixMinuteValid() {

        assertFalse(CoffeeShop.isValidTime(6, 4), "CoffeeShop.isValidTime(6, 4)");

    } 

    /**
    * Tests the isValidTime method with valid morning time on boundary
    */
    @Test
    public void testIsValidTimeValidMorningOnBoundary() {

        assertTrue(CoffeeShop.isValidTime(7, 0), "CoffeeShop.isValidTime(7, 0)");

    }
    
    /**
    * Tests the isValidTime method with valid hour but invalid negative minute value
    */
    @Test
    public void testIsValidTimeHourValidMinuteNegative() {

        assertFalse(CoffeeShop.isValidTime(5, -1), "CoffeeShop.isValidTime(5, -1)");

    }  

    /**
    * Tests the isValidTime method with invalid negative hour but valid minute value.
    */
    @Test
    public void testIsValidTimeHourNegativeMinuteValid() {

        assertFalse(CoffeeShop.isValidTime(-1, 10), "CoffeeShop.isValidTime(-1, 10)");

    } 
    
    /**
    * Tests the isValidTime method with invalid hour > 12 but valid minute value.
    */
    @Test
    public void testIsValidTimeHourThirteenMinuteValid() {

        assertFalse(CoffeeShop.isValidTime(13, 15), "CoffeeShop.isValidTime(13, 15)");

    } 

    /**
    * Tests the isValidTime method with hour = 0 but valid minute value.
    */
    @Test
    public void testIsValidTimeHourZeroMinuteValid() {

        assertFalse(CoffeeShop.isValidTime(0, 30), "CoffeeShop.isValidTime(0, 30)");

    }    

    /**
    * Tests the isValidTime method with hour = 12 and minute value set to zero.
    */
    @Test
    public void testIsValidTimeNoon() {
        
        assertTrue(CoffeeShop.isValidTime(12, 00), "CoffeeShop.isValidTime(12, 00)");
        
    }
    
    /**
    * Tests the isValidTime method with hour = 5 and minute value set to zero.
    */
    @Test
    public void testIsValidTimeValidEveningOnBoundary() {

        assertTrue(CoffeeShop.isValidTime(5, 00), "CoffeeShop.isValidTime(5, 00)");
    
    }

    /**
    * Tests the isValidTime method with valid hour but minute value set to 60.
    */
    @Test
    public void testIsValidTimeHourValidMinuteSixty() {

        assertFalse(CoffeeShop.isValidTime(0, 60), "CoffeeShop.isValidTime(0, 60)");

    }    

    /**
    * Tests the isBusyTime method with valid input busy time on ending boundary.
    */
    @Test
    public void testIsBusyTimeOnEndingBoundary() {

        assertTrue(CoffeeShop.isBusyTime(8, 59), "CoffeeShop.isBusyTime(8, 59)");

    }
    
    /**
    * Tests the isBusyTime method with valid input busy time on starting boundary.
    */ 
    @Test
    public void testIsBusyTimeOnStartingBoundary() {

        assertTrue(CoffeeShop.isBusyTime(7, 0), "CoffeeShop.isBusyTime(7, 0)");

    }  

    /**
    * Tests the isBusyTime method with invalid input busy time and minutes as 0.
    */
    @Test
    public void testIsBusyTimeNine() {

        assertFalse(CoffeeShop.isBusyTime(9, 0), "CoffeeShop.isValidTime(9, 0)");

    }
    
    /**
    * Tests the isBusyTime method with valid input busy time and but 
    * minutes as negative.
    */
    @Test
    public void testIsBusyTimeHourSevenMinuteNegative() {

        assertFalse(CoffeeShop.isBusyTime(7, -1), "CoffeeShop.isValidTime(7, -1)");

    }

    /**
    * Tests the isBusyTime method with invalid input busy time.
    */
    @Test
    public void testIsBusyTimeThreeThirty() {

        assertFalse(CoffeeShop.isBusyTime(3, 30), "CoffeeShop.isValidTime(3, 30)");

    } 

    /**
    * Tests the isBusyTime method with invalid input busy time as 
    * minutes is 60.
    */
    @Test
    public void testIsBusyTimeHourEightMinuteSixty() {

        assertFalse(CoffeeShop.isBusyTime(8, 60), "CoffeeShop.isValidTime(8, 60)");


    } 
     
    /**
    * Tests the isBusyTime method with valid input busy time.
    */
    @Test
    public void testIsBusyTimeEightFifteen() {

        assertTrue(CoffeeShop.isBusyTime(8, 15), "CoffeeShop.isValidTime(8, 15)");

        
    }
        
    /**
    * Tests the isValidZipcode method with a valid zipcode.
    */
    @Test
    public void testIsValidZipcode27605() {

        assertTrue(CoffeeShop.isValidZipcode(27605), "CoffeeShop.isValidZipcode(27605)");

    }

    /**
    * Tests the isValidZipcode method with a invalid zipcode.
    */
    @Test
    public void testIsValidZipcode27604() {

        assertFalse(CoffeeShop.isValidZipcode(27604), "CoffeeShop.isValidZipcode(27604)");

    }
    
    /**
    * Tests the isValidZipcode method with a invalid zipcode.
    */
    @Test
    public void testIsValidZipcode27511() {

        assertFalse(CoffeeShop.isValidZipcode(27511), "CoffeeShop.isValidZipcode(27511)");

    }

    /**
    * Tests the isValidZipcode method with a valid zipcode.
    */
    @Test
    public void testIsValidZipcode27606() {

        assertTrue(CoffeeShop.isValidZipcode(27606), "CoffeeShop.isValidZipcode(27606)");

    }

    /**
    * Tests the isValidZipcode method with a invalid zipcode.
    */
    @Test
    public void testIsValidZipcode27615() {

        assertFalse(CoffeeShop.isValidZipcode(27615), "CoffeeShop.isValidZipcode(27615)");

    }    

    /**
    * Tests the getOrderCost method with valid input for one small coffee.
    */
    @Test
    public void testGetOrderCostOneSmallCoffee() {
        assertEquals(349, CoffeeShop.getOrderCost(1, 0, 0, 0, 0, 0),
                     "CoffeeShop.getOrderCost(1, 0, 0, 0, 0, 0)");

    }
    
    /**
    * Tests the getOrderCost method with valid input for one medium coffee.
    */
    @Test
    public void testGetOrderCostOneMediumCoffee() {
        assertEquals(399, CoffeeShop.getOrderCost(0, 1, 0, 0, 0, 0),
                     "CoffeeShop.getOrderCost(0, 1, 0, 0, 0, 0)");

    } 
  
    /**
    * Tests the getOrderCost method with valid input for one smoothie.
    */
    @Test
    public void testGetOrderCostOneSmoothie() {
        assertEquals(650, CoffeeShop.getOrderCost(0, 0, 0, 1, 0, 0),
                     "CoffeeShop.getOrderCost(0, 0, 0, 1, 0, 0)");

    }  

    /**
    * Tests the getOrderCost method with valid input for one tea.
    */
    @Test
    public void testGetOrderCostOneTea() {
        assertEquals(650, CoffeeShop.getOrderCost(0, 0, 0, 0, 0, 1),
                     "CoffeeShop.getOrderCost(1, 0, 0, 0, 0, 1)");

    }  

    /**
    * Tests the getOrderCost method with valid input quantity of 
    * two in each item.
    */
    @Test
    public void testGetOrderCostTwoOfEach() {
        assertEquals(3894, CoffeeShop.getOrderCost(2, 2, 2, 2, 2, 2),
                     "CoffeeShop.getOrderCost(2, 2, 2, 2, 2, 2)");

    } 
    
     
    /**
    * Tests the getOrderCost method with valid input of 
    * five smoothies and one large coffee.
    */
    @Test
    public void testGetOrderCostFiveSmoothiesOneLargeCoffee() {
        assertEquals(2499, CoffeeShop.getOrderCost(0, 0, 1, 5, 0, 0),
                     "CoffeeShop.getOrderCost(0, 0, 1, 5, 0, 0)");

    } 
   
    /**
    * Tests the getOrderCost method with valid input of no items.
    */
    @Test
    public void testGetOrderCostNoItems() {
        assertEquals(0, CoffeeShop.getOrderCost(0, 0, 0, 0, 0, 0),
                     "CoffeeShop.getOrderCost(0, 0, 0, 0, 0, 0)");

    }    
    
    
    /**
    * Tests the getOrderCost method with valid input of one large coffee.
    */
    @Test
    public void testGetOrderCostOneLargeCoffee() {
        assertEquals(449, CoffeeShop.getOrderCost(0, 0, 1, 0, 0, 0),
                     "CoffeeShop.getOrderCost(0, 0, 1, 0, 0, 0)");

    }
    
    /**
    * Tests the getOrderCost method with valid input of one shake.
    */
    @Test
    public void testGetOrderCostOneShake() {    
        assertEquals(650, CoffeeShop.getOrderCost(0, 0, 0, 0, 1, 0),
                     "CoffeeShop.getOrderCost(0, 0, 0, 0, 1, 0)");

    }   
       
    /**
    * Tests the getOrderCost method with valid input quantity of one in each item.
    */
    @Test
    public void testGetOrderCostOneOfEach() {
        assertEquals(2147, CoffeeShop.getOrderCost(1, 1, 1, 1, 1, 1),
                     "CoffeeShop.getOrderCost(1, 1, 1, 1, 1, 1)");
        
    }
    
    /**
    * Tests the getOrderCost method with valid input of one small coffee, 
    * two medium coffees and three shakes.
    */
    @Test
    public void testGetOrderCostOneSmallTwoMediumThreeShakes() {
        
        assertEquals(2097, CoffeeShop.getOrderCost(1, 2, 0, 0, 3, 0),
                     "CoffeeShop.getOrderCost(1, 2, 0, 0, 3, 0)");
    
    }  
   
    /**
    * Tests the getDeliveryTime method with delivery on 
    * campus at given valid hour(busy time)
    */
    @Test
    public void testGetDeliveryTimeOnCampusEightAM() {
        assertEquals("8:30", CoffeeShop.getDeliveryTime(true, 0, 8, 0),
                     "CoffeeShop.getDeliveryTime(true, 0, 8, 0)");

    }
    
    /**
    * Tests the getDeliveryTime method with delivery on campus at given valid hour
    */
    @Test
    public void testGetDeliveryTimeOnCampusTwelveFiftyPM() {
        assertEquals("13:05", CoffeeShop.getDeliveryTime(true, 0, 12, 50),
                     "CoffeeShop.getDeliveryTime(true, 0, 12, 50)");

    }

    /**
    * Tests the getDeliveryTime method with delivery off campus,
    * valid zipcode and at given valid hour(busy time)
    */
    @Test
    public void testGetDeliveryTime27605SevenTwenty() {
        assertEquals("8:00", CoffeeShop.getDeliveryTime(false, 27605, 7, 20),
                     "CoffeeShop.getDeliveryTime(false, 27605, 7, 20)");

    } 

    /**
    * Tests the getDeliveryTime method with delivery off campus,
    * valid zipcode and at given valid hour
    */
    @Test
    public void testGetDeliveryTime27606FiveFifty() {
        assertEquals("6:15", CoffeeShop.getDeliveryTime(false, 27606, 5, 50),
                     "CoffeeShop.getDeliveryTime(false, 27606, 5, 50)");

    }     

    /**
    * Tests the getDeliveryTime method with delivery off campus, 
    * valid zipcode and at given valid hour(busy time)
    */
    @Test
    public void testGetDeliveryTime27606EightFortyFive() { 
        assertEquals("9:35", CoffeeShop.getDeliveryTime(false, 27606, 8, 45),
                     "CoffeeShop.getDeliveryTime(false, 27606, 8, 45)");
    } 
    
    /**
    * Tests the getDeliveryTime method with delivery on campus and at given valid hour.
    */
    @Test
    public void testGetDeliveryTimeOnCampusNineThirty() { 
        assertEquals("9:45", CoffeeShop.getDeliveryTime(true, 0, 9, 30),
                     "CoffeeShop.getDeliveryTime(true, 0, 9, 30)");

    }   

    /**
    * Tests the getDeliveryTime method with delivery off campus(valid zipcode)
    * and at given valid hour.
    */
    @Test
    public void testGetDeliveryTime27605TwoFifteen() {
        assertEquals("2:35", CoffeeShop.getDeliveryTime(false, 27605, 2, 15),
                     "CoffeeShop.getDeliveryTime(false, 27605, 2, 15)");

    }      
    
    /**
    * Tests the getDeliveryTime method with delivery on campus and at given valid hour(busy time).
    */
    @Test
    public void testGetDeliveryTimeOnCampusEightFiftyNine() {
        assertEquals("9:29", CoffeeShop.getDeliveryTime(true, 0, 8, 59),
                     "CoffeeShop.getDeliveryTime(false, 27605, 2, 15)");
        
    }

    /**
     * Test the CoffeeShop methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> CoffeeShop.getOrderCost(-1, 2, 3, 4, 0, 1),
                                           "CoffeeShop.getOrderCost(-1, 2, 3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing CoffeeShop.getOrderCost(-1, 2, 3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> CoffeeShop.getOrderCost(2, -2, 3, 4, 0, 1),
                                 "CoffeeShop.getOrderCost(2, -2, 3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing CoffeeShop.getOrderCost(2, -2, 3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> CoffeeShop.getOrderCost(0, 2, -3, 4, 0, 1),
                                 "CoffeeShop.getOrderCost(0, 2, -3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing CoffeeShop.getOrderCost(0, 2, -3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> CoffeeShop.getOrderCost(1, 2, 3, -3, 0, 1),
                                 "CoffeeShop.getOrderCost(1, 2, 3, -3, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing CoffeeShop.getOrderCost(1, 2, 3, -3, 0, 1) - " +
                     "exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> CoffeeShop.getOrderCost(1, 2, 3, 4, -1, 1),
                                 "CoffeeShop.getOrderCost(1, 2, 3, 4, -1, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing CoffeeShop.getOrderCost(1, 2, 3, 4, -1, 1) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> CoffeeShop.getOrderCost(1, 2, 3, 4, 1, -3),
                                 "CoffeeShop.getOrderCost(1, 2, 3, 4, 1, -3)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing CoffeeShop.getOrderCost(1, 2, 3, 4, 1, -3) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> CoffeeShop.getDeliveryTime(false, 11234, 3, 20),
                                 "CoffeeShop.getDeliveryTime(false, 11234, 3, 20)");
        assertEquals("Invalid zipcode", exception.getMessage(),
                     "Testing CoffeeShop.getDeliveryTime(false, 11234, 3, 20) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> CoffeeShop.getDeliveryTime(true, 0, 6, 30),
                                 "CoffeeShop.getDeliveryTime(true, 0, 6, 30)");
        assertEquals("Invalid time", exception.getMessage(),
                     "Testing CoffeeShop.getDeliveryTime(true, 0, 6, 30) - " +
                     "exception message");
                     
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> CoffeeShop.getDeliveryTime(true, 276, 6, 30),
                                 "CoffeeShop.getDeliveryTime(true, 276, 6, 30)");
        assertEquals("Invalid time", exception.getMessage(),
                     "Testing CoffeeShop.getDeliveryTime(true, 276, 6, 30) - " +
                     "exception message");
                                       
        exception = assertThrows(IllegalArgumentException.class,
            () -> CoffeeShop.getDeliveryTime(false, 276, 6, 30),
                                 "CoffeeShop.getDeliveryTime(false, 276, 6, 30)");
        assertEquals("Invalid zipcode", exception.getMessage(),
                     "Testing CoffeeShop.getDeliveryTime(false, 276, 6, 30) - " +
                     "exception message");                     


    }
}