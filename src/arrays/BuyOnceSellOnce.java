package arrays;

import java.util.ArrayList;
import java.util.List;

public class BuyOnceSellOnce {
    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        maximizeProfit(arr);
        sellStock(arr);

        int[] arr1 = {2, 3, 1, 1, 1, 1, 9};
        subarry(arr1);
    }

    static class Stock {
        int buy;
        int sell;
    }

    private static void sellStock(int[] price) {
        List<Stock> stocks = new ArrayList<>();
        int n = price.length;

        int i = 0;
        int count = 0;

        while (i < n  - 1) {
            // Get Minima which is to compare it with next elements to check if the current is small then move ahead
            while (i < n - 1 && price[i] >= price[i + 1])
                i++;

            if (i == n - 1) break;

            Stock stock = new Stock();
            stock.buy = i++;

            // Get Maxima which is to compare it with next elements to check if the current is small then move ahead
            while (i < n && price[i] >= price[i - 1])
                i++;

            stock.sell = i - 1;

            stocks.add(stock);
            count++;
        }

        if (count == 0) {
            System.out.println("No profits");
        }
        else {
            for (int j = 0; j < count; j++) {
                System.out.println("Buy at: " + stocks.get(j).buy + " Sell at:" + stocks.get(j).sell);
            }
        }
    }

    private static void maximizeProfit(int[] arr) {
        int maxPrice = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : arr) {
            maxPrice = Math.max(maxPrice, price - minPrice);
            minPrice = Math.min(price, minPrice);
        }
        System.out.println(maxPrice);
    }

    private static void subarry(int[] arr) {
        int n = arr.length;
        int i = 0;

        // count starts at one coz it will take into account the number from where the equality check starts
        int count = 1;

        while (i < n - 1) {
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }

            i++;
            if (i == n - 1) break;
        }
        System.out.println(count);
    }
}
