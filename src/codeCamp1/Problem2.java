package codeCamp1;

import java.util.Scanner;

public class Problem2 {
    /**
     * Prompts the user to repeatedly enter integer numbers
     * and sums them up, until the user enters a 0.
     */
    public void getNumbersAndComputeSum() {
        // FILL  IN CODE
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int num = 1;
        while (num != 0) {
            System.out.println("Enter a non-zero number to add or 0 to exit: ");
            num = Integer.parseInt(sc.nextLine());
            sum += num;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Problem2 pr = new Problem2();
        pr.getNumbersAndComputeSum();
    }
}