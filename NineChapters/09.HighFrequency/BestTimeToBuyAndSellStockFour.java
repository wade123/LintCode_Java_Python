public class BestTimeToBuyAndSellStockFour {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        if (k >= prices.length) {
            return maxProfit2(prices);
        }
        int length = prices.length;
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 1; i < length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = k; j > 0; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockFour test = new BestTimeToBuyAndSellStockFour();
        int k = 2;
        int[] prices = {1, 2, 4, 7, 3, 6, 0, 11};
        System.out.println(test.maxProfit(k, prices));
    }
}