package dp;

public class BestTimeToBuyAndSellStockII_E122M_I150M {
	/**
	 * Sum up all the increasing prices (i.e., positive difference).
	 * Time: O(n); Space: O(1)
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;	// invalid input
		}
		
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			if (diff > 0) {
				profit += diff;
			}
		}
		
		return profit;
	}
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockII_E122M_I150M obj = new BestTimeToBuyAndSellStockII_E122M_I150M();
		System.out.println(obj.maxProfit(null));	// 0
		System.out.println(obj.maxProfit(new int[]{}));	// 0
		
		int[] a = {1, 1, 3, 2, 3};
		System.out.println(obj.maxProfit(a));	// 3
	}
}

/**
 * LeetCode #122
 * LintCode #150
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time 
 *   (i.e., you must sell the stock before you buy again).
 */
