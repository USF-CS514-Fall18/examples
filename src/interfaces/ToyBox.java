package interfaces;

import java.util.Iterator;

/** Class ToyBox. Shows an example of how to implement an Iterator interface
 *  (see inner class ToyIterator)
 */
public class ToyBox  {
    public static final int MAX_NUM = 10;
    private String[] toys;
    private int size;

    /**
     * Constructor of class ToyBox
     */
    public ToyBox() {
        this.toys = new String[MAX_NUM ];
        this.size = 0;
    }

    /** Constructor of class ToyBox
     *
     * @param newToys toys in an array of Strings
     */
    public ToyBox(String[] newToys) {
        this.size = newToys.length;
        this.toys = new String[size];
        for (int i = 0; i < size; i++) {
            this.toys[i] = newToys[i];
        }
    }

    /**
     * Adds a toy to the ToyBox
     * @param toy
     */
    public void add(String toy) {
        toys[size] = toy;
        size++;

    }

    /** Method returning an iterator for this ToyBox
     *
     * @return ToyIterator
     */
    public ToyIterator iterator() {
        ToyIterator it = new ToyIterator();
        return it;
    }

    /**
     * Inner class ToyIterator of outer class ToyBox:
     * Implement Iterator interface
     */
    class ToyIterator implements Iterator<String> {
        private int currentIndex = 0;

        /**
         * Return true if there is "next" toy in the ToyBox, and false otherwise
         * @return true if there is next toy
         */
        public boolean hasNext() {
            boolean b = currentIndex < size && (toys[currentIndex] != null);
            //System.out.println(currentIndex + " " + b);
            return b;
        }

        /**
         * Returns the "next" toy
         * @return next toy
         */
        public String next() {
            String nextElem = toys[currentIndex];
            currentIndex++;
            return nextElem;
        }

    }// inner class MyIterator
}


