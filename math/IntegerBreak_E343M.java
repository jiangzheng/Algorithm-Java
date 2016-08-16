package math;

public class IntegerBreak_E343M {
	/**
	 * Math trick.
	 * Find how many 3's we can get when n > 3.
	 * 2 -> 1*1, 3 -> 1*2, 4 -> 2*2, 
	 * 5 -> 3*2, 6 -> 3*3, 7 -> 3*4, 
	 * 8 -> 3*3*2, 9 -> 3*3*3, 10 -> 3*3*4, 
	 * 11 -> 3*3*3*2
	 * Time: O(1); Space: O(1)
	 */
	public int integerBreak1(int n) {
		if (n < 2) {
			return 0;	// invalid input
		}
		
		if (n < 4) {
			return n - 1;	// shortcut
		}
	 
		if (n % 3 == 2) {	// 5, 8, 11, ...
			return(int) Math.pow(3, n / 3) * 2;
		}
		
		if (n % 3 == 1) {	// 7, 10, 13, ...
			return (int) Math.pow(3, (n - 4) / 3) * 4;
		}
		
		return (int) Math.pow(3, n / 3);	// if (n % 3 == 0) {	// 6, 9, 12, ...
	}

	/**
	 * 1-d DP.
	 * d(i): the max production value for breaking the number i.
	 * Time: O(n^2); Space: O(n)
	 */
	public int integerBreak2(int n) {
		if (n < 2) {
			return 0;	// invalid input
		}
		
		int[] d = new int[n + 1];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < i + 1; j++) {
				if (i + j <= n) {
					d[i + j] = Math.max(Math.max(d[i], i) * Math.max(d[j] , j), d[i + j]);
				}
			}
		}
		
		return d[n];
	}
	
	public static void main(String[] args) {
		IntegerBreak_E343M obj = new IntegerBreak_E343M();
		for (int i = -1; i <= 10; i++) {
			System.out.print(obj.integerBreak1(i) + ", ");	// 0, 0, 0, 1, 2, 4, 6, 9, 12, 18, 27, 36, 
		}
		System.out.print("\n");
		for (int i = -1; i <= 10; i++) {
			System.out.print(obj.integerBreak2(i) + ", ");	// 0, 0, 0, 1, 2, 4, 6, 9, 12, 18, 27, 36, 
		}
	}
}

/**
 * LeetCode #343
 * Given a positive integer n, 
 * break it into the sum of at least two positive integers and maximize the product of those integers. 
 * Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: you may assume that n is not less than 2.
 */
