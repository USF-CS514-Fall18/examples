package nestedClasses;
/** MyOuter class, contains MyInner class.
 *  Demonstrates the use of an inner class. */
public class MyOuter {
    private String message = "Eat";
    private String name = "Hoho";

    /** Inner class */
    private class MyInner {
        private String message = "Love";

        private void printMessages() {
            String message = "Pray";
            System.out.print(message + " ");
            System.out.print(this.message + " ");
            System.out.print(MyOuter.this.message);
            System.out.println( " " + name);
        }
    }

    public static void main(String[] args) {
        MyOuter.MyInner obj = new MyOuter().new MyInner();
        obj.printMessages();

    }
}
