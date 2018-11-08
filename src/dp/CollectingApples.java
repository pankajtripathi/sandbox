package dp;


/*
* A table composed of N x M cells, each having a certain quantity of apples, is given.
* You start from the upper-left corner. At each step you can go down or right one cell.
* Find the maximum number of apples you can collect.
*
* */
public class CollectingApples {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4},
                {1, 1, 1, 1},
                {9, 9, 9, 9}
        };
        System.out.println(new CollectingApples().maxApples(A));
    }

    private int maxApples(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] dp = new int[m][n];

        // This is straight forward coz you start from top left so you can come to a cell from left or from top
        // hence once you arrive at a cell you check whether coming from left was max or coming from top
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row > 0 && col > 0) {
                    dp[row][col] = A[row][col] + Math.max(dp[row][col - 1], dp[row - 1][col]);
                } else {
                    dp[row][col] = A[row][col];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
