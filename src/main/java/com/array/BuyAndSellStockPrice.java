package com.array;

public class BuyAndSellStockPrice {

    public static void main(String[] args) {
        double[] stockPrices = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250, 400};
        double maxProfit = findMaxProfit(stockPrices);
        System.out.println(maxProfit);
    }

    public static double findMaxProfit(double[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        double maxProfit = 0;
        double minPrice = Double.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

}
