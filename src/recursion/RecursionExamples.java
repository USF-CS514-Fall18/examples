package recursion;

/** Demonstrates how to write recursive methods */
public class RecursionExamples {

    /** Computes factorial of n
     * @param n integer number
     * @return factorial of n
     */
    public static int factorial(int n) {
        if (n <= 0)
            return 1;
        else
            return n*factorial(n-1);
    }

    /**
     * Computes sum of numbers from 1 to n
     * @param n integer n
     * @return sum of numbers from 1 to n
     */
    public static int sum(int n) {
        if (n < 1)
            return 0; // throw an exception?

        if (n == 1)
            return 1;
        else
            return n + sum(n-1);
    }

    /**
     * Power function. Computes x to the power of n
     * @param x number to raise to the power of n
     * @param n exponent
     * @return x to the power of n
     */
    public static double pow(double x, int n) {
        if (n == 0) // base case
            return 1;
        else if (n > 0) // recursive case
            return x * pow(x, n - 1);
        else {
            return (1.0/x) * pow(x, n + 1);
        }
    }

    /** Reverses a string
     *
     * @param s string
     * @return reversed string
     */
    public static String reverse(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        else {
            return reverse(s.substring(1, n)) + s.charAt(0);
        }
    }

    public static void main(String[] args) {
        System.out.print("Factorial of 5: ");
        System.out.println(RecursionExamples.factorial(5));

        System.out.print("Sum of numbers from 1 to 5: ");
        System.out.println(RecursionExamples.sum(5));

        System.out.print("Power (2, 5): ");
        System.out.println(RecursionExamples.pow(2, 5));

        System.out.print("Reversing a string hello: ");
        System.out.println(RecursionExamples.reverse("hello"));


    }
}
