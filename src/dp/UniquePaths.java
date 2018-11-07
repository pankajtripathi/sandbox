package dp;

public class UniquePaths {
    static int[] stack;
    int top = -1;

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

        };
        System.out.println("Recursive: " + new UniquePaths().uniquePathsCountRec(3, 3));
        System.out.println("DP: " + new UniquePaths().uniquePathsCount(3, 3));

        stack = new int[matrix.length + matrix[0].length];
        new UniquePaths().uniquePaths(matrix, 3, 3);
    }


    // Works well for small numbers
    // time complexity increases exponentially
    private int uniquePathsCountRec(int m, int n) {
        if (m == 0 && n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        return uniquePathsCountRec(m, n - 1)
                + uniquePathsCountRec(m - 1, n)
                + uniquePathsCountRec(m - 1, n - 1);
    }

    private int uniquePathsCount(int m, int n) {
        if (m == 0 && n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    private void uniquePaths(int[][] matrix, int m, int n) {
        if (m == 0 || n == 0) return;
        stack[++top] = matrix[m - 1][n - 1];

        if (m == 1 && n == 1) printStack();

        uniquePaths(matrix, m - 1, n);
        uniquePaths(matrix, m, n - 1);
        uniquePaths(matrix, m - 1, n - 1);

        top--;
    }



    private void printStack() {
        for (int i = top; i > 1; i--)
            System.out.print(stack[i] + " -> ");
        System.out.println(stack[1]);
    }
}
