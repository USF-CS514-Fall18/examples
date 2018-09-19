package fileProcessing;

import java.io.IOException;
import java.nio.file.*;


/** Demonstrates how to use DirectoryStream to get all files and subdirectories
 *  in a given directory */
public class DirectoryStreamExample {
    public static void main(String[] args) {
        Path p = Paths.get("dir");
        try (DirectoryStream<Path> filesList = Files.newDirectoryStream(p)) {
            for (Path file : filesList) {
                // print the name of each file in the directory
                if (!Files.isDirectory(file))
                    System.out.println(file);
            }
        } catch (IOException e) {
            System.out.println("Can not open directory");
        }
    }
}
