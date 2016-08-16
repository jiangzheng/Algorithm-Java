package math;

public class FactorialTrailingZeroes_E172E_I2E {
	/**
	 * # of 0s = floor(n/5) + floor(n/25) + floor(n/125) + ...
	 * Time: O(log5 n); Space: O(1)
	 */
	public long trailingZeroes(long n) {
		long counter = 0;
		
		while (n > 0) {
			n /= 5;	
			counter += n;
		}
		
		return counter;
	}
	
	public static void main(String[] args) {
		FactorialTrailingZeroes_E172E_I2E obj = new FactorialTrailingZeroes_E172E_I2E();
		System.out.println(obj.trailingZeroes(124));	// 28
		System.out.println(obj.trailingZeroes(11));	// 2
	}
}

/**
 * LeetCode #172
 * LintCode #2
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
