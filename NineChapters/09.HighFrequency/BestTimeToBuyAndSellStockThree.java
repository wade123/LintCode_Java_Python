public class BestTimeToBuyAndSellStockThree {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int length = prices.length;
        int[] left = new int[length + 1];
        int min = prices[0];
        for (int i = 2; i <= length; i++) {
            min = Math.min(min, prices[i - 1]);
            left[i] = Math.max(left[i - 1], prices[i - 1] - min);
        }
        int[] right = new int[length + 1];
        int max = prices[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        int maxProfit = 0;
        for (int i = 0; i <= length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }
}