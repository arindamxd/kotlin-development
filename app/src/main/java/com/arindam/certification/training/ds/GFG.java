package com.arindam.certification.training.ds;

/**
 * Java program to find out all combinations of positive numbers that add up to given number.
 *
 * Created by Arindam Karmakar on 29/7/19.
 */

public class GFG {

    /**
     * @param arr        array to store the combination
     * @param index      next location in array
     * @param num        given number
     * @param reducedNum reduced number
     */
    private static void findCombinationsUtil(int[] arr, int index, int num, int reducedNum) {

        // Base condition
        if (reducedNum < 0)
            return;

        // If combination is
        // found, print it
        if (reducedNum == 0) {
            for (int i = 0; i < index; i++)
                System.out.print(arr[i] + " ");

            System.out.println();
            return;
        }

        // Find the previous number
        // stored in arr[]. It helps
        // in maintaining increasing
        // order
        int prev = (index == 0) ? 1 : arr[index - 1];

        // note loop starts from
        // previous number i.e. at
        // array location index - 1
        for (int k = prev; k <= num; k++) {
            // next element of
            // array is k
            arr[index] = k;

            // call recursively with
            // reduced number
            findCombinationsUtil(arr, index + 1, num, reducedNum - k);
        }
    }

    /* Function to find out all
    combinations of positive
    numbers that add upto given
    number. It uses findCombinationsUtil() */

    /**
     * Function to find out all combinations of positive numbers that add up to given number.
     * It uses findCombinationsUtil()
     *
     * @param n max n elements
     */
    private static void findCombinations(int n) {
        // array to store the combinations
        // It can contain max n elements
        int[] arr = new int[n];

        // find all combinations
        findCombinationsUtil(arr, 0, n, n);
    }

    // Driver code
    public static void main(String[] args) {
        int k = 5;
        findCombinations(k);
    }
}
