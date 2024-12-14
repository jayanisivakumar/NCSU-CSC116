import java.util.Scanner;

/**
* PatternMaker program - Program that creates and outputs patterns of squares,
* diamonds, and triangles. Prompts the user for:
* the number of rows and columns for patterns of squares, 
* the number of rows for patterns of diamonds
* and the number of rows for patterns of triangles. prints square, 
* diamond and triangle patterns accordingly.
*
* @author Jayani Sivakumar
*/
public class PatternMaker {

    /**
    * Main method to execute the Pattern Maker program. 
    * @param args Command-line arguments
    * @throws IllegalArgumentException throws illegalargumentexception for invalid input
    */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String option = "";
        
        while (!option.equalsIgnoreCase("Q")) {

            displayMenu();

            option = console.next();

            try {
        
                if (option.equalsIgnoreCase("S")) {
                    System.out.print("Rows: ");
                    int squareRows = console.nextInt();
                    System.out.print("Columns: ");
                    int squareColumns = console.nextInt();
                    char[][] squares = getSquares(squareRows, squareColumns);
                    System.out.println(toString(squares));

                } 
                else if (option.equalsIgnoreCase("D")) {
                    System.out.print("Rows: ");
                    int diamondRows = console.nextInt();
                    char[][] diamonds = getDiamonds(diamondRows);
                    System.out.println(toString(diamonds));

                }
                else if (option.equalsIgnoreCase("T")) {
                    System.out.print("Rows: ");
                    int triangleRows = console.nextInt();
                    char[][] triangles = getTriangles(triangleRows);
                    System.out.println(toString(triangles));

                }
                else if (option.equalsIgnoreCase("Q")) {
                    break;
                
                } else {
                    System.out.println("Invalid option");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid rows");
                continue;
            }
        }

        console.close();

    }   
    
    /**
    * Displays the menu for the Pattern Maker program.
    */
    public static void displayMenu() {
        System.out.println("Pattern Maker - Please choose an option.");
        System.out.println("S - Square");
        System.out.println("D - Diamond");
        System.out.println("T - Triangle");
        System.out.println("Q - Quit");
        System.out.print("Option: ");

    }


    /** Returns a 2D array of characters containing a Square pattern with the given number of 
    * rows and columns as described above.
    * @param rows number of rows of Square pattern
    * @param columns number of columns of pattern
    * @return Square pattern as Array
    *
    * @throws IllegalArgumentException Throws an IllegalArgumentException with the message,
    *                           "Invalid rows", if rows < 1 or rows > 10
    * @throws IllegalArgumentException Throws an IllegalArgumentException with the message,
    *                           "Invalid columns", if cols < 1 or cols > 10
    */
    public static char[][] getSquares(int rows, int columns) {
        if (rows < 1 || rows > 10) {
            throw new IllegalArgumentException("Invalid rows");
        }
        if (columns < 1 || columns > 10) {
            throw new IllegalArgumentException("Invalid columns");
        }
    
        char[][] squarePattern = new char[rows + 1][columns * 2 + 1];
     
        for (int j = 0; j < columns * 2; j += 2) {
            squarePattern[0][j] = ' ';
            squarePattern[0][j + 1] = '_';
            squarePattern[0][j + 2] = ' ';
        }
        for (int i = 1; i < rows + 1; i++) {
            squarePattern[i][0] = '|';
            for (int j = 1; j < columns * 2; j += 2) {
                squarePattern[i][j] = '_';
                squarePattern[i][j + 1] = '|';
            }
        }
    
        return squarePattern;
    }
    

    /** Returns a 2D array of characters containing a Diamond pattern with the given number of rows
    * as described above.
    * @param rows number of rows of Diamond pattern
    * @return Diamond Pattern as Array
    *
    * @throws IllegalArgumentException Throws an IllegalArgumentException with the message,
    *                         "Invalid rows", if rows < 1 or rows > 10
    */
    public static char[][] getDiamonds(int rows) {
        if (rows < 1 || rows > 10) {
            throw new IllegalArgumentException("Invalid rows");
        }
    
        char[][] diamondPattern = new char[rows + 1][rows * 2];

        for (int i = 0; i < diamondPattern.length; i++) { 

            int forwardSlashI = rows - i - 1; 
            int bwdSlashI = rows + i; 

            for (int j = 0; j < diamondPattern[i].length; j++) { 
                if (i != diamondPattern.length - 1) { 
                    if (j < forwardSlashI || j > bwdSlashI) { 
                        diamondPattern[i][j] = ' '; 
                    
                    } else if (j == forwardSlashI) { 
                        diamondPattern[i][j] = '/'; 
                    
                    } else if (j == bwdSlashI) { 
                        diamondPattern[i][j] = '\\'; 
                    
                    } else { 
                        if (diamondPattern[i][j - 1] == '/') { 
                            diamondPattern[i][j] = '\\'; 
                        } 
                        if (diamondPattern[i][j - 1] == '\\') { 
                            diamondPattern[i][j] = '/'; 
                        } 
                    }
                
                } else { 
                    if (diamondPattern[i - 1][j] == '/') { 
                        diamondPattern[i][j] = '\\';
                    } 

                    if (diamondPattern[i - 1][j] == '\\') { 
                        diamondPattern[i][j] = '/'; 
                    } 
                } 
            } 
        } 

        return diamondPattern; 
    }

    /** Returns a 2D array of characters containing a Triangle pattern with the given number of rows
    * as described above.
    * @param rows number of rows of Traingle pattern
    * @return Triangle Pattern as Array
    *
    * @throws IllegalArgumentException Throws an IllegalArgumentException with the message,
    *                                 "Invalid rows", if rows < 1 or rows > 10
    */
    public static char[][] getTriangles(int rows) {
        if (rows < 1 || rows > 10) {
            throw new IllegalArgumentException("Invalid rows");
        }
    
        char[][] trianglePattern = new char[rows][rows * 2 + 1];
    

        for (int i = 0; i < rows; i++) {
            int spaces = rows - i - 1;
    
            for (int j = 0; j < spaces; j++) {
                trianglePattern[i][j] = ' ';
            }
    
            trianglePattern[i][spaces] = '/';
            trianglePattern[i][spaces + (rows - spaces) * 2] = '\\';
    
            for (int j = 1; j < (rows - spaces) * 2; j++) {
                if (i == 0) {
                    trianglePattern[i][spaces + j] = ' ';
                } else {
                    trianglePattern[i][spaces + j] = '_';
                }
            }
        }
    
        // Fill in the last row separately
        int lastRow = rows - 1;
        for (int j = 0; j < rows * 2 + 1; j++) {
            if (j == 0) {
                trianglePattern[lastRow][j] = '/';
            } else if (j == rows * 2) {
                trianglePattern[lastRow][j] = '\\';
            } else {
                trianglePattern[lastRow][j] = '_';
            }
        }
    
        return trianglePattern;
    }
           
    /** Returns a String representation of a 2D array of characters. The String should contain the
    * characters in the first row followed by a newline character, followed by the characters in 
    * the second row followed by a newline character, etc., depending on the number of rows in 
    * the array.
    * @param array 2D array of characters to convert
    * @return Spring representation of 2D array
    *
    * @throws IllegalArgumentException Throws an IllegalArgumentException with the message,
    *                            "Null array", if the array is null
    * @throws IllegalArgumentException Throws an IllegalArgumentException the message, 
    *                              "Empty array", if the number of rows in the array is 0.
    */
    public static String toString(char[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Null array");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        String result = "";
        for (char[] row : array) {
            for (char c : row) {
                result += c;
            }
            result += "\n";
        }
        return result;
    }
}


