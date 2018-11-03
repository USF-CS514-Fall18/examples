package codeCamp2;

/** Problem 1, class TreasureChest */
public class TreasureChest implements Lockable {
    private String treasure; // description of treasure
    private int key; // key for the lock of this treasure chest
    private boolean locked; // whether it is locked or unlocked

    /** Sets treasure, sets the key value and locks the treasure chest
     *
     * @param treasure treasure description
     * @param key integer key
     */
    public TreasureChest(String treasure, int key) {
        this.treasure = treasure;
        this.key = key;
        this.locked = true;
    }


    /**
     * Locks the treasure chest with this key if it matches saved key
     * @param key key
     * @return true if was able to lock successfully and false otherwise
     */
    @Override
    public boolean lock(int key) {
        if (key == this.key) {
            locked = true;
            return true; //operation was successful
        } else {
            System.out.println("Key does not match");
            return false; // could not lock
        }
    }

    /** Unlocks the treasure chest if the key matches.
     *
     * @param key key
     * @return True if we were able to successfully unlock the treasure chest,
     * and false otherwise.
     */
    @Override
    public boolean unlock(int key) {
        if (key == this.key) {
            locked = false;
            return true; //operation was successful
        } else {
            System.out.println("Key does not match");
            return false; // could not unlock
        }
    }

    /**
     * True if it's locked and false otherwise.
     * @return whether it's locked
     */
    @Override
    public boolean isLocked() {
        return locked;
    }

    /** If the key matches, returns the description of the treasure
     *
     * @param key key
     * @return description of the treasure
     */
    public String getTreasure(int key) {
        if (unlock(key))
            return treasure;
        else
            return null;
    }
}

