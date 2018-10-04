package fileIO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/** Demonstrates how to use a PrintWriter to write to the file. */
public class PrintWriterExample {

    /**
     * Writes words from the given array to the file.
     * One word per line.
     * @param filename
     */
    public static void writeToFile(String[] arr, String filename) {
        try (PrintWriter pw = new PrintWriter(new File(filename))) {
            for (int i = 0; i < arr.length; i++) {
                pw.println(arr[i]);
            }
            pw.flush();
        }
        catch (IOException e) {
            System.out.println("Could not write to the file: " + e);
        }
    }

    public static void main(String[] args) {
        String[] words = {"cat", "dog", "bird", "elephant"};
        PrintWriterExample.writeToFile(words, "animals.txt");
    }
}
