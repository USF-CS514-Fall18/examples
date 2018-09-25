package maps;

import java.util.ArrayList;
import java.util.HashMap;

public class NestedMapExample {
    private HashMap<String, ArrayList<Integer>> map;
    // HashMap called map, where keys are words
    // For each word, it stores the arraylist of its positions within some "document"

    public NestedMapExample() {
        map = new HashMap();
    }

    /** Takes a "document" - an array of words, and creates a HashMap, where
     *  each word is a key; and the value is a list of positions of this word
     *  within the "document"
     * @param documentOfWords
     */
    public void createMap(String[] documentOfWords) {
        for (int i = 0 ; i < documentOfWords.length; i++) {
            String word = documentOfWords[i];
            if (map.containsKey(word)) {
                // word was already added as the key;
                // so there is a corresponding value (ArrayList) in the map
                ArrayList<Integer> list = map.get(word);
                list.add(i); // add another position to the list
            }
            else {
                // word is not a key yet, so no value for it
                ArrayList<Integer> list = new ArrayList();
                list.add(i);
                map.put(word, list); // put this word as the key, and the list as the value
            }
            // note: the code above can be shorted
        }
    }

    /** Prints the map */
    public void print() {
        for (String word: map.keySet()) {
            System.out.print(word + ": ");
            for (Integer i: map.get(word)) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NestedMapExample mapExample = new NestedMapExample();
        String[] words = {"cat", "dog", "bird", "dog", "fox", "fox", "cat", "dog", "cat"};
        mapExample.createMap(words);
        mapExample.print();
    }
}
