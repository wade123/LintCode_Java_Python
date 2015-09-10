public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int currentMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            currentMin = Math.min(currentMin, price);
            maxProfit = Math.max(maxProfit, price - currentMin);
        }
        return maxProfit;
    }
}