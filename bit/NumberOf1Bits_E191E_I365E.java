package bit;

public class NumberOf1Bits_E191E_I365E {
	/**
	 * For each bit, & 1 and count.
	 * Time: O(n); Space: O(1)
	 */
	public int hammingWeight(int n) {
		int numberOf1Bits = 0;
		
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				numberOf1Bits++;
			}
			n >>= 1;
		}
		
		return numberOf1Bits;
	}
	
	public static void main(String[] args) {
		NumberOf1Bits_E191E_I365E obj = new NumberOf1Bits_E191E_I365E();
		System.out.println(obj.hammingWeight(11));	// 3
		System.out.println(obj.hammingWeight(32));	// 1
		System.out.println(obj.hammingWeight(5));	// 2
		System.out.println(obj.hammingWeight(1023));	// 10
	}
}

/**
 * LeetCode #191
 * LintCode #365
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (aka the Hamming weight).
 * E.g.,the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
 *   so the function should return 3.
 * You need to treat n as an unsigned value.
 */
