package fileProcessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PathExample {

    public static void printPathInfo(Path path) {
        System.out.println("toString(): " + path.toString());
        System.out.println("Parent: " + path.getParent());
        System.out.println("Root: " + path.getRoot());
        System.out.println("getFileName: " + path.getFileName());

        try {
            System.out.println(Files.size(path));
            System.out.println(Files.getOwner(path));
            System.out.println(Files.exists(path));

        } catch (IOException e) {
            System.out.println("IOException occurred");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        String currPath = "dir"; // relative path
        System.out.println("-----Info about " + currPath);
        Path p = Paths.get(currPath); // relative path
        printPathInfo(p);

        currPath = "."; // relative path, current directory
        System.out.println("-----Info about " + currPath);
        Path relativeDirectory = Paths.get(currPath); //curent directory
        printPathInfo(relativeDirectory);

        Path absoluteDirectory = relativeDirectory.toAbsolutePath();
        System.out.println("-----Info about " + absoluteDirectory);
        printPathInfo(absoluteDirectory);

        // combine paths together
        Path srcDirectory = Paths.get(".", "dir/song.txt");
        printPathInfo(srcDirectory);

        // canonical path
        Path path = Paths.get("./dir/././song.txt");
        System.out.println("Absolute path: " + path.toAbsolutePath());
        Path canonicalPath = path.toAbsolutePath().normalize();
        printPathInfo(canonicalPath);

    }
}