package arrays;

public class MaxSumOfNonAdjacentNumbers {
    public static void main(String[] args) {
        int[] arr1 = {5, 5, 10, 100, 10, 5};
        System.out.println(new MaxSumOfNonAdjacentNumbers().findMax(arr1));

        int[] arr2 = {1, 2, 3};
        System.out.println(new MaxSumOfNonAdjacentNumbers().findMax(arr2));
    }

    private int findMax(int[] arr) {
        int incl = arr[0];
        int excl = 0;
        int exclNew = 0;

        // There are two cases here
        // 1. If I include the current then incl will be excluding prev + current element
        // 2. If I exclude current then excl will be max of excl or incl
        for (int i = 1; i < arr.length; i++) {
            // 2nd case
            exclNew = Math.max(excl, incl);

            // 1st case
            incl = arr[i] + excl;

            excl = exclNew;
        }

        return Math.max(excl, incl);
    }
}
