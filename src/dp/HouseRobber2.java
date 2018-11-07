package dp;

/*
* Similar to house robber problem thwe only change is that houses are arranged circularly. Hence first and last
* houses are neighbors.
*
* */
public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new HouseRobber2().rob(nums));
    }

    private int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // first is included and last is excluded
        int max1 = robHelper(nums, 2, nums.length - 2);

        // first is excluded and last is included
        int max2 = robHelper(nums, 1, nums.length - 1);

        // added first element to max1 coz we did not add it while calculating max1
        return Math.max(nums[0] + max1, max2);
    }

    private int robHelper(int[] nums, int from, int to) {
        if (from > to) return 0;
        if (from == to) return nums[from];

        int[] dp = new int[to - from + 1];
        dp[0] = nums[from];
        dp[1] = Math.max(dp[0], nums[from + 1]);

        for (int i = 2; i < to - from; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[to - from];
    }
}
