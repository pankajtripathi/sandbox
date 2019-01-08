package arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(nums));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums.length < 3) return new ArrayList<>(result);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;

            int complement = -nums[i];
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                if (nums[low] + nums[high] == complement) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;

                    // skip already seen numbers
                    while (low < high && low > 0 && nums[low - 1] == nums[low])
                        low++;
                    // skip already seen numbers
                    while (low < high && high < nums.length - 1 && nums[high] == nums[high + 1])
                        high--;

                }
                else if (nums[low] + nums[high] < complement) {
                    low++;
                } else if (nums[low] + nums[high] > complement) {
                    high--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
