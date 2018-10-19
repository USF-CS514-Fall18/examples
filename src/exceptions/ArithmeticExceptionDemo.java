package exceptions;

/** Example on using try/catch to handle an arithmetic exception */
public class ArithmeticExceptionDemo {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            int c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by 0.");
        }
    }
}
