package inheritance;

/** Book.java       Author: Lewis/Loftus
 *  Represents a book. Used as the parent of a derived class to
 *  demonstrate inheritance.
 */
public class Book
{
    private int pages = 1500;

    /**  Pages mutator.
     *
     * @param numPages number of pages
     */
    public void setPages(int numPages)
    {
        pages = numPages;
    }

    /**  Pages accessor.
     *
     * @return number of pages
     */
    public int getPages()
    {
        return pages;
    }
}