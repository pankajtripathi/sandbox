package dp;


// Similar to knapsack problem. In this case sum is capacity
public class SubsetSum {
    public static void main (String args[]) {
        int set[] = {3, 34, 12, 2};
        int sum = 14;
        int n = set.length;

        if (isSubsetSumWithoutDP(set, n, sum) == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");

        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }

    private static boolean isSubsetSum(int[] set, int N, int sum) {
        boolean[][] dp = new boolean[N + 1][sum + 1];

        for (int n = 0; n < dp.length; n++) {
            for (int s = 0; s < dp[0].length; s++) {
                if (s == 0) dp[n][s] = true;
                else if (n == 0 && s != 0) dp[n][s] = false;
                else if (set[n - 1] > s) dp[n][s] = dp[n - 1][s];
                else dp[n][s] = dp[n - 1][s - set[n - 1]] || dp[n - 1][s];
            }
        }

        return dp[N][sum];
    }

    private static boolean isSubsetSumWithoutDP(int[] set, int n, int sum) {
        if (sum == 0) return true;
        else if (n == 0 && sum != 0) return false;
        // if last element is greater than sum then exclude that
        else if (set[n - 1] > sum) return isSubsetSumWithoutDP(set, n - 1, sum);
        else return isSubsetSumWithoutDP(set, n - 1, sum - set[n - 1])
                    || isSubsetSumWithoutDP(set, n- 1, sum);
    }
}
