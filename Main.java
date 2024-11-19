public class Main {
    public static void main(String[] args) {
        // Test with BadString.txt
        System.out.println("Processing BadString.txt with max length 7:");
        FileProcessor badFileProcessor = new FileProcessor("BadString.txt", 7);
        badFileProcessor.processFile();
        System.out.println("Strings successfully read: " + badFileProcessor.getArrayListSize());
        System.out.println();

        // Test with goodString.txt
        System.out.println("Processing goodString.txt with max length 7:");
        FileProcessor goodFileProcessor = new FileProcessor("goodString.txt", 7);
        goodFileProcessor.processFile();
        System.out.println("Strings successfully read: " + goodFileProcessor.getArrayListSize());
        System.out.println();

        // Test with a smaller length limit
        System.out.println("Processing BadString.txt with max length 5:");
        FileProcessor shortLengthProcessor = new FileProcessor("BadString.txt", 5);
        shortLengthProcessor.processFile();
        System.out.println("Strings successfully read: " + shortLengthProcessor.getArrayListSize());
    }
}