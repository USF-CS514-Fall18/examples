package codeCamp2;

/** Problem 1 */
interface Lockable {
    boolean lock(int key);    // locks if the key is correct
    boolean unlock(int key);  // unlocks if the key is correct
    boolean isLocked();       // true if the object is locked
}
