import java.util.Scanner;
/**
* Project 1 
* Program for representing the Wolfpack Coffee Shop.
* Consists of methods for handling online orders and delivery.
*
* @author Jayani Sivakumar
*/

public class CoffeeShop {
    /**
    * to convert cents to dollars
    */
    public static final double CENTS_TO_D = 100.00;

    /**
    * hour values ranging from 7
    */
    public static final int HR_7 = 7;

    /**
    * hour value ranging to 12
    */
    public static final int HR_12 = 12;

    /**
    * hour value ranging up to 5
    */
    public static final int HR_5 = 5;

    /**
    * min value ranging up to 59
    */
    public static final int MIN_59  = 59;

    /**
    * hour value ranging to 8
    */
    public static final int HR_8 = 8;

    /**
    * Valid zipcode #1
    */
    public static final int ZIP1 = 27605;

    /**
    * Valid zipcode #2
    */
    public static final int ZIP2 = 27606;

    /**
    * Cost of one Small Coffee
    */
    public static final int SMALL_C = 149;

    /**
    * Cost of one Medium Coffee
    */
    public static final int MEDIUM_C = 199;

    /**
    * Cost of one Large Coffee
    */
    public static final int LARGE_C = 249;

    /**
    * Cost of one Strawberry Mango Smoothie, Mocha Shake and Chai Tea
    */
    public static final int SMOOTHIE_SHAKE_TEA = 450;

    /**
    * Delivery charge to be added in cents
    */
    public static final int DELIVERY_C = 200;

    /**
    * For orders greater than > 2500, free delivery
    */
    public static final int LIMIT_DELIVERYC = 2500;

    /**
    * busyTime delivery time for orders with zipcode = 27605
    */
    public static final int BUSYTIME_27605 = 40;

    /**
    * busyTime delivery time for orders with zipcode = 27606
    */
    public static final int BUSYTIME_27606 = 50;

    /**
    * busyTime delivery time for orders on-campus
    */
    public static final int BUSYTIME_ONC = 30;

    /**
    * normal delivery time for orders with zipcode = 27605
    */
    public static final int NORMALTIME_27605 = 20;

    /**
    * normal delivery time for orders with zipcode = 27606
    */
    public static final int NORMALTIME_27606 = 25;

    /**
    * normal delivery time for on-campus orders
    */
    public static final int NORMALTIME_ONC = 15;

    /**
    * 1 hour = 60mins
    */
    public static final int H_MINS = 60;

    /**
    * for hours less than 10, be printed as, for example,  "4" instead of "04"
    */
    public static final int H_FORMAT = 10;

