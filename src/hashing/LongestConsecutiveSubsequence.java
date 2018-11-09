package hashing;

import java.util.HashSet;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.

Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
* */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSubsequence().longestConsecutive(arr));
    }

    private int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : nums) {
            int res = 0;
            if (!set.contains(num - 1)) {
                int index = num;
                while (set.contains(index)) {
                    res++;
                    index++;
                }
            }
            max = Math.max(max, res);
        }

        return max;
    }
}
