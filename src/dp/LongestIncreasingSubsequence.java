package dp;

/*
* Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is
* the last element of the LIS. Then, L(i) can be recursively written as:
*  L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
*  L(i) = 1, if no such j exists.
* */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int a[] = {50, 3, 10, 7, 40, 80};
        System.out.println(longestSeqDP(a));
    }

    private static int longestSeqDP(int[] arr) {
        if (arr.length == 0) return 0;

        int[] LIS = new int[arr.length];
        for (int i = 0; i < LIS.length; i++) {
            LIS[i] = 1;
        }

        int result = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                // if arr[i] > arr[j LIS[i] = LIS[j] + 1;
                if (arr[i] > arr[j]) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            result = Math.max(result, LIS[i]);
        }

        return result;
    }
}
