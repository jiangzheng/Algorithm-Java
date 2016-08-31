package bit;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_E89M_I411M {
	/**
	 * Pattern:
	 * n = 0:                  0
	 * n = 1:                0 | 1
	 * n = 2:           00  01 | 11  10
	 * n = 3: 000 001  011 010 | 110 111  101 100
	 * ...
	 * 1st half: add a "0" to the nth bit for the previous level (from left to right)
	 * 2nd half: add a "1" to the nth bit for the previous level (from right to left)
	 * Time: O(n^2), Space: O(1)
	 */
	public List<Integer> grayCode(int n) {
		if (n < 0) {
			return null;	// invalid input
		}
		
		List<Integer> list = new ArrayList<>();
		list.add(0);
		
		for (int i = 0; i < n; i++) {
			int mask = 1 << i;
			for (int j = list.size() - 1; j >= 0; j--) {	// scan the previous level backward
				list.add(list.get(j) + mask);	// add a "1" to the current highest bit
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		GrayCode_E89M_I411M obj = new GrayCode_E89M_I411M();
		System.out.println(obj.grayCode(-1));	// null
		System.out.println(obj.grayCode(0));	// [0]
		
		List<Integer> l = obj.grayCode(3);
		System.out.println(l);	// [0, 1, 3, 2, 6, 7, 5, 4]
		for (int n : l) {
			System.out.print(Integer.toBinaryString(n) + ", ");	// 0, 1, 11, 10, 110, 111, 101, 100,
		}
		l = obj.grayCode(4);
		System.out.println("\n" + l);	// [0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8]
		for (int n : l) {
			System.out.print(Integer.toBinaryString(n) + ", ");
			// 0, 1, 11, 10, 110, 111, 101, 100, 1100, 1101, 1111, 1110, 1010, 1011, 1001, 1000, 
		}
	}
}

/**
 * LeetCode #89
 * LintCode #411
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, 
 *   print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note: For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 */