    /**
    * Main method to handle online orders and delivery.
    * 
    * @param args Command-line arguments, takes input from user
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("              Welcome to the Wolfpack Coffee Shop!");
        System.out.println("We deliver on-campus and to nearby locations. There is a $2 delivery ");
        System.out.println("fee, but orders of $25 or more receive free delivery! Orders must be ");
        System.out.println("placed between 7:00 AM and 5:59 PM. When prompted, please enter the ");
        System.out.println("time and your location. You will then be asked to enter the ");
        System.out.println("number of each item you would like to purchase - Small Coffee, ");
        System.out.println("Medium Coffee, Large Coffee, Strawberry Mango Smoothie, ");
        System.out.println("Mocha Shake, Chai Tea. The cost of your order and the ");
        System.out.println("estimated delivery time will then be output.");

        
        System.out.print("Please enter time (hr mn, eg. 8 59): ");
        int hour = scanner.nextInt();
        int min = scanner.nextInt();

        if (!isValidTime(hour, min)) {
            System.out.println("Invalid time");
            System.exit(1);
        }

        System.out.print("Are you on-campus? (y/n): ");
        scanner.nextLine(); 
        String onCampusInput = scanner.nextLine().toLowerCase();

        boolean onCampus = onCampusInput.toLowerCase().charAt(0) == 'y';
        int zipcode = 0;

        if (!onCampus) {
            System.out.print("Please enter your zipcode: ");
            zipcode = scanner.nextInt();
        

            if (!isValidZipcode(zipcode)) {
                System.out.println("Sorry, we do not deliver to that location.");
                System.exit(1);
            } 
        }

        System.out.println("\nPlease enter the number of each drink");
        System.out.print("that you would like to purchase:\n");
        int smallCoffee = promptQuantity(scanner, "Small Coffee");
        if(smallCoffee < 0){
            System.out.println("Invalid amount");
            System.exit(1);
        }
        int mediumCoffee = promptQuantity(scanner, "Medium Coffee");
        if(mediumCoffee < 0){
            System.out.println("Invalid amount");
            System.exit(1);
        }
        int largeCoffee = promptQuantity(scanner, "Large Coffee");
        if(largeCoffee < 0){
            System.out.println("Invalid amount");
            System.exit(1);
        }
        int smoothie = promptQuantity(scanner, "Strawberry Mango Smoothie");
        if(smoothie < 0){
            System.out.println("Invalid amount");
            System.exit(1);
        }
        int shake = promptQuantity(scanner, "Mocha Shake");
        if(shake < 0){
            System.out.println("Invalid amount");
            System.exit(1);
        }
        int tea = promptQuantity(scanner, "Chai Tea");
        if(tea < 0){
            System.out.println("Invalid amount");
            System.exit(1);
        }

        if (smallCoffee < 0 || mediumCoffee < 0 || largeCoffee < 0 || 
            smoothie < 0 || shake < 0 || tea < 0) {
            System.out.println("Invalid amount");
            System.exit(1);
        }

        int orderCost = getOrderCost(smallCoffee, mediumCoffee, largeCoffee, smoothie, shake, tea);
        String deliveryTime = getDeliveryTime(onCampus, zipcode, hour, min);

        System.out.printf("\nCost of Order: $%.2f%n", (double) orderCost / CENTS_TO_D);
        System.out.println("Estimated Delivery Time: " + deliveryTime);

        scanner.close();
    }
    
    /**
    * Validates if the given hour and minute values represent a valid time.
    * Returns true, if hour is a value ranging from 7 to 12 or 
    * 1 to 5 and min is a value from 0 to 59
    * Returns false, otherwise
    * 
    * @param hour hour component of the time
    * @param min minute component of the time
    * @return returns true if the time is valid or else false
    */
    public static boolean isValidTime(int hour, int min) {
        return (hour >= HR_7 && hour <= HR_12 || hour >= 1 &&
                hour <= HR_5) && (min >= 0 && min <= MIN_59);
    
    }
   
    /**
    * Checks if the given hour and minute values fall within the busy time period.
    * Returns true, if hour is a value ranging from 7 to 8 and min is a value from 0 to 59
    * Returns false, otherwise
    * 
    * @param hour hour component of the time
    * @param min minute component of the time
    * @return returns true if the time is during the busy period or else false
    */ 
    public static boolean isBusyTime(int hour, int min) {
        return (hour == HR_7 && min >= 0 && min <= MIN_59)
                || (hour == HR_8 && min >= 0 && min <= MIN_59);                
    }

    /**
    * Validates if the given zipcode is valid for delivery.
    * Returns true, if zipcode is 27605 or 27606
    * Returns false, otherwise
    * 
    * @param zipcode zipcode to validate
    * @return returns true if the zipcode is valid for delivery or else false
    */
    public static boolean isValidZipcode(int zipcode) {
        return zipcode == ZIP1 || zipcode == ZIP2;
                             
    }

