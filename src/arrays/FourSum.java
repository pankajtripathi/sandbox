package arrays;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println(new FourSum().fourSum(nums, target));
    }

    private List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums == null || nums.length < 4) return new ArrayList<>(result);

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j - 1] == nums[j]) continue;

                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] + nums[i] + nums[j] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;

                        while (low < high && low > 0 && nums[low - 1] == nums[low])
                            low++;

                        while (low < high && high < nums.length - 1 && nums[high + 1] == nums[high])
                            high--;

                    } else if (target > nums[low] + nums[high] + nums[i] + nums[j]) {
                        low++;
                    } else if (target < nums[low] + nums[high] + nums[i] + nums[j]) {
                        high--;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
