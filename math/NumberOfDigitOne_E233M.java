package math;

public class NumberOfDigitOne_E233M {
	/**
	 * Formula: (n + 8) / 10 * a + (n % 10 == 1 ? b : 0).
	 * Time: O(log n); Space: O(1) 
	 */
	public int countDigitOne(int n) {
		if (n < 0) {
			return -1;	// invalid input
		}
		
		int result = 0, b = 1, a = 1;
		
		while (n > 0) {
			result += (n + 8) / 10 * a + (n % 10 == 1 ? b : 0);
			b += n % 10 * a;
			a *= 10;
			n /= 10;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		NumberOfDigitOne_E233M obj = new NumberOfDigitOne_E233M();
		System.out.println(obj.countDigitOne(-1));	// -1
		
		System.out.println(obj.countDigitOne(0));	// 0
		System.out.println(obj.countDigitOne(1));	// 1
		System.out.println(obj.countDigitOne(13));	// 6
	}
}

/**
 * LeetCode #233
 * Given an integer n, 
 *   count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * For example: Given n = 13, Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * Hint: Beware of overflow.
 */

/**
 * There are three cases:
 * Case 1: UVW0XYZ	count = count	e.g., 109: (10+1)*1 + 0*10 + (9+1)
 * Case 2: UVW1XYZ	count += XYZ + 1	e.g., 1456: (145+1)*1 + (14+1)*10 + (1+1)*100 + (456+1)
 * Case 3: UVW?XYZ (? >= 2)		count += (UVW + 1) * 1000 (1000 is determined by the digit of ?)
 *   e.g., 229: (22+1)*1 + (2+1)*10 + (0+1)*100
 * Algorithm: count the 1's for each digit (from low to high)
 * Case 1: (n + 8) / 10 = 0, n % 10 == 0, then count += 0;
 * Case 2: (n + 8) / 10 = 0, n % 10 == 1, set count += b where b = XYZ + 1;
 * Case 3: (n + 8) / 10 > 0, n % 10 != 1, set count += (n + 8) / 10 * a where a is the 1000 in the above example.
 * Combine the three cases in one formula: (n + 8) / 10 * a + (n % 10 == 1 ? b : 0).
 */
