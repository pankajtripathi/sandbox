package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is
* the last element of the LIS. Then, L(i) can be recursively written as:
*  L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
*  L(i) = 1, if no such j exists.
*
* Input: nums = [0,1,0,3,2,3]
* Output: 4
* */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int a[] = {0,1,0,3,2,3};
        System.out.println(new LongestIncreasingSubsequence().longestSeqDP(a));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(a));
    }

    // O(n^2)
    private int longestSeqDP(int[] arr) {
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
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            result = Math.max(result, LIS[i]);
        }

        return result;
    }

    // If binary search cannot find element it returns -(insertion) - 1
    // where The insertion point is the point at which the key would be inserted into the array:
    // the index of the first element greater than the key, or a.length if all elements in the array are
    // less than the specified key.
    // O(n log n)
    private int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.size() == 0 || num > list.get(list.size() - 1))
                list.add(num);
            else {
                int idx = Collections.binarySearch(list, num);
                list.set(idx < 0 ? -idx-1 : idx, num);
            }
        }
        return list.size();
    }
}
