package bit;

public class FlipBits_I181E {
	/**
	 * Count the number of 1s in the result of a ^ b.
	 * Time: O(1); Space: O(1)
	 */
	public int bitSwapRequired(int a, int b) {
		if (a == b) {
			return 0;
		}
		
		int result = 0;
		int XOR = a ^ b;
		for (int i = 0; i < 32; i++) {
			result += XOR & 1;
			XOR >>= 1;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		FlipBits_I181E obj = new FlipBits_I181E();
		System.out.println(obj.bitSwapRequired(31, 31));	// 0
		System.out.println(obj.bitSwapRequired(31, 14));	// 2
	}
}

/**
 * LintCode #181
 * Determine the number of bits required to flip if you want to convert integer n to integer m.
 * Notice: Both n and m are 32-bit integers.
 * Example: Given n = 31 (11111), m = 14 (01110), return 2.
 */
