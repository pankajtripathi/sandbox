package dp;

import java.util.Arrays;
import java.util.Scanner;

/*
* Given a list of N coins, their values (V1, V2, … , VN), and the total sum S. Find the minimum number of coins the sum
* of which is S (we can use as many coins of one type as we want), or report that it’s not possible to select coins in
* such a way that they sum up to S.
* */
public class CollectCoins {
    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sum required: ");
        int reqSum = scanner.nextInt();
        new CollectCoins().coinChange(coins, reqSum);
    }

    private void coinChange(int[] coins, int reqSum) {
        int[] min = new int[reqSum + 1];
        for (int i = 0; i <= reqSum; i++) {
            min[i] = 999;
        }
        min[0] = 0;

        // 1. check if the current coin value is less than or equal to the current required sum
        // 2. Also check if the min value of it previous mins is less than default min.
        for (int i = 1; i <= reqSum; i++) {
            for (int Vj : coins) {
                if (Vj <= i && min[i - Vj] + 1 < min[i]) {
                    min[i] = min[i - Vj] + 1;
                }
            }
        }

        System.out.println(min[reqSum]);
    }
}
