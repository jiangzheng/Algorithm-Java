package math;

public class DigitCounts_I3M {
	/**
	 * Mod.
	 * Time: O(n); Space: O(1)
	 */
	public int digitCounts(int k, int n) {
		if (n < 0 || k < 0 || k > 9) {
			return 0;	// invalid input
		}
		
		int total = 0;
		for (int i = k; i <= n; i++) {
			total += getDigitCountsForEachNumber(k, i);
		}
		
		return total;
	}
	
	private int getDigitCountsForEachNumber(int k, int n) {
		if (n == 0 && k == 0) {
			return 1;
		}
		
		int counter = 0;
		while (n > 0) {
			if (n % 10 == k) {
				counter++;
			}
			n /= 10;
		}
		
		return counter;
	}
	
	public static void main(String[] args) {
		DigitCounts_I3M obj = new DigitCounts_I3M();
		System.out.println(obj.digitCounts(1, -1));	// 0
		System.out.println(obj.digitCounts(1, 0));	// 0
		System.out.println(obj.digitCounts(-1, 12));	// 0
		System.out.println(obj.digitCounts(10, 12));	// 0
		
		System.out.println(obj.digitCounts(1, 12));	// 5
		System.out.println(obj.digitCounts(2, 12));	// 2
		System.out.println(obj.digitCounts(0, 19));	// 2
	}
}

/**
 * LintCode #3
 * Count the number of k's between 0 and n. k can be 0 - 9.
 * Example: if n=12, k=1 in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], we have FIVE 1's (1, 10, 11, 12)
 */
