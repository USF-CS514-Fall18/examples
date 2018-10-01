package codeCamp1;

// Problem 5

public class StringUtil {
    /**
     * Recursive method that checks whether
     * a given string contains a given substring.
     * @param string given string
     * @param substring given substring
     * @return true if the given string contains the given substring
     */
    public static boolean contains(String string, String substring) {
        // FILL IN CODE
        if (string == null || substring == null)
            return false;
        if (string.isEmpty() && !substring.isEmpty())
            return false;
        if (string.startsWith(substring))
            return true;
        else
            return contains(string.substring(1, string.length()), substring);

    }

    public static void main(String[] args) {
        boolean found = StringUtil.contains("hello", "ll");
        System.out.println(found);
        System.out.println(StringUtil.contains("help", "hello, world!" ));
    }

}
