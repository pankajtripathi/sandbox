package arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permutation().permute(nums));
    }

    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        permutations(nums, new ArrayList<>(), result);

        return result;
    }

    private void permutations(int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if (nums.length == temp.size()) result.add(new ArrayList(temp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) continue;
                // choose first num
                temp.add(nums[i]);

                // explore options
                permutations(nums, temp, result);

                // remove the added num
                temp.remove(temp.size() - 1);
            }
        }
    }


}
