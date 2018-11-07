package dp;

/*
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *
 * Insert
 * Remove
 * Replace
 * */

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "geek";
        String str2 = "gesek";

        System.out.println("Distance With DP: " + editDistWithoutDP( str1 , str2 , str1.length(), str2.length()) );
        System.out.println("Distance With Recursion: " + editDist( str1 , str2 , str1.length(), str2.length()) );
    }

    private static int editDistWithoutDP(String str1, String str2, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
            }
        }

        return dp[m][n];
    }

    private static int editDist(String str1, String str2, int m, int n) {
        if (m == 0) return m;
        if (n == 0) return n;

        // if last characters are same then recursively check other characters
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDist(str1, str2, m - 1, n - 1);

        return  1 + Math.min(editDist(str1, str2, m, n - 1) ,
                Math.min(editDist(str1, str2, m - 1, n), editDist(str1, str2, m - 1, n - 1)));
    }
}
