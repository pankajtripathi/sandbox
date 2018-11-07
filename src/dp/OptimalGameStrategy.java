package dp;

public class OptimalGameStrategy {
    public static void main(String[] args) {
        int arr1[] = {8, 15, 3, 7};
        int arr2[] = {2, 2, 2, 2};
        int arr3[] = {20, 30, 2, 2, 2, 10};

        optimalStrategyOfGame(arr1, arr1.length);
        optimalStrategyOfGame(arr2, arr2.length);
        optimalStrategyOfGame(arr3, arr3.length);
    }

    /**
     * Algorithm:
     * F(i, j)  represents the maximum value the user can collect from i'th coin to j'th coin.
     * F(i, j)  = Max(Vi + min(F(i+2, j), F(i+1, j-1) ), Vj + min(F(i+1, j-1), F(i, j-2) ))
     *
     * Base Cases
     * F(i, j)  = Vi           If j == i
     * F(i, j)  = max(Vi, Vj)  If j == i+1
     * */
    private static void optimalStrategyOfGame(int[] arr, int N) {
        int[][] dp = new int[N][N];

        for (int gap = 0; gap < N; gap++) {
            // gap is gap in chance
            for (int i = 0, j = gap; j < N; i++, j++) {
                int one = (i + 2) <= j ? dp[i+2][j] : 0;
                int two = (i + 1) <= (j - 1) ? dp[i + 1][j - 1] : 0;
                int three = i <= (j - 2) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(arr[i] + Math.min(one, two), arr[j] + Math.min(three, two));
            }
        }

        System.out.println(dp[0][N-1]);
    }
}
