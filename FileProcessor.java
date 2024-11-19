import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {
    private String fileName;
    private int stringLength;
    private ArrayList<String> strings;

    // Constructor
    public FileProcessor(String fileName, int stringLength) {
        strings = new ArrayList<>();
        setFileName(fileName);
        setStringLength(stringLength);
    }

    // Setter and getter for fileName
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    // Setter and getter for stringLength with bounds checking
    public void setStringLength(int stringLength) {
        if (stringLength < 5) {
            this.stringLength = 5;
        } else {
            this.stringLength = stringLength;
        }
    }

    public int getStringLength() {
        return stringLength;
    }

    // Method to get the size of the ArrayList
    public int getArrayListSize() {
        return strings.size();
    }

    // Method to process the file
    public void processFile() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine() && scanner.nextLine().length() <= stringLength) {
                String line = scanner.nextLine();
                try {
                    System.out.println("Processing line: " + line); // Debug log
                    if (line.length() > stringLength) {
                        throw new StringTooLongException("String is too long!");
                    }
                    strings.add(line); // Add valid strings to the ArrayList
                     System.out.println("Added: " + line); // Debug log
                } catch (StringTooLongException e) {
                    System.out.println(e.getMessage() + " -> " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}