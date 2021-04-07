package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyOnceSellTwice {
    public static void main(String[] args) {
        int[] price = {3,3,5,0,0,3,1,4};
        System.out.println(new BuyOnceSellTwice().maxProfit(price));
    }

    private int buyAndSellTwice(List<Integer> prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        List<Integer> firstBuyProfits = new ArrayList<>();

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
            firstBuyProfits.add(maxProfit);
        }

        int maxPrice = Integer.MIN_VALUE;
        for (int i = prices.size() - 1; i > 0; i--) {
            maxPrice = Math.max(maxPrice, prices.get(i));
            maxProfit = Math.max(maxProfit, maxPrice - prices.get(i) + firstBuyProfits.get(i - 1));
        }

        return maxProfit;
    }

    /*
    * You are given an array prices where prices[i] is the price of a given stock on the ith day.
    * Find the maximum profit you can achieve. You may complete as many transactions as you like
    * (i.e., buy one and sell one share of the stock multiple times).
    * Note: You may not engage in multiple transactions simultaneously
    * (i.e., you must sell the stock before you buy again).
    * */
    private int maxProfit(int[] prices) {
        int i = 0;
        int buy = prices[0];
        int sell = prices[0];
        int maxProfit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            buy = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            sell = prices[i];
            maxProfit += sell - buy;
        }
        return maxProfit;
    }
}
