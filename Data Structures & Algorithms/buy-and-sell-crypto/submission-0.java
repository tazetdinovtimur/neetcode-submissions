class Solution {
    public int maxProfit(int[] prices) {
        var minPrice = prices[0];
        var maxProfit = 0;

        for (var i = 1; i < prices.length; i++) {
            var profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
