package dp;


/*
* Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in
* the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
* associated with n items respectively. Also given an integer W which represents knapsack capacity,
* find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
* */
public class Knapsack {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println("KnapSack Without DP: " + knapSackWithoutDP(W, wt, val, n));
        System.out.println("KnapSack With DP: " + knapSack(W, wt, val, n));
    }

    private static int knapSack(int W, int[] wt, int[] val, int N) {
        int[][] dp = new int[N + 1][W + 1];

        for (int n = 0; n < dp.length; n++) {
            for (int w = 0; w < dp[0].length; w++) {
                if (w == 0 || n == 0) dp[n][w] = 0;

                //since last items weight is greater than capacity exclude the last item
                else if (wt[n - 1] > w) dp[n][w] = dp[n - 1][w];

                // else max of two cases
                // 1. include last item
                // 2. exclude last item
                else dp[n][w] = Math.max(dp[n-1][w - wt[n - 1]] + val[n - 1], dp[n - 1][w]);
            }
        }

        return dp[N][W];
    }

    private static int knapSackWithoutDP(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0) return 0;

        //since last items weight is greater than capacity exclude the last item
        else if (wt[n - 1] > W) return knapSack(W, wt, val, n-1);

        // else max of two cases
        // 1. include last item
        // 2. exclude last item
        else return Math.max(knapSack(W - wt[n-1], wt, val, n - 1) + val[n - 1], knapSack(W, wt, val, n - 1));
    }
}
