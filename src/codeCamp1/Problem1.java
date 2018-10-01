package codeCamp1;

public class Problem1 {
    /** Takes an array of integers alist and integer num,
     * and returns an array of two elements, where the first one is
     *  the sum of elements in the array that are larger than num;
     *  and the second element of the resulting  has the sum elements
     *  of alist that are less than num.
     *  @param alist array of integers
     *  @param num integer number
     *  @return array of two elements: the sum of elements of alist
     *  that are larger than num and the sum of elements of alist
     *  that are less than num */
    public int[] sumElems(int[] alist, int num) {
        int[] res = new int[2];
        if (alist == null)
            return res;

        for (int i = 0; i < alist.length; i++) {
            if (alist[i] > num)
                res[0] += alist[i];
            else
                res[1] += alist[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1 pr1 = new Problem1();
        int[] arr = {10, 3, 8, 5, 7, 2, 1};
        int[] res = pr1.sumElems(arr, 6);
        if (res != null && res.length == 2)
        System.out.println(res[0] + " " + res[1]);

    }
}
