package staticKeyword;

public class MyClass {
    private static int var;

    public void setVar(int newVal) {
        var = newVal;
    }

    public int getVar() {
        return var;
    }

    public static void main(String[] args) {
        MyClass first = new MyClass();
        MyClass second = new MyClass();
        first.setVar(10);
        second.setVar(5);
        System.out.println(first.getVar());
    }
}
