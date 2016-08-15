package bit;

public class UpdateBits_I179M {
	/**
	 * Make a mask, set ith through jth bits to 0 by mask & n, then plus m << i.
	 * Time: O(1); Space: O(1)
	 */
	public int updateBits(int n, int m, int i, int j) {
		if (i < 0 || i > 31 || j < 0 || j > 31 || i > j) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int mask = 0;
		if (j == 31) {
			mask = (1 << i) - 1;	// e.g., i = 2, j = 31 => mask = 000...00011
		} else {
			mask = ~((1 << (j + 1)) - (1 << i));	// e.g., i = 2, j = 6 => mask = 111...1110000011
		}
		
		return (mask & n) + (m << i);
	}
	
	public static void main(String[] args) {
		UpdateBits_I179M obj = new UpdateBits_I179M();
		System.out.println(obj.updateBits(1024, 21, 7, 6));	// -2147483648
		System.out.println(obj.updateBits(1024, 21, -1, 6));	// -2147483648
		System.out.println(obj.updateBits(1024, 21, -2, -1));	// -2147483648
		System.out.println(obj.updateBits(1024, 21, 32, 33));	// -2147483648
		System.out.println(obj.updateBits(1024, 21, 2, 32));	// -2147483648
		
		System.out.println(Integer.toBinaryString(
				obj.updateBits(Integer.parseInt("10000000000", 2), Integer.parseInt("10101", 2), 2, 6)
		));	// 10001010100
	}
}

/**
 * LintCode #179
 * Given two 32-bit numbers, N and M, and two bit positions, i and j. 
 * Write a method to set all bits between i and j in N equal to M 
 * (e.g., M becomes a substring of N located at i and starting at j)
 * Notice: In the function, the numbers N and M will given in decimal, you should also return a decimal number.
 * You can assume that the bits j through i have enough space to fit all of M. 
 * That is, if M=10011, you can assume that there are at least 5 bits between j and i. 
 * You would not, for example, have j=3 and i=2, because M could not fully fit between bit 3 and bit 2.
 * Example: Given N=(10000000000)2, M=(10101)2, i=2, j=6 return N=(10001010100)2
 * Minimum number of operations?
 */
