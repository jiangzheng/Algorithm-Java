package dp;

public class BestTimeToBuyAndSellStock_E121E_E149M {
	/**
	 * 1-d DP.
	 * d(i): the max profit when the transaction is in [0, i].
	 * Time: O(n); Space: O(1)
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;	// invalid input
		}
		
		int profit = 0;
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);	// find min price
			profit = Math.max(profit, prices[i] - minPrice);	// d(i) = max{d(i - 1), current profit}
		}
		
		return profit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock_E121E_E149M obj = new BestTimeToBuyAndSellStock_E121E_E149M();
		System.out.println(obj.maxProfit(null));	// 0
		System.out.println(obj.maxProfit(new int[]{}));	// 0
		
		int[] a = {1, 1, 3, 2, 3};
		System.out.println(obj.maxProfit(a));	// 2
	}
}

/**
 * LeetCode #121
 * LintCode #149
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most 1 transaction 
 *   (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
