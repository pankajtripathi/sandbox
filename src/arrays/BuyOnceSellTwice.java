package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyOnceSellTwice {
    public static void main(String[] args) {
        Integer[] price = {10, 22, 5, 75, 65, 80};
        System.out.println(new BuyOnceSellTwice().buyAndSellTwice(Arrays.asList(price)));
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
}
