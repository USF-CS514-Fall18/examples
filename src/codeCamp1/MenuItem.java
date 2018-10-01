package codeCamp1;

import java.io.*;
import java.util.*;
public class MenuItem {
    private String name; // the name. Example: "sesame chicken"
    private float price; // the price
    private ArrayList<String> ingredients; // a list of ingredients			// Example: "cubed chicken meat", "soy sauce", "oil", "flour"

    /**
     * Constructor for class MenuItem
     * @param name
     * @param price
     */
    public MenuItem(String name, float price) {
        this.name = name;
        this.price = price;
    }
    /** Constructor that loads info about a single MenuItem from the file.
     * @param filename
     */
    public MenuItem(String filename) {
        /* Reads info about a single menu from the given file.
        The info about the menu item is in the following format:
         name, price
         ingredient1, ingredient2, ingredient3, ..
         */
        ingredients = new ArrayList();
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
            if (sc.hasNextLine()) { // read first line
                String firstLine = sc.nextLine();
                String[] words = firstLine.split(", ");
                if (words.length != 2) {
                    System.out.println("Incorrect file format");
                    return; // would be better to throw an exception here
                }
                this.name = words[0];
                this.price = Float.parseFloat(words[1]);
            }
            if (sc.hasNextLine()) { // read second line
                // Assume all ingredients fit into one line
                String secondLine = sc.nextLine();
                String[] ingredients = secondLine.split(", ");
                for (String ing: ingredients) {
                    this.ingredients.add(ing);
                }

            }
        }
        catch (IOException e) {
            System.out.println("Could not read from the file: " + e);
        }
    }

    /** Return name of this menu item
     *  @return name */
    public String getName() {
        return name;
    }


    /** Return price of this menu item
     *  @return price */
    public float getPrice() {
        return price;
    }

    /** Add this ingredient to the ArrayList of ingredients
     * @param ingredient */
    public void addIngredient(String ingredient) {
        // FILL IN CODE
        if (ingredients == null) {
            ingredients = new ArrayList();
        }
        ingredients.add(ingredient);
    }


    /** Increases the price of this menu item by the given price difference
     * @param priceDifference */
    public void increasePrice(float priceDifference) {
        // Update the price: increase it by priceDifference, assume it's >=0
        // FILL IN CODE
        this.price += priceDifference;
    }

    /** Returns true if this item contains a given ingredient
     *  @param ingredient
     *  @return true if this menu item contains this ingredient
     */
    public boolean containsIngredient(String ingredient) {
        // FILL IN CODE
        // You may NOT use contains method
        if (ingredients == null)
            return false;
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).equals(ingredient))
                return true;
        }
        return false;
    }

    /** Return menu item info in the following format:
     *  name, price; ingredients separated by comma
     *  Example: Sesame chicken, 8.25; cubed chicken meat, soy sauce, oil, flour
     */
    public String toString() {
        // FILL IN CODE:
        StringBuffer sb  = new StringBuffer();
        sb.append(name + ", " + price + "; ");
        for (int i = 0; i < ingredients.size() - 1; i++) {
            sb.append(ingredients.get(i) + ", ");
        }
        sb.append(ingredients.get(ingredients.size()-1));
        return sb.toString();
    }

    public static void main(String[] args) {
        MenuItem it = new MenuItem("src/codeCamp1/sesameChicken");
        System.out.println(it);
        System.out.println(it.containsIngredient("soy sauce"));
        System.out.println(it.containsIngredient("milk"));
        it.addIngredient("pepper");
        System.out.println(it);
        it.increasePrice(1.5f);
        System.out.println(it);

    }
}

