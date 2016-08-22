package dp;

public class BestTimeToBuyAndSellStockIV_E188H_I393H {
	/**
	 * 2-d DP.
	 * Time: O(n^2)
	 */
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length < k || k < 1) {
			return 0;	// invalid input
		}
		
		int profit = 0;
		
		// Special case: k > prices.length / 2, i.e., as many transactions as we want, same as 122
		if (k > prices.length / 2) {
			for (int i = 0; i < prices.length - 1; i++) {
				int diff = prices[i + 1] - prices[i];
				if (diff > 0) {
					profit += diff;
				}
			}
			
			return profit;
		}
		
		// at most k transactions
		// d(i, j) = max{d(i, j - 1), max_{1<=l<=j} {d(i - 1, l - 1) - p[l] (buy) + p[j] (sell)}}
		int[][] d = new int[k + 1][prices.length];
		
		for (int i = 1; i <= k; i++) {
			int tmpMax = d[i - 1][0] - prices[0];
			for (int j = 1; j < prices.length; j++) {
				tmpMax = Math.max(tmpMax, d[i - 1][j - 1] - prices[j]);
				d[i][j] = Math.max(d[i][j - 1], prices[j] + tmpMax);
			}
		}
		
		return d[k][prices.length - 1];
	}
	
	public static void main(String[] args) {
		int[] a = {10, 12, 13, 11, 9, 15, 18, 8, 7, 10, 13, 19};
		
		BestTimeToBuyAndSellStockIV_E188H_I393H obj = new BestTimeToBuyAndSellStockIV_E188H_I393H();
		System.out.println(obj.maxProfit(3, null));	// 0
		System.out.println(obj.maxProfit(0, a));	// 0
		
		System.out.println(obj.maxProfit(2, a));	// 21
		System.out.println(obj.maxProfit(3, a));	// 24
	}
}

/**
 * LeetCode #188
 * LintCode #393
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note: You may not engage in multiple transactions at the same time 
 *   (i.e., you must sell the stock before you buy again).
 */
