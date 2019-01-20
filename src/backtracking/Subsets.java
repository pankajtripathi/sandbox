package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
* */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, new ArrayList<>(), result, 0);
        return result;
    }

    private void backtracking(int[] nums, List<Integer> temp, List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            // choose
            temp.add(nums[i]);

            // explore
            backtracking(nums, temp, result, i + 1);

            //remove
            temp.remove(temp.size() - 1);
        }
    }
}
