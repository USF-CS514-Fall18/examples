package codeCamp2;

import java.util.Random;
import java.util.Scanner;

/** Driver class for Problem 1 of the code camp */
public class TreasureChestTest {
    public static void main(String[] args) {

        // Problem 1:
        Random r = new Random();
        int key = r.nextInt(11);
        TreasureChest box = new TreasureChest("Gold", key);
        //System.out.println("Hint: The key for chest is " + key);

        Scanner sc = new Scanner(System.in);
        System.out.println("Guess the key from 0 to 10 to unlock the treasure chest: ");
        int guessKey = Integer.parseInt(sc.nextLine());
        while (guessKey != key) {
            System.out.println("You did not guess correctly, try again.");
            System.out.println("Guess the key from 0 to 10 to unlock the treasure chest: ");
            guessKey = Integer.parseInt(sc.nextLine());
        }
        String treasure = box.getTreasure(guessKey);
        System.out.println("You unlocked the treasure chest and saw: " + treasure);

    }
}
