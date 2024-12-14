import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
* Project3 - simple form of text compression
* provides methods for processing, compressing and decompressing text files.
* involves replacing specific character sequences with special characters.
* @author Jayani Sivakumar
*/
public class Compression {
    
    /**
    * If compress is true, read text from input scanner then compress
    * the text and write the compressed text to output
    * If compress is false, read text from input scanner then decompress 
    * the text and write the decompressed text to output
    *
    * @param compress boolean value indicating whether to compress or decompress the text
    * @param input Scanner object for reading input text
    * @param output PrintWriter object for writing compressed or decompressed text
    * @throws IllegalArgumentException with the message, "Null input", if input is null
    * @throws IllegalArgumentException with the message, "Null output", if output is null
    */
    public static void processFile (boolean compress, Scanner input, PrintWriter output) {
        if (input == null) {
            throw new IllegalArgumentException("Null input");
        }
        else if (output == null) {
            throw new IllegalArgumentException("Null output");
        }
        while (input.hasNext()) {
            if (compress == true) {
                String c = input.nextLine();
                String text = compressLine(c);
                if(input.hasNextLine()) {
                    text += '\n';
                }
                
                output.print(text);
                
            }
            else if (compress == false) {
                String d = input.nextLine();
                String text1 = decompressLine(d);
                if (input.hasNextLine()) {
                    text1 += '\n';

                }
                
                output.print(text1);
            }
        }
        output.close();
    }


    /**
    * Returns string containing compressed line
    *
    * @param line the input line to be compressed
    * @return returns compressed verison of input line
    * @throws IllegalArgumentException with the message, "Null line", if line is null
    */
    public static String compressLine(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Null line");
        }

        StringBuilder compressedLine = new StringBuilder();
        String[] words = line.split("\\s+");
        for (String word : words) {
            compressedLine.append(compressWord(word)).append(" ");
        }
        return compressedLine.toString().trim();

    }

    /**
    * Returns string containing compressed word (token)
    *
    * @param word the input word to be compressed
    * @return returns compressed version of input word
    * @throws IllegalArgumentException with the message, "Null word", if word is null
    */
    public static String compressWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Null word");
        }
        String[][] replacements = {
            {"the", "&"},
            {"an", "~"},
            {"ion", "#"},
            {"ing", "@"},
            {"tis", "%"},
            {"men", "+"},
            {"re", "$"}
        };
        for (String[] replacement : replacements) {
            int index = word.indexOf(replacement[0]);
            if (index != -1) {
                StringBuilder compressedWord = new StringBuilder(word.substring(0, index));
                compressedWord.append(replacement[1]).append
                    (word.substring(index + replacement[0].length()));
                word = compressedWord.toString();
            }
        }
        return word;
    }
        

    /**
    * Returns string containing decompressed line
    *
    * @param line the input line to be decompressed
    * @return returns decompressed version of input line
    * @throws IllegalArgumentException with the message, "Null line", if line is null
    */
    public static String decompressLine(String line){
        if (line == null) {
            throw new IllegalArgumentException("Null line");
        }
        StringBuilder decompressedLine = new StringBuilder();
        String[] words = line.split("\\s+");
        for (String word : words) {
            decompressedLine.append(decompressWord(word)).append(" ");
        }
        return decompressedLine.toString().trim();
    }


    /**
    * Returns string containing decompressed word (token)
    *
    * @param word the input word to be decompressed
    * @return returns decompressed version of input word
    * @throws IllegalArgumentException with the message, "Null word", if word is null
    */
    public static String decompressWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Null word");
        }
        String[][] replacements = {
            {"&", "the"},
            {"~", "an"},
            {"#", "ion"},
            {"@", "ing"},
            {"%", "tis"},
            {"+", "men"},
            {"$", "re"}
            
        };
        for (String[] replacement : replacements) {
            int index = word.indexOf(replacement[0]);
            if (index != -1) {
                StringBuilder decompressedWord = new StringBuilder(word.substring(0, index));
                decompressedWord.append(replacement[1]).append
                    (word.substring(index + replacement[0].length()));
                word = decompressedWord.toString();
            }
        }
        return word;
    }
    
    /**
     * Accepts command-line arguments for compression or decompression, input file
     * and output file.
     * User interface error checking is performed to handle invalid
     * inputs and file operations.
     *
     * @param args command-line arguments for operations (-C for compression, -D
     * for decompression), input file, and output file
     */
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: java -cp bin Compression {-C|-D} infile outfile");
            System.exit(1);
        }

        String file = args[0];
        String inputFileName = args[1];
        String outputFileName = args[2];

        if (!file.equals("-C") && !file.equals("-D")) {
            System.out.println("Usage: java -cp bin Compression {-C|-D} infile outfile");
            System.exit(1);
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(inputFileName);
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to access input file: " + inputFileName);
            System.exit(1);
        }

        Path path = Path.of(outputFileName);
        FileOutputStream outputStream = null;
        try {
            if (!Files.exists(path)) {
                outputStream = new FileOutputStream(outputFileName);
            } else {
                System.out.print(outputFileName + "exists - OK to overwrite (y,n)?: ");
                Scanner scanner = new Scanner(System.in);
                String response = scanner.next();
                if (!(response.charAt(0) == 'y' || response.charAt(0) == 'Y')) {
                    System.exit(1);
                } else {
                    outputStream = new FileOutputStream(outputFileName);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot create output file");
            System.exit(1);
        }

        Scanner input = new Scanner(inputStream);
        PrintWriter outputWriter = new PrintWriter(outputStream);

        boolean compress = false;
        if (file.charAt(1) == 'C') {
            compress = true;
        }
        else if (file.charAt(1) == 'D') {
            compress = false;
        }
        processFile(compress, input, outputWriter);
        
    }
}
        