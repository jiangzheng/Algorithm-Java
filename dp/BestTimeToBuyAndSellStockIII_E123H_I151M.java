package dp;

public class BestTimeToBuyAndSellStockIII_E123H_I151M {
	/**
	 * 1-d DP.
	 * d(i): the max profit when 1st transaction is in [0, i] and 2nd transaction is in [i, n - 1].
	 * Time: O(3n); Space: O(2n)
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;	// invalid input
		}
		
		int[] f = new int[prices.length];
		int[] g = new int[prices.length];
		
		// calculate f[i] = max profit in [0, i], similar to BestTimeToBuyAndSellStock_E121E_E149M
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {	// scan forwards
			minPrice = Math.min(minPrice, prices[i]);	// find min price
			f[i] = Math.max(f[i - 1], prices[i] - minPrice);
		}
		
		// calculate g[i] = max profit in [i + 1, n - 1]
		int maxPrice = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {	// scan backwards
			maxPrice = Math.max(maxPrice, prices[i]);	// find max price
			g[i] = Math.max(g[i + 1], maxPrice - prices[i]);
		}
		
		// calculate max profit in [0, n - 1]
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, f[i] + g[i]);
		}
		
		return profit;
	}
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII_E123H_I151M obj = new BestTimeToBuyAndSellStockIII_E123H_I151M();
		System.out.println(obj.maxProfit(null));	// 0
		System.out.println(obj.maxProfit(new int[]{}));	// 0
		
		int[] a = {10, 12, 13, 11, 9, 15, 18, 8, 7, 10, 13, 19};
		System.out.println(obj.maxProfit(a));	// 21
	}
}

/**
 * LeetCode #123
 * LintCode #151
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most 2 transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */

/**
 * d(i): the max profit when 1st transaction is in [0, i] and 2nd transaction is in [i, n - 1].
 * d(i) = f(i) + g(i) where
 * - f(i) = max{ f(i - 1), price[i] - minPrice }
 * - g(i) = max{ g(i + 1), maxPrice - price[i] }
 * max profit = max{ f(i) + g(i) }, for i in [0, n - 1]
 */
