package bit;

public class BitwiseANDofNumbersRange_E201M {
	/**
	 * Right-shift m and n until m equals to n, left-shift m the number of shifts.
	 * Time: O(n); Space: O(1)
	 */
	int rangeBitwiseAnd(int m, int n) {
		if (m < 0 || n < 0 || m > n) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int numberOfShifts = 0;
		
		while (m != n) {	// until m == n
			m >>= 1;
			n >>= 1;
			numberOfShifts++;
		}
		
		return m << numberOfShifts;
	}
	
	public static void main(String[] args) {
		BitwiseANDofNumbersRange_E201M obj = new BitwiseANDofNumbersRange_E201M();
		System.out.println(obj.rangeBitwiseAnd(-1, 7));	// -2147483648
		System.out.println(obj.rangeBitwiseAnd(-2, -1));	// -2147483648
		System.out.println(obj.rangeBitwiseAnd(8, 7));	// -2147483648
		
		System.out.println(obj.rangeBitwiseAnd(5, 7));	// 4
		System.out.println(obj.rangeBitwiseAnd(25, 31));	// 24
	}
}

/**
 * LeetCode #201
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 */
