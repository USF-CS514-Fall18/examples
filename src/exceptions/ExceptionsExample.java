package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionsExample {

    public static void main(String[] args) {
        try {
            System.out.println("Statement 1" + 5/0);

            Scanner sc = new Scanner(new File("file1.txt"));
            // to do: more code
        }
        catch (FileNotFoundException e) {
            // statements executed when
            // exception is thrown
           System.out.println("Statement Catch");
        }
        finally {
            // statements that are executed
            // in any case
            System.out.println("Statement 3");
        }
        System.out.println("Statement 4");

    }
}
