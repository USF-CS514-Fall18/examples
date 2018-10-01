package codeCamp1;

import java.util.*;

public class Menu {
    private HashMap<String, MenuItem> items;
    // maps the name of the menuItem to the corresponding MenuItem

    /** Constructor of class Menu */
    public Menu() {
        items = new HashMap();
    }

    /** Create a MenuItem with the given name, price and list of ingredients.
     .  * Then add the MenuItem to the HashMap called items declared earlier */
    public void addMenuItem(String name, float price, ArrayList<String> ingredients)
    {
        // FILL IN CODE
        MenuItem m = new MenuItem(name, price); // create MenuItem
        for (String ing: ingredients) { // add ingredients
            m.addIngredient(ing);
        }
        items.put(name, m); // add to the map
    }


    /** Takes the names of the menu item and returns true if it is offered in this menu
     * and false otherwise. Method must be efficient.
     * @param name
     * @return true if this item is contained in the menu */
    public boolean isOffered(String name) {
        // FILL IN CODE
        if (items == null)
            return false;
        return (items.get(name) != null);
    }

    /** Return a list of names of menu items that contain a given ingredient */
    public ArrayList<MenuItem> getMenuItemsWithIngredient(String ingredient) {
        // FILL IN CODE
        ArrayList<MenuItem> itemsWithThisIngredient  = new ArrayList<>();
        for (String name: items.keySet()) {
            MenuItem m = items.get(name);
            if (m != null) {
                if (m.containsIngredient(ingredient))
                    itemsWithThisIngredient.add(m);
            }
        }
        return itemsWithThisIngredient;

    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<String> ingredients1 = new ArrayList();
        ingredients1.add("soy");
        ingredients1.add("chicken");
        ingredients1.add("sesame");
        menu.addMenuItem("sesame chicken", 10.0f, ingredients1);

        ArrayList<String> ingredients2 = new ArrayList();
        ingredients2.add("cheese");
        ingredients2.add("flour");
        ingredients2.add("tomato sauce");
        menu.addMenuItem("cheese pizza", 9.5f, ingredients2);

        System.out.println(menu.isOffered("cheese pizza"));
        System.out.println(menu.isOffered("mushroom pizza"));
        System.out.println(menu.getMenuItemsWithIngredient("cheese"));



    }
}
