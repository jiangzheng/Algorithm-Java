package bit;

public class ReverseBits_E190E {
	/**
	 * Bit manipulation.
	 * Time: O(N); Space: O(1)
	 */
	public int reverseBits(int n) {
		int reversedInt = 0;
		
		for (int i = 0; i < 32; i++) {
			reversedInt = reversedInt << 1 | n & 1;	// reversedInt << 1: move left; n & 1: get the last bit
			n >>= 1;
		}
		
		return reversedInt;
	}
	
	public static void main(String[] args) {
		ReverseBits_E190E obj = new ReverseBits_E190E();
		System.out.println(obj.reverseBits(43261596));	// 964176192
		System.out.println(obj.reverseBits(65536));	// 32768
		System.out.println(obj.reverseBits(0));	// 0
	}
}

/**
 * LeetCode #190
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 *   return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up: If this function is called many times, how would you optimize it?
 */
