package dp;


/*
* Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of
* gold in tons. Initially the miner is at first column but can be at any row.
* He can move only (right->,right up /,right down\) that is from a given cell, the miner can move to the cell
* diagonally up towards the right or right or diagonally down towards the right.
* Find out maximum amount of gold he can collect.
*
* Also similar to largest path sum
* */
public class GoldMine {
    public static void main(String[] args) {
        int[][] A = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };
        System.out.println(new GoldMine().collectGold(A));
    }

    private int collectGold(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] dp = new int[m][n];
        for (int col = n - 1; col >= 0; col--) {
            for (int row = 0; row < m; row++) {

                int right = col == n - 1 ?  0 : dp[row][col + 1];
                int right_up = row == 0 || col == n - 1 ? 0 : dp[row - 1][col + 1];
                int right_down = row == m - 1 || col == n - 1 ? 0 : dp[row + 1][col + 1];

                dp[row][col] = A[row][col] + Math.max(right, Math.max(right_up, right_down));
            }
        }

        // The max amount of apples collected will be
        // the max value in first column of all rows
        int res = dp[0][0];
        for (int i = 0; i < m; i++) {
            res = Math.max(res, dp[i][0]);
        }

        return res;
    }
}
