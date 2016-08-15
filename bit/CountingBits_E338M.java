package bit;

public class CountingBits_E338M {
	/**
	 * Pattern: bits of i = [bits of (i & (i - 1))] + 1
	 * i	1s	i&(i-1)	1s	
	 * 0000	0	/		/
	 * 0001	1	0000	0
	 * 0010	1	0000	0
	 * 0011	2	0010	1
	 * 0100	1	0000	0
	 * 0101	2	0100	1
	 * 0110	2	0100	1
	 * 0111	3	0110	2
	 * 1000	1	0000	0
	 * 1001	2	1000	1
	 * 1010	2	1000	1
	 * 1011	3	1010	2
	 * 1100	2	1000	1
	 * 1101	3	1100	2
	 * 1110	3	1100	2
	 * 1111	4	1110	3
	 * Time: O(n); Space: O(1)
	 */
	public int[] countBits(int num) {
		if (num < 0) {
			return null;	// invalid input
		}
		
		int[] bits = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			bits[i] = bits[i & (i - 1)] + 1;
		}
		
		return bits;
	}
	
	public static void main(String[] args) {
		CountingBits_E338M obj = new CountingBits_E338M();
		System.out.println(obj.countBits(-1));	// null
		
		int[] result = obj.countBits(15);
		for (int x : result) {
			System.out.print(x + ", ");	// 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 
		}
	}
}

/**
 * LeetCode #338
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 <= i <= num calculate the number of 1's in their binary representation and 
 *   return them as an array.
 * Example: For num = 5 you should return [0,1,1,2,1,2].
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any built-in function like __builtin_popcount in c++ or 
 *   in any other language.
 */
