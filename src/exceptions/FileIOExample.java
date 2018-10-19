package exceptions;

import java.io.*;

/** Demonstates the use of BufferedReader to read from the file,
 * and the use of PrintWriter to print to a file */

public class FileIOExample {

    /** Reads lines from the input file and prints them to the console
     *
     * @param input name of the file
     */
    public static void readFromFile(String input) {
        BufferedReader br = null;
        try {
            FileReader f = new FileReader(input);

            br = new BufferedReader(f);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        finally {
            try {
                br.close();
            }
            catch (IOException e) {
                System.out.println("Exception occurred while closing the file");

            }
        }

    }

    /** Reads lines from the input file and writes them to the output file
     *
     * @param input input file
     * @param output output file
     */
    public static void readAndPrint(String input, String output) {
        try (FileReader f = new FileReader(input); PrintWriter writer = new PrintWriter(new FileWriter(output))) {
            BufferedReader br = new BufferedReader(f);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("line = " + line);
                writer.println(line);

            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException occured" + e);
        }
        // no need to close FileReader, BufferedReader or PrintWriter because
        // we used try with resources -> they will be closed automatically.
    }

    public static void main(String[] args) {
        readFromFile("dir/song.txt");
        // readAndPrint("myFile.txt", "out.txt");

    }

}