    /**
    * Calculates the cost of the order in cents.
    * Returns the cost of the order as specified above as an integer number of cents
    * Throws an IllegalArgumentException with the message, "Invalid amount", 
    * if any parameter value is negative
    * 
    * @param smallCoffee quantity of small coffees ordered
    * @param mediumCoffee quantity of medium coffees ordered
    * @param largeCoffee quantity of large coffees ordered
    * @param smoothie quantity of smoothies ordered
    * @param shake quantity of shakes ordered
    * @param tea quantity of teas ordered
    * @return returns the total cost of the order in cents
    * @throws IllegalArgumentException if any parameter value is negative
    */
    public static int getOrderCost(int smallCoffee, int mediumCoffee, int largeCoffee, 
        int smoothie, int shake, int tea) {
        if (!isValidQuantity(smallCoffee) || !isValidQuantity(mediumCoffee) 
            || !isValidQuantity(largeCoffee) || !isValidQuantity(smoothie) || 
            !isValidQuantity(shake) || !isValidQuantity(tea)) {
            throw new IllegalArgumentException("Invalid amount");
        }
        
        int totalItems = smallCoffee + mediumCoffee + largeCoffee + smoothie + shake + tea;
        if (totalItems == 0) {
            return 0;
        }
        double totalCost = smallCoffee * SMALL_C + mediumCoffee * MEDIUM_C 
            + largeCoffee * LARGE_C + smoothie * SMOOTHIE_SHAKE_TEA + shake * SMOOTHIE_SHAKE_TEA 
            + tea * SMOOTHIE_SHAKE_TEA;
        
        totalCost += DELIVERY_C;

        if (totalCost >= LIMIT_DELIVERYC) {
            totalCost -= DELIVERY_C;
        }

        return (int) totalCost;
    }
                             
    /**
    * Calculates the estimated delivery time for an order.
    * Determines and returns the delivery time as a String in which the hour and minutes 
    * are separated by a colon (:) and minute values that are less than 10 are preceded 
    * by a 0. For example,  "8:05", "12:29", etc.
    * 
    * @param onCampus true if the delivery is on-campus or else false
    * @param zipcode delivery zipcode only for off-campus)
    * @param hour hour component of the delivery time
    * @param min minute component of the delivery time
    * @return returns estimated delivery time as a formatted string (HH:MM)
    * @throws IllegalArgumentException if time is invalid or if the 
    * zipcode is invalid when not on campus
    */
    public static String getDeliveryTime(boolean onCampus, int zipcode, int hour, int min) {
        if (!onCampus && !isValidZipcode(zipcode)) {
            throw new IllegalArgumentException("Invalid zipcode");
        }

        if (!isValidTime(hour, min)) {
            throw new IllegalArgumentException("Invalid time");
        }

        int normaldeliveryTime;
        if (isBusyTime(hour, min)) {
            if (zipcode == ZIP1) {
                normaldeliveryTime = BUSYTIME_27605;
            } else if (zipcode == ZIP2) {
                normaldeliveryTime = BUSYTIME_27606;
            } else {
                normaldeliveryTime = BUSYTIME_ONC;
            }
            
        } else {
            if (zipcode == ZIP1) {
                normaldeliveryTime = NORMALTIME_27605;
            } else if (zipcode == ZIP2) {
                normaldeliveryTime = NORMALTIME_27606;
            } else {
                normaldeliveryTime = NORMALTIME_ONC;
            }
        }
        
        int totalMinutes = min + normaldeliveryTime;
        int finalHour = hour + totalMinutes / H_MINS;
        int finalMin = totalMinutes % H_MINS;

        String formattedHour = finalHour < H_FORMAT ? "" + finalHour : "" + finalHour;
        String formattedMin = finalMin < H_FORMAT ? "0" + finalMin : "" + finalMin;
    
        return formattedHour + ":" + formattedMin;
    }
    
    /**
    * Prompts the user to enter the quantity for a specific drink and returns the entered quantity.
    * 
    * @param scanner scanner object used for input
    * @param drinkName name of the drink 
    * @return returns the quantity of the specified drink 
    */
    public static int promptQuantity(Scanner scanner, String drinkName) {
        System.out.print(drinkName + ": ");
        int quantity = scanner.nextInt();
        return quantity;
    }

    /**
    * Checks if the specified quantity is non-negative.
    * 
    * @param quantity quantity to validate
    * @return returns true if the quantity is positive or else false
    */
    public static boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }
}